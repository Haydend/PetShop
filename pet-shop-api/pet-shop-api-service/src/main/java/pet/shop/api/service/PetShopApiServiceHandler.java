/**
 *
 */
package pet.shop.api.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;
import pet.shop.api.persistence.service.PetPersistenceService;

/**
 * Implementation of {@link PetShopApiService}
 */
public class PetShopApiServiceHandler implements PetShopApiService {

    /** {@link PetPersistenceService}. */
    private final PetPersistenceService petPersistenceService;

    /**
     * Constructor.
     *
     * @param petPersistenceService
     *            {@link PetPersistenceService}.
     */
    @Inject
    public PetShopApiServiceHandler(final PetPersistenceService petPersistenceService) {

        this.petPersistenceService = petPersistenceService;
    }

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

        petPersistenceService.savePet(dog);

        return Arrays.asList(dog, cat);
    }

}
