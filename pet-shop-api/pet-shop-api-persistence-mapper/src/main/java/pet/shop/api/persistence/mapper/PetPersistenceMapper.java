/**
 *
 */
package pet.shop.api.persistence.mapper;

import pet.shop.api.domain.Pet;
import pet.shop.api.persistence.model.PetPersistenceModel;

/**
 * Pet persistence mapper.
 *
 * Maps between {@link PetPersistenceModel} and {@link Pet}.
 */
public interface PetPersistenceMapper {

    /**
     * Map from {@link Pet} to {@link PetPersistenceModel}.
     *
     * @param pet
     *            {@link Pet}.
     * @return {@link PetPersistenceModel}.
     */
    public PetPersistenceModel mapTo(Pet pet);

}
