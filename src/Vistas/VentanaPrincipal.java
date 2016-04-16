/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
        setTitle("SISTEMA PODOLÓGICO v1.0");
        setSize(718, 455);
        setResizable(false);
        setLocationRelativeTo(null);
        setIcon();
        addWindowListener(new WindowAdapter() {
        	
        	@Override
        	public void windowClosing(WindowEvent e) {
        		Object[] options = {"CANCELAR", "ACEPTAR"};
            	int n = JOptionPane.showOptionDialog(null,
                        "Si sale el sistema se cerrara ¿Desea salir?","AVISO",JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,null,options,options[0]);
		       
            	if (n == JOptionPane.YES_OPTION){}
		        else if (n == JOptionPane.NO_OPTION) 
		        {
		        	System.exit(0);//Cerrar todo el sistema
		        }
        	}
        });
    }

    private void setIcon() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
    public class ImgUtils {

    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFichMedica = new javax.swing.JButton();
        btnVade = new javax.swing.JButton();
        btnTurnos = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnFichMedica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFichMedica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ficha medica.png"))); // NOI18N
        btnFichMedica.setText("FICHAS MEDICAS");
        btnFichMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichMedicaActionPerformed(evt);
            }
        });
        getContentPane().add(btnFichMedica);
        btnFichMedica.setBounds(10, 10, 210, 50);

        btnVade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book.png"))); // NOI18N
        btnVade.setText("VADEMECUM");
        btnVade.setBorder(null);
        btnVade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnVade);
        btnVade.setBounds(10, 130, 210, 50);

        btnTurnos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTurnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/turnos.png"))); // NOI18N
        btnTurnos.setText("TURNOS");
        btnTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnosActionPerformed(evt);
            }
        });
        getContentPane().add(btnTurnos);
        btnTurnos.setBounds(10, 240, 210, 50);

        btnPacientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1458530871_PatientMale.png"))); // NOI18N
        btnPacientes.setText("PACIENTES");
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPacientes);
        btnPacientes.setBounds(10, 350, 210, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/podologia.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 430);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/podologia-original.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 350, 80, 80);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFichMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichMedicaActionPerformed
        VentanaFicha VFM= new VentanaFicha();
        VFM.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnFichMedicaActionPerformed

    private void btnTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnosActionPerformed
        VentanaTurnos miVentanaTurnos= new VentanaTurnos();
        miVentanaTurnos.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_btnTurnosActionPerformed

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        VentanaPacientes miVentanaPacientes= new VentanaPacientes();
        miVentanaPacientes.setVisible(true);
       // this.dispose();
    }//GEN-LAST:event_btnPacientesActionPerformed

    private void btnVadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVadeActionPerformed
        VentanaVademecum miVentanaVademecum= new VentanaVademecum();
        miVentanaVademecum.setVisible(true);
        //this.dispose();
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
    private javax.swing.JButton btnPacientes;
    private javax.swing.JButton btnTurnos;
    private javax.swing.JButton btnVade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
