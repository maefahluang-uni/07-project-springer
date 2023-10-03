package order.service.orderservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
@LoadBalancerClient(name = "user-service", configuration = LoadBalancerConfiguration.class)
@EnableDiscoveryClient
public interface UserProxy {

    @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable Long id);

    
    
}

