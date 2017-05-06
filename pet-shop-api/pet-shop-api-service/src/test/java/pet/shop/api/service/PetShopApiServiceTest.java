/**
 *
 */
package pet.shop.api.service;

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
import pet.shop.api.persistence.service.PetPersistenceService;

/**
 * Tests for {@link PetShopApiService}.
 */
@RunWith(MockitoJUnitRunner.class)
public class PetShopApiServiceTest {

    /** Name of dog. */
    private static final String NAME = "Doggo";

    /** Mock for {@link PetPersistenceService}. */
    @Mock
    private PetPersistenceService petPersistenceService;

    /** Class under test. */
    private PetShopApiService petShopApiService;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        petShopApiService = new PetShopApiServiceHandler(petPersistenceService);
    }

    /**
     * Check retrieveAllPets method.
     */
    @Test
    public void checkRetrieveAllPets() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).build();
        final List<Pet> expectedPetList = Arrays.asList(pet);

        // Mock
        Mockito.when(petPersistenceService.findAllPets()).thenReturn(Arrays.asList(pet));

        // Test
        final List<Pet> actualPetList = petShopApiService.retrieveAllPets();

        // Verify
        Mockito.verify(petPersistenceService).findAllPets();

        // Assert
        Assert.assertEquals(expectedPetList, actualPetList);
    }

    /**
     * Check addPet method.
     */
    @Test
    public void checkAddPet() {

        // Setup
        final Pet pet = new Pet.PetBuilder().name(NAME).build();

        // Test
        petShopApiService.addPet(pet);

        // Verify
        Mockito.verify(petPersistenceService).savePet(pet);
    }

}
