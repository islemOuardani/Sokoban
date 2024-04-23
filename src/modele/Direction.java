package modele;

public enum Direction {
    HAUT(-1, 0),
    BAS(1, 0),
    GAUCHE(0, -1),
    DROITE(0, 1);

    private final int incrementX;
    private final int incrementY;

    Direction(int incrementX, int incrementY) {
        this.incrementX = incrementX;
        this.incrementY = incrementY;
    }

    public int getIncrementX() {
        return incrementX;
    }

    public int getIncrementY() {
        return incrementY;
    }
}
