package guru.springframework.msscbrewery.web.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

  @MockBean
  CustomerService customerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  CustomerDto validCustomer;

  @Before
  public void setUp() {
    validCustomer = CustomerDto.builder().id(UUID.randomUUID()).name("Customer1").build();
  }

  @Test
  public void getCustomer() throws Exception {
    given(customerService.getCustomerById(any())).willReturn(validCustomer);

    mockMvc.perform(get("/api/v1/customer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void saveCustomer() throws Exception {

      CustomerDto customerDto = validCustomer;
      String customerDtoJson = objectMapper.writeValueAsString(customerDto);

      given(customerService.save(any())).willReturn(validCustomer);

      mockMvc.perform(post("/api/v1/customer/")
              .contentType(MediaType.APPLICATION_JSON)
              .content(customerDtoJson))
              .andExpect(status().isCreated());
  }

  @Test
  public void updateCustomer() throws Exception {
      given(customerService.update(any(), any())).willReturn(validCustomer);

      CustomerDto customerDto = validCustomer;
      String customerDtoJson = objectMapper.writeValueAsString(customerDto);

      mockMvc.perform(put("/api/v1/customer/" + UUID.randomUUID().toString())
              .contentType(MediaType.APPLICATION_JSON)
              .content(customerDtoJson))
              .andExpect(status().isNoContent());
  }
}