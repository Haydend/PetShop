/**
 *
 */
package pet.shop.api.persistence.service;

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

        final PetPersistenceModel petPersistenceModel = petPersistenceMapper.mapTo(pet);

        final PetPersistenceModel savedPetPersistenceModel = petRepository.save(petPersistenceModel);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pet> findAllPets() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pet findPetById(final Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
