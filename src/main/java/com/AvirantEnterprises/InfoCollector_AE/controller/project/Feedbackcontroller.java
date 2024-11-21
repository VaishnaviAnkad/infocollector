package com.AvirantEnterprises.InfoCollector_AE.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Feedbackcontroller {

    @GetMapping("/FeedbackandIssueTrackingForm.html")
    public String showDashboard(Model model) {
        model.addAttribute("Projectfeedback", "Dashboard - Avirant Enterprises");
        model.addAttribute("issueDiscription", "Dashboard - Avirant Enterprises");
        return "FeedbackandIssueTrackingForm"; // Name of the HTML file
    }
}
