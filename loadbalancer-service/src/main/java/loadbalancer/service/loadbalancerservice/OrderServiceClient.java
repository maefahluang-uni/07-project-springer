package loadbalancer.service.loadbalancerservice;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import product.service.product;

@FeignClient(name = "product-service")
@LoadBalancerClient(name = "product-service", configuration = LoadBalancerConfiguration.class)
@EntityScan(basePackages = "product-service.product")
public interface OrderServiceClient {

    @PostMapping("/products")
    ResponseEntity<String> createProduct(@RequestBody product product);




}
