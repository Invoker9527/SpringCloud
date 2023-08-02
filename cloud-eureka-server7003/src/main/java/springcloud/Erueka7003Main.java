package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author YangRuiHong
 * @Create 2022-02-07 20:46
 * @Description
 */
@SpringBootApplication
@EnableEurekaServer
public class Erueka7003Main {
    public static void main(String[] args) {
        SpringApplication.run(Erueka7003Main.class, args);
    }
}
