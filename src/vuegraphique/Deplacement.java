package vuegraphique;

import modele.Direction;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Deplacement extends KeyAdapter {
    VueSokoban v;

    public Deplacement(VueSokoban v) {
        this.v = v;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(v.getC().deplacement(Direction.GAUCHE)){
                v.miseAjour(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(v.getC().deplacement(Direction.DROITE)) {
                v.miseAjour(0);
            }
        }else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (v.getC().deplacement(Direction.HAUT)){
                v.miseAjour(0);
            }
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(v.getC().deplacement(Direction.BAS)){
                v.miseAjour(0);
            }
        }
    }
}
