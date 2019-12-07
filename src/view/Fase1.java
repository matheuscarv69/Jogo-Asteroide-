/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Metricas;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Asteroides;
import model.Bullets;
import model.nave;
import threads.ThreadPrincipal;
import sons.ThreadSom;

/**
 *
 * @author mathe
 */
public class Fase1 extends javax.swing.JFrame {

    /**
     * Creates new form Fase1
     */
    nave nave;
    Bullets tiro = new Bullets(0, 0);
    Asteroides ast;

    ThreadPrincipal thread;
    ThreadSom tSom = new ThreadSom();

    private JLabel labelFim;
    private JLabel labelDev;
    private JLabel labelLife1;
    private JLabel labelLife2;
    private JLabel labelLife3;

    private JButton jButtonSim;
    private JButton jButtonNao;

    public Fase1() {
        initComponents();

        gerarNave();
        gerarAst();
        criaLifes();

        tSom.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFase1 = new javax.swing.JPanel();
        jLabelScore = new javax.swing.JLabel();
        jLabelNumScore = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asteroids");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/IconGame.png")).getImage());
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelFase1.setBackground(new java.awt.Color(120, 65, 147));

        jLabelScore.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelScore.setText("Score: ");

        jLabelNumScore.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNumScore.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumScore.setText("0");

        jLabelNivel.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNivel.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNivel.setText("Nível 1");

        javax.swing.GroupLayout jPanelFase1Layout = new javax.swing.GroupLayout(jPanelFase1);
        jPanelFase1.setLayout(jPanelFase1Layout);
        jPanelFase1Layout.setHorizontalGroup(
            jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFase1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabelNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(jLabelScore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumScore, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanelFase1Layout.setVerticalGroup(
            jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFase1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelScore)
                    .addComponent(jLabelNumScore)
                    .addComponent(jLabelNivel))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        // andar Esquerda 
        if (evt.getKeyChar() == 'a' || evt.getKeyChar() == 'A') {
            nave.andarEsquerda();
            nave.verEsquerda();

        }
        // andar Direita 
        if (evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
            nave.andarDireita();
            nave.verDireita();
        }
        // tiro
        if (evt.getKeyChar() == 'k' || evt.getKeyChar() == 'K') {
            tSom.somTiroDisp();
            gerarTiro();
        }

        // pause
        if (evt.getKeyChar() == 'p' || evt.getKeyChar() == 'P') {
            //Metricas.inGame = false;
            //thread.stop();
        }
        // retorna a execucao da thread
        if (evt.getKeyChar() == 'o' || evt.getKeyChar() == 'O') {
            // Metricas.inGame = true;
            // thread.resume();
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fase1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fase1().setVisible(true);
            }
        });

    }

    private void gerarNave() {
        nave = new nave(280, 330);
        jPanelFase1.add(nave);

    }

    private void gerarTiro() {
        int a = nave.getX() + 20;
        int b = nave.getY() - 13;

        tiro = new Bullets(a, b);
        jPanelFase1.add(tiro);
        // Funcao de movimentacao do tiro 
        thread.getTiro(tiro);
    }

    private void gerarAst() {
        new Thread() {
            @Override
            public void run() {
                while (Metricas.inGame) {
                    Random random = new Random();
                    int low = -30;
                    int hight = 0;
                    int right = 540;
                    int left = -10;

                    int x = random.nextInt(right - left) + left;
                    int y = random.nextInt(hight - low) + low;

                    ast = new Asteroides(x, y);

                    jPanelFase1.add(ast);

                    jPanelFase1.validate();
                    jPanelFase1.repaint();

                    // Funcao de movimentacao do asteroide
                    thread = new ThreadPrincipal(nave, ast, jPanelFase1, jLabelNumScore, labelLife1, labelLife2, labelLife3, jLabelNivel);

                    // Aumenta a velocidade de geração dos asteroides
                    niveis();

                    // Verifica se a qunatidade de vidas acabou
                    if (Metricas.lifes == 0) {
                        telaFim();
                        // Som de game over
                        tSom.gameOver();
                        jPanelFase1.validate();
                        jPanelFase1.repaint();
                        stop();
                    }
                    if (Metricas.score >= 1000) {
                        // Som de level complete
                        telaFim();
                        tSom.levelComplete();
                        jPanelFase1.validate();
                        jPanelFase1.repaint();
                        stop();
                    }

                    try {
                        Thread.sleep(Metricas.time);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    jPanelFase1.updateUI();
                }
            }
        }.start();
    }

    public synchronized void niveis() {
        if (Metricas.score >= 70 && Metricas.score <= 150) {
            Metricas.time = 2150;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 2");
        } else if (Metricas.score >= 300 && Metricas.score <= 450) {
            Metricas.time = 1900;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 3");
        } else if (Metricas.score >= 500 && Metricas.score <= 600) {
            Metricas.time = 1700;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 3");
        } else if (Metricas.score >= 670 && Metricas.score <= 750) {
            Metricas.time -= 30;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 4");
        } else if (Metricas.score >= 800) {
            Metricas.time = 1300;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 5");
        }
    }

    public void criaLifes() {
        labelLife1 = new JLabel();
        labelLife2 = new JLabel();
        labelLife3 = new JLabel();

        labelLife1.setBounds(20, 14, 43, 35);
        labelLife2.setBounds(70, 14, 43, 35);
        labelLife3.setBounds(120, 14, 43, 35);

        if (Metricas.escNave == 1) {
            labelLife1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN1.png")));
            labelLife2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN1.png")));
            labelLife3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN1.png")));
        } else if (Metricas.escNave == 2) {
            labelLife1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN2.png")));
            labelLife2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN2.png")));
            labelLife3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/life/lifeN2.png")));
        }

        jPanelFase1.add(labelLife1);
        jPanelFase1.add(labelLife2);
        jPanelFase1.add(labelLife3);
        jPanelFase1.validate();
        jPanelFase1.repaint();
    }

    public void telaFim() {
        Metricas.inGame = false;
        // Para o som de background
        tSom.stop();
        // Para a thread principal
        thread.stop();

        jPanelFase1.remove(nave);
        jPanelFase1.remove(ast);
        jPanelFase1.remove(tiro);

        labelLife1.setVisible(false);
        labelLife2.setVisible(false);
        labelLife3.setVisible(false);
        jLabelScore.setVisible(false);
        jLabelNivel.setVisible(false);
        jLabelNumScore.setVisible(false);

        criaButtons();
        criajLabelFim();

        jPanelFase1.validate();
        jPanelFase1.repaint();
    }

    private void criajLabelFim() {
        //Mensagem de parabens por terminar o jogo
        labelFim = new JLabel();
        labelFim.setBounds(35, 120, 583, 154);
        labelFim.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        labelFim.setForeground(new java.awt.Color(255, 255, 255));
        labelFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFim.setText("<html>Parabéns! Você terminou o beta<br/>sua pontuação foi: " + Metricas.score + " Pontos <br/>" + "Deseja jogar novamente?" + "</html>");

        //Informacao do desenvolvedor
        labelDev = new JLabel();
        labelDev.setBounds(210, 388, 186, 18);
        labelDev.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        labelDev.setForeground(new java.awt.Color(255, 255, 255));
        labelDev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDev.setText("Developed by Matheus Carvalho");

        jPanelFase1.add(labelFim);
        jPanelFase1.add(labelDev);
    }

    private void criaButtons() {
        //Instaciacao de botao sim
        jButtonSim = new JButton();
        jButtonSim.setBackground(new java.awt.Color(153, 153, 153));
        jButtonSim.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonSim.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSim.setText("Sim");
        jButtonSim.setBounds(120, 300, 70, 30);
        jButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimActionPerformed(evt);
            }
        });
        //Instanciacao de botao nao
        jButtonNao = new JButton();
        jButtonNao.setBackground(new java.awt.Color(153, 153, 153));
        jButtonNao.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonNao.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNao.setText("Não");
        jButtonNao.setBounds(430, 300, 70, 30);
        jButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaoActionPerformed(evt);
            }
        });

        jPanelFase1.add(jButtonSim);
        jPanelFase1.add(jButtonNao);

    }

    private void jButtonSimActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Metricas.inGame = true;
        Metricas.score = 0;
        Metricas.lifes = 3;
        Metricas.time = 2250;
        dispose();

        JFrame Menu = new Menu();
        Menu.setLocationRelativeTo(null);
        Menu.setVisible(true);
    }

    private void jButtonNaoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelNumScore;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JPanel jPanelFase1;
    // End of variables declaration//GEN-END:variables

}
