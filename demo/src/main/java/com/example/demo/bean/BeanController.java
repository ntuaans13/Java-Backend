package com.example.demo.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {
    private final ConfigurableApplicationContext applicationContext;

    public BeanController(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/api/beans")
    public List<Map<String, String>> ListAllBeansWithScope() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        List<Map<String, String>> beanWithScope = new ArrayList<>();

        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanFactory().getBeanDefinition(beanName);
            String scope = beanDefinition.getScope();
            if (scope == null || scope.isEmpty()) {
                scope = BeanDefinition.SCOPE_SINGLETON;
            }
            beanWithScope.add(Map.of("beanName", beanName, "scope", scope));
        }

        return beanWithScope;
    }
}
