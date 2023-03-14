package controller;

import model.Element;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.IOException;
import java.sql.Connection;

/**
 * clase donde maneja los acciones sobre las tablas de base de datos
 */
public class TableController {
    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    /**
     * constructor de tableController
     * @param connection la conneccion de base de datos
     * @param entityManagerFactory manejar la connection
     */
    public TableController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     * metodo que añade toda las tablas a la base de datos
     * @throws IOException excepcion
     */
    public void addAllTables() throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            String createTableRegionQuery = "CREATE TABLE region(" +
                    "id_region INT," +
                    "region_name text PRIMARY KEY" +
                    ");";
            Query createTableRegion = entityManager.createNativeQuery(createTableRegionQuery);
            createTableRegion.executeUpdate();

            String createTableElementQuery = "CREATE TABLE element(" +
                    "id_element INT," +
                    "element_name text PRIMARY KEY" +
                    ");";
            Query createTableElement = entityManager.createNativeQuery(createTableElementQuery);
            createTableElement.executeUpdate();

            String createTableCharacterQuery = "CREATE TABLE character(" +
                    "id_character serial PRIMARY KEY," +
                    "character_name text," +
                    "character_rarity text," +
                    "character_image text," +
                    "character_description text," +
                    "element_name text REFERENCES element (element_name)," +
                    "region_name text REFERENCES region (region_name)," +
                    "weapon_type text" +
                    ");";
            Query createTableCharacter = entityManager.createNativeQuery(createTableCharacterQuery);
            createTableCharacter.executeUpdate();

            String createTableWeaponQuery = "CREATE TABLE weapon(" +
                    "id_weapon serial PRIMARY KEY," +
                    "weapon_name text," +
                    "weapon_rarity INT," +
                    "weapon_image text," +
                    "weapon_description text," +
                    "weapon_type text," +
                    "base_atk text" +
                    ");";
            Query createTableWeapon = entityManager.createNativeQuery(createTableWeaponQuery);
            createTableWeapon.executeUpdate();

            String createTableArtifactQuery = "CREATE TABLE artifact(\n" +
                    "id_artifactSet serial," +
                    "set_name text," +
                    "flower_of_life text," +
                    "img_flower_of_life text," +
                    "plume_of_death text," +
                    "img_plume_of_death text," +
                    "sands_of_eon text," +
                    "img_sands_of_eon text," +
                    "goblet_of_eonothem text," +
                    "img_goblet_of_eonothem text," +
                    "circlet_of_logos text," +
                    "img_circlet_of_logos text," +
                    "x2_bonus text," +
                    "x4_bonus text" +
                    ");";
            Query createTableArtifact = entityManager.createNativeQuery(createTableArtifactQuery);
            createTableArtifact.executeUpdate();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("Error creating tables", e);
        } finally {
            entityManager.close();
        }
    }

    /**
     * metodo que borra toda las tablas de la base de datos
     */
    public void removeAllTables() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            String dropTableCharacterQuery = "DROP TABLE IF EXISTS character";
            Query dropTableCharacter = entityManager.createNativeQuery(dropTableCharacterQuery);
            dropTableCharacter.executeUpdate();


            String dropTableWeaponQuery = "DROP TABLE IF EXISTS weapon";
            Query dropTableWeapon = entityManager.createNativeQuery(dropTableWeaponQuery);
            dropTableWeapon.executeUpdate();

            String dropTableArtifactQuery = "DROP TABLE IF EXISTS artifact";
            Query dropTableArtifact = entityManager.createNativeQuery(dropTableArtifactQuery);
            dropTableArtifact.executeUpdate();


            String dropTableRegionQuery = "DROP TABLE IF EXISTS region";
            Query dropTableRegion = entityManager.createNativeQuery(dropTableRegionQuery);
            dropTableRegion.executeUpdate();


            String dropTableElementQuery = "DROP TABLE IF EXISTS element";
            Query dropTableElement = entityManager.createNativeQuery(dropTableElementQuery);
            dropTableElement.executeUpdate();
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new RuntimeException("Error dropping tables", e);
        } finally {
            entityManager.close();
        }
    }


}
