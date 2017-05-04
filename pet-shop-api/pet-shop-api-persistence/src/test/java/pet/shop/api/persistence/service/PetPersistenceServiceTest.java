package pet.shop.api.persistence.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pet.shop.api.domain.Pet;
import pet.shop.api.persistence.mapper.PetPersistenceMapper;
import pet.shop.api.persistence.model.PetPersistenceModel;
import pet.shop.api.persistence.repository.PetRepository;

/**
 * Tests for {@link PetPersistenceService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PetPersistenceServiceTest {

    private static final String NAME = null;

    private static final Long ID = null;

    /** Mock for {@link PetRepository}. */
    @Mock
    private PetRepository petRepository;

    /** Mock for {@link PetPersistenceMapper}. */
    @Mock
    private PetPersistenceMapper petPersistenceMapper;

    /** Class under test. */
    private PetPersistenceService petPersistenceService;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        petPersistenceService = new PetPersistenceServiceHandler(petRepository, petPersistenceMapper);
    }

    /**
     * Check savePet method.
     */
    @Test
    public void checkSavePet() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).build();
        final Pet savedPet = new Pet.PetBuilder().name(NAME).id(ID).build();

        final PetPersistenceModel petPersistenceModel = new PetPersistenceModel();
        petPersistenceModel.setName(NAME);
        final PetPersistenceModel savedPetPersistenceModel = new PetPersistenceModel();
        savedPetPersistenceModel.setName(NAME);
        savedPetPersistenceModel.setId(ID);

        // Mock
        Mockito.when(petPersistenceMapper.mapTo(pet)).thenReturn(petPersistenceModel);
        Mockito.when(petRepository.save(petPersistenceModel)).thenReturn(savedPetPersistenceModel);
        Mockito.when(petPersistenceMapper.mapFrom(savedPetPersistenceModel)).thenReturn(savedPet);

        // Test
        final Pet actualPet = petPersistenceService.savePet(pet);

        // Verify
        Mockito.verify(petPersistenceMapper).mapTo(pet);
        Mockito.verify(petRepository).save(petPersistenceModel);
        Mockito.verify(petPersistenceMapper).mapFrom(savedPetPersistenceModel);

        // Assert
        Assert.assertEquals(savedPet, actualPet);
    }

    /**
     * Check findAllPets method.
     */
    @Test
    public void checkFindAllPets() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).build();
        final PetPersistenceModel petPersistenceModel = new PetPersistenceModel();
        petPersistenceModel.setName(NAME);

        // Mock
        Mockito.when(petRepository.findAll()).thenReturn(Arrays.asList(petPersistenceModel));
        Mockito.when(petPersistenceMapper.mapFrom(petPersistenceModel)).thenReturn(pet);

        // Test
        final List<Pet> actualPetList = petPersistenceService.findAllPets();

        // Verify
        Mockito.verify(petRepository).findAll();
        Mockito.verify(petPersistenceMapper).mapFrom(petPersistenceModel);

        // Assert
        Assert.assertEquals(Arrays.asList(pet), actualPetList);
    }

    /**
     * Check findPetById method.
     */
    @Test
    public void checkFindPetById() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).id(ID).build();
        final PetPersistenceModel petPersistenceModel = new PetPersistenceModel();
        petPersistenceModel.setName(NAME);
        petPersistenceModel.setId(ID);

        // Mock
        Mockito.when(petRepository.findBy(ID)).thenReturn(petPersistenceModel);
        Mockito.when(petPersistenceMapper.mapFrom(petPersistenceModel)).thenReturn(pet);

        // Test
        final Pet actualPet = petPersistenceService.findPetById(ID);

        // Verify
        Mockito.verify(petRepository).findBy(ID);
        Mockito.verify(petPersistenceMapper).mapFrom(petPersistenceModel);

        // Assert
        Assert.assertEquals(pet, actualPet);
    }

}
