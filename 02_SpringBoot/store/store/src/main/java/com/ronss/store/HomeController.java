package com.ronss.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {
    // @Value("${spring.application.name}")
    // private String appName;

    // @Value("${server.port}")
    // private String serverPortFromApplicationDotProperties;

    @GetMapping("/")
    public String Index() {
        // System.out.println("Entered in Index controller");
        String viewName = getViewName();
        return viewName;
    }

    private String getViewName() {
        return "index.html";
    }
}
