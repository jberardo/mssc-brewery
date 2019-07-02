package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID id) {
    return CustomerDto.builder()
              .id(UUID.randomUUID())
              .name("Customer 1")
              .build();
  }
}