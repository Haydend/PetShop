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

}
