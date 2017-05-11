package demo;

import com.netflix.archaius.api.annotations.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import sdk.SDK;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RefreshScope
public class Consumer {

    @Value("${foo:World!}")
    static String foo;

    public static void main(String[] args) {


        //Init
        SpringApplication.run(Consumer.class, args);


        SDK.start();


        System.out.println("Consumer  ===> "+foo);

        while (true){

        }
    }
}
