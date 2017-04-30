/**
 *
 */
package pet.shop.api.controller.mapper;

import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.domain.Species;

/**
 * Implementation of {@link SpeciesControllerMapper}.
 */
public class SpeciesControllerMapperHandler implements SpeciesControllerMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public SpeciesControllerEnum mapTo(final Species species) {

        SpeciesControllerEnum speciesControllerEnum = null;

        if (species != null) {

            if (species == Species.DOG) {
                speciesControllerEnum = SpeciesControllerEnum.DOG;
            } else if (species == Species.CAT) {
                speciesControllerEnum = SpeciesControllerEnum.CAT;
            } else if (species == Species.FISH) {
                speciesControllerEnum = SpeciesControllerEnum.FISH;
            } else if (species == Species.RABBIT) {
                speciesControllerEnum = SpeciesControllerEnum.RABBIT;
            } else {
                throw new IllegalStateException("Enum is not handled.");
            }
        }

        return speciesControllerEnum;
    }

}
