package hik.taiji.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages="hik.taiji.springcloud.service")
public class SpringCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}
}
