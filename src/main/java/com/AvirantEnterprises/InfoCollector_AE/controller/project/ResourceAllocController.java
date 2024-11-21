package com.AvirantEnterprises.InfoCollector_AE.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourceAllocController {

    @GetMapping("/ResourceAllocationForm.html")
    public String showDashboard(Model model) {
        model.addAttribute("ResourceType", "Dashboard - Avirant Enterprises");
        model.addAttribute("Quantityneeded", "Dashboard - Avirant Enterprises");
        model.addAttribute("deadline/duration", "Dashboard - Avirant Enterprises");
        model.addAttribute("uploadresourceexcelfile", "Dashboard - Avirant Enterprises");
        return "ResourceAllocationForm"; // Name of the HTML file
    }
}
