package ui;

//import uy.edu.ort.logica.FachadaServicios;

/**
 *
 * @author ddauser
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLogin = new javax.swing.JMenuItem();
        mLoginAdministrador = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a Sistema de Agendas");

        jMenu1.setText("Usuario");

        mLogin.setText("Login Jugador");
        mLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginJugadorActionPerformed(evt);
            }
        });
        jMenu1.add(mLogin);

        mLoginAdministrador.setText("Login Croupier");
        mLoginAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginCroupierActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginAdministrador);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLoginJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginJugadorActionPerformed
        this.loginJugador();
    }//GEN-LAST:event_mLoginJugadorActionPerformed

    private void mLoginCroupierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginCroupierActionPerformed
        this.loginCroupier();
    }//GEN-LAST:event_mLoginCroupierActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLogin;
    private javax.swing.JMenuItem mLoginAdministrador;
    // End of variables declaration//GEN-END:variables

    private void loginJugador() {
        new DialogoLoginJugador(this, false).setVisible(true);
    }

    private void loginCroupier() {
        new DialogoLoginCroupier(this, false).setVisible(true);
    }
}
