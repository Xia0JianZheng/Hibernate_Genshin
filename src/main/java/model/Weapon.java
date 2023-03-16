package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase weapon
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "weapon")
public class Weapon implements Serializable {
    /**
     * el id de la arma
     */
    @Id
    @Column(name = "id_weapon")
    int id_weapon;
    /**
     * el nombre de la arma
     */
    @Column(name = "weapon_name", length = 30)
    String weapon_name;
    /**
     * la rareza de la arma
     */
    @Column(name = "weapon_rarity", length = 30)
    int weapon_rarity;
    /**
     * la imagen de la arma
     */
    @Column(name = "weapon_image", length = 1000)
    String weapon_image;
    /**
     *el descripcion de la arma
     */
    @Column(name = "weapon_description", length = 1000)
    String weapon_description;
    /**
     * el tipo de la arma que pertenece
     */
    @Column(name = "weapon_type", length = 100)
    String weapon_type;
    /**
     * el ataque basico que tiene la arma
     */
    @Column(name = "base_atk", length = 30)
    String base_atk;
    /**
     * el character que lo utiliza
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_character")
    public Character character;

    /**
     * constructor de la clase weapon
     * @param id_weapon el id del weapon
     * @param weapon_name el nombre del weapon
     * @param weapon_rarity la rareza del weapon
     * @param weapon_image la imagen del weapon
     * @param weapon_description el descripcion del weapon
     * @param weapon_type el tipo del weapon
     * @param base_atk el ataque del weapon
     * @param character un character
     */
    public Weapon(int id_weapon, String weapon_name, int weapon_rarity, String weapon_image, String weapon_description, String weapon_type, String base_atk,Character character) {
        super();
        this.id_weapon = id_weapon;
        this.weapon_name = weapon_name;
        this.weapon_rarity = weapon_rarity;
        this.weapon_image = weapon_image;
        this.weapon_description = weapon_description;
        this.weapon_type = weapon_type;
        this.base_atk = base_atk;
        this.character = character;
    }

    /**
     * Constructor vacio
     */
    public Weapon(){
        super();
    }

    /**
     * getter id
     * @return weapon id
     */
    public int getId_weapon() {
        return id_weapon;
    }

    /**
     * setter id
     * @param id_weapon weapon id
     */
    public void setId_weapon(int id_weapon) {
        this.id_weapon = id_weapon;
    }

    /**
     * weapon name
     * @return weapon name
     */
    public String getWeapon_name() {
        return weapon_name;
    }

    /**
     * setter weapon name
     * @param weapon_name weapon name
     */
    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    /**
     * getter weapon rarity
     * @return weapon rarity
     */
    public int getWeapon_rarity() {
        return weapon_rarity;
    }

    /**
     * setter weapon rarity
     * @param weapon_rarity weapon rarity
     */
    public void setWeapon_rarity(int weapon_rarity) {
        this.weapon_rarity = weapon_rarity;
    }

    /**
     * getter weapon image
     * @return weapon image
     */
    public String getWeapon_image() {
        return weapon_image;
    }

    /**
     * setter weapon image
     * @param weapon_image weapon image
     */
    public void setWeapon_image(String weapon_image) {
        this.weapon_image = weapon_image;
    }

    /**
     * getter weapon description
     * @return getter weapon description
     */
    public String getWeapon_description() {
        return weapon_description;
    }

    /**
     * setter weapon description
     * @param weapon_description weapon description
     */
    public void setWeapon_description(String weapon_description) {
        this.weapon_description = weapon_description;
    }

    /**
     * getter Weapon type
     * @return weapon type
     */
    public String getWeapon_type() {
        return weapon_type;
    }

    /**
     * setter weapon type
     * @param weapon_type weapon type
     */
    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    /**
     * getter weapon atk
     * @return weapon atk
     */
    public String getBase_atk() {
        return base_atk;
    }

    /**
     * setter weapon atk
     * @param base_atk weapon atk
     */
    public void setBase_atk(String base_atk) {
        this.base_atk = base_atk;
    }

    /**
     * getter character
     * @return character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * setter character
     * @param character character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * toString with all information of the weapon
     * @return info of the weapon
     */
    @Override
    public String toString() {
        return "Weapon{" +
                "id_weapon=" + id_weapon +
                ", weapon_name='" + weapon_name + '\'' +
                ", weapon_rarity=" + weapon_rarity +
                ", weapon_image='" + weapon_image + '\'' +
                ", weapon_description='" + weapon_description + '\'' +
                ", weapon_type='" + weapon_type + '\'' +
                ", base_atk='" + base_atk + '\'' +
                ", character=" + character.getCharacterName() +
                '}';
    }
}
