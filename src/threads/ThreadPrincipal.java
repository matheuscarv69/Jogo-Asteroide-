/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import control.Metricas;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Asteroides;
import model.Bullets;
import model.nave;
import javax.swing.JOptionPane;

/**
 *
 * @author mathe
 */
public class ThreadPrincipal extends Thread {

    private nave nave;
    private Bullets tiro;
    private Asteroides ast;
    private JPanel jPanel;
    private JLabel pontos;
    private JLabel vidas;
    private JLabel velocidade;

    private static Rectangle rectAstD;
    private static Rectangle rectTiroD = new Rectangle(0, 0, 0, 0);

    public ThreadPrincipal(nave nave, Asteroides ast, JPanel jPanel, JLabel pontos, JLabel vidas, JLabel velocidade) {
        this.nave = nave;
        this.ast = ast;
        this.jPanel = jPanel;
        this.pontos = pontos;
        this.vidas = vidas;
        this.velocidade = velocidade;
        this.tiro = new Bullets(nave.getX() + 20, nave.getY() - 13);
        start();
    }

    @Override
    public synchronized void run() {
        // aqui o booleano inGame está dentro do while para parar de executar quando for setado com false
        // dessa forma ele não gera dois jOptionPane
        while (Metricas.inGame) {
            ast.movAst();
            // Remove o asteroide ao atingir y = 420
            if (verLimiteAst()) {
                jPanel.remove(ast);
                stop();
            }

            // Funcao de colisao entre nave e asteroide
            if (colisaoNavAst()) {
                jPanel.remove(ast);
                jPanel.validate();
                jPanel.repaint();
                // contagem de vidas
                diminuiLife();
                stop();
            }
            rectAstD = new Rectangle(ast.getBounds());

            //System.out.println("rectAst - " + rectAstD.getBounds());
            //System.out.println("rectTiro - " + rectTiroD.getBounds());
            if (rectTiroD.intersects(rectAstD)) {
                //System.out.println("funcionou");
                jPanel.remove(ast);
                jPanel.validate();
                jPanel.repaint();

                somaScore();
                stop();
            }

            // Muda a imagem da nave de acordo com a quantidade de vidas
            mudaNave();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public  void getTiro(Bullets tiro) {
        this.tiro = tiro;

        new Thread() {
            @Override
            public void run() {
                while (Metricas.inGame) {
                    tiro.movBullet();

                    // Funcao para remover o tiro caso ele atinge y = -26
                    if (verLimiteTiro()) {
                        jPanel.remove(tiro);
                        jPanel.validate();
                        jPanel.repaint();
                        stop();
                    }

                    if (colisaoTiroAst()) {
                        jPanel.remove(ast);
                        jPanel.remove(tiro);
                        jPanel.validate();
                        jPanel.repaint();
                        // Funcao que para a movimentacao do Asteroide thread principal
                        paraAst();
                        // contagem de pontos ao Tiro atingir Asteroide
                        somaScore();
                        //System.out.println("padrao");
                        stop();
                    }

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        }.start();

    }

    // Funcao que remove o tiro caso atinja a posicao y = -26 
    public boolean verLimiteTiro() {
        return tiro.getY() == -26;
    }

    // Funcao que remove o Asteroide ao atingir a posicao y = 420
    public boolean verLimiteAst() {
        return ast.getY() > 420;
    }

    // Funcao que para a Thread Principal de movimento do asteroide de acordo com o if
    public void paraAst() {
        // funciona como se tivesse um this na frente do stop;
        this.stop();
    }

    // Funcao de colisao entre Nave e Asteroides
    public synchronized boolean colisaoNavAst() {
        Rectangle rectNave = new Rectangle(nave.getBounds());
        Rectangle rectAst = new Rectangle(ast.getBounds());

        //rectAstD = new Rectangle(rectAst);
        //rectAstD = new Rectangle(ast.getBounds());
        return rectAst.intersects(rectNave);
    }

    // Funcao de colisao entre Tiro e Asteroides
    public boolean colisaoTiroAst() {
        Rectangle rectTiro = new Rectangle(tiro.getBounds());
        Rectangle rectAst = new Rectangle(ast.getBounds());
        //testeT = new Rectangle(tiro.getBounds());

        rectTiroD = new Rectangle(rectTiro);
        //rectTiroD = new Rectangle(tiro.getBounds());

        return rectTiro.intersects(rectAst);
    }

    // Muda a imagem da nave de acordo com a quantidade de vidas
    public synchronized void mudaNave() {
        // /
        if (Metricas.escNave == 1) {
            if (Metricas.lifes == 2) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave1-d1.png")));
            } else if (Metricas.lifes == 1) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave1-d2.png")));
            } else if (Metricas.lifes == 0) {
                jPanel.remove(nave);
                jPanel.validate();
                jPanel.repaint();
                // aqui seta o booleano inGame como falso para parar o while da Thread que movimenta o asteroide
                // dessa forma ele não gera dois jOptionPane
                Metricas.inGame = false;
                // OptionPane ao zerar a vida
                geraJoptionPane();
                // this para parar a thread principal 
                this.stop();
            }
            // /*
        } else {
            if (Metricas.lifes == 2) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave2-d1.png")));
            } else if (Metricas.lifes == 1) {
                nave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/naves/Nave2-d2.png")));
            } else if (Metricas.lifes == 0) {
                jPanel.remove(nave);
                jPanel.validate();
                jPanel.repaint();
                // aqui seta o booleano inGame como falso para parar o while da Thread que movimenta o asteroide
                // dessa forma ele não gera dois jOptionPane
                Metricas.inGame = false;
                // OptionPane ao zerar a vida
                //geraJoptionPane();
                // this para parar a thread principal 
                this.stop();
            }
        }
        // */
    }

    public synchronized void somaScore() {
        Metricas.score += 10;
        pontos.setText(String.valueOf(Metricas.score));
    }

    public void diminuiLife() {
        Metricas.lifes--;
        vidas.setText(String.valueOf(Metricas.lifes));
    }

    public void geraJoptionPane() {
        Icon figura = new javax.swing.ImageIcon(getClass().getResource("/images/facepalm2.png"));
        JOptionPane.showMessageDialog(null, "Já morreu fera? Ruimzão hein? affs!\nSó fez " + Metricas.score + " pontos!", "Game-Over", JOptionPane.PLAIN_MESSAGE, figura);

    }
    // final
}
