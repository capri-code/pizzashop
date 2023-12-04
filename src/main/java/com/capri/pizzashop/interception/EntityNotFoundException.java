package com.capri.pizzashop.interception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EntityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public EntityNotFoundException(String message) {
    super(message);
  }

  public EntityNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
