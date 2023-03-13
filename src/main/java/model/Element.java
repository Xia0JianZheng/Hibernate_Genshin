package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name = "element")
public class Element implements Serializable {

    @Id
    @Column(name = "id_element")
    int id_element;

    @Column(name="element_name")
    String element_name;

    public Element(int id_element, String element_name) {
        this.id_element = id_element;
        this.element_name = element_name;
    }



    public String getElement_name() {
        return element_name;
    }

    public void setElement_name(String element_name) {
        this.element_name = element_name;
    }

    public int getElementId() {
        return id_element;
    }

    public void setElementId(int elementId) {
        this.id_element = elementId;
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementId=" + id_element +
                ", element_name='" + element_name + '\'' +
                '}';
    }
}
