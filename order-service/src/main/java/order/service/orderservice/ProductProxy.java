package order.service.orderservice;

import javax.persistence.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
@LoadBalancerClient(name = "product-service", configuration = LoadBalancerConfiguration.class)
@EntityScan(basePackages = "product.service")
public interface ProductProxy { 
    

    @GetMapping("/products/{ID}")
    public ProductDTO getProduct(@PathVariable long pid);


    
}
