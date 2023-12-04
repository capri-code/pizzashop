package com.capri.pizzashop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capri.pizzashop.model.Pizza;
import com.capri.pizzashop.services.PizzaService;

@RestController
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  @GetMapping("/pizzas")
  public ResponseEntity<List<Pizza>> getAllPizzas() {
    return ResponseEntity.ok().body(pizzaService.getAllPizzas());
  }

  @GetMapping("/pizzas/{id}")
  public ResponseEntity<Pizza> getPizzaById(@PathVariable int id) {
    return ResponseEntity.ok().body(pizzaService.getPizzaById(id));
  }

  @PostMapping("/pizzas")
  public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
    return ResponseEntity.ok().body(this.pizzaService.createPizza(pizza));
  }

  @PutMapping("/pizzas/{id}")
  public ResponseEntity<Pizza> updatePizza(@PathVariable int id, @RequestBody Pizza pizza) {
    pizza.setId(id);
    return ResponseEntity.ok().body(this.pizzaService.updatePizza(pizza));
  }

  @DeleteMapping("/pizzas/{id}")
  public HttpStatus deletePizza(@PathVariable int id) {
    this.pizzaService.deletePizza(id);
    return HttpStatus.OK;
  }

}
