package pet.shop.api.persistence.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manager Producer.
 */
@ApplicationScoped
public class EntityManagerProducer {

    /** {@link EntityManagerFactory} */
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petShopApi");

    /**
     * Create.
     *
     * @return {@link EntityManager}.
     */
    @Produces
    public EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Close.
     *
     * @param entityManager
     *            {@link EntityManager} to close.
     */
    public void close(@Disposes final EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}