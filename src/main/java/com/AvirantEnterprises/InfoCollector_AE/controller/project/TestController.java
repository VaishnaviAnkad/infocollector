package com.AvirantEnterprises.InfoCollector_AE.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/TaskAssignment.html")
    public String showDashboard(Model model) {
        model.addAttribute("title", "Dashboard - Avirant Enterprises");
        return "TaskAssignment"; // Name of the HTML file
    }
}
