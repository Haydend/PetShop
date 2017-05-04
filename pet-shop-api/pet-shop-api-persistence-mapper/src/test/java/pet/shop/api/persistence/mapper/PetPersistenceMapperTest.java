/**
 *
 */
package pet.shop.api.persistence.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;
import pet.shop.api.persistence.model.PetPersistenceModel;
import pet.shop.api.persistence.model.SpeciesPersistenceEnum;
import pet.shop.api.persistence.model.StatusPersistenceEnum;

/**
 * Tests for {@link PetPersistenceMapper}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PetPersistenceMapperTest {

    /** Name. */
    private static final String NAME = "Digger";

    /** Age. */
    private static final Integer AGE = 4;

    /** {@link Status}. */
    private static final Status STATUS = Status.ADOPTED;

    /** {@link Species}. */
    private static final Species SPECIES = Species.DOG;

    /** {@link StatusPersistenceEnum}. */
    private static final StatusPersistenceEnum STATUS_CONTROLER_ENUM = StatusPersistenceEnum.ADOPTED;

    /** {@link SpeciesPersistenceEnum}. */
    private static final SpeciesPersistenceEnum SPECIES_CONTROLLER_ENUM = SpeciesPersistenceEnum.DOG;

    /** Mock for {@link SpeciesPersistenceMapper}. */
    @Mock
    private SpeciesPersistenceMapper speciesPersistenceMapper;

    /** Mock for {@link StatusPersistenceMapper}. */
    @Mock
    private StatusPersistenceMapper statusPersistenceMapper;

    /** Class under test. */
    private PetPersistenceMapper petPersistenceMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {

        petPersistenceMapper = new PetPersistenceMapperHandler(speciesPersistenceMapper, statusPersistenceMapper);
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Pet pet = null;

        // Test
        final PetPersistenceModel actualPetPersistenceModel = petPersistenceMapper.mapTo(pet);

        // Assert
        Assert.assertNull(actualPetPersistenceModel);
    }

    /**
     * Check mapFrom method with null model.
     */
    @Test
    public void checkMapFromWithNullModel() {

        // Setup
        final PetPersistenceModel petPersistenceModel = null;

        // Test
        final Pet actualPet = petPersistenceMapper.mapFrom(petPersistenceModel);

        // Assert
        Assert.assertNull(actualPet);
    }

    /**
     * Check mapTo method with empty model.
     */
    @Test
    public void checkMapToWithEmptyModel() {

        // Setup
        final Pet pet = new Pet.PetBuilder().build();
        final PetPersistenceModel expectedPetPersistenceModel = new PetPersistenceModel();

        // Mock
        Mockito.when(statusPersistenceMapper.mapTo(null)).thenReturn(null);
        Mockito.when(speciesPersistenceMapper.mapTo(null)).thenReturn(null);

        // Test
        final PetPersistenceModel actualPetPersistenceModel = petPersistenceMapper.mapTo(pet);

        // Verify
        Mockito.verify(statusPersistenceMapper).mapTo(null);
        Mockito.verify(speciesPersistenceMapper).mapTo(null);

        // Assert
        Assert.assertEquals(expectedPetPersistenceModel, actualPetPersistenceModel);
    }

    /**
     * Check mapFrom method with empty model.
     */
    @Test
    public void checkMapFromWithEmptyModel() {

        // Setup
        final Pet expectedPet = new Pet.PetBuilder().build();
        final PetPersistenceModel petPersistenceModel = new PetPersistenceModel();

        // Mock
        Mockito.when(statusPersistenceMapper.mapFrom(null)).thenReturn(null);
        Mockito.when(speciesPersistenceMapper.mapFrom(null)).thenReturn(null);

        // Test
        final Pet actualPet = petPersistenceMapper.mapFrom(petPersistenceModel);

        // Verify
        Mockito.verify(statusPersistenceMapper).mapFrom(null);
        Mockito.verify(speciesPersistenceMapper).mapFrom(null);

        // Assert
        Assert.assertEquals(expectedPet, actualPet);
    }

    /**
     * Check mapTo method with full model.
     */
    @Test
    public void checkMapToWithFullModel() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).age(AGE).status(STATUS).species(SPECIES).build();

        final PetPersistenceModel expectedPetPersistenceModel = new PetPersistenceModel();
        expectedPetPersistenceModel.setName(NAME);
        expectedPetPersistenceModel.setAge(AGE);
        expectedPetPersistenceModel.setStatus(STATUS_CONTROLER_ENUM);
        expectedPetPersistenceModel.setSpecies(SPECIES_CONTROLLER_ENUM);

        // Mock
        Mockito.when(statusPersistenceMapper.mapTo(STATUS)).thenReturn(STATUS_CONTROLER_ENUM);
        Mockito.when(speciesPersistenceMapper.mapTo(SPECIES)).thenReturn(SPECIES_CONTROLLER_ENUM);

        // Test
        final PetPersistenceModel actualPetPersistenceModel = petPersistenceMapper.mapTo(pet);

        // Verify
        Mockito.verify(statusPersistenceMapper).mapTo(STATUS);
        Mockito.verify(speciesPersistenceMapper).mapTo(SPECIES);

        // Assert
        Assert.assertEquals(expectedPetPersistenceModel, actualPetPersistenceModel);
    }

    /**
     * Check mapFrom method with full model.
     */
    @Test
    public void checkMapFromWithFullModel() {

        // Setup
        final Pet expectPet = new Pet.PetBuilder().name(NAME).age(AGE).status(STATUS).species(SPECIES).build();

        final PetPersistenceModel petPersistenceModel = new PetPersistenceModel();
        petPersistenceModel.setName(NAME);
        petPersistenceModel.setAge(AGE);
        petPersistenceModel.setStatus(STATUS_CONTROLER_ENUM);
        petPersistenceModel.setSpecies(SPECIES_CONTROLLER_ENUM);

        // Mock
        Mockito.when(statusPersistenceMapper.mapFrom(STATUS_CONTROLER_ENUM)).thenReturn(STATUS);
        Mockito.when(speciesPersistenceMapper.mapFrom(SPECIES_CONTROLLER_ENUM)).thenReturn(SPECIES);

        // Test
        final Pet actualPet = petPersistenceMapper.mapFrom(petPersistenceModel);

        // Verify
        Mockito.verify(statusPersistenceMapper).mapFrom(STATUS_CONTROLER_ENUM);
        Mockito.verify(speciesPersistenceMapper).mapFrom(SPECIES_CONTROLLER_ENUM);

        // Assert
        Assert.assertEquals(expectPet, actualPet);
    }

}
