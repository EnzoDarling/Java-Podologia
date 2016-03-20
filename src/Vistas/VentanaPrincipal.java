/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

/**
 *
 * @author Enzo
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public VentanaPrincipal() {
        initComponents();
        setSize(396, 292);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miPanel1 = new javax.swing.JPanel();
        btnTurnos = new javax.swing.JButton();
        btnVade = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnFichas = new javax.swing.JButton();
        btnFichMedica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        miPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        miPanel1.setLayout(null);

        btnTurnos.setText("Turnos");
        btnTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnosActionPerformed(evt);
            }
        });
        miPanel1.add(btnTurnos);
        btnTurnos.setBounds(180, 100, 120, 50);

        btnVade.setText("Vademecum");
        btnVade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVadeActionPerformed(evt);
            }
        });
        miPanel1.add(btnVade);
        btnVade.setBounds(30, 170, 120, 50);

        btnPacientes.setText("Pacientes");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        miPanel1.add(btnPacientes);
        btnPacientes.setBounds(30, 100, 120, 50);

        btnFichas.setText("Fichas");
        btnFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichasActionPerformed(evt);
            }
        });
        miPanel1.add(btnFichas);
        btnFichas.setBounds(30, 30, 120, 50);

        btnFichMedica.setText("Fichas Medicas");
        btnFichMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichMedicaActionPerformed(evt);
            }
        });
        miPanel1.add(btnFichMedica);
        btnFichMedica.setBounds(180, 30, 120, 50);

        getContentPane().add(miPanel1);
        miPanel1.setBounds(4, 2, 390, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFichMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichMedicaActionPerformed
        VentanaFichaMedica VFM2= new VentanaFichaMedica();
        VFM2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFichMedicaActionPerformed

    private void btnFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichasActionPerformed
        VentanaFicha miVentanaFicha= new VentanaFicha();
        miVentanaFicha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFichasActionPerformed

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        VentanaTurnos miVentanaTurnos= new VentanaTurnos();
        miVentanaTurnos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        VentanaPacientes miVentanaPacientes= new VentanaPacientes();
        miVentanaPacientes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnVadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVadeActionPerformed
        VentanaVademecum miVentanaVademecum= new VentanaVademecum();
        miVentanaVademecum.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVadeActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFichMedica;
    private javax.swing.JButton btnFichas;
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnTurnos;
    private javax.swing.JButton btnVade;
    private javax.swing.JPanel miPanel1;
    // End of variables declaration//GEN-END:variables
}
