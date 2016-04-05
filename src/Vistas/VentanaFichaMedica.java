/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conector.Conexion;

/**
 *
 * @author Enzo
 */
public class VentanaFichaMedica extends javax.swing.JFrame {
	DefaultTableModel model;
    /**
     * Creates new form VentanaFichaMedica2
     */
    public VentanaFichaMedica() {
        initComponents();
        setSize(1200, 550);
        setLocationRelativeTo(null);
        cargar("");
        setTitle("LISTA DE FICHAS M�DICAS");
    }
    private void cargar(String valor){
    	String [] titulos={"Codigo","Apellido","Nombre","Dire","Edad","Anticuagulado","DBT","Af.Cardiacas","Micosis","Onicocriptosis","T.Agrietado","Hiperqueratosis","Edema","D.Cl�nicos","Otras Pat.","Tratamiento","Evoluci�n"};
    	String [] registros= new String[18];
    	String sql="SELECT * FROM fichasmedicas WHERE fich_ap LIKE '"+valor+"' ORDER BY fich_ap ASC";
    	model= new DefaultTableModel(null,titulos);
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	try {
			Statement st= cn.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()){
				registros[0]=rs.getString("fich_cod");
				registros[1]=rs.getString("fich_ap");
				registros[2]=rs.getString("fich_nom");
				registros[3]=rs.getString("fich_dire");
				registros[4]=rs.getString("fich_edad");
				registros[5]=rs.getString("fich_anticua");
				registros[6]=rs.getString("fich_dbt");
				registros[7]=rs.getString("fich_afcard");
				registros[8]=rs.getString("fich_micosis");
				registros[9]=rs.getString("fich_onicocri");
				registros[10]=rs.getString("fich_talonagri");
				registros[11]=rs.getString("fich_hiperquera");
				registros[12]=rs.getString("fich_hiperhidro");
				registros[13]=rs.getString("fich_edema");
				registros[14]=rs.getString("fich_datoscli");
				registros[15]=rs.getString("fich_otraspato");
				registros[16]=rs.getString("fich_tratam");
				registros[17]=rs.getString("fich_evolucion");
				model.addRow(registros);				
			}
			tablaFichaMedica.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"ERROR :"+e,"ERROR", JOptionPane.ERROR_MESSAGE);
		}
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
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter(){
        	public void keyReleased(java.awt.event.KeyEvent evt){
        		campoBuscarKeyReleased(evt);
        	}
        });
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
        jScrollPane2.setBounds(10, 64, 1165, 440);

        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1458516970_medical-06.png"))); // NOI18N
        btnMostrar.setText("MOSTRAR TODO");
        jPanel1.add(btnMostrar);
        btnMostrar.setBounds(360, 13, 220, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1180, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void campoBuscarKeyReleased(KeyEvent evt) {
		cargar(campoBuscar.getText());
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
