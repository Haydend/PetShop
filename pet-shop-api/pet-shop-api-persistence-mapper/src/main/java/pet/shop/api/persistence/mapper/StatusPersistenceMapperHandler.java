/**
 *
 */
package pet.shop.api.persistence.mapper;

import org.apache.commons.lang3.NotImplementedException;

import pet.shop.api.domain.Status;
import pet.shop.api.persistence.model.StatusPersistenceEnum;

/**
 * Implementation of {@link StatusPersistenceMapper}.
 */
public class StatusPersistenceMapperHandler implements StatusPersistenceMapper {

    /**
     * {@inheritDoc}
     */
    @Override
    public StatusPersistenceEnum mapTo(final Status status) {

        StatusPersistenceEnum statusPersistenceEnum = null;

        if (status != null) {

            if (status == Status.ADOPTED) {
                statusPersistenceEnum = StatusPersistenceEnum.ADOPTED;
            } else if (status == Status.AVAILABLE_FOR_ADOPTION) {
                statusPersistenceEnum = StatusPersistenceEnum.AVAILABLE_FOR_ADOPTION;
            } else if (status == Status.UNAVAILABLE_FOR_ADOPTION) {
                statusPersistenceEnum = StatusPersistenceEnum.UNAVAILABLE_FOR_ADOPTION;
            } else {
                throw new NotImplementedException("Enum not handled.");
            }
        }

        return statusPersistenceEnum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Status mapFrom(final StatusPersistenceEnum statusPersistenceEnum) {

        Status status = null;

        if (statusPersistenceEnum != null) {

            if (statusPersistenceEnum == StatusPersistenceEnum.ADOPTED) {
                status = Status.ADOPTED;
            } else if (statusPersistenceEnum == StatusPersistenceEnum.AVAILABLE_FOR_ADOPTION) {
                status = Status.AVAILABLE_FOR_ADOPTION;
            } else if (statusPersistenceEnum == StatusPersistenceEnum.UNAVAILABLE_FOR_ADOPTION) {
                status = Status.UNAVAILABLE_FOR_ADOPTION;
            } else {
                throw new NotImplementedException("Enum not handled.");
            }
        }

        return status;
    }

}
