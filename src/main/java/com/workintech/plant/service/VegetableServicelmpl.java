package com.workintech.plant.service;

import com.workintech.plant.dao.VegetableRepository;
import com.workintech.plant.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VegetableServicelmpl implements VegetableService{
    private VegetableRepository vegetableRepository;
@Autowired
    public VegetableServicelmpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> findAllByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable find(int id) {
       Optional<Vegetable>optionalVegetable=vegetableRepository.findById(id);
       if(optionalVegetable.isPresent()){
           return optionalVegetable.get();
       }return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
    vegetableRepository.delete(vegetable);

    }
}
