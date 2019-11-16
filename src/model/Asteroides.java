/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JLabel;

/**
 *
 * @author mathe
 */
public class Asteroides extends JLabel{
    private int x;
    private int y;
    
    private static int width = 87;
    private static int height = 65;
    
    
    public Asteroides(int x, int y) {
        this.x = x;
        this.y = y;
        
        setBounds(x, y, width, height);
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Asteroide.png")));
    }
    
    public void movAst(){
        x = getX();
        y = getY();
        y++;
        setBounds(x, y, width, height);
    }    
    
}
