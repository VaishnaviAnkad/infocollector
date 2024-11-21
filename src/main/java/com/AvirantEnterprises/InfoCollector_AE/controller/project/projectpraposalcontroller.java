package com.AvirantEnterprises.InfoCollector_AE.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class projectpraposalcontroller {

    @GetMapping("/projectpraposal.html")
    public String showDashboard(Model model) {
        model.addAttribute("ProjectName", "Dashboard - Avirant Enterprises");
        model.addAttribute("ProjectDiscription", "Dashboard - Avirant Enterprises");
        model.addAttribute("ProjectDeadline", "Dashboard - Avirant Enterprises");
        return "projectpraposal"; // Name of the HTML file
    }
}
