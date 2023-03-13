package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "character")
public class Character implements Serializable{
    @Id
    @Column(name = "id_character")
    int characterId;
    @Column(name = "character_name", length = 30)
    String characterName;
    @Column(name = "character_rarity")
    int characterRarity;
    @Column(name = "character_image")
    String characterImage;

    @Column(name = "character_description")
    String characterDescription;

    @Column(name = "element_name")
    String elementName;

    @Column(name = "region_name")
    String regionName;

    @Column(name = "weapon_type")
    String weapontype;

    public Character(int characterId, String characterName, int characterRarity, String characterImage, String characterDescription, String elementName, String regionName, String weapontype) {
        this.characterId = characterId;
        this.characterName = characterName;
        this.characterRarity = characterRarity;
        this.characterImage = characterImage;
        this.characterDescription = characterDescription;
        this.elementName = elementName;
        this.regionName = regionName;
        this.weapontype = weapontype;
    }

    public Character() {
        super();

    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterRarity() {
        return characterRarity;
    }

    public void setCharacterRarity(int characterRarity) {
        this.characterRarity = characterRarity;
    }

    public String getCharacterImage() {
        return characterImage;
    }

    public void setCharacterImage(String characterImage) {
        this.characterImage = characterImage;
    }

    public String getCharacterDescription() {
        return characterDescription;
    }

    public void setCharacterDescription(String characterDescription) { this.characterDescription = characterDescription; }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getWeapontype() {
        return weapontype;
    }

    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }

    @Override
    public String toString() {

        return "Character{" +
                "characterId=" + characterId +
                ", characterName='" + characterName + '\'' +
                ", characterRarity=" + characterRarity +
                ", characterImage='" + characterImage + '\'' +
                ", characterDescription='" + characterDescription + '\'' +
                ", elementName='" + elementName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", weapontype='" + weapontype + '\'' +
                 '}';

    }
}
