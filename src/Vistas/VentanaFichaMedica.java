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
public class VentanaFichaMedica extends javax.swing.JFrame {

    /**
     * Creates new form VentanaFichaMedica2
     */
    public VentanaFichaMedica() {
        initComponents();
        setSize(932, 550);
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

        jPanel1 = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFichaMedica = new javax.swing.JTable();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        campoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(campoBuscar);
        campoBuscar.setBounds(160, 20, 140, 30);

        labelBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBuscar.setText("Buscar");
        jPanel1.add(labelBuscar);
        labelBuscar.setBounds(30, 14, 70, 30);

        tablaFichaMedica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaFichaMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaFichaMedica);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 64, 890, 440);

        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1458516970_medical-06.png"))); // NOI18N
        btnMostrar.setText("MOSTRAR TODO");
        jPanel1.add(btnMostrar);
        btnMostrar.setBounds(360, 13, 220, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFichaMedica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFichaMedica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JTable tablaFichaMedica;
    // End of variables declaration//GEN-END:variables
}
