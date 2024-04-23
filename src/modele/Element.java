package modele;

public class Element {
    protected int posX;
    protected int posY;

    public Element(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void deplacer(Direction direction){
        this.posX += direction.getIncrementX();
        this.posY += direction.getIncrementY();
    }
}
