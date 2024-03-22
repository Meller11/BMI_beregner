package com.example.bmi_beregner.BMIService;

import org.springframework.stereotype.Service;

@Service
public class BMIService {
    public double calculateBMI(double weight, double height) {
        return weight / Math.pow(height / 100, 2);
    }
}

