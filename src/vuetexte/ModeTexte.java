package vuetexte;

import modele.Carte;
import modele.Direction;

import java.util.HashMap;
import java.util.Map;

public class ModeTexte {
    private Carte c;
    private Map<Character, Direction> controls = new HashMap<>();

    public ModeTexte(Carte c) {
        this.c = c;
        controls.put('z', Direction.HAUT);
        controls.put('s', Direction.BAS);
        controls.put('q', Direction.GAUCHE);
        controls.put('d', Direction.DROITE);
    }
    public Direction lireDirection() {
        char car;
        do {
            car = Outil.lireCaractere();
        } while (!controls.containsKey(car));
        return controls.get(car);
    }
    public void lancerPartie() {
        while (!c.getFin()) {
            Direction direction = lireDirection();
            c.deplacement(direction);
            System.out.println(c.toString());
        }
        System.out.println("Félicitations vous avez gagné");
        int n = c.getNiveau();
        n++;
        if (n<=3){
            this.c = new Carte("src/map/map"+n+".txt",n);
            System.out.println("Niveau "+n);
            System.out.println(c.toString());
            lancerPartie();
        }
        else {
            System.out.println("Félicitations Fin");
        }
    }
}
