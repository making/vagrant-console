package vagrant.webui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    String targetPath;

    @PostConstruct
    void init() {
        this.targetPath = apiHost + ":" + apiPort + "/api/localrules";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model) {
        ResponseEntity<List<LocalRule>> response = restTemplate.exchange(targetPath, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<LocalRule>>() {
                });
        List<LocalRule> rules = response.getBody();
        log.debug("rules={}", rules);
        model.addAttribute("rules", rules);
        return "index";
    }

    @RequestMapping(value = "/", params = "command=up")
    String up(@RequestParam String id) {
        restTemplate.postForObject(targetPath + "/up?id=" + id, null, Void.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/", params = "command=halt")
    String halt(@RequestParam String id) {
        restTemplate.postForObject(targetPath + "/halt?id=" + id, null, Void.class);
        return "redirect:/";
    }

    @RequestMapping(value = "/", params = "command=destroy")
    String destroy(@RequestParam String id) {
        restTemplate.postForObject(targetPath + "/destroy?id=" + id, null, Void.class);
        return "redirect:/";
    }
}
