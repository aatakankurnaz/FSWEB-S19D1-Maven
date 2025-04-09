package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllVegetablesAsc() {
        return vegetableService.getVegetablesSortedByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getVegetableById(@PathVariable long id) {
        return vegetableService.getVegetableById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllVegetablesDesc() {
        return vegetableService.getVegetablesSortedByPriceDesc();
    }

    @PostMapping
    public Vegetable saveOrUpdateVegetable(@RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PostMapping("/{name}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name) {
        return vegetableService.getVegetablesByNameContaining(name);
    }

    @DeleteMapping("/{id}")
    public void deleteVegetable(@PathVariable long id) {
        vegetableService.deleteVegetable(id);
    }
}
