package com.spring.controller;

import com.spring.service.ICarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/main")
    public String showAllCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "main";
    }
}
