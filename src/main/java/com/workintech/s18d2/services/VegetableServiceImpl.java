package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;



    @Override
    public List<Vegetable> getVegetablesSortedByPriceAsc() {
        return vegetableRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public Vegetable getVegetableById(Long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if (vegetableOptional.isPresent()) {
            return vegetableOptional.get();
        }
        throw new PlantException("Fruit with id " + id + " not found.", HttpStatus.NOT_FOUND);
    }


    @Override
    public List<Vegetable> getVegetablesSortedByPriceDesc() {
        return vegetableRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public Vegetable updateVegetable(Long id, Vegetable updatedVegetable) {
        if (vegetableRepository.existsById(id)) {
            return vegetableRepository.save(updatedVegetable);
        }
        return null;
    }

    @Override
    public List<Vegetable> getVegetablesByNameContaining(String name) {
        return vegetableRepository.findByNameContaining(name);
    }

    @Override
    public void deleteVegetable(Long id) {
        vegetableRepository.deleteById(id);
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }
}
