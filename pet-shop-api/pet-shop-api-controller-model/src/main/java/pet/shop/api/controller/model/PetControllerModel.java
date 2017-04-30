/**
 *
 */
package pet.shop.api.controller.model;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Pet controller model.
 */
public class PetControllerModel {

    /** Name. */
    @XmlElement(name = "Name")
    private String name;

    /** Age. */
    @XmlElement(name = "Age")
    private Integer age;

    /** {@link SpeciesControllerEnum}. */
    @XmlElement(name = "Species")
    private SpeciesControllerEnum species;

    /** {@link StatusControlerEnum}. */
    @XmlElement(name = "Status")
    private StatusControlerEnum status;

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
    public SpeciesControllerEnum getSpecies() {
        return species;
    }

    /**
     * @param species
     *            the species to set
     */
    public void setSpecies(final SpeciesControllerEnum species) {
        this.species = species;
    }

    /**
     * @return the status
     */
    public StatusControlerEnum getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final StatusControlerEnum status) {
        this.status = status;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {

        if (obj instanceof PetControllerModel) {

            final PetControllerModel other = (PetControllerModel) obj;

            return new EqualsBuilder().append(name, other.name)
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
        return new HashCodeBuilder().append(name).append(age).append(species).append(status).toHashCode();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(name)
            .append(age)
            .append(species)
            .append(status)
            .toString();
    }
}
