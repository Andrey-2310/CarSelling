package com.a.redkovsky.carselling.controller;

import com.a.redkovsky.carselling.model.Car;
import com.a.redkovsky.carselling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/getAll")
    public String getCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCar(Model model, @RequestParam("id") Long id) {
        carService.deleteCar(id);
        return "redirect:/cars/getAll";
    }

    @RequestMapping(value = "/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createCar(Model model) {
        model.addAttribute("newCar", new Car());
        return "newCar";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String submitCar(Model model, @ModelAttribute Car newCar) {
        carService.saveCar(newCar);
        return "redirect:/cars/getAll";
    }
}
