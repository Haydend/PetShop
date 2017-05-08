/**
 *
 */
package pet.shop.api.controller;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pet.shop.api.controller.mapper.PetControllerMapper;
import pet.shop.api.controller.model.PetControllerModel;
import pet.shop.api.domain.Pet;
import pet.shop.api.service.PetShopApiService;

/**
 * Tests for {@link PetShopApiController}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PetShopApiControllerTest {

    /** Name. */
    private static final String NAME = "fred";

    /** {@link PetShopApiService}. */
    @Mock
    private PetShopApiService petShopApiService;

    /** {@link PetControllerMapper}. */
    @Mock
    private PetControllerMapper petControllerMapper;

    /** Class under test. */
    private PetShopApiController petShopApiController;

    /**
     * Setup for test.
     */
    @Before
    public void setup() {
        petShopApiController = new PetShopApiController(petShopApiService, petControllerMapper);
    }

    /**
     * Check retrieveAllPets method.
     */
    @Test
    @Ignore
    public void checkRetrieveAllPets() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).build();

        final PetControllerModel expectedPetControllerModel = new PetControllerModel();
        expectedPetControllerModel.setName(NAME);

        // Mock
        Mockito.when(petShopApiService.retrieveAllPets()).thenReturn(Arrays.asList(pet));
        Mockito.when(petControllerMapper.mapTo(pet)).thenReturn(expectedPetControllerModel);

        // Test
        final Response actualPetControllerModelList = petShopApiController.retrieveAllPets();

        // Verify
        Mockito.verify(petShopApiService).retrieveAllPets();
        Mockito.verify(petControllerMapper).mapTo(pet);

        // Assert
        Assert.assertEquals(Arrays.asList(expectedPetControllerModel), actualPetControllerModelList);
    }

}
