package com.example.bmi_beregner.BMIController;

import com.example.bmi_beregner.BMIService.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BMIController {

    @Autowired
    private BMIService bmiService;

    @GetMapping("/bmicalculator")
    public String showBMICalculatorForm() {
        return "bmicalculator";
    }

    @PostMapping("/calculateBMI")
    public String calculateBMI(@RequestParam("weight") double weight, @RequestParam("height") double height, RedirectAttributes redirectAttributes) {
        double bmi = bmiService.calculateBMI(weight, height);
        redirectAttributes.addAttribute("bmi", bmi);
        return "redirect:/bmiresult";
    }

    @GetMapping("/bmiresult")
    public String showBMIResult(@RequestParam("bmi") double bmi, Model model) {
        model.addAttribute("bmi", bmi);
        return "bmiresult";
    }
}

