package vuegraphique;

import javax.swing.*;
import java.awt.*;

public class CasePanel extends JPanel {
    public Image image;
    private Character c;
    public CasePanel(Character c) {
        this.c = c;
        switch (c){
            case '/':
                this.image = new ImageIcon("").getImage();
                break;
            case '#':
                this.image = new ImageIcon("src/img/mur.gif").getImage();
                break;
            case ' ':
                this.image = new ImageIcon("src/img/sol.gif").getImage();
                break;
            case '.':
                this.image = new ImageIcon("src/img/but.gif").getImage();
                break;
            case '@':
                this.image = new ImageIcon("src/img/Bas.gif").getImage();
                break;
            case '$':
                this.image = new ImageIcon("src/img/caisse1.gif").getImage();
                break;
            case '-':
                this.image = new ImageIcon("src/img/caisse2.gif").getImage();
                break;
        }
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}
