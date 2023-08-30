package com.workintech.plant.service;

import com.workintech.plant.entity.Fruit;
import com.workintech.plant.entity.Vegetable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VegetableService {
    List<Vegetable> findAll();
    List<Vegetable> findAllByPriceDesc();
    List<Vegetable> findAllByPriceAsc();
    List<Vegetable> searchByName(String name);
    Vegetable find(int id);
    Vegetable save(Vegetable vegetable);
    void delete(Vegetable vegetable);
}
