/**
 *
 */
package pet.shop.api.controller.mapper;

import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.domain.Pet;

/**
 * Pet controller mapper.
 *
 * Maps between {@link PetControllerModel} and {@link Pet}.
 */
public interface PetControllerMapper {

    /**
     * Map from {@link Pet} to {@link PetControllerModel}.
     *
     * @param pet
     *            {@link Pet}.
     * @return {@link PetControllerModel}.
     */
    public PetControllerModel mapTo(Pet pet);

}
