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

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;

@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

  @MockBean
  BeerService beerService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  BeerDto validBeer;

  @Before
  public void setUp() {
    validBeer = BeerDto.builder()
                        .id(UUID.randomUUID())
                        .beerName("Beer1")
                        .beerStyle("PALE_ALE")
                        .upc(123456789012L)
                        .build();
  }

  @Test
  public void getBeer() throws Exception {
    given(beerService.getBeerById(any())).willReturn(validBeer);


    mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk());
  }

  @Test
  public void saveBeer() throws Exception {

    BeerDto beerDto = validBeer;
    beerDto.setId(null);

    String beerDtoJson = objectMapper.writeValueAsString(beerDto);
    BeerDto savedBeerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();

    given(beerService.saveBeer(any())).willReturn(savedBeerDto);

    mockMvc.perform(post("/api/v1/beer/")
            .contentType(MediaType.APPLICATION_JSON)
            .content(beerDtoJson))
            .andExpect(status().isCreated());
  }

  @Test
  public void updateBeer() throws Exception {
    BeerDto beerDto = validBeer;
    beerDto.setId(null);
    String beerDtoJson = objectMapper.writeValueAsString(beerDto);
    given(beerService.updateBeer(any(), any())).willReturn(validBeer);

      mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
              .contentType(MediaType.APPLICATION_JSON)
              .content(beerDtoJson))
              .andExpect(status().isNoContent());
  }
}