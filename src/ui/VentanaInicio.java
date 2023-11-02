package ui;

//import uy.edu.ort.logica.FachadaServicios;

import Logica.Fachada;


/**
 *
 * @author ddauser
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    Fachada fachada;
    
    public VentanaInicio(Fachada fachada) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fachada = fachada;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jugadorLogin = new javax.swing.JButton();
        crupierLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("¡Bienvenido!");
        setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("¡Bienvenido!");

        jugadorLogin.setText("Jugador");
        jugadorLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadorLoginActionPerformed(evt);
            }
        });

        crupierLogin.setText("Crupier");
        crupierLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crupierLoginActionPerformed(evt);
            }
        });

        jLabel2.setText("Elige  tu rol para ingresar a la ruleta");

        jMenu1.setText("Menu");

        Exit.setText("Salir");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitJugadorActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jugadorLogin)
                        .addGap(31, 31, 31)
                        .addComponent(crupierLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crupierLogin)
                    .addComponent(jugadorLogin))
                .addContainerGap(175, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitJugadorActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitJugadorActionPerformed

    private void crupierLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crupierLoginActionPerformed
        this.loginCroupier();
    }//GEN-LAST:event_crupierLoginActionPerformed

    private void jugadorLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadorLoginActionPerformed
       this.loginJugador();
    }//GEN-LAST:event_jugadorLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JButton crupierLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jugadorLogin;
    // End of variables declaration//GEN-END:variables

    private void loginJugador() {
        new DialogoLoginJugador(this, false,fachada).setVisible(true);
    }

    private void loginCroupier() {
        new DialogoLoginCroupier(this, false,fachada).setVisible(true);
        
    }
}
