package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * class element
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "element")
public class Element implements Serializable {

    @Id
    @Column(name = "id_element")
    int id_element;

    @Column(name="element_name")
    String element_name;

    /**
     * Constructor of the class element
     * @param id_element id of the element
     * @param element_name name of the element
     */
    public Element(int id_element, String element_name) {
        this.id_element = id_element;
        this.element_name = element_name;
    }

    /**
     * getter of element name
     * @return element name
     */
    public String getElement_name() {
        return element_name;
    }

    /**
     * setter of element name
     * @param element_name element name
     */
    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    /**
     * getter of the element id
     * @return element id
     */
    public int getElementId() {
        return id_element;
    }

    /**
     * setter of the element id
     * @param elementId element id
     */
    public void setElementId(int elementId) {
        this.id_element = elementId;
    }

    /**
     * show info for elements
     * @return element info
     */
    @Override
    public String toString() {
        return "Element{" +
                "elementId=" + id_element +
                ", element_name='" + element_name + '\'' +
                '}';
    }
}
