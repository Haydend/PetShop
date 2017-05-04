/**
 *
 */
package pet.shop.api.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import pet.shop.api.domain.Pet;
import pet.shop.api.persistence.mapper.PetPersistenceMapper;
import pet.shop.api.persistence.model.PetPersistenceModel;
import pet.shop.api.persistence.repository.PetRepository;

/**
 * Implementation of {@link PetPersistenceService}.
 */
public class PetPersistenceServiceHandler implements PetPersistenceService {

    /** {@link PetRepository}. */
    private final PetRepository petRepository;

    /** {@link PetPersistenceMapper}. */
    private final PetPersistenceMapper petPersistenceMapper;

    /**
     * Constructor.
     *
     * @param petRepository
     *            {@link PetRepository}.
     * @param petPersistenceMapper
     *            {@link PetPersistenceMapper}.
     */
    @Inject
    public PetPersistenceServiceHandler(final PetRepository petRepository,
            final PetPersistenceMapper petPersistenceMapper) {

        this.petRepository = petRepository;
        this.petPersistenceMapper = petPersistenceMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pet savePet(final Pet pet) {

        // Map from domain to persistence model.
        final PetPersistenceModel petPersistenceModel = petPersistenceMapper.mapTo(pet);

        // Save model.
        final PetPersistenceModel savedPetPersistenceModel = petRepository.save(petPersistenceModel);

        // Map saved persistence model to domain modal.
        final Pet savedPet = petPersistenceMapper.mapFrom(savedPetPersistenceModel);

        return savedPet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pet> findAllPets() {

        // Retrieve all pets.
        final List<PetPersistenceModel> petPersistenceModelList = petRepository.findAll();

        // Map pets from persistence to domain model.
        final List<Pet> petList = new ArrayList<>();
        for (final PetPersistenceModel petPersistenceModel : petPersistenceModelList) {

            final Pet pet = petPersistenceMapper.mapFrom(petPersistenceModel);
            petList.add(pet);
        }

        return petList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pet findPetById(final Long id) {

        // Retrieve pet by identifier.
        final PetPersistenceModel petPersistenceModel = petRepository.findBy(id);

        // Map pet from persistence to domain model.
        final Pet pet = petPersistenceMapper.mapFrom(petPersistenceModel);

        return pet;
    }

}
