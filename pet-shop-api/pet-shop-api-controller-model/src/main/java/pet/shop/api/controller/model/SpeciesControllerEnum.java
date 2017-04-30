/**
 *
 */
package pet.shop.api.controller.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Species controller enum.
 */
@XmlType
@XmlEnum(String.class)
public enum SpeciesControllerEnum {

    /** Dog. */
    @XmlEnumValue("Dog")
    DOG,

    /** Cat. */
    @XmlEnumValue("Cat")
    CAT,

    /** Rabbit. */
    @XmlEnumValue("Rabbit")
    RABBIT,

    /** Fish. */
    @XmlEnumValue("Fish")
    FISH;
}
