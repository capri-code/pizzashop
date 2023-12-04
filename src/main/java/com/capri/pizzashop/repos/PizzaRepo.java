package com.capri.pizzashop.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capri.pizzashop.model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
}
