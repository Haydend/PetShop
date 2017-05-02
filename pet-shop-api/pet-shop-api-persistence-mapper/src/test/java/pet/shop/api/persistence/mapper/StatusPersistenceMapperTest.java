/**
 *
 */
package pet.shop.api.persistence.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pet.shop.api.domain.Status;
import pet.shop.api.persistence.model.StatusPersistenceEnum;

/**
 * Tests for {@link StatusPersistenceMapper}.
 */
public class StatusPersistenceMapperTest {

    /** Class under test. */
    private StatusPersistenceMapper statusPersistenceMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        statusPersistenceMapper = new StatusPersistenceMapperHandler();
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Status status = null;

        // Test
        final StatusPersistenceEnum actualStatusPersistenceEnum = statusPersistenceMapper.mapTo(status);

        // Assert
        Assert.assertNull(actualStatusPersistenceEnum);
    }

    /**
     * Check mapTo method with Adpoted enum.
     */
    @Test
    public void checkMapToWithAdopted() {

        // Setup
        final Status status = Status.ADOPTED;
        final StatusPersistenceEnum expectedStatusPersistenceEnum = StatusPersistenceEnum.ADOPTED;

        // Test
        final StatusPersistenceEnum actualStatusPersistenceEnum = statusPersistenceMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusPersistenceEnum, actualStatusPersistenceEnum);
    }

    /**
     * Check mapTo method with Available for Adoption enum.
     */
    @Test
    public void checkMapToWithAvailableForAdoption() {

        // Setup
        final Status status = Status.AVAILABLE_FOR_ADOPTION;
        final StatusPersistenceEnum expectedStatusPersistenceEnum = StatusPersistenceEnum.AVAILABLE_FOR_ADOPTION;

        // Test
        final StatusPersistenceEnum actualStatusPersistenceEnum = statusPersistenceMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusPersistenceEnum, actualStatusPersistenceEnum);
    }

    /**
     * Check mapTo method with Unavailable for Adoption enum.
     */
    @Test
    public void checkMapToWithUnavailableForAdoption() {

        // Setup
        final Status status = Status.UNAVAILABLE_FOR_ADOPTION;
        final StatusPersistenceEnum expectedStatusPersistenceEnum = StatusPersistenceEnum.UNAVAILABLE_FOR_ADOPTION;

        // Test
        final StatusPersistenceEnum actualStatusPersistenceEnum = statusPersistenceMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusPersistenceEnum, actualStatusPersistenceEnum);
    }

}
