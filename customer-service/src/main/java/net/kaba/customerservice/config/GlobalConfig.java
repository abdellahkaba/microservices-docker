package net.kaba.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

//creer un bean global config avec cette annotation
//au demarrage  il creer un objet config avec des parametres de global param
@ConfigurationProperties(prefix = "global.params")
@Data @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig {
    private int p1 ;
    private int p2 ;
}
