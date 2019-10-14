package com.spring.controller;

import com.spring.service.ICarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"producers", "classes"})
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
    public String showCarsByMark(Model model, @RequestParam(name = "mark") String mark) {
        model.addAttribute("cars", carService.getCarsByMark(mark));
        return "main";
    }

    @GetMapping("/clas/**")
    public String showCarsByClass(Model model, @RequestParam(name = "clas") String className) {
        model.addAttribute("cars", carService.getCarsByClass(className));
        return "main";
    }
}
