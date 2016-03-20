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
public class VentanaFicha extends javax.swing.JFrame {

    /**
     * Creates new form VentanaFicha2
     */
    public VentanaFicha() {
        initComponents();
        setSize(966, 563);
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
        labelApe = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelDire = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        labelDbt = new javax.swing.JLabel();
        campoApe = new javax.swing.JTextField();
        campoNom = new javax.swing.JTextField();
        campoDire = new javax.swing.JTextField();
        campoTel = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
        comboHiperhidrosis = new javax.swing.JComboBox<>();
        labelCardiacas = new javax.swing.JLabel();
        labelAnticuagulado = new javax.swing.JLabel();
        comboTalon = new javax.swing.JComboBox<>();
        comboCardiacas = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        labelMicosis = new javax.swing.JLabel();
        comboMicosis = new javax.swing.JComboBox<>();
        labelOnicocriptosis = new javax.swing.JLabel();
        comboAnticuagulado = new javax.swing.JComboBox<>();
        labelTalon1 = new javax.swing.JLabel();
        comboDbt = new javax.swing.JComboBox<>();
        labelHiperquratosis = new javax.swing.JLabel();
        comboHiperqueratosis = new javax.swing.JComboBox<>();
        labelHiperhidrosis = new javax.swing.JLabel();
        comboEdema = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        comboOnicocriptosis = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        labelDClinicos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDClinicos = new javax.swing.JTextArea();
        labelPatologias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaPatologias = new javax.swing.JTextArea();
        labelTratamiento = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaEvolucion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaTratamiento = new javax.swing.JTextArea();
        labelEvolucion = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        labelTalon2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelApe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelApe.setText("Apellido");
        jPanel1.add(labelApe);
        labelApe.setBounds(10, 30, 50, 17);

        labelNom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNom.setText("Nombre");
        jPanel1.add(labelNom);
        labelNom.setBounds(240, 30, 60, 17);

        labelDire.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDire.setText("Dirección");
        jPanel1.add(labelDire);
        labelDire.setBounds(470, 40, 60, 17);

        labelTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTel.setText("Tel/Cel");
        jPanel1.add(labelTel);
        labelTel.setBounds(700, 30, 40, 17);

        labelEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEdad.setText("Edad");
        jPanel1.add(labelEdad);
        labelEdad.setBounds(10, 90, 31, 17);

        labelDbt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDbt.setText("DBT");
        jPanel1.add(labelDbt);
        labelDbt.setBounds(480, 110, 26, 17);
        jPanel1.add(campoApe);
        campoApe.setBounds(110, 30, 110, 30);
        jPanel1.add(campoNom);
        campoNom.setBounds(330, 30, 110, 30);
        jPanel1.add(campoDire);
        campoDire.setBounds(550, 30, 110, 30);
        jPanel1.add(campoTel);
        campoTel.setBounds(830, 30, 110, 30);
        jPanel1.add(campoEdad);
        campoEdad.setBounds(110, 90, 110, 30);

        comboHiperhidrosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboHiperhidrosis);
        comboHiperhidrosis.setBounds(110, 210, 110, 30);

        labelCardiacas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCardiacas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardiacas.setText("Afecciones Cardíacas");
        jPanel1.add(labelCardiacas);
        labelCardiacas.setBounds(690, 100, 130, 17);

        labelAnticuagulado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelAnticuagulado.setText("Anticuagulado");
        jPanel1.add(labelAnticuagulado);
        labelAnticuagulado.setBounds(240, 90, 86, 17);

        comboTalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboTalon);
        comboTalon.setBounds(550, 180, 110, 30);

        comboCardiacas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboCardiacas);
        comboCardiacas.setBounds(830, 100, 110, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(680, 10, 10, 250);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(230, 10, 10, 250);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3);
        jSeparator3.setBounds(460, 10, 10, 250);

        labelMicosis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelMicosis.setText("Micosis");
        jPanel1.add(labelMicosis);
        labelMicosis.setBounds(10, 150, 60, 17);

        comboMicosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inter Digital", "Ungueal", "Plantar", " " }));
        jPanel1.add(comboMicosis);
        comboMicosis.setBounds(110, 150, 110, 30);

        labelOnicocriptosis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelOnicocriptosis.setText("Onicocriptosis");
        jPanel1.add(labelOnicocriptosis);
        labelOnicocriptosis.setBounds(240, 160, 90, 17);

        comboAnticuagulado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboAnticuagulado);
        comboAnticuagulado.setBounds(340, 90, 100, 30);

        labelTalon1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTalon1.setText("Talón");
        jPanel1.add(labelTalon1);
        labelTalon1.setBounds(470, 170, 40, 17);

        comboDbt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboDbt);
        comboDbt.setBounds(550, 100, 110, 30);

        labelHiperquratosis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHiperquratosis.setText("Hiperqueratosis");
        jPanel1.add(labelHiperquratosis);
        labelHiperquratosis.setBounds(690, 170, 100, 17);

        comboHiperqueratosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lateral", "Superior", "Metatarsal" }));
        jPanel1.add(comboHiperqueratosis);
        comboHiperqueratosis.setBounds(830, 170, 110, 30);

        labelHiperhidrosis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHiperhidrosis.setText("HiperHidrosis");
        jPanel1.add(labelHiperhidrosis);
        labelHiperhidrosis.setBounds(10, 220, 90, 17);

        comboEdema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboEdema);
        comboEdema.setBounds(340, 210, 100, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Edema");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(240, 220, 42, 17);

        comboOnicocriptosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboOnicocriptosis);
        comboOnicocriptosis.setBounds(340, 150, 100, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        labelDClinicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDClinicos.setText("Datos Clínicos");
        jPanel2.add(labelDClinicos);
        labelDClinicos.setBounds(20, 10, 100, 17);

        areaDClinicos.setColumns(20);
        areaDClinicos.setRows(5);
        jScrollPane1.setViewportView(areaDClinicos);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 200, 160);

        labelPatologias.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelPatologias.setText("Otras Patologías");
        jPanel2.add(labelPatologias);
        labelPatologias.setBounds(250, 10, 110, 17);

        areaPatologias.setColumns(20);
        areaPatologias.setRows(5);
        jScrollPane2.setViewportView(areaPatologias);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(240, 40, 200, 160);

        labelTratamiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTratamiento.setText("Tratamiento");
        jPanel2.add(labelTratamiento);
        labelTratamiento.setBounds(470, 10, 90, 17);

        areaEvolucion.setColumns(20);
        areaEvolucion.setRows(5);
        jScrollPane3.setViewportView(areaEvolucion);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(710, 40, 210, 160);

        areaTratamiento.setColumns(20);
        areaTratamiento.setRows(5);
        jScrollPane4.setViewportView(areaTratamiento);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(470, 40, 210, 160);

        labelEvolucion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelEvolucion.setText("Evolución");
        jPanel2.add(labelEvolucion);
        labelEvolucion.setBounds(720, 10, 60, 17);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(220, 10, 10, 180);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator5);
        jSeparator5.setBounds(690, 10, 10, 180);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(450, 10, 10, 180);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 270, 930, 210);

        labelTalon2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTalon2.setText("Agrietado");
        jPanel1.add(labelTalon2);
        labelTalon2.setBounds(470, 200, 60, 14);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(10, 500, 90, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar);
        btnModificar.setBounds(120, 500, 100, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnBorrar.setText("Borrar");
        jPanel1.add(btnBorrar);
        btnBorrar.setBounds(240, 500, 90, 40);

        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnMostrar.setText("Mostrar Fichas");
        jPanel1.add(btnMostrar);
        btnMostrar.setBounds(710, 500, 150, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 960, 560);

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
            java.util.logging.Logger.getLogger(VentanaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFicha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFicha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDClinicos;
    private javax.swing.JTextArea areaEvolucion;
    private javax.swing.JTextArea areaPatologias;
    private javax.swing.JTextArea areaTratamiento;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JTextField campoApe;
    private javax.swing.JTextField campoDire;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoNom;
    private javax.swing.JTextField campoTel;
    private javax.swing.JComboBox<String> comboAnticuagulado;
    private javax.swing.JComboBox<String> comboCardiacas;
    private javax.swing.JComboBox<String> comboDbt;
    private javax.swing.JComboBox<String> comboEdema;
    private javax.swing.JComboBox<String> comboHiperhidrosis;
    private javax.swing.JComboBox<String> comboHiperqueratosis;
    private javax.swing.JComboBox<String> comboMicosis;
    private javax.swing.JComboBox<String> comboOnicocriptosis;
    private javax.swing.JComboBox<String> comboTalon;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelAnticuagulado;
    private javax.swing.JLabel labelApe;
    private javax.swing.JLabel labelCardiacas;
    private javax.swing.JLabel labelDClinicos;
    private javax.swing.JLabel labelDbt;
    private javax.swing.JLabel labelDire;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelEvolucion;
    private javax.swing.JLabel labelHiperhidrosis;
    private javax.swing.JLabel labelHiperquratosis;
    private javax.swing.JLabel labelMicosis;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelOnicocriptosis;
    private javax.swing.JLabel labelPatologias;
    private javax.swing.JLabel labelTalon1;
    private javax.swing.JLabel labelTalon2;
    private javax.swing.JLabel labelTel;
    private javax.swing.JLabel labelTratamiento;
    // End of variables declaration//GEN-END:variables
}
