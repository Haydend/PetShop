/**
 *
 */
package pet.shop.api.controller.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Status controler enum.
 */
@XmlType
@XmlEnum(String.class)
public enum StatusControlerEnum {

    /** Adopted. */
    @XmlEnumValue("Adopted")
    ADOPTED,

    /** Available for adoption. */
    @XmlEnumValue("Available for Adoption")
    AVAILABLE_FOR_ADOPTION,

    /** Unavailable for adoption. */
    @XmlEnumValue("Unavailable for Adoption")
    UNAVAILABLE_FOR_ADOPTION;
}
