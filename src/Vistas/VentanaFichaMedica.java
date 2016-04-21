/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Conector.Conexion;
import java.awt.Toolkit;

/**
 *
 * @author Enzo
 */
public class VentanaFichaMedica extends javax.swing.JFrame {
	DefaultTableModel model;
	DiseñoLetraFondo diseño = new DiseñoLetraFondo();    
	Mensajeria mensaje = new Mensajeria();
    /**
     * Creates new form VentanaFichaMedica2
     */
    public VentanaFichaMedica() {
        initComponents();        
        setSize(1195, 545);
        setIcon();
        setLocationRelativeTo(null);
        setResizable(false);
        cargar("");
        setTitle("LISTA DE FICHAS MÉDICAS");
        inicar();        
    }
    private void inicar() {
    	diseño.Mensaje(campoBuscar,mensaje.getNombre(), 0);
	}
	private void cargar(String valor){
    	String [] titulos={"Codigo","Apellido","Nombre","Dire","Edad","Anticuagulado","DBT","Af.Cardiacas","Micosis","Onicocriptosis","T.Agrietado","Hiperqueratosis","Edema","D.Clinicos","Otras Pat.","Tratamiento","Evolucion"};
    	String [] registros= new String[18];
    	String sql="SELECT * FROM fichasmedicas WHERE fich_ap LIKE '%"+valor+"%' ORDER BY fich_ap ASC";
    	model= new DefaultTableModel(null,titulos){
    	    @Override
    	    public boolean isCellEditable(int row, int column) {
    	       //all cells false
    	       return false;
    	    }
    	};
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        tablaFichaMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFichaMedicaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFichaMedica);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 64, 890, 390);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 910, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaFichaMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFichaMedicaMouseClicked
        VentanaFicha miVF= new VentanaFicha();
    	miVF.campoCod.setVisible(false);
        miVF.etiqCod.setVisible(false);
    	int fila=tablaFichaMedica.getSelectedRow();
    	if(fila>=0){   		
            miVF.campoCod.setText(tablaFichaMedica.getValueAt(fila,0).toString());
            miVF.campoApe.setText(tablaFichaMedica.getValueAt(fila,1).toString());
            miVF.campoNom.setText(tablaFichaMedica.getValueAt(fila,2).toString());
            miVF.campoDire.setText(tablaFichaMedica.getValueAt(fila,3).toString());
            miVF.campoEdad.setText(tablaFichaMedica.getValueAt(fila,4).toString());
            miVF.comboAnticuagulado.setSelectedItem(tablaFichaMedica.getValueAt(fila,5).toString());
            miVF.comboDbt.setSelectedItem(tablaFichaMedica.getValueAt(fila,6).toString());
            miVF.comboCardiacas.setSelectedItem(tablaFichaMedica.getValueAt(fila,7).toString());
            miVF.comboMicosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,8).toString());
            miVF.comboOnicocriptosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,9).toString());
            miVF.comboTalon.setSelectedItem(tablaFichaMedica.getValueAt(fila,10).toString());
            miVF.comboHiperqueratosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,11).toString());
            miVF.comboHiperhidrosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,12).toString());
            miVF.comboEdema.setSelectedItem(tablaFichaMedica.getValueAt(fila,13).toString());
            miVF.areaDClinicos.setText(tablaFichaMedica.getValueAt(fila,14).toString());
            miVF.areaPatologias.setText(tablaFichaMedica.getValueAt(fila,15).toString());
            miVF.areaTratamiento.setText(tablaFichaMedica.getValueAt(fila,16).toString());
            miVF.areaEvolucion.setText(tablaFichaMedica.getValueAt(fila,17).toString());
        }
    }//GEN-LAST:event_tablaFichaMedicaMouseClicked

    protected void campoBuscarFocusLost(FocusEvent evt) {
    	diseño.Mensaje(campoBuscar, mensaje.getNombre(), campoBuscar.getText().trim().length());
	}
	protected void campoBuscarMouseClicked(MouseEvent evt) {
            diseño.Clic(campoBuscar, mensaje.getNombre());		
	}	
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
    private javax.swing.JTextField campoBuscar;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JTable tablaFichaMedica;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
}
