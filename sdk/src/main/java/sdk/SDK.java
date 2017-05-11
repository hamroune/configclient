package sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.cloud.service.common.RelationalServiceInfo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@ComponentScan
@RefreshScope
@Service
public class SDK {

    @Value("${bar:World!}")
    String bar;

    public String hello() {
        return  bar + "!";
    }

    public static void start() {
        SpringApplication context = new SpringApplication(SDK.class);
        context.setWebEnvironment(false);
        ConfigurableApplicationContext configurableApplicationContext = context.run("");

        SDK sdk = configurableApplicationContext.getBean(SDK.class);
        String hello = sdk.hello();

        ConcurrentCompositeConfiguration myConfiguration =
                (ConcurrentCompositeConfiguration) DynamicPropertyFactory.getInstance().getBackingConfigurationSource();



        System.out.println("SDK ==> "+hello);


    }
}
