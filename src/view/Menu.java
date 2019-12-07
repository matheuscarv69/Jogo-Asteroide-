/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Metricas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sons.ThreadSom;

/**
 *
 * @author mathe
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    JLabel teclaA;
    JLabel teclaD;
    JLabel teclaK;
    JLabel tutMovimentos;
    JLabel tutTiro;

    JLabel naveVermelha;
    JLabel naveAzul;

    JLabel naveVerMenu;
    JLabel naveAzulMenu;

    ThreadSom tSom = new ThreadSom();

    public Menu() {
        initComponents();
        navesMenu();
        
        tSom.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jButtonMenuIniciar = new javax.swing.JButton();
        jLabelDesenvolvedor = new javax.swing.JLabel();
        jLabelTituloJogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asteroids Menu");
        setBounds(new java.awt.Rectangle(0, 0, 625, 417));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/IconGame.png")).getImage());
        setResizable(false);

        jPanelMenu.setBackground(new java.awt.Color(81, 33, 105));

        jButtonMenuIniciar.setBackground(new java.awt.Color(153, 153, 153));
        jButtonMenuIniciar.setFont(new java.awt.Font("Comic Sans MS", 3, 14)); // NOI18N
        jButtonMenuIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMenuIniciar.setText("INICIAR");
        jButtonMenuIniciar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonMenuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuIniciarActionPerformed(evt);
            }
        });

        jLabelDesenvolvedor.setFont(new java.awt.Font("Comic Sans MS", 3, 12)); // NOI18N
        jLabelDesenvolvedor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesenvolvedor.setText("Developed by Matheus Carvalho");

        jLabelTituloJogo.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        jLabelTituloJogo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTituloJogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTituloJogo.setText("ASTEROIDES");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabelDesenvolvedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jButtonMenuIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabelTituloJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelTituloJogo)
                .addGap(122, 122, 122)
                .addComponent(jButtonMenuIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jLabelDesenvolvedor)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMenuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuIniciarActionPerformed
        jPanelMenu.remove(jButtonMenuIniciar);
        jLabelTituloJogo.setText("ESCOLHA SUA NAVE!!!");

        criaTeclas();
        escolhaNave();

        jPanelMenu.remove(naveVerMenu);
        jPanelMenu.remove(naveAzulMenu);
        jButtonMenuIniciar.setVisible(false);

        jPanelMenu.validate();
        jPanelMenu.repaint();

    }//GEN-LAST:event_jButtonMenuIniciarActionPerformed

    public void telaFase1() {
        JFrame fase1 = new Fase1();
        fase1.setLocationRelativeTo(null);
        fase1.setVisible(true);
        // fecha o menu
        dispose();
    }

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    private void navesMenu() {
        naveVerMenu = new JLabel();
        naveVerMenu.setBounds(38, 221, 160, 160);
        naveVerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuNave1.png")));
        naveVerMenu.setVisible(true);

        naveAzulMenu = new JLabel();
        naveAzulMenu.setBounds(423, 221, 160, 160);
        naveAzulMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuNave2.png")));
        naveAzulMenu.setVisible(true);

        jPanelMenu.add(naveVerMenu);
        jPanelMenu.add(naveAzulMenu);

    }

    private void escolhaNave() {
        //Instanciacao da nave de escolha vermelha
        naveVermelha = new JLabel();
        naveVermelha.setBounds(38, 221, 160, 160);
        naveVermelha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuNave1.png")));
        naveVermelha.setVisible(true);
        naveVermelha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naveVermelhaMouseClicked(evt);
            }
        });

        //Instanciacao da nave de escolha azul
        naveAzul = new JLabel();
        naveAzul.setBounds(423, 221, 160, 160);
        naveAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MenuNave2.png")));
        naveAzul.setVisible(true);
        naveAzul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naveAzulMouseClicked(evt);
            }
        });
        jPanelMenu.add(naveVermelha);
        jPanelMenu.add(naveAzul);

    }

    private void naveVermelhaMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Metricas.escNave = 1;
        tSom.stop();
        telaFase1();
    }

    private void naveAzulMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        Metricas.escNave = 2;
        tSom.stop();
        telaFase1();
    }

    private void criaTeclas() {
        tutMovimentos = new JLabel();
        tutMovimentos.setBounds(50, 90, 134, 34);
        tutMovimentos.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        tutMovimentos.setForeground(new java.awt.Color(255, 255, 255));
        tutMovimentos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tutMovimentos.setText("Movimentos");

        tutTiro = new JLabel();
        tutTiro.setBounds(450, 90, 94, 34);
        tutTiro.setFont(new java.awt.Font("Comic Sans MS", 3, 24)); // NOI18N
        tutTiro.setForeground(new java.awt.Color(255, 255, 255));
        tutTiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tutTiro.setText("Tiro");

        //Instanciacao de label da tecla A
        teclaA = new JLabel();
        teclaA.setBounds(35, 130, 70, 70);
        teclaA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclas/aR.png")));
        teclaA.setVisible(true);
        //Instanciacao de label da tecla D
        teclaD = new JLabel();
        teclaD.setBounds(130, 130, 70, 70);
        teclaD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclas/dR.png")));
        teclaD.setVisible(true);
        //Instanciacao de label da tecla K
        teclaK = new JLabel();
        teclaK.setBounds(467, 130, 70, 70);
        teclaK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/teclas/kR.png")));
        teclaK.setVisible(true);
        //Adicionando labels ao panel
        jPanelMenu.add(teclaA);
        jPanelMenu.add(teclaD);
        jPanelMenu.add(teclaK);
        jPanelMenu.add(tutMovimentos);
        jPanelMenu.add(tutTiro);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMenuIniciar;
    private javax.swing.JLabel jLabelDesenvolvedor;
    private javax.swing.JLabel jLabelTituloJogo;
    private javax.swing.JPanel jPanelMenu;
    // End of variables declaration//GEN-END:variables
}
