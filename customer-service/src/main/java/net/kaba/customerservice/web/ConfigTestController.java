package net.kaba.customerservice.web;

import net.kaba.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class ConfigTestController {

    //afficher les parametres et injecte depuis le fichier properties
    @Value("${global.params.p1}")
    private int p1 ;
    @Value("${global.params.p2}")
    private  int p2 ;
    @Value("${customer.params.x}")
    private int x ;
    @Value("${customer.params.y}")
    private int y ;

    @Autowired
    private GlobalConfig globalConfig ;

    //pour tester
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig() {
        return globalConfig ;
    }

    //une methode qui retourne un Map de type string
    @GetMapping("/testConfig")
    public Map<String,Integer> configString () {
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y) ;
    }
}
