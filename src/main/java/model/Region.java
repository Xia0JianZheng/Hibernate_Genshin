package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * class Region
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "region")
public class Region implements Serializable {
    /**
     * el id del region
     */
    @Id
    @Column(name = "id_region")
    int regionId;
    /**
     * el nombre del region
     */
    @Column(name = "region_name")
    String region_name;

    /**
     * Constructor of the class Region
     * @param regionId id region
     * @param region_name name of the region
     */
    public Region(int regionId, String region_name) {
        this.regionId = regionId;
        this.region_name = region_name;
    }

    /**
     * getter region name
     * @return region name
     */
    public String getRegion_name() {
        return region_name;
    }

    /**
     * setter region name
     * @param region_name region name
     */
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    /**
     * getter region id
     * @return region id
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * setter region id
     * @param regionId region id
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * show info of the region
     * @return region info
     */
    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", region_name='" + region_name + '\'' +
                '}';
    }
}
