package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carte {
    private Lecture l;
    public Case[][] cases;
    private Robot robot;
    private Boolean fin;
    private int nbMouv,niveau;
    public Carte(String nomFich,int niveau) {
        this.l = new Lecture(nomFich);
        this.niveau = niveau;
        this.cases= new Case[this.l.getNbLigne()][this.l.getTaille()];
        for (int i=0 ; i<this.l.getNbLigne();i++){
            for (int j=0;j<this.l.getTaille();j++){
                switch (this.l.getListNiv().get(i).charAt(j)){
                    case '/':
                        this.cases[i][j]=new Case('/');
                        break;
                    case '#':
                        this.cases[i][j]=new Case('#');
                        break;
                    case ' ':
                        this.cases[i][j]=new Case(' ');
                        break;
                    case '.':
                        this.cases[i][j]=new Case('.');
                        break;
                    case '@':
                        this.cases[i][j]=new Case(' ');
                        this.cases[i][j].setRobotCollision(true);
                        this.robot=new Robot(i,j);
                        break;
                    case '$':
                        this.cases[i][j]=new Case(' ');
                        this.cases[i][j].setCaisseCollision(true);
                        break;
                }
            }
        }
        this.fin=false;
    }

    public Lecture getL() {
        return l;
    }

    public void setL(Lecture l) {
        this.l = l;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Boolean getFin() {
        return fin;
    }

    public void setFin(Boolean fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        for (int i=0 ; i<this.l.getNbLigne();i++) {
            for (int j = 0; j < this.l.getTaille(); j++) {
                if(cases[i][j].isDestination()&&cases[i][j].isRobotCollision()){
                    s.append("+");
                } else if (cases[i][j].isCaisseCollision()){
                    s.append("$");
                } else if (cases[i][j].isRobotCollision()) {
                    s.append("@");
                }else {
                    s.append(cases[i][j].getCaracters());
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void deplacerRobot(Direction d){
        cases[robot.getPosX()][robot.getPosY()].setRobotCollision(false);
        cases[robot.getPosX()+d.getIncrementX()][robot.getPosY()+d.getIncrementY()].setRobotCollision(true);
        robot.deplacer(d);
    }
    public boolean deplacerCaisse(Direction d,int x,int y){
        if(cases[x+d.getIncrementX()][y+d.getIncrementY()].isCaisseCollision()||cases[x+d.getIncrementX()][y+d.getIncrementY()].isObstacle()){
            return false;
        }else{
            cases[x][y].setCaisseCollision(false);
            cases[x+d.getIncrementX()][y+d.getIncrementY()].setCaisseCollision(true);
            return true;
        }
    }
    public boolean isFin(){
        for (int i=0 ; i<this.l.getNbLigne();i++) {
            for (int j = 0; j < this.l.getTaille(); j++) {
                if(cases[i][j].isDestination())
                {
                    if (!cases[i][j].isCaisseCollision()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean deplacement(Direction d){
        int x=robot.getPosX()+d.getIncrementX();
        int y=robot.getPosY()+d.getIncrementY();
        if (!cases[x][y].isObstacle()){
            if(cases[x][y].isCaisseCollision())
            {
                if(this.deplacerCaisse(d,x,y)){
                    deplacerRobot(d);
                    if(isFin()){
                        this.setFin(true);
                    }
                    nbMouv++;
                    return true;
                }
            }else {
                deplacerRobot(d);
                if(isFin()){
                    this.setFin(true);
                }
                nbMouv++;
                return true;
            }
        }
        return false;
    }

    public int getNbMouv() {
        return nbMouv;
    }

    public void setNbMouv(int nbMouv) {
        this.nbMouv = nbMouv;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
