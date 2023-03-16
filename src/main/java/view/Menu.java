package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Clase donde contiene toda las menus de la programa
 */
public class Menu {
    private int option;
    Scanner sc = new Scanner(System.in);

    /**
     * constructor
     */
    public Menu() {
        super();
    }

    /**
     * Menu que contiene los opciones que controla los submenus
     * @return retorna las opciones
     */
    public int mainMenu() {

        System.out.println("-----------------------------------");
        System.out.println("-			Main Menu			  -");
        System.out.println("-----------------------------------");
        System.out.println("- 	1. Access to Table menu		  -");
        System.out.println("-	2. Access to Character table  -");
        System.out.println("-	3. Access to Weapon table	  -");
        System.out.println("-	4. Exit						  -");
        System.out.println("-----------------------------------");

        System.out.println("Choose a option : ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("The option you have choice doesn't exist");
        }
        return option;
    }

    /**
     * Menu que contiene los opciones que controla las tablas
     * @return retorna las opciones
     */
    public int tableMenu(){
        System.out.println("-----------------------------------");
        System.out.println("-	      	Table Menu   	      -");
        System.out.println("-----------------------------------");
        System.out.println("-	1. Add the Tables		  	  -");
        System.out.println("-	2. Remove the Tables	  	  -");
        System.out.println("-	3. Back to Main Menu		  -");
        System.out.println("-----------------------------------");

        System.out.println("Choose a option : ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("The option you have choice doesn't exist");
        }
        return option;
    }

    /**
     * Menu que contiene los opciones que controla la tabla de character
     * @return retorna las opciones
     */

    public int characterMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("-	    	    Character Menu    	  		   -");
        System.out.println("------------------------------------------------");
        System.out.println("-	1. Add an Characters using CSV File 	   -");
        System.out.println("-	2. Show all the Characters				   -");
        System.out.println("-	3. Show all characters with region name    -");
        System.out.println("-	4. show all characters with element		   -");
        System.out.println("-	5. modifier character information with id  -");
        System.out.println("-	6. Delete a Character					   -");
        System.out.println("-	7. Back to Main Menu		 		       -");
        System.out.println("------------------------------------------------");

        System.out.println("Choose a option : ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("The option you have choice doesn't exist");
        }
        return option;
    }

    /**
     * Menu que contiene los opciones que controla la tabla de armas
     * @return retorna las opciones
     */
    public int weaponMenu(){
        System.out.println("---------------------------------------------");
        System.out.println("-	      		Weapon Menu       	  	    -");
        System.out.println("---------------------------------------------");
        System.out.println("-	1. Add an Weapons using CSV File	    -");
        System.out.println("-	2. Show all the Weapons			  	    -");
        System.out.println("-	3. modifier Weapons information with id -");
        System.out.println("-	4. Delete a Weapon 				  	    -");
        System.out.println("-	5. Back to Main Menu		  		    -");
        System.out.println("---------------------------------------------");

        System.out.println("Choose a option : ");
        try{
            option = sc.nextInt();
        }catch (Exception e){
            System.out.println("The option you have choice doesn't exist");
        }
        return option;
    }

}