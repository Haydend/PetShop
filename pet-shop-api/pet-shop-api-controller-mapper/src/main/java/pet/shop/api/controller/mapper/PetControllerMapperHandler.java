/**
 *
 */
package pet.shop.api.controller.mapper;

import javax.inject.Inject;

import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.controller.model.StatusControlerEnum;
import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;

/**
 * Implementation of {@link PetControllerMapper}.
 */
public class PetControllerMapperHandler implements PetControllerMapper {

    /** {@link SpeciesControllerMapper}. */
    private final SpeciesControllerMapper speciesControllerMapper;

    /** {@link StatusControllerMapper}. */
    private final StatusControllerMapper statusControllerMapper;

    /**
     * Constructor for {@link PetControllerMapperHandler}.
     *
     * @param speciesControllerMapper
     *            {@link SpeciesControllerMapper}.
     * @param statusControllerMapper
     *            {@link StatusControllerMapper}.
     */
    @Inject
    public PetControllerMapperHandler(final SpeciesControllerMapper speciesControllerMapper,
            final StatusControllerMapper statusControllerMapper) {

        this.speciesControllerMapper = speciesControllerMapper;
        this.statusControllerMapper = statusControllerMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PetControllerModel mapTo(final Pet pet) {

        PetControllerModel petControllerModel = null;

        if (pet != null) {

            // Map Species.
            final SpeciesControllerEnum speciesControllerEnum = speciesControllerMapper.mapTo(pet.getSpecies());

            // Map Status.
            final StatusControlerEnum statusControlerEnum = statusControllerMapper.mapTo(pet.getStatus());

            // Build new model.
            petControllerModel = new PetControllerModel();
            petControllerModel.setName(pet.getName());
            petControllerModel.setAge(pet.getAge());
            petControllerModel.setSpecies(speciesControllerEnum);
            petControllerModel.setStatus(statusControlerEnum);
        }

        return petControllerModel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pet mapFrom(final PetControllerModel petControllerModel) {

        Pet pet = null;

        if (petControllerModel != null) {

            // Map Species.
            final Species species = speciesControllerMapper.mapFrom(petControllerModel.getSpecies());

            // Map Status.
            final Status status = statusControllerMapper.mapFrom(petControllerModel.getStatus());

            // Build new model.
            pet = new Pet.PetBuilder().name(petControllerModel.getName())
                .age(petControllerModel.getAge())
                .species(species)
                .status(status)
                .build();
        }

        return pet;
    }
}
