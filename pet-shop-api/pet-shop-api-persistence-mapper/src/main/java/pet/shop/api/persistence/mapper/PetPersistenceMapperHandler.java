/**
 *
 */
package pet.shop.api.persistence.mapper;

import javax.inject.Inject;

import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;
import pet.shop.api.persistence.model.PetPersistenceModel;
import pet.shop.api.persistence.model.SpeciesPersistenceEnum;
import pet.shop.api.persistence.model.StatusPersistenceEnum;

/**
 * Implementation of {@link PetPersistenceMapper}.
 */
public class PetPersistenceMapperHandler implements PetPersistenceMapper {

    /** {@link SpeciesPersistenceMapper}. */
    private final SpeciesPersistenceMapper speciesPersistenceMapper;

    /** {@link StatusPersistenceMapper}. */
    private final StatusPersistenceMapper statusPersistenceMapper;

    /**
     * Constructor for {@link PetPersistenceMapperHandler}.
     *
     * @param speciesPersistenceMapper
     *            {@link SpeciesPersistenceMapper}.
     * @param statusPersistenceMapper
     *            {@link StatusPersistenceMapper}.
     */
    @Inject
    public PetPersistenceMapperHandler(final SpeciesPersistenceMapper speciesPersistenceMapper,
            final StatusPersistenceMapper statusPersistenceMapper) {

        this.speciesPersistenceMapper = speciesPersistenceMapper;
        this.statusPersistenceMapper = statusPersistenceMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetPersistenceModel mapTo(final Pet pet) {

        PetPersistenceModel petPersistenceModel = null;

        if (pet != null) {

            // Map Species.
            final SpeciesPersistenceEnum speciesPersistenceEnum = speciesPersistenceMapper.mapTo(pet.getSpecies());

            // Map Status.
            final StatusPersistenceEnum statusPersistenceEnum = statusPersistenceMapper.mapTo(pet.getStatus());

            // Build new model.
            petPersistenceModel = new PetPersistenceModel();
            petPersistenceModel.setName(pet.getName());
            petPersistenceModel.setAge(pet.getAge());
            petPersistenceModel.setSpecies(speciesPersistenceEnum);
            petPersistenceModel.setStatus(statusPersistenceEnum);
        }

        return petPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pet mapFrom(final PetPersistenceModel petPersistenceModel) {

        Pet pet = null;

        if (petPersistenceModel != null) {

            // Map Species.
            final Species species = speciesPersistenceMapper.mapFrom(petPersistenceModel.getSpecies());

            // Map Status.
            final Status status = statusPersistenceMapper.mapFrom(petPersistenceModel.getStatus());

            // Build new model.
            pet = new Pet.PetBuilder().name(petPersistenceModel.getName())
                .age(petPersistenceModel.getAge())
                .species(species)
                .status(status)
                .build();
        }

        return pet;
    }

}
