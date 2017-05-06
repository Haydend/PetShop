/**
 *
 */
package pet.shop.api.service;

import java.util.List;

import pet.shop.api.domain.Pet;

/**
 * Pet Shop API service.
 */
public interface PetShopApiService {

    /**
     * Retrieve all pets.
     *
     * @return {@link List} of {@link Pet}s.
     */
    public List<Pet> retrieveAllPets();

    /**
     * Add new {@link Pet} to the store.
     *
     * @param pet
     *            {@link Pet} to be added.
     */
    public void addPet(Pet pet);

}
