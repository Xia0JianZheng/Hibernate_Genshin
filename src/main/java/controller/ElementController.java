package controller;

import model.Character;
import model.Element;
import org.hibernate.boot.model.source.internal.hbm.XmlElementMetadata;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Clase que controla los acciones de la tabla element
 */
public class ElementController {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    /**
     * Constructor de la clase elementController
     * @param connection connection de la base de datos
     */
    public ElementController(Connection connection) {
        this.connection = connection;
    }

    /**
     * Constructor de la clase elementController
     * @param connection connection de la base de datos
     * @param entityManagerFactory manejar la connection
     */
    public ElementController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     * metodo que lee el fichero csv y meterlos en la tabla element
     * @param filename fichero csv que contiene los elments
     * @return una lista de element
     * @throws IOException sale una excepcion si se peta
     */
    public List<Element> readElementsFile(String filename) throws IOException {
        int id_element;
        String element_name;


        List<Element> elementsList = new ArrayList();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            id_element = Integer.parseInt(str.nextToken());
            element_name = str.nextToken();
            try {
                elementsList.add(new Element(id_element,element_name));
            } catch (Exception e) {
                System.err.println("Errada format data al fitxer");
                e.printStackTrace();
            }
        }
        br.close();

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        for (Element e: elementsList) {
            Element elementExist = (Element) em.find(Element.class, e.getElementId());
            if(elementExist == null){
                System.out.println("element added");
                em.persist(e);
            }
            em.merge(e);
        }
        em.getTransaction().commit();
        em.close();

        return elementsList;
    }
}
