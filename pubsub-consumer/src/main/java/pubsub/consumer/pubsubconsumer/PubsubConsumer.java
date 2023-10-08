package pubsub.consumer.pubsubconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PubsubConsumer {
	Logger LOG = LoggerFactory.getLogger(PubsubConsumer.class);

	//TODO: add listener methods here
	@KafkaListener(topics = "payments")
	void listener(String transaction) {
		LOG.info(transaction);
	}
}
