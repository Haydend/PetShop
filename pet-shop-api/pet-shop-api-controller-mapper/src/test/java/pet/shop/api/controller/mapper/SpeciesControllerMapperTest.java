/**
 *
 */
package pet.shop.api.controller.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pet.shop.api.controller.model.SpeciesControllerEnum;
import pet.shop.api.domain.Species;

/**
 * Tests for {@link SpeciesControllerMapper}.
 */
public class SpeciesControllerMapperTest {

    /** Class under test. */
    private SpeciesControllerMapper speciesControllerMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        speciesControllerMapper = new SpeciesControllerMapperHandler();
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Species species = null;

        // Test
        final SpeciesControllerEnum actualSpeciesControllerEnum = speciesControllerMapper.mapTo(species);

        // Assert
        Assert.assertNull(actualSpeciesControllerEnum);
    }

    /**
     * Check mapTo method with Dog enum.
     */
    @Test
    public void checkMaptoWithDogEnum() {

        // Setup
        final Species species = Species.DOG;
        final SpeciesControllerEnum expectedSpeciesControllerEnum = SpeciesControllerEnum.DOG;

        // Test
        final SpeciesControllerEnum actualSpeciesControllerEnum = speciesControllerMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesControllerEnum, actualSpeciesControllerEnum);
    }

    /**
     * Check mapTo method with Cat enum.
     */
    @Test
    public void checkMaptoWithCatEnum() {

        // Setup
        final Species species = Species.CAT;
        final SpeciesControllerEnum expectedSpeciesControllerEnum = SpeciesControllerEnum.CAT;

        // Test
        final SpeciesControllerEnum actualSpeciesControllerEnum = speciesControllerMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesControllerEnum, actualSpeciesControllerEnum);
    }

    /**
     * Check mapTo method with Fish enum.
     */
    @Test
    public void checkMaptoWithFishEnum() {

        // Setup
        final Species species = Species.FISH;
        final SpeciesControllerEnum expectedSpeciesControllerEnum = SpeciesControllerEnum.FISH;

        // Test
        final SpeciesControllerEnum actualSpeciesControllerEnum = speciesControllerMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesControllerEnum, actualSpeciesControllerEnum);
    }

    /**
     * Check mapTo method with Rabbit enum.
     */
    @Test
    public void checkMaptoWithRabbitEnum() {

        // Setup
        final Species species = Species.RABBIT;
        final SpeciesControllerEnum expectedSpeciesControllerEnum = SpeciesControllerEnum.RABBIT;

        // Test
        final SpeciesControllerEnum actualSpeciesControllerEnum = speciesControllerMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesControllerEnum, actualSpeciesControllerEnum);
    }
}
