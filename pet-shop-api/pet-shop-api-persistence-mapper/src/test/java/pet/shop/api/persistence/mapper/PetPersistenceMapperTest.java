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
     * Check mapTo method with empty model.
     */
    @Test
    public void checkMaptoWithEmptyModel() {

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
     * Check mapTo method with full model.
     */
    @Test
    public void checkMaptoWithFullModel() {

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

}
