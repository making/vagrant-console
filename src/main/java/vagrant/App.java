package vagrant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk7.Jdk7Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import vagrant.localrule.LocalRuleEndpoint;

import javax.inject.Named;
import javax.ws.rs.ApplicationPath;
import java.util.Arrays;

@SpringBootApplication
@EnableAsync
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    private static final ObjectMapper sharedObjectMapper;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk7Module());
        sharedObjectMapper = objectMapper;
    }

    @Bean
    ObjectMapper objectMapper() {
        return sharedObjectMapper;
    }

    @Bean
    RestTemplate restTemplate() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(objectMapper());
        TestRestTemplate restTemplate = new TestRestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(messageConverter, new FormHttpMessageConverter()));
        return restTemplate;
    }

    @Named
    @ApplicationPath("api")
    static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.register(LocalRuleEndpoint.class);
            JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
            provider.setMapper(sharedObjectMapper);
            this.register(provider);
        }
    }
}