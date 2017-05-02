/**
 *
 */
package pet.shop.api.persistence.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import pet.shop.api.persistence.model.PetPersistenceModel;

/**
 * Pet repository for {@link PetPersistenceModel}.
 */
@Repository
public interface PetRepository extends EntityRepository<PetPersistenceModel, Long> {

}
