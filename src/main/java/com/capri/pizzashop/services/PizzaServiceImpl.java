package com.capri.pizzashop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capri.pizzashop.interception.EntityNotFoundException;
import com.capri.pizzashop.model.Pizza;
import com.capri.pizzashop.repos.PizzaRepo;

@Service
@Transactional
public class PizzaServiceImpl implements PizzaService {

  @Autowired
  private PizzaRepo pizzaRepo;

  @Override
  public Pizza createPizza(Pizza pizza) {
    return pizzaRepo.save(pizza);
  }

  @Override
  public Pizza updatePizza(Pizza pizza) {
    Optional<Pizza> pizzaDb = this.pizzaRepo.findById(pizza.getId());
    if (pizzaDb.isPresent()) {
      Pizza pizzaUpdate = pizzaDb.get();
      pizzaUpdate.setId(pizza.getId());
      pizzaUpdate.setSize(pizza.getSize());
      pizzaUpdate.setCheesyCrust(pizza.getCheesyCrust());
      pizzaUpdate.setTimeToDeliever(pizza.getTimeToDeliever());
      pizzaRepo.save(pizzaUpdate);
      return pizzaUpdate;
    } else {
      throw new EntityNotFoundException("Record not found with id : " + pizza.getId());
    }
  }

  @Override
  public List<Pizza> getAllPizzas() {
    return this.pizzaRepo.findAll();
  }

  @Override
  public Pizza getPizzaById(int pizzaId) {
    Optional<Pizza> pizzaDb = this.pizzaRepo.findById(pizzaId);
    if (pizzaDb.isPresent()) {
      return pizzaDb.get();
    } else {
      throw new EntityNotFoundException("Record not found with id : " + pizzaId);
    }
  }

  @Override
  public void deletePizza(int pizzaId) {
    Optional<Pizza> pizzaDb = this.pizzaRepo.findById(pizzaId);
    if (pizzaDb.isPresent()) {
      this.pizzaRepo.delete(pizzaDb.get());
    } else {
      throw new EntityNotFoundException("Record not found with id : " + pizzaId);
    }

  }
}