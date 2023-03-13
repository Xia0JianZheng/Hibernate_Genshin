package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name = "region")
public class Region implements Serializable {

    @Id
    @Column(name = "id_region")
    int regionId;
    @Column(name = "region_name")
    String region_name;

    public Region(int regionId, String region_name) {
        this.regionId = regionId;
        this.region_name = region_name;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "Region{" +
                "regionId=" + regionId +
                ", region_name='" + region_name + '\'' +
                '}';
    }
}
