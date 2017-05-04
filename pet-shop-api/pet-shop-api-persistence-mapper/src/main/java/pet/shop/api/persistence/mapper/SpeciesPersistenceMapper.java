/**
 *
 */
package pet.shop.api.persistence.mapper;

import pet.shop.api.domain.Species;
import pet.shop.api.persistence.model.SpeciesPersistenceEnum;

/**
 * Species persistence mapper.
 *
 * Maps between {@link Species} and {@link SpeciesPersistenceEnum}.
 */
public interface SpeciesPersistenceMapper {

    /**
     * Map from {@link Species} to {@link SpeciesPersistenceEnum}.
     *
     * @param species
     *            {@link Species}.
     * @return {@link SpeciesPersistenceEnum}.
     */
    public SpeciesPersistenceEnum mapTo(Species species);

    /**
     * Map from {@link SpeciesPersistenceEnum} to {@link Species}.
     *
     * @param speciesPersistenceEnum
     *            {@link SpeciesPersistenceEnum}
     * @return {@link Species}.
     */
    public Species mapFrom(SpeciesPersistenceEnum speciesPersistenceEnum);

}
