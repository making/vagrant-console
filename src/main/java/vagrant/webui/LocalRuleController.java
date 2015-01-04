package vagrant.webui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import vagrant.localrule.LocalRule;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Controller
@Slf4j
public class LocalRuleController {
    @Inject
    RestTemplate restTemplate;

    @Value("${api.host:http://localhost}")
    String apiHost;
    @Value("${api.port:${server.port:8080}}")
    int apiPort;
    String targetUrl;

    @PostConstruct
    void init() {
        this.targetUrl = apiHost + ":" + apiPort + "/api/localrules";
    }

    @RequestMapping("/")
    String home(Model model) {
        ResponseEntity<List<LocalRule>> response = restTemplate.exchange(targetUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<LocalRule>>() {
                });
        List<LocalRule> rules = response.getBody();
        log.info("rules={}", rules);
        model.addAttribute("rules", rules);
        return "index";
    }
}
