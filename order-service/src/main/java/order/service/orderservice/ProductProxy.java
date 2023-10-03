package order.service.orderservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service")
@LoadBalancerClient(name = "product-service", configuration = LoadBalancerConfiguration.class)
@EnableDiscoveryClient
public interface ProductProxy {
    

    @GetMapping("/products/{id}")
    public ProductDTO getProduct(@PathVariable Long id);
}
