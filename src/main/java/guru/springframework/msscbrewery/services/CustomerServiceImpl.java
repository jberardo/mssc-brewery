package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID id) {
    log.debug("Retrieving customer id: ".concat(id.toString()));

    return CustomerDto.builder()
              .id(UUID.randomUUID())
              .name("Customer 1")
              .build();
  }

  @Override
  public CustomerDto save(CustomerDto customerDto) {
    log.debug("Saving customer name: ".concat(customerDto.getName()));

    return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("John Doe")
                .build();
  }

  @Override
  public CustomerDto update(UUID customerId, CustomerDto customerDto) {
    log.debug("Updating customer id: ".concat(customerId.toString()));

    return customerDto;
  }

  @Override
  public void delete(UUID customerId) {
    log.debug("Deleting customer id: ".concat(customerId.toString()));
  }
}
