package pubsub.consumer.pubsubconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PubsubConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubsubConsumerApplication.class, args);
	}

}
