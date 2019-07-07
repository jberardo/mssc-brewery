package guru.springframework.msscbrewery.web.mapper;

import org.mapstruct.Mapper;

import guru.springframework.msscbrewery.domain.Customer;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

  CustomerDto customerToCustomerDTO(Customer customer);

  Customer customerDTOToCustomer(CustomerDto customerDto);
}