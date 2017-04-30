/**
 *
 */
package pet.shop.api.domain;

import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Pet model.
 */
public class Pet {

    /** Name. */
    private final String name;

    /** Age. */
    private final Integer age;

    /** {@link Species}. */
    private final Species species;

    /** {@link Status}. */
    private final Status status;

    /**
     * Constructor for {@link Pet}.
     *
     * @param petBuilder
     *            {@link PetBuilder}.
     */
    private Pet(final PetBuilder petBuilder) {

        name = petBuilder.name;
        age = petBuilder.age;
        species = petBuilder.species;
        status = petBuilder.status;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @return the species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Builder for {@link Pet}.
     */
    public static class PetBuilder implements Builder<Pet> {

        /** Name. */
        private String name;

        /** Age. */
        private Integer age;

        /** {@link Species}. */
        private Species species;

        /** {@link Status}. */
        private Status status;

        /**
         * @param name
         *            the name to set
         */
        public PetBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @param age
         *            the age to set
         */
        public PetBuilder age(final Integer age) {
            this.age = age;
            return this;
        }

        /**
         * @param species
         *            the species to set
         */
        public PetBuilder species(final Species species) {
            this.species = species;
            return this;
        }

        /**
         * @param status
         *            the status to set
         */
        public PetBuilder status(final Status status) {
            this.status = status;
            return this;
        }

        /** {@inheritDoc} */
        @Override
        public Pet build() {

            return new Pet(this);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {

        if (obj instanceof Pet) {

            final Pet other = (Pet) obj;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(name)
            .append(age)
            .append(species)
            .append(status)
            .toString();
    }
}
