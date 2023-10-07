package user.service.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	// @Bean
	// public WebMvcConfigurer corsConfigurer() {
	// 	return new WebMvcConfigurer() {
	// 		@Override
	// 		public void addCorsMappings(CorsRegistry registry) {
	// 			// TODO: make sure the port of web front is correct.
	// 			registry.addMapping("/users").allowedOrigins("http://localhost:8080");
	// 		}
	// 	};
	// }


}
