/**
 *
 */
package pet.shop.api.controller.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.controller.model.StatusControlerEnum;
import pet.shop.api.domain.Pet;
import pet.shop.api.domain.Species;
import pet.shop.api.domain.Status;

/**
 * Tests for {@link PetControllerMapper}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PetControllerMapperTest {

    /** Name. */
    private static final String NAME = "Digger";

    /** Age. */
    private static final Integer AGE = 4;

    /** {@link Status}. */
    private static final Status STATUS = Status.ADOPTED;

    /** {@link Species}. */
    private static final Species SPECIES = Species.DOG;

    /** {@link StatusControlerEnum}. */
    private static final StatusControlerEnum STATUS_CONTROLER_ENUM = StatusControlerEnum.ADOPTED;

    /** {@link SpeciesControllerEnum}. */
    private static final SpeciesControllerEnum SPECIES_CONTROLLER_ENUM = SpeciesControllerEnum.DOG;

    /** Mock for {@link SpeciesControllerMapper}. */
    @Mock
    private SpeciesControllerMapper speciesControllerMapper;

    /** Mock for {@link StatusControllerMapper}. */
    @Mock
    private StatusControllerMapper statusControllerMapper;

    /** Class under test. */
    private PetControllerMapper petControllerMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {

        petControllerMapper = new PetControllerMapperHandler(speciesControllerMapper, statusControllerMapper);
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Pet pet = null;

        // Test
        final PetControllerModel actualPetControllerModel = petControllerMapper.mapTo(pet);

        // Assert
        Assert.assertNull(actualPetControllerModel);
    }

    /**
     * Check mapTo method with empty model.
     */
    @Test
    public void checkMaptoWithEmptyModel() {

        // Setup
        final Pet pet = new Pet.PetBuilder().build();
        final PetControllerModel expectedPetControllerModel = new PetControllerModel();

        // Mock
        Mockito.when(statusControllerMapper.mapTo(null)).thenReturn(null);
        Mockito.when(speciesControllerMapper.mapTo(null)).thenReturn(null);

        // Test
        final PetControllerModel actualPetControllerModel = petControllerMapper.mapTo(pet);

        // Verify
        Mockito.verify(statusControllerMapper).mapTo(null);
        Mockito.verify(speciesControllerMapper).mapTo(null);

        // Assert
        Assert.assertEquals(expectedPetControllerModel, actualPetControllerModel);
    }

    /**
     * Check mapTo method with full model.
     */
    @Test
    public void checkMaptoWithFullModel() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).age(AGE).status(STATUS).species(SPECIES).build();

        final PetControllerModel expectedPetControllerModel = new PetControllerModel();
        expectedPetControllerModel.setName(NAME);
        expectedPetControllerModel.setAge(AGE);
        expectedPetControllerModel.setStatus(STATUS_CONTROLER_ENUM);
        expectedPetControllerModel.setSpecies(SPECIES_CONTROLLER_ENUM);

        // Mock
        Mockito.when(statusControllerMapper.mapTo(STATUS)).thenReturn(STATUS_CONTROLER_ENUM);
        Mockito.when(speciesControllerMapper.mapTo(SPECIES)).thenReturn(SPECIES_CONTROLLER_ENUM);

        // Test
        final PetControllerModel actualPetControllerModel = petControllerMapper.mapTo(pet);

        // Verify
        Mockito.verify(statusControllerMapper).mapTo(STATUS);
        Mockito.verify(speciesControllerMapper).mapTo(SPECIES);

        // Assert
        Assert.assertEquals(expectedPetControllerModel, actualPetControllerModel);
    }

}
