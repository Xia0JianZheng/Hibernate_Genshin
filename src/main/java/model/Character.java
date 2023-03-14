package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * class of the character
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "character")
public class Character implements Serializable{
    /**
     * id de la character
     */
    @Id
    @Column(name = "id_character")
    int characterId;
    /**
     * el nombre de la character
     */
    @Column(name = "character_name", length = 30)
    String characterName;
    /**
     * la rareza de la character
     */
    @Column(name = "character_rarity")
    int characterRarity;
    /**
     * la image de la character
     */
    @Column(name = "character_image")
    String characterImage;
    /**
     * el descripcion de la character
     */
    @Column(name = "character_description")
    String characterDescription;
    /**
     * el elemeto de la character
     */
    @Column(name = "element_name")
    String elementName;
    /**
     * el region de la character
     */
    @Column(name = "region_name")
    String regionName;
    /**
     * el tipo de arma que utiliza la character
     */
    @Column(name = "weapon_type")
    String weapontype;

    /**
     * constructor of the class character
     * @param characterId id of the character
     * @param characterName name of the character
     * @param characterRarity rarity of the character
     * @param characterImage image of the character
     * @param characterDescription description of the character
     * @param elementName the element of the character
     * @param regionName the region of the character
     * @param weapontype the type of the character
     */
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

    /**
     * constructor of the class character
     */
    public Character() {
        super();
    }

    /**
     * getter of character id
     * @return character id
     */
    public int getCharacterId() {
        return characterId;
    }

    /**
     * setter of the character id
     * @param characterId character id
     */
    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    /**
     * getter of the character name
     * @return character name
     */
    public String getCharacterName() {
        return characterName;
    }

    /**
     * setter of the character name
     * @param characterName character name
     */
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    /**
     * getter of the character rarity
     * @return character rarity
     */
    public int getCharacterRarity() {
        return characterRarity;
    }

    /**
     * setter of the character rarity
     * @param characterRarity character rarity
     */
    public void setCharacterRarity(int characterRarity) {
        this.characterRarity = characterRarity;
    }

    /**
     * getter of the character image
     * @return character iamge
     */
    public String getCharacterImage() {
        return characterImage;
    }

    /**
     * setter of the character image
     * @param characterImage character image
     */
    public void setCharacterImage(String characterImage) {
        this.characterImage = characterImage;
    }

    /**
     * getter of the character description
     * @return character description
     */
    public String getCharacterDescription() {
        return characterDescription;
    }

    /**
     * setter of the character description
     * @param characterDescription character description
     */
    public void setCharacterDescription(String characterDescription) { this.characterDescription = characterDescription; }

    /**
     * getter of the element name
     * @return element name
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * setter of the element name
     * @param elementName element name
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * getter of the character region name
     * @return region name
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * setter of the character region name
     * @param regionName region name
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * getter of the character weapon type
     * @return weapon type
     */
    public String getWeapontype() {
        return weapontype;
    }

    /**
     * setter of the character weapon type
     * @param weapontype weapon type
     */
    public void setWeapontype(String weapontype) {
        this.weapontype = weapontype;
    }

    /**
     * show all info of the character
     * @return info character
     */
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
