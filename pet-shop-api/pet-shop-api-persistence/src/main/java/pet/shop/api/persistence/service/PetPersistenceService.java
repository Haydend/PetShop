package pet.shop.api.persistence.service;

import java.util.List;

import pet.shop.api.domain.Pet;

/**
 * Pet persistence service.
 */
public interface PetPersistenceService {

    /**
     * Save {@link Pet}.
     *
     * @param pet
     *            {@link Pet} to save.
     * @return Saved instance of {@link Pet}.
     */
    Pet savePet(Pet pet);

    /**
     * Find all {@link Pet}s.
     *
     * @return {@link List} of all {@link Pet}s.
     */
    List<Pet> findAllPets();

    /**
     * Find {@link Pet} by Identifier.
     *
     * @param id
     *            Identifier for {@link Pet}.
     * @return {@link Pet} with identifier.
     */
    Pet findPetById(Long id);

}
