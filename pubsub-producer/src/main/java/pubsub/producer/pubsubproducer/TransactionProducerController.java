package pubsub.producer.pubsubproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionProducerController {

	// TODO: add the kafka template for configuration.
	@Autowired
	private KafkaTemplate<String, Transaction> kafkaTemplate;

	Thread generator;

	@GetMapping("/payment/start")
	public ResponseEntity<String> start() {

		TransactionGenerator genTask = new TransactionGenerator();

		// TODO: pass kafka template to generator
		genTask.setKafkaTemplate(kafkaTemplate);

		generator = new Thread(genTask);
		generator.start();
		return new ResponseEntity<>("payment started.", HttpStatus.OK);
	}

	@GetMapping("/payment/stop")
	public ResponseEntity<String> stop() {
		generator.interrupt();
		try {
			generator.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
			new ResponseEntity<>("Error occured -> " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("payment stopped.", HttpStatus.OK);

	}

}
