package controller;

import model.Element;
import model.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RegionController {
    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    public RegionController(Connection connection) {
        this.connection = connection;
    }

    public RegionController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<Region> readRegionsFile(String filename) throws IOException {
        int regionId;
        String region_name;


        List<Region> regionsList = new ArrayList();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            regionId = Integer.parseInt(str.nextToken());
            region_name = str.nextToken();
            try {
                regionsList.add(new Region(regionId,region_name));
            } catch (Exception e) {
                System.err.println("Errada format data al fitxer");
                e.printStackTrace();
            }
        }
        br.close();

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        for (Region r: regionsList) {
            Region regionExist = (Region) em.find(Region.class, r.getRegionId());
            if(regionExist == null){
                System.out.println("region added");
                em.persist(r);
            }
            em.merge(r);
        }
        em.getTransaction().commit();
        em.close();

        return regionsList;
    }
}
