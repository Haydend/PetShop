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

}
