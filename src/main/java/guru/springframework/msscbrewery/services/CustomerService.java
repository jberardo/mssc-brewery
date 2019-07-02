package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;

/**
 * Customer Service Interface
 * 
 * @author Joao Berardo
 */
public interface CustomerService {
  public CustomerDto getCustomerById(UUID id);
}