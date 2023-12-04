package com.capri.pizzashop.services;

import java.util.List;

import com.capri.pizzashop.model.Pizza;

public interface PizzaService {
  Pizza createPizza(Pizza pizza);

  Pizza updatePizza(Pizza Pizza);

  List<Pizza> getAllPizzas();

  Pizza getPizzaById(int PizzaId);

  void deletePizza(int id);
}
