package guru.springframework.msscbrewery.services.v2;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveBeer(BeerDtoV2 beerDto);

	BeerDtoV2 updateBeer(UUID beerId, BeerDtoV2 beerDto);

	void delete(UUID beerId);
}
