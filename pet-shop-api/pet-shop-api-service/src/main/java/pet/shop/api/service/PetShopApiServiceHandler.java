/**
 *
 */
package pet.shop.api.service;

import java.util.List;

import javax.inject.Inject;

import pet.shop.api.domain.Pet;
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

        // Retrieve all pets from the persistence layer.
        final List<Pet> petList = petPersistenceService.findAllPets();

        return petList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPet(final Pet pet) {

        // Pass pet to persistence layer to be saved.
        petPersistenceService.savePet(pet);
    }

}
