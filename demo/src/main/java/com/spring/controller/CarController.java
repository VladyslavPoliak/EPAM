package com.spring.controller;

import com.spring.service.ICarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("producers")
public class CarController {

    private final ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping("/main")
    public String showMainPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("producers", carService.getAllMarks());
        model.addAttribute("classes", carService.getAllClasses());
        return "main";
    }

    @GetMapping("/mark/**")
    public String showMark(Model model, @RequestParam(name = "mark") String mark) {
        model.addAttribute("cars", carService.getCarsByMark(mark));
        return "main";
    }
}
