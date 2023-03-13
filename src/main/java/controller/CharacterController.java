package controller;

import model.*;
import model.Character;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CharacterController {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    Scanner sc = new Scanner(System.in);
    int characterID;
    String character_name;
    int character_rarity;
    String character_image;
    String character_description;
    String character_element;
    String character_region;
    String weapon_type;

    public CharacterController(Connection connection) {
        this.connection = connection;
    }

    public CharacterController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Character> readCharactersFile(String filename) throws IOException {
        int characterId;
        String character_name;
        int character_rarity;
        String character_image;
        String character_description;
        String character_element;
        String character_region;
        String weapon_type;

        List<Character> characterList = new ArrayList();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            characterId = Integer.parseInt(str.nextToken());
            character_name = str.nextToken();
            character_rarity = Integer.parseInt(str.nextToken());
            character_image = str.nextToken();
            character_description = str.nextToken();
            character_element = str.nextToken();
            character_region = str.nextToken();
            weapon_type = str.nextToken();
            try {
                characterList.add(new Character(characterId,character_name,character_rarity,character_image,character_description,character_element,character_region,weapon_type));
            } catch (Exception e) {
                System.err.println("Errada format data al fitxer");
                e.printStackTrace();
            }
        }
        br.close();

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        for (Character c: characterList) {
            Character characterExist = (Character) em.find(Character.class, c.getCharacterId());
            if(characterExist == null){
                System.out.println("character added");
                em.persist(c);
            }
            em.merge(c);
        }
        em.getTransaction().commit();
        em.close();


        return characterList;
    }

    public void addCharacter() {
        System.out.println("Indroduce el Id de character que quieres añadir");
        characterID = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Nombre de character que quieres añadir");
        character_name = sc.nextLine();
        System.out.println("Indroduce la Rareza de character que quieres añadir");
        character_rarity = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el Image de character que quieres añadir");
        character_image = sc.nextLine();
        System.out.println("Indroduce el Descripcion de character que quieres añadir");
        character_description = sc.nextLine();
        System.out.println("Indroduce el elemento de character que quieres añadir");
        character_element = sc.nextLine();
        System.out.println("Indroduce el region de character que quieres añadir");
        character_region = sc.nextLine();
        System.out.println("Indroduce el tipo de arma de character que quieres añadir");
        weapon_type = sc.nextLine();
        Character c1 = new Character(characterID,character_name,character_rarity,character_image,character_description,character_element,character_region,weapon_type);
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Character characterExist = (Character) em.find(Character.class, c1.getCharacterId());
        if(characterExist == null){
            System.out.println("character added");
            em.persist(c1);
        }
        em.merge(c1);
        em.getTransaction().commit();
        em.close();
    }

    public void listCharacters() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Character> result = em.createQuery("from Character", Character.class)
                .getResultList();

        for (Character character : result) {
            System.out.println(character.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void listCharactersWithRegion() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Type the region name : [Mondstadt][Liyue][Inazuma][Sumeru][Fontaine][Natlan][Snezhnaya][Khaenri'ah][None]");
        String region_name = sc.nextLine();
        List<Character> result = em.createQuery("from Character WHERE region_name = :region", Character.class)
                .setParameter("region",region_name)
                .getResultList();

        for (Character character : result) {
            System.out.println(character.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void listCharactersWithElement() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Type the element name : [Geo][Cryo][Pyro][Electro][Dendro][Anemo][NONE]");
        String element_name = sc.nextLine();
        List<Character> result = em.createQuery("from Character WHERE element_name = :element", Character.class)
                .setParameter("element",element_name)
                .getResultList();

        for (Character character : result) {
            System.out.println(character.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void updateCharacter() {
        System.out.println("Indroduce el Id de character que quieres modificar");
        characterID = sc.nextInt();
        sc.nextLine();
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Indroduce el nuevo Nombre de character que quieres añadir");
        character_name = sc.nextLine();
        System.out.println("Indroduce la nueva Rareza de character que quieres añadir");
        character_rarity = sc.nextInt();
        sc.nextLine();
        System.out.println("Indroduce el nuevo Image de character que quieres añadir");
        character_image = sc.nextLine();
        System.out.println("Indroduce el nuevo Descripcion de character que quieres añadir");
        character_description = sc.nextLine();
        System.out.println("Indroduce el nuevo elemento de character que quieres añadir");
        character_element = sc.nextLine();
        System.out.println("Indroduce el nuevo region de character que quieres añadir");
        character_region = sc.nextLine();
        System.out.println("Indroduce el nuevo tipo de arma de character que quieres añadir");
        weapon_type = sc.nextLine();
        try{
            Character character = (Character) em.find(Character.class, characterID);

            character.setCharacterName(character_name);
            character.setCharacterRarity(character_rarity);
            character.setCharacterImage(character_image);
            character.setCharacterDescription(character_description);
            character.setElementName(character_element);
            character.setRegionName(character_region);
            character.setWeapontype(weapon_type);

            em.merge(character);
            em.getTransaction().commit();

        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e);
        }
        em.close();
    }

    public void deleteCharacter() {
        System.out.println("Indroduce el Id de character que quieres borrar");
        characterID = sc.nextInt();
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Character character = (Character) em.find(Character.class, characterID);
        em.remove(character);
        em.getTransaction().commit();
        em.close();
    }
}
