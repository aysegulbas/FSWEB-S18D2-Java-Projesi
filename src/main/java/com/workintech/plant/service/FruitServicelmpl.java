package com.workintech.plant.service;

import com.workintech.plant.dao.FruitRepository;
import com.workintech.plant.entity.Fruit;
import com.workintech.plant.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServicelmpl implements FruitService {
    private FruitRepository fruitRepository;
@Autowired
    public FruitServicelmpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit find(int id) {
        Optional<Fruit>fruitOptional=fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        return null;
    }

    @Override
    public List<Fruit> findAllByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> findAllByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public void delete(Fruit fruit) {
    fruitRepository.delete(fruit);

    }
}
