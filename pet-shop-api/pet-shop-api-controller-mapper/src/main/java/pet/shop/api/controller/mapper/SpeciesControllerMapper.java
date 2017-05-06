/**
 *
 */
package pet.shop.api.controller.mapper;

import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.domain.Species;

/**
 * Species controller mapper.
 *
 * Maps between {@link Species} and {@link SpeciesControllerEnum}.
 */
public interface SpeciesControllerMapper {

    /**
     * Map from {@link Species} to {@link SpeciesControllerEnum}.
     *
     * @param species
     *            {@link Species}.
     * @return {@link SpeciesControllerEnum}.
     */
    public SpeciesControllerEnum mapTo(Species species);

    /**
     * Map from {@link SpeciesControllerEnum} to {@link Species}.
     *
     * @param speciesControllerEnum
     *            {@link SpeciesControllerEnum}
     * @return {@link Species}.
     */
    public Species mapFrom(SpeciesControllerEnum speciesControllerEnum);

}
