package modele;

public class Case {
    private char caracters;
    private boolean robotCollision;
    private boolean caisseCollision;

    public Case(char caracters) {
        this.caracters = caracters;
        this.robotCollision = false;
        this.caisseCollision = false;
    }

    public char getCaracters() {
        return caracters;
    }

    public void setCaracters(char caracters) {
        this.caracters = caracters;
    }

    public boolean isRobotCollision() {
        return robotCollision;
    }

    public void setRobotCollision(boolean robotCollision) {
        this.robotCollision = robotCollision;
    }

    public boolean isCaisseCollision() {
        return caisseCollision;
    }

    public void setCaisseCollision(boolean caisseCollision) {
        this.caisseCollision = caisseCollision;
    }
    public boolean isObstacle(){
        return this.caracters == '#' || this.caracters == '/';
    }
    public boolean isDestination(){
        return this.caracters == '.';
    }
}
