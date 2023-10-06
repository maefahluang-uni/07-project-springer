package pubsub.producer.pubsubproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PubsubProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsubProducerApplication.class, args);
	}

}
