/**
 *
 */
package pet.shop.api.persistence.mapper;

import pet.shop.api.domain.Status;
import pet.shop.api.persistence.model.StatusPersistenceEnum;

/**
 * Status persistence mapper.
 *
 * Maps between {@link StatusPersistenceEnum} and {@link Status}.
 */
public interface StatusPersistenceMapper {

    /**
     * Map from {@link Status} to {@link StatusPersistenceEnum}.
     *
     * @param status
     *            {@link Status}.
     * @return {@link StatusPersistenceEnum}.
     */
    public StatusPersistenceEnum mapTo(Status status);

    /**
     * Map from {@link StatusPersistenceEnum} to {@link Status}.
     *
     * @param statusPersistenceEnum
     *            {@link StatusPersistenceEnum}.
     * @return {@link Status}.
     */
    public Status mapFrom(StatusPersistenceEnum statusPersistenceEnum);

}
