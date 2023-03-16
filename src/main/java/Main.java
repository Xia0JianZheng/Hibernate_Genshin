import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import controller.*;
import model.Character;
import model.Weapon;
import database.ConnectionFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import view.Menu;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase main donde ejecuta los menus y los metodos necessarias
 */
public class Main {
  /**
   * constructor vacio de la clase Main
   */
  public Main(){

  }
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

  /**
   * Construye la ssesion con el fichero config
   * @return la ssesion
   */
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

  /**
   * Crear una manejo de coneccion
   * @return emf
   */
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

  /**
   * Contiene los menus y los metodo que funciona el programa
   * @param args las entradas
   * @throws IOException exception
   */
  public static void main(String[] args) throws IOException {

    ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
    Connection c = connectionFactory.connect();

//    SessionFactory sessionFactory = buildSessionFactory();
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory();
    //sessionObj = buildSessionFactory().openSession();

    TableController tableController = new TableController(c,entityManagerFactory);
    CharacterController characterController = new CharacterController(c, entityManagerFactory);
    WeaponController weaponController = new WeaponController(c, entityManagerFactory);
    ElementController elementController = new ElementController(c, entityManagerFactory);
    RegionController regionController = new RegionController(c, entityManagerFactory);

    Menu menu = new Menu();
    int option;
    option = menu.mainMenu();

    while (option != 4) {
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
          while (characterOption != 7){
            switch (characterOption){
              case 1 -> {
                List<Character> characters = characterController.readCharactersFile("src/main/resources/characters.csv");
                for(Character character : characters){
                  characterController.addCharacter(character);
                }
              }
              case 2 -> characterController.listCharacters();
              case 3 -> characterController.listCharactersWithRegion();
              case 4 -> characterController.listCharactersWithElement();
              case 5 -> characterController.updateCharacter();
              case 6 -> characterController.deleteCharacter();
              default -> System.out.println("option not found, try again");
            }
            characterOption = menu.characterMenu();
          }
        }
       case 3 -> {
          int weaponOption = menu.weaponMenu();
          while (weaponOption != 5){
            switch (weaponOption){
              case 1 -> {
                List<Character> characters = weaponController.readWeaponFile("src/main/resources/weapons.csv","src/main/resources/characters.csv");

                for (int i = 0; i < characters.size(); i++) {
                  System.out.println(characters.get(i).toString()+"\n");
                  for (int j = 0; j < characters.get(i).getWeapons().size(); j++) {
                    Character character = characters.get(i).getWeapons().get(j).getCharacter();
                    Weapon weapon = characters.get(i).getWeapons().get(j);
                    weapon.setCharacter(character);
                    weaponController.addWeapon(weapon);
                  }
                }
              }
              case 2 -> weaponController.listWeapons();
              case 3 -> weaponController.updateWeapon();
              case 4 -> weaponController.deleteWeapon();
              default -> System.out.println("option not found, try again");
            }
            weaponOption = menu.weaponMenu();
          }
      }
        default -> System.out.println("option not found, try again");
      }
        option = menu.mainMenu();
    }
  }
}