package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

    @Entity
    @Access(AccessType.FIELD)
    @Table(name = "artifact")
    public class Artifact implements Serializable {
        @Id
        @Column(name = "id_artifact")
        int artifactId;
        @Column(name = "set_name", length = 30)
        String set_name;
        @Column(name = "flower_of_life", length = 30)
        String flower_of_life;
        @Column(name = "img_flower_of_life", length = 1000)
        String img_flower_of_life;
        @Column(name = "plume_of_death", length = 30)
        String plume_of_death;
        @Column(name = "img_plume_of_death", length = 1000)
        String img_plume_of_death;
        @Column(name = "sands_of_eon", length = 30)
        String sands_of_eon;
        @Column(name = "img_sands_of_eon", length = 1000)
        String img_sands_of_eon;
        @Column(name = "goblet_of_eonothem", length = 30)
        String goblet_of_eonothem;
        @Column(name = "img_goblet_of_eonothem", length = 1000)
        String img_goblet_of_eonothem;
        @Column(name = "circlet_of_logos", length = 30)
        String circlet_of_logos;
        @Column(name = "img_circlet_of_logos", length = 1000)
        String img_circlet_of_logos;
        @Column(name = "x2Bonus", length = 1000)
        String x2Bonus;
        @Column(name = "x4Bonus", length = 1000)
        String x4Bonus;


        public Artifact(int artifactId, String set_name, String flower_of_life, String img_flower_of_life, String plume_of_death, String img_plume_of_death, String sands_of_eon, String img_sands_of_eon, String goblet_of_eonothem, String img_goblet_of_eonothem, String circlet_of_logos, String img_circlet_of_logos, String x2Bonus, String x4Bonus) {
            this.artifactId = artifactId;
            this.set_name = set_name;
            this.flower_of_life = flower_of_life;
            this.img_flower_of_life = img_flower_of_life;
            this.plume_of_death = plume_of_death;
            this.img_plume_of_death = img_plume_of_death;
            this.sands_of_eon = sands_of_eon;
            this.img_sands_of_eon = img_sands_of_eon;
            this.goblet_of_eonothem = goblet_of_eonothem;
            this.img_goblet_of_eonothem = img_goblet_of_eonothem;
            this.circlet_of_logos = circlet_of_logos;
            this.img_circlet_of_logos = img_circlet_of_logos;
            this.x2Bonus = x2Bonus;
            this.x4Bonus = x4Bonus;
        }

        public int getArticleId() {
            return artifactId;
        }

        public void setArtifactId(int articleId) {
            this.artifactId = articleId;
        }

        public String getTitle() {
            return set_name;
        }

        public void setSet_name(String set_name) {
            this.set_name = set_name;
        }

        public String getFlower_of_life() {
            return flower_of_life;
        }

        public void setFlower_of_life(String flower_of_life) {
            this.flower_of_life = flower_of_life;
        }

        public String getImg_flower_of_life() {
            return img_flower_of_life;
        }

        public void setImg_flower_of_life(String img_flower_of_life) {
            this.img_flower_of_life = img_flower_of_life;
        }

        public String getPlume_of_death() {
            return plume_of_death;
        }

        public void setPlume_of_death(String plume_of_death) {
            this.plume_of_death = plume_of_death;
        }

        public String getImg_plume_of_death() {
            return img_plume_of_death;
        }

        public void setImg_plume_of_death(String img_plume_of_death) {
            this.img_plume_of_death = img_plume_of_death;
        }

        public String getSands_of_eon() {
            return sands_of_eon;
        }

        public void setSands_of_eon(String sands_of_eon) {
            this.sands_of_eon = sands_of_eon;
        }

        public String getImg_sands_of_eon() {
            return img_sands_of_eon;
        }

        public void setImg_sands_of_eon(String img_sands_of_eon) {
            this.img_sands_of_eon = img_sands_of_eon;
        }

        public String getGoblet_of_eonothem() {
            return goblet_of_eonothem;
        }

        public void setGoblet_of_eonothem(String goblet_of_eonothem) {
            this.goblet_of_eonothem = goblet_of_eonothem;
        }

        public String getImg_goblet_of_eonothem() {
            return img_goblet_of_eonothem;
        }

        public void setImg_goblet_of_eonothem(String img_goblet_of_eonothem) {
            this.img_goblet_of_eonothem = img_goblet_of_eonothem;
        }

        public String getCirclet_of_logos() {
            return circlet_of_logos;
        }

        public void setCirclet_of_logos(String circlet_of_logos) {
            this.circlet_of_logos = circlet_of_logos;
        }

        public String getImg_circlet_of_logos() {
            return img_circlet_of_logos;
        }

        public void setImg_circlet_of_logos(String img_circlet_of_logos) {
            this.img_circlet_of_logos = img_circlet_of_logos;
        }

        public String getX2Bonus() {
            return x2Bonus;
        }

        public void setX2Bonus(String x2Bonus) {
            this.x2Bonus = x2Bonus;
        }

        public String getX4Bonus() {
            return x4Bonus;
        }

        public void setX4Bonus(String x4Bonus) {
            this.x4Bonus = x4Bonus;
        }

        @Override
        public String toString() {
            return "Artifact{" +
                    "artifactId=" + artifactId +
                    ", set_name='" + set_name + '\'' +
                    ", flower_of_life='" + flower_of_life + '\'' +
                    ", img_flower_of_life='" + img_flower_of_life + '\'' +
                    ", plume_of_death='" + plume_of_death + '\'' +
                    ", img_plume_of_death='" + img_plume_of_death + '\'' +
                    ", sands_of_eon='" + sands_of_eon + '\'' +
                    ", img_sands_of_eon='" + img_sands_of_eon + '\'' +
                    ", goblet_of_eonothem='" + goblet_of_eonothem + '\'' +
                    ", img_goblet_of_eonothem='" + img_goblet_of_eonothem + '\'' +
                    ", circlet_of_logos='" + circlet_of_logos + '\'' +
                    ", img_circlet_of_logos='" + img_circlet_of_logos + '\'' +
                    ", x2Bonus='" + x2Bonus + '\'' +
                    ", x4Bonus='" + x4Bonus + '\'' +
                    '}';
        }
    }
