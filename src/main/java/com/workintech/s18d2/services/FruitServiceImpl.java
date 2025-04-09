package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public Fruit getById(Long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if (fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        throw new PlantException("Fruit with id " + id + " not found.", HttpStatus.NOT_FOUND);
    }


    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit updateFruit(Long id, Fruit updatedFruit) {
        if (fruitRepository.existsById(id)) {
            return fruitRepository.save(updatedFruit);
        }
        return null;
    }

    @Override
    public List<Fruit>  searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        Optional<Fruit> foundFruit = fruitRepository.findById(id);
        if (foundFruit.isPresent()) {
            fruitRepository.deleteById(id);
            return foundFruit.get();
        } else {
            throw new PlantException("Fruit with id " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Fruit save(Fruit fruit) {
         return fruitRepository.save(fruit);
    }
}
