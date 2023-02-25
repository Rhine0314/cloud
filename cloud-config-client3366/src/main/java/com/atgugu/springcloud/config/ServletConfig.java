package com.atgugu.springcloud.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServletConfig implements
        WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    /*
     * 不知道为什么一配置了bootstrap.yml后配置的端口不生效，这里直接再次指定一下这个端口
     * */
    @Override
    public void customize(ConfigurableServletWebServerFactory server) {
        server.setPort(3366);
    }
}
