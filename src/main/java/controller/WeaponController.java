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

    private CharacterController characterController = new CharacterController(connection);
//    private WeaponController weaponController = new WeaponController(connection);

    public WeaponController(java.sql.Connection connection) {
        this.connection = connection;
    }

    public WeaponController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

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
        List<Character> charactersList = characterController.readCharactersFile(characterFile);
        List<Weapon> weaponsList = new ArrayList<>();

        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            weaponId = Integer.parseInt(str.nextToken());
            characterId = Integer.parseInt(str.nextToken());
            weapon_name = str.nextToken();
            weapon_rarity = Integer.parseInt(str.nextToken());
            weapon_image = str.nextToken();
            weapon_description = str.nextToken();
            weapon_type = str.nextToken();
            base_atk = str.nextToken();

            try {
                weaponsList.add(new Weapon(weaponId, weapon_name, weapon_rarity, weapon_image, weapon_description, weapon_type, base_atk, charactersList.get(characterId - 1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        br.close();
        return weaponsList;
    }

    public void addWeapon() {
        System.out.println("Indroduce el Id de character que quieres añadir");
        weaponID = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Nombre de character que quieres añadir");
        weapon_name = sc.nextLine();
        System.out.println("Indroduce la Rareza de character que quieres añadir");
        weapon_rarity = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Image de character que quieres añadir");
        weapon_image = sc.nextLine();
        System.out.println("Indroduce el Descripcion de character que quieres añadir");
        weapon_description = sc.nextLine();
        System.out.println("Indroduce el tipo de arma de character que quieres añadir");
        weapon_type = sc.nextLine();
        Weapon w1 = new Weapon(weaponID, weapon_name, weapon_rarity, weapon_image, weapon_description,weapon_type,base_atk,characterId);
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

    public void updateWeapon(Integer weaponId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Weapon weapon = (Weapon) em.find(Weapon.class, weaponId);
        em.merge(weapon);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteWeapon(Integer weaponId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Weapon weapon = (Weapon) em.find(Weapon.class, weaponId);
        em.remove(weapon);
        em.getTransaction().commit();
        em.close();
    }
}


