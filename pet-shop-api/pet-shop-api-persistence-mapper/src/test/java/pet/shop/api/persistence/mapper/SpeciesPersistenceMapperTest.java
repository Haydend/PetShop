/**
 *
 */
package pet.shop.api.persistence.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pet.shop.api.domain.Species;
import pet.shop.api.persistence.model.SpeciesPersistenceEnum;

/**
 * Tests for {@link SpeciesPersistenceMapper}.
 */
public class SpeciesPersistenceMapperTest {

    /** Class under test. */
    private SpeciesPersistenceMapper speciesPersistenceMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        speciesPersistenceMapper = new SpeciesControllerMapperHandler();
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Species species = null;

        // Test
        final SpeciesPersistenceEnum actualSpeciesPersistenceEnum = speciesPersistenceMapper.mapTo(species);

        // Assert
        Assert.assertNull(actualSpeciesPersistenceEnum);
    }

    /**
     * Check mapTo method with Dog enum.
     */
    @Test
    public void checkMaptoWithDogEnum() {

        // Setup
        final Species species = Species.DOG;
        final SpeciesPersistenceEnum expectedSpeciesPersistenceEnum = SpeciesPersistenceEnum.DOG;

        // Test
        final SpeciesPersistenceEnum actualSpeciesPersistenceEnum = speciesPersistenceMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesPersistenceEnum, actualSpeciesPersistenceEnum);
    }

    /**
     * Check mapTo method with Cat enum.
     */
    @Test
    public void checkMaptoWithCatEnum() {

        // Setup
        final Species species = Species.CAT;
        final SpeciesPersistenceEnum expectedSpeciesPersistenceEnum = SpeciesPersistenceEnum.CAT;

        // Test
        final SpeciesPersistenceEnum actualSpeciesPersistenceEnum = speciesPersistenceMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesPersistenceEnum, actualSpeciesPersistenceEnum);
    }

    /**
     * Check mapTo method with Fish enum.
     */
    @Test
    public void checkMaptoWithFishEnum() {

        // Setup
        final Species species = Species.FISH;
        final SpeciesPersistenceEnum expectedSpeciesPersistenceEnum = SpeciesPersistenceEnum.FISH;

        // Test
        final SpeciesPersistenceEnum actualSpeciesPersistenceEnum = speciesPersistenceMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesPersistenceEnum, actualSpeciesPersistenceEnum);
    }

    /**
     * Check mapTo method with Rabbit enum.
     */
    @Test
    public void checkMaptoWithRabbitEnum() {

        // Setup
        final Species species = Species.RABBIT;
        final SpeciesPersistenceEnum expectedSpeciesPersistenceEnum = SpeciesPersistenceEnum.RABBIT;

        // Test
        final SpeciesPersistenceEnum actualSpeciesPersistenceEnum = speciesPersistenceMapper.mapTo(species);

        // Assert
        Assert.assertEquals(expectedSpeciesPersistenceEnum, actualSpeciesPersistenceEnum);
    }
}
