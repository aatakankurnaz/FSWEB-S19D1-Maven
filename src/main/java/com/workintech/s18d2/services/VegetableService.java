package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {

    List<Vegetable> getVegetablesSortedByPriceAsc();

    Vegetable getVegetableById(Long id);

    List<Vegetable> getVegetablesSortedByPriceDesc();

    Vegetable updateVegetable(Long id, Vegetable updatedVegetable);

    List<Vegetable> getVegetablesByNameContaining(String name);

    void deleteVegetable(Long id);

    Vegetable save(Vegetable vegetable);

}
