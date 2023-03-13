import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import database.ConnectionFactory;
import model.Artifact;
import model.Character;
import model.Region;
import model.Weapon;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import view.Menu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

  static SessionFactory sessionFactoryObj;
/*
  private static SessionFactory buildSessionFactory() {
    // Creating Configuration Instance & Passing Hibernate Configuration File
    Configuration configObj = new Configuration();
    configObj.configure("hibernate.cfg.xml");

    // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
    ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

    // Creating Hibernate SessionFactory Instance
    sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
    return sessionFactoryObj;
  } */

  private static SessionFactory buildSessionFactory() {
    try {
      StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
          .configure("hibernate.cfg.xml").build();
      Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();

    } catch (HibernateException he) {
      System.out.println("Session Factory creation failure");
      throw he;
    }
  }

  public static EntityManagerFactory createEntityManagerFactory(){
    EntityManagerFactory emf;
    try {
      emf = Persistence.createEntityManagerFactory("JPAMagazines");
    } catch (Throwable ex) {
      System.err.println("Failed to create EntityManagerFactory object."+ ex);
      throw new ExceptionInInitializerError(ex);
    }
    return emf;
  }

  public static void main(String[] args) throws IOException {

    ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
    Connection c = connectionFactory.connect();

//    SessionFactory sessionFactory = buildSessionFactory();
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory();
    //sessionObj = buildSessionFactory().openSession();

    TableController tableController = new TableController(c,entityManagerFactory);
    CharacterController characterController = new CharacterController(c, entityManagerFactory);
    WeaponController weaponController = new WeaponController(c, entityManagerFactory);
    ArtifactController artifactController = new ArtifactController(c, entityManagerFactory);
    ElementController elementController = new ElementController(c, entityManagerFactory);
    RegionController regionController = new RegionController(c, entityManagerFactory);

    Menu menu = new Menu();
    int option;
    option = menu.mainMenu();

    while (option != 5) {
      switch (option) {
        case 1 -> {
          int tableOption = menu.tableMenu();
          while (tableOption != 3){
            switch (tableOption){
              case 1 -> {
                tableController.addAllTables();
                elementController.readElementsFile("src/main/resources/elements.csv");
                regionController.readRegionsFile("src/main/resources/regions.csv");
              }
              case 2 -> tableController.removeAllTables();
              default -> System.out.println("option not found, try again");
            }
            tableOption = menu.tableMenu();
          }
        }
        case 2 -> {
          int characterOption = menu.characterMenu();
          while (characterOption != 8){
            switch (characterOption){
              case 1 -> characterController.addCharacter();
              case 2 -> characterController.readCharactersFile("src/main/resources/characters.csv");
              case 3 -> characterController.listCharacters();
              case 4 -> characterController.listCharactersWithRegion();
              case 5 -> characterController.listCharactersWithElement();
              case 6 -> characterController.updateCharacter();
              case 7 -> characterController.deleteCharacter();
              default -> System.out.println("option not found, try again");
            }
            characterOption = menu.characterMenu();
          }
        }
       case 3 -> {
          int weaponOption = menu.weaponMenu();
          while (weaponOption != 6){
            switch (weaponOption){
              case 1 -> weaponController.addWeapon();
              case 2 -> weaponController.addWeaponUsingCSV();
              case 3 -> weaponController.showAllWeapons();
              case 4 -> weaponController.showWeaponWithType();
              case 5 -> weaponController.removeOneWeapon();
              default -> System.out.println("option not found, try again");
            }
            weaponOption = menu.weaponMenu();
          }
        }

 /*       case 4 -> {
          int artifactOption = menu.artifactMenu();
          while (artifactOption != 6){
            switch (artifactOption){
              case 1 -> artifactController.addArtifactSet();
              case 2 -> artifactController.addArtifactSetUsingCSV();
              case 3 -> artifactController.showAllArtifacts();
              case 4 -> artifactController.showSpecificArtifact();
              case 5 -> artifactController.removeOneArtifactSet();
              default -> System.out.println("option not found, try again");
            }
            artifactOption = menu.artifactMenu();
          }
        }
        default -> System.out.println("option not found, try again");
*/      }
      option = menu.mainMenu();
    }
  }
}