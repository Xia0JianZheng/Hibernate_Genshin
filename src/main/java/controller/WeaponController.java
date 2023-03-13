package controller;

import model.Weapon;
import model.Character;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * class that controlling all functionality of the table Weapon
 */
public class WeaponController {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    Scanner sc = new Scanner(System.in);
    int weaponID;
    String weapon_name;
    int weapon_rarity;
    String weapon_image;
    String weapon_description;
    String weapon_type;
    String base_atk;
    int characterId;

    private CharacterController characterController = new CharacterController(connection,entityManagerFactory);


    List<Character> charactersList;

    /**
     * constructor of the class weaponController 1param
     * @param connection connection of the ddbb
     */
    public WeaponController(java.sql.Connection connection) {
        this.connection = connection;
    }

    /**
     * Constructor of the class weaponController 2param
     * @param connection connection of the ddbb
     * @param entityManagerFactory manejar la connection
     */
    public WeaponController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    /**
     * metodo que lee los ficheros csv y pone los infos de weapons en una lista
     * @param weaponFile fichero donde tiene infos de weapon
     * @param characterFile fichero donde tiene infos de character
     * @return una lista de weapons
     * @throws IOException lanza una excepcion cuando ocurre una error
     */
    public List<Weapon> readWeaponFile(String weaponFile, String characterFile)
            throws IOException {
        int weaponId, characterId;
        String weapon_name;
        int weapon_rarity;
        String weapon_image;
        String weapon_description;
        String weapon_type;
        String base_atk;

        BufferedReader br = new BufferedReader(new FileReader(weaponFile));
        String linea = "";
        charactersList = characterController.readCharactersFile(characterFile);
        List<Weapon> weaponsList = new ArrayList<>();

        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            weaponId = Integer.parseInt(str.nextToken());
            weapon_name = str.nextToken();
            weapon_rarity = Integer.parseInt(str.nextToken());
            weapon_image = str.nextToken();
            weapon_description = str.nextToken();
            weapon_type = str.nextToken();
            base_atk = str.nextToken();
            characterId = Integer.parseInt(str.nextToken());
            try {
                weaponsList.add(new Weapon(weaponId, weapon_name, weapon_rarity, weapon_image, weapon_description, weapon_type, base_atk, charactersList.get(characterId - 1)));
            } catch (Exception e) {
                System.err.println("Errada format data al fitxer");
                e.printStackTrace();
            }
        }
        br.close();

        return weaponsList;
    }

    /**
     * metodo que añade una lista de weapons a la base de datos
     * @param weaponsList la lista de weapons
     */
    public void addWeaponCSV(List<Weapon> weaponsList) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        for (Weapon w: weaponsList) {
            Weapon weaponExist = (Weapon) em.find(Weapon.class, w.getId_weapon());
            if(weaponExist == null){
                System.out.println("weapon added");
                em.persist(w);
            }
            em.merge(w);
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * metodo que añade un weapon con los infos de usuario
     */
    public void addWeapon() {
        System.out.println("Indroduce el Id de weapon ");
        weaponID = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Nombre del weapon");
        weapon_name = sc.nextLine();
        System.out.println("Indroduce la Rareza del weapon ");
        weapon_rarity = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Image del weapon ");
        weapon_image = sc.nextLine();
        System.out.println("Indroduce el Descripcion del weapon ");
        weapon_description = sc.nextLine();
        System.out.println("Que tipo de arma es?");
        weapon_type = sc.nextLine();
        System.out.println("A quien lo pertenece? (id_character)");
        characterId = sc.nextInt();
        Weapon w1 = new Weapon(weaponID, weapon_name, weapon_rarity, weapon_image, weapon_description,weapon_type,base_atk,charactersList.get(characterId - 1));
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Weapon weaponExist = (Weapon) em.find(Weapon.class, w1.getId_weapon());
        if(weaponExist == null){
            System.out.println("weapon added");
            em.persist(w1);
        }
        em.merge(w1);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * metodo que lista toda las weapons de la tabla
     */
    public void listWeapons() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Weapon> result = em.createQuery("from Weapon", Weapon.class)
                .getResultList();
        for (Weapon weapon : result) {
            System.out.println(weapon.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * metodo que lista las weapons por el tipo
     */
    public void listWeaponsWithType(){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Type the weapon type : [Sword][Catalyst][Claymore][Bow][Polearm]");
        String weapon_type = sc.nextLine();
        List<Weapon> result = em.createQuery("from Character WHERE region_name = :weaponType", Weapon.class)
                .setParameter("weapontype",weapon_type)
                .getResultList();

        for (Weapon weapon : result) {
            System.out.println(weapon.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    /**
     * metodo que modifica info de una weapon con el id
     */
    public void updateWeapon() {
        System.out.println("Indroduce el Id de character que quieres modificar");
        weaponID = sc.nextInt();
        sc.nextLine();
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Indroduce el nuevo Nombre del weapon ");
        weapon_name = sc.nextLine();
        System.out.println("Indroduce la nueva Rareza del weapon ");
        weapon_rarity = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el nuevo Image del weapon ");
        weapon_image = sc.nextLine();
        System.out.println("Indroduce el nuevo Descripcion del weapon ");
        weapon_description = sc.nextLine();
        System.out.println("Indroduce el nuevo elemento del weapon ");
        base_atk = sc.nextLine();
        System.out.println("Indroduce el nuevo region del weapon ");
        characterId = sc.nextInt();
        System.out.println("Indroduce el nuevo tipo del weapon");
        weapon_type = sc.nextLine();
        System.out.println("A quien lo pertenece? (id_character)");
        characterId = sc.nextInt();

        try {
            Weapon weapon = (Weapon) em.find(Weapon.class, weaponID);

            weapon.setWeapon_name(weapon_name);
            weapon.setWeapon_rarity(weapon_rarity);
            weapon.setWeapon_image(weapon_image);
            weapon.setWeapon_description(weapon_description);
            weapon.setWeapon_type(weapon_type);
            weapon.setBase_atk(base_atk);
            weapon.setCharacter(charactersList.get(characterId - 1));

            em.merge(weapon);
            em.getTransaction().commit();

        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();

    }

    /**
     * metodo que borra un weapon en la tabla
     */
    public void deleteWeapon() {
        System.out.println("Indroduce el Id de weapon que quieres borrar");
        weaponID = sc.nextInt();
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Weapon weapon = (Weapon) em.find(Weapon.class, weaponID);
        em.remove(weapon);
        em.getTransaction().commit();
        em.close();
    }
}


