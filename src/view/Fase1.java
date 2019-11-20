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
import model.Asteroides;
import model.Bullets;
import model.nave;
import threads.ThreadPrincipal;

/**
 *
 * @author mathe
 */
public class Fase1 extends javax.swing.JFrame {

    /**
     * Creates new form Fase1
     */
    nave nave;
    Bullets tiro;
    Asteroides ast;

    ThreadPrincipal thread;

    private JButton jButtonSim;
    private JButton jButtonNao;

    public Fase1() {
        initComponents();

        gerarNave();
        gerarAst();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFase1 = new javax.swing.JPanel();
        jLabelScore = new javax.swing.JLabel();
        jLabelNumScore = new javax.swing.JLabel();
        jLabelLifes = new javax.swing.JLabel();
        jLabelNumLifes = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jLabelFim = new javax.swing.JLabel();

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

        jLabelLifes.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelLifes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLifes.setText("Lifes:");

        jLabelNumLifes.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNumLifes.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumLifes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumLifes.setText("3");

        jLabelNivel.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelNivel.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNivel.setText("Nível 1");

        javax.swing.GroupLayout jPanelFase1Layout = new javax.swing.GroupLayout(jPanelFase1);
        jPanelFase1.setLayout(jPanelFase1Layout);
        jPanelFase1Layout.setHorizontalGroup(
            jPanelFase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFase1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelLifes)
                .addGap(18, 18, 18)
                .addComponent(jLabelNumLifes)
                .addGap(112, 112, 112)
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
                    .addComponent(jLabelLifes)
                    .addComponent(jLabelNumLifes)
                    .addComponent(jLabelNivel))
                .addContainerGap(372, Short.MAX_VALUE))
        );

        jLabelFim.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelFim.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFim.setText("Parabéns! Você terminou o beta, sua pontuação foi: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jLabelFim, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFase1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(jLabelFim, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(132, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    thread = new ThreadPrincipal(nave, ast, jPanelFase1, jLabelNumScore, jLabelNumLifes, jLabelNivel);

                    // Aumenta a velocidade de geração dos asteroides
                    niveis();

                    // Verifica se a qunatidade de vidas acabou
                    if (Metricas.lifes == 0) {
                        telaFim();
                        jPanelFase1.validate();
                        jPanelFase1.repaint();
                        stop();
                    }
                    if (Metricas.score >= 1000) {
                        //geraJoptionPane();
                        telaFim();
                        jPanelFase1.validate();
                        jPanelFase1.repaint();
                        stop();
                    }
                    //System.out.println("time: " + Metricas.time);
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
            //Metricas.time -= 30;
            Metricas.time = 2150;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 2");
        } else if (Metricas.score >= 300 && Metricas.score <= 450) {
            // Metricas.time -= 60;
            Metricas.time = 1900;
            System.out.println("time: " + Metricas.time);
            jLabelNivel.setText("Nível 3");
        } else if (Metricas.score >= 500 && Metricas.score <= 600) {
            //Metricas.time -= 80;
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

    public void telaFim() {
        Metricas.inGame = false;
        thread.stop();

        criaButtonSim();
        criaButtonNao();
        jPanelFase1.add(jButtonSim);
        jPanelFase1.add(jButtonNao);

        jPanelFase1.remove(nave);
        jPanelFase1.remove(ast);
        jPanelFase1.remove(tiro);

        jLabelLifes.setVisible(false);
        jLabelScore.setVisible(false);
        jLabelNivel.setVisible(false);
        jLabelNumLifes.setVisible(false);
        jLabelNumScore.setVisible(false);

        jLabelFim.setText("<html>Parabéns! Você terminou o beta, sua<br/>pontuação foi: " + Metricas.score + " pontos <br/>" + "Deseja jogar novamente?" + "</html>");
        jPanelFase1.add(jLabelFim);

        jPanelFase1.validate();
        jPanelFase1.repaint();
    }


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

    private void criaButtonSim() {
        jButtonSim = new JButton();
        jButtonSim.setBackground(new java.awt.Color(153, 153, 153));
        jButtonSim.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonSim.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSim.setText("Sim");
        jButtonSim.setBounds(150, 300, 70, 30);
        jButtonSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimActionPerformed(evt);
            }
        });
    }

    private void criaButtonNao() {
        jButtonNao = new JButton();
        jButtonNao.setBackground(new java.awt.Color(153, 153, 153));
        jButtonNao.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonNao.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNao.setText("Não");
        jButtonNao.setBounds(350, 300, 70, 30);
        jButtonNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaoActionPerformed(evt);
            }
        });
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
    private javax.swing.JLabel jLabelFim;
    private javax.swing.JLabel jLabelLifes;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelNumLifes;
    private javax.swing.JLabel jLabelNumScore;
    private javax.swing.JLabel jLabelScore;
    private javax.swing.JPanel jPanelFase1;
    // End of variables declaration//GEN-END:variables

}
