package com.workintech.plant.controller;

import com.workintech.plant.entity.Fruit;
import com.workintech.plant.exceptions.FruitException;
import com.workintech.plant.service.FruitService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
@Validated
public class FruitController {
    private FruitService fruitService;
@Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @GetMapping("/")
   public List<Fruit> get(){
    return fruitService.findAll();
    }
    @GetMapping("/{id}")
    public Fruit getById(@Positive @PathVariable int id){
    Fruit fruit=fruitService.find(id);
    if(fruit==null){throw new FruitException("Fruit with given id is not exist"+id, HttpStatus.BAD_REQUEST);
    }
    return fruit;
    }
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.findAllByPriceDesc();
    }
    @PostMapping("/")
    public Fruit save(@Validated @RequestBody Fruit fruit){
    return fruitService.save(fruit);
    }//@validated ile validasyon işlemlerini burda uygula dedik, yada sınıfın en üstüne yazılır
    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable int id){
    Fruit fruit=getById(id);
    fruitService.delete(fruit);
    return fruit;
    }
    @PostMapping("/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

}
