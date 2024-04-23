package vuetexte;

import modele.Carte;

public class SokobanTexte {
    public static void main(String[] args) {

        Carte niveau1 =new Carte("src/map/map1.txt",1);
        System.out.println(niveau1.toString());

        ModeTexte modeTexte= new ModeTexte(niveau1);
        modeTexte.lancerPartie();
    }
}
