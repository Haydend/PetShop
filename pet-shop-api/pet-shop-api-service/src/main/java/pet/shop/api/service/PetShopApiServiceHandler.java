/**
 *
 */
package pet.shop.api.service;

import java.util.Arrays;
import java.util.List;

import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;

/**
 * Implementation of {@link PetShopApiService}
 */
public class PetShopApiServiceHandler implements PetShopApiService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pet> retrieveAllPets() {

        final Pet dog = new Pet.PetBuilder().name("Rob").age(5).species(Species.DOG).status(Status.ADOPTED).build();
        final Pet cat = new Pet.PetBuilder().name("Socks")
            .age(1)
            .species(Species.CAT)
            .status(Status.AVAILABLE_FOR_ADOPTION)
            .build();

        return Arrays.asList(dog, cat);
    }

}
