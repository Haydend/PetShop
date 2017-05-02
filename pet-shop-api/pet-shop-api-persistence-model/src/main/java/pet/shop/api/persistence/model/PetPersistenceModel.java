/**
 *
 */
package pet.shop.api.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Pet persistence model.
 */
@Entity
@Table(name = "pet")
public class PetPersistenceModel {

    @Id
    @GeneratedValue
    /** Identifier. */
    private Integer id;

    /** Name. */
    private String name;

    /** Age. */
    private Integer age;

    /** {@link SpeciesPersistenceEnum}. */
    private SpeciesPersistenceEnum species;

    /** {@link StatusPersistenceEnum}. */
    private StatusPersistenceEnum status;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * @return the species
     */
    public SpeciesPersistenceEnum getSpecies() {
        return species;
    }

    /**
     * @param species
     *            the species to set
     */
    public void setSpecies(final SpeciesPersistenceEnum species) {
        this.species = species;
    }

    /**
     * @return the status
     */
    public StatusPersistenceEnum getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final StatusPersistenceEnum status) {
        this.status = status;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {

        if (obj instanceof PetPersistenceModel) {

            final PetPersistenceModel other = (PetPersistenceModel) obj;

            return new EqualsBuilder().append(id, other.id)
                .append(name, other.name)
                .append(age, other.age)
                .append(species, other.species)
                .append(status, other.status)
                .isEquals();

        } else {
            return false;
        }
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(age).append(species).append(status).toHashCode();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(id)
            .append(name)
            .append(age)
            .append(species)
            .append(status)
            .toString();
    }
}
