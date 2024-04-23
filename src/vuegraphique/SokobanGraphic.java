package vuegraphique;

import modele.Carte;

public class SokobanGraphic {
    public static void main(String[] args){
        Carte niveau =new Carte("src/map/map1.txt",1);
        VueSokoban v = new VueSokoban(niveau);
    }
}
