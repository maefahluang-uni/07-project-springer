package order.service.orderservice;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "user-service")
@LoadBalancerClient(name = "user-service", configuration = LoadBalancerConfiguration.class)
public interface UserProxy {


 @GetMapping("/user/{id}")
    public ResponseEntity<Order> getUSer(@PathVariable ("user") Long userid);

    
    
}

