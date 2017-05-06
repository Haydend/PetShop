/**
 *
 */
package pet.shop.api.controller.mapper;

import pet.shop.api.controller.model.StatusControlerEnum;
import pet.shop.api.domain.Status;

/**
 * Status controller mapper.
 *
 * Maps between {@link StatusControlerEnum} and {@link Status}.
 */
public interface StatusControllerMapper {

    /**
     * Map from {@link Status} to {@link StatusControlerEnum}
     *
     * @param status
     *            {@link Status}.
     * @return {@link StatusControlerEnum}.
     */
    public StatusControlerEnum mapTo(Status status);

    /**
     * Map from {@link StatusControlerEnum} to {@link Status}.
     *
     * @param statusControlerEnum
     *            {@link StatusControlerEnum}.
     * @return {@link Status}.
     */
    public Status mapFrom(StatusControlerEnum statusControlerEnum);
}
