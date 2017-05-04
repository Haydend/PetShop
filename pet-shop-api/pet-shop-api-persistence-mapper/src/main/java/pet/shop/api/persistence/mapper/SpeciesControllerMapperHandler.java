/**
 *
 */
package pet.shop.api.persistence.mapper;

import pet.shop.api.domain.Species;
import pet.shop.api.persistence.model.SpeciesPersistenceEnum;

/**
 * Implementation of {@link SpeciesPersistenceMapper}.
 */
public class SpeciesControllerMapperHandler implements SpeciesPersistenceMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public SpeciesPersistenceEnum mapTo(final Species species) {

        SpeciesPersistenceEnum speciesPersistenceEnum = null;

        if (species != null) {

            if (species == Species.DOG) {
                speciesPersistenceEnum = SpeciesPersistenceEnum.DOG;
            } else if (species == Species.CAT) {
                speciesPersistenceEnum = SpeciesPersistenceEnum.CAT;
            } else if (species == Species.FISH) {
                speciesPersistenceEnum = SpeciesPersistenceEnum.FISH;
            } else if (species == Species.RABBIT) {
                speciesPersistenceEnum = SpeciesPersistenceEnum.RABBIT;
            } else {
                throw new IllegalStateException("Enum is not handled.");
            }
        }

        return speciesPersistenceEnum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Species mapFrom(final SpeciesPersistenceEnum speciesPersistenceEnum) {

        Species species = null;

        if (speciesPersistenceEnum != null) {

            if (speciesPersistenceEnum == SpeciesPersistenceEnum.DOG) {
                species = Species.DOG;
            } else if (speciesPersistenceEnum == SpeciesPersistenceEnum.CAT) {
                species = Species.CAT;
            } else if (speciesPersistenceEnum == SpeciesPersistenceEnum.FISH) {
                species = Species.FISH;
            } else if (speciesPersistenceEnum == SpeciesPersistenceEnum.RABBIT) {
                species = Species.RABBIT;
            } else {
                throw new IllegalStateException("Enum is not handled.");
            }
        }

        return species;
    }

}
