package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Access(AccessType.FIELD)
@Table(name = "weapon")
public class Weapon implements Serializable {
    @Id
    @Column(name = "id_weapon")
    int id_weapon;
    @Column(name = "weapon_name", length = 30)
    String weapon_name;
    @Column(name = "weapon_rarity", length = 30)
    int weapon_rarity;
    @Column(name = "weapon_image", length = 1000)
    String weapon_image;
    @Column(name = "weapon_description", length = 1000)
    String weapon_description;
    @Column(name = "weapon_type", length = 100)
    String weapon_type;
    @Column(name = "base_atk", length = 30)
    String base_atk;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_character")
    public Character character;

    public Weapon(int id_weapon, String weapon_name, int weapon_rarity, String weapon_image, String weapon_description, String weapon_type, String base_atk,Character character) {
        this.id_weapon = id_weapon;
        this.weapon_name = weapon_name;
        this.weapon_rarity = weapon_rarity;
        this.weapon_image = weapon_image;
        this.weapon_description = weapon_description;
        this.weapon_type = weapon_type;
        this.base_atk = base_atk;
        this.character = character;
    }

    public int getId_weapon() {
        return id_weapon;
    }

    public void setId_weapon(int id_weapon) {
        this.id_weapon = id_weapon;
    }

    public String getWeapon_name() {
        return weapon_name;
    }

    public void setWeapon_name(String weapon_name) {
        this.weapon_name = weapon_name;
    }

    public int getWeapon_rarity() {
        return weapon_rarity;
    }

    public void setWeapon_rarity(int weapon_rarity) {
        this.weapon_rarity = weapon_rarity;
    }

    public String getWeapon_image() {
        return weapon_image;
    }

    public void setWeapon_image(String weapon_image) {
        this.weapon_image = weapon_image;
    }

    public String getWeapon_description() {
        return weapon_description;
    }

    public void setWeapon_description(String weapon_description) {
        this.weapon_description = weapon_description;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public String getBase_atk() {
        return base_atk;
    }

    public void setBase_atk(String base_atk) {
        this.base_atk = base_atk;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

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
                ", character=" + character.toString() +
                '}';
    }
}
