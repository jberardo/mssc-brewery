package guru.springframework.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 saveBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        return beerDto;
    }

    @Override
    public void delete(UUID beerId) {
        log.debug("Deleting beer with id: ".concat(beerId.toString()));
    }
}
