package vuegraphique;

import modele.Carte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueSokoban extends JFrame {
    private Carte c;
    JPanel pJeu,pControl;
    JButton btRejouer;
    public VueSokoban(Carte c) {
        super("Sokoban");
        this.c = c;
        pJeu = new JPanel(new GridLayout(c.getL().getNbLigne(), c.getL().getTaille()));
        pJeu.setSize(c.getL().getTaille() * 30, (c.getL().getNbLigne()+1) * 30);
        for (int i = 0; i < c.getL().getNbLigne(); i++) {
            for (int j = 0; j < c.getL().getTaille(); j++) {
                if (c.cases[i][j].isDestination() && c.cases[i][j].isCaisseCollision()) {
                    pJeu.add(new CasePanel('-'));
                } else if (c.cases[i][j].isCaisseCollision()) {
                    pJeu.add(new CasePanel('$'));
                } else if (c.cases[i][j].isRobotCollision()) {
                    pJeu.add(new CasePanel('@'));
                } else {
                    pJeu.add(new CasePanel(c.cases[i][j].getCaracters()));
                }
            }
        }

        pControl = new JPanel(new FlowLayout());
        pControl.setPreferredSize(new Dimension(c.getL().getTaille() * 30,50));
        pControl.add(new JLabel("Nombre de mouvements : "+c.getNbMouv()));
        btRejouer = new JButton("Redemarrer la partie");
        btRejouer.setFocusable(false);
        pControl.add(btRejouer);


        this.setLayout(new BorderLayout());
        this.add(pJeu, BorderLayout.CENTER);
        this.add(pControl,BorderLayout.SOUTH);

        setSize(c.getL().getTaille() * 30, ((c.getL().getNbLigne()+1) * 30)+50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        addKeyListener(new Deplacement(this));
        btRejouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VueSokoban.this.setC(new Carte("src/map/map1.txt",1));
                VueSokoban.this.miseAjour(1);
            }
        });
    }
    public Carte getC() {
        return c;
    }

    public void setC(Carte c) {
        this.c = c;
    }
    public void miseAjour(int k){
        if(k==0){//mise a jour pour le deplacemment
            for (int i = 0; i < c.getL().getNbLigne(); i++) {
                for (int j = 0; j < c.getL().getTaille(); j++) {
                    if (c.cases[i][j].isDestination() && c.cases[i][j].isCaisseCollision()) {
                        pJeu.remove(i * c.getL().getTaille() +j);
                        pJeu.add(new CasePanel('-'),i * c.getL().getTaille() + j);
                    } else if (c.cases[i][j].isCaisseCollision()) {
                        pJeu.remove(i * c.getL().getTaille() + j);
                        pJeu.add(new CasePanel('$'),i * c.getL().getTaille() + j);
                    } else if (c.cases[i][j].isRobotCollision()) {
                        pJeu.remove(i * c.getL().getTaille() + j);
                        pJeu.add(new CasePanel('@'),i * c.getL().getTaille() + j);
                    } else if (! (c.cases[i][j].getCaracters() == '#' || c.cases[i][j].getCaracters() == '/' )){
                        pJeu.remove(i * c.getL().getTaille() + j);
                        pJeu.add(new CasePanel(c.cases[i][j].getCaracters()),i * c.getL().getTaille() + j);
                    }
                }
            }
            if (c.isFin()){
                int n = c.getNiveau();
                n++;
                if(n<=3){
                    this.setC(new Carte("src/map/map"+n+".txt",n));
                    this.miseAjour(2);
                }
                this.dispose();
            }
        }else{
            pJeu.removeAll();
            for (int i = 0; i < c.getL().getNbLigne(); i++) {
                for (int j = 0; j < c.getL().getTaille(); j++) {
                    if (c.cases[i][j].isDestination() && c.cases[i][j].isCaisseCollision()) {
                        pJeu.add(new CasePanel('-'));
                    } else if (c.cases[i][j].isCaisseCollision()) {
                        pJeu.add(new CasePanel('$'));
                    } else if (c.cases[i][j].isRobotCollision()) {
                        pJeu.add(new CasePanel('@'));
                    } else {
                        pJeu.add(new CasePanel(c.cases[i][j].getCaracters()));
                    }
                }
            }
            setSize(c.getL().getTaille() * 30, ((c.getL().getNbLigne()+1) * 30)+50);
            pJeu.setLayout(new GridLayout(c.getL().getNbLigne(), c.getL().getTaille()));
            pJeu.setSize(c.getL().getTaille() * 30, (c.getL().getNbLigne()+1) * 30);
        }

        pControl.remove(0);
        pControl.add(new JLabel("Nombre de mouvements : "+c.getNbMouv()),0);
        getContentPane().revalidate();
        getContentPane().repaint();
    }
}
