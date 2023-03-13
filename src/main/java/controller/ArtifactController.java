package controller;

import model.Artifact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArtifactController {

    private Connection connection;
    private EntityManagerFactory entityManagerFactory;

    public ArtifactController(Connection connection) {
        this.connection = connection;
    }
    public ArtifactController(Connection connection, EntityManagerFactory entityManagerFactory) {
        this.connection = connection;
        this.entityManagerFactory = entityManagerFactory;
    }
    public List<Artifact> readArtifactFile(String filename) throws IOException {
        int artifactId;
        String set_name, flower_of_life, img_flower_of_life, plume_of_death, img_plume_of_death, sands_of_eon, img_sands_of_eon, goblet_of_eonothem, img_goblet_of_eonothem, circlet_of_logos, img_circlet_of_logos, x2_bonus, x4_bonus;
        List<Artifact> artifactList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String linea = "";
        while((linea = br.readLine()) != null) {
            StringTokenizer str = new StringTokenizer(linea, ",");
            artifactId = Integer.parseInt(str.nextToken());
            set_name = str.nextToken();
            flower_of_life = str.nextToken();
            img_flower_of_life = str.nextToken();
            plume_of_death = str.nextToken();
            img_plume_of_death = str.nextToken();
            sands_of_eon = str.nextToken();
            img_sands_of_eon = str.nextToken();
            goblet_of_eonothem = str.nextToken();
            img_goblet_of_eonothem = str.nextToken();
            circlet_of_logos = str.nextToken();
            img_circlet_of_logos = str.nextToken();
            x2_bonus = str.nextToken();
            x4_bonus = str.nextToken();

            artifactList.add(new Artifact(artifactId,set_name,flower_of_life,img_flower_of_life,plume_of_death,img_plume_of_death,sands_of_eon,img_sands_of_eon,goblet_of_eonothem,img_goblet_of_eonothem,circlet_of_logos,img_circlet_of_logos,x2_bonus,x4_bonus));
        }
        br.close();

        return artifactList;
    }

    public void printArtifacts(ArrayList<Artifact> artifactsList) {
        for (int i = 0; i < artifactsList.size(); i++) {
            System.out.println(artifactsList.get(i).toString());
        }
    }

    public void addArtifact(Artifact artifact) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Artifact artifactExists = (Artifact) em.find(Artifact.class, artifact.getArticleId());
        if (artifactExists == null ){
            System.out.println("insert artifact");
            em.persist(artifact);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void listArtifact() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Artifact> result = em.createQuery("from Artifact", Artifact.class)
                .getResultList();
        for (Artifact artifact : result) {
            System.out.println(artifact.toString());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void updateAartifact(Integer artifactId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Artifact artifact = (Artifact) em.find(Artifact.class, artifactId);
        em.merge(artifact);
        em.getTransaction().commit();
        em.close();
    }

    /* Method to DELETE an Author from the records */
    public void deleteArtifact(Integer artifactId) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Artifact artifact = (Artifact) em.find(Artifact.class, artifactId);
        em.remove(artifact);
        em.getTransaction().commit();
        em.close();
    }
}
