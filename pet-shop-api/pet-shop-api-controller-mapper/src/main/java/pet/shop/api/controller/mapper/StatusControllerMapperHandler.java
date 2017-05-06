/**
 *
 */
package pet.shop.api.controller.mapper;

import org.apache.commons.lang3.NotImplementedException;

import pet.shop.api.controller.model.StatusControlerEnum;
import pet.shop.api.domain.Status;

/**
 * Implementation of {@link StatusControllerMapper}.
 */
public class StatusControllerMapperHandler implements StatusControllerMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusControlerEnum mapTo(final Status status) {

        StatusControlerEnum statusControlerEnum = null;

        if (status != null) {

            if (status == Status.ADOPTED) {
                statusControlerEnum = StatusControlerEnum.ADOPTED;
            } else if (status == Status.AVAILABLE_FOR_ADOPTION) {
                statusControlerEnum = StatusControlerEnum.AVAILABLE_FOR_ADOPTION;
            } else if (status == Status.UNAVAILABLE_FOR_ADOPTION) {
                statusControlerEnum = StatusControlerEnum.UNAVAILABLE_FOR_ADOPTION;
            } else {
                throw new NotImplementedException("Enum not handled.");
            }
        }

        return statusControlerEnum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status mapFrom(final StatusControlerEnum statusControlerEnum) {

        Status status = null;

        if (statusControlerEnum != null) {

            if (statusControlerEnum == StatusControlerEnum.ADOPTED) {
                status = Status.ADOPTED;
            } else if (statusControlerEnum == StatusControlerEnum.AVAILABLE_FOR_ADOPTION) {
                status = Status.AVAILABLE_FOR_ADOPTION;
            } else if (statusControlerEnum == StatusControlerEnum.UNAVAILABLE_FOR_ADOPTION) {
                status = Status.UNAVAILABLE_FOR_ADOPTION;
            } else {
                throw new NotImplementedException("Enum not handled.");
            }
        }

        return status;
    }

}
