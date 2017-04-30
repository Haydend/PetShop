/**
 *
 */
package pet.shop.api.controller.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pet.shop.api.controller.model.StatusControlerEnum;
import pet.shop.api.domain.Status;

/**
 * Tests for {@link StatusControllerMapper}.
 */
public class StatusControllerMapperTest {

    /** Class under test. */
    private StatusControllerMapper statusControllerMapper;

    /**
     * Setup for tests.
     */
    @Before
    public void setup() {
        statusControllerMapper = new StatusControllerMapperHandler();
    }

    /**
     * Check mapTo method with null model.
     */
    @Test
    public void checkMapToWithNullModel() {

        // Setup
        final Status status = null;

        // Test
        final StatusControlerEnum actualStatusControlerEnum = statusControllerMapper.mapTo(status);

        // Assert
        Assert.assertNull(actualStatusControlerEnum);
    }

    /**
     * Check mapTo method with Adpoted enum.
     */
    @Test
    public void checkMapToWithAdopted() {

        // Setup
        final Status status = Status.ADOPTED;
        final StatusControlerEnum expectedStatusControlerEnum = StatusControlerEnum.ADOPTED;

        // Test
        final StatusControlerEnum actualStatusControlerEnum = statusControllerMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusControlerEnum, actualStatusControlerEnum);
    }

    /**
     * Check mapTo method with Available for Adoption enum.
     */
    @Test
    public void checkMapToWithAvailableForAdoption() {

        // Setup
        final Status status = Status.AVAILABLE_FOR_ADOPTION;
        final StatusControlerEnum expectedStatusControlerEnum = StatusControlerEnum.AVAILABLE_FOR_ADOPTION;

        // Test
        final StatusControlerEnum actualStatusControlerEnum = statusControllerMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusControlerEnum, actualStatusControlerEnum);
    }

    /**
     * Check mapTo method with Unavailable for Adoption enum.
     */
    @Test
    public void checkMapToWithUnavailableForAdoption() {

        // Setup
        final Status status = Status.UNAVAILABLE_FOR_ADOPTION;
        final StatusControlerEnum expectedStatusControlerEnum = StatusControlerEnum.UNAVAILABLE_FOR_ADOPTION;

        // Test
        final StatusControlerEnum actualStatusControlerEnum = statusControllerMapper.mapTo(status);

        // Assert
        Assert.assertEquals(expectedStatusControlerEnum, actualStatusControlerEnum);
    }

}
