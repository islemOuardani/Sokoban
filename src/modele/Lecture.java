package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private String nomFich;
    private List<String> listNiv;
    private int nbLigne;
    private int taille;

    public Lecture(String nomFich) {
        this.nomFich = nomFich;
        nbLigne=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomFich));
            String ligne;
            this.listNiv = new ArrayList<>();
            while ((ligne = br.readLine()) != null) {
                listNiv.add(ligne);
                nbLigne++;
            }
            taille=listNiv.get(0).length();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getNomFich() {
        return nomFich;
    }

    public void setNomFich(String nomFich) {
        this.nomFich = nomFich;
    }

    public List<String> getListNiv() {
        return listNiv;
    }

    public void setListNiv(List<String> listNiv) {
        this.listNiv = listNiv;
    }

    public int getNbLigne() {
        return nbLigne;
    }

    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
}
