/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conector.Conexion;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */
public class VentanaTurnos extends javax.swing.JFrame {
DefaultTableModel model;
    /**
     * Creates new form VentanaTurnos2
     */
    public VentanaTurnos() {
        initComponents();
        setSize(1019, 520);
        setLocationRelativeTo(null);
        setTitle("TURNOS");
        cargarTurnos("");
        cargarPacientes();
    }
    private void cargarTurnos(String valor){
        String [] titulos = {"Tel/Cel","Apellido","Nombre","Domicilio","Fecha","Hora","Min"};
        String [] registros= new String[7];
        String sql="SELECT * FROM turnos WHERE turn_ape LIKE '%"+valor+"%' ORDER BY turn_ape ASC";
        model = new DefaultTableModel (null, titulos);
        Conexion cc= new Conexion();
        Connection cn= cc.conexion();
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("turn_cel");
                registros[1]=rs.getString("turn_ape");
                registros[2]=rs.getString("turn_nom");
                registros[3]=rs.getString("turn_dire");
                registros[4]=rs.getString("turn_fecha");
                registros[5]=rs.getString("turn_hora");
                registros[6]=rs.getString("turn_min");
                
                model.addRow(registros);
            }
            tablaTurnos.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:" +e);
        }
    } 
    private void cargarPacientes(){
        String [] titulos = {"Tel/Cel","Apellido","Nombre","Domicilio"};
        String [] registros= new String[5];
        String sql="SELECT * FROM pacientes ORDER BY pac_ap ASC";
        model = new DefaultTableModel (null, titulos);
        Conexion cc= new Conexion();
        Connection cn= cc.conexion();
        try {
            Statement st= cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                registros[0]=rs.getString("pac_cel");
                registros[1]=rs.getString("pac_ap");
                registros[2]=rs.getString("pac_nom");
                registros[3]=rs.getString("pac_dom");
                model.addRow(registros);
            }
            tablaPacientes.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:" +e);
        }
    } 
    
    private void guardar(){
    Conexion cc= new Conexion();
    Connection cn= cc.conexion();
    String cel= campoCel.getText();
    String ape= campoAp.getText();
    String nom= campoNom.getText();
    String hora= campoHora.getText();
    String minu= campoMin.getText();    
    String fecha= campoFecha.getText();
    String dire= campoDire.getText();
    String sql= "INSERT INTO turnos (turn_cel, turn_ape, turn_nom, turn_fecha, turn_dire, turn_hora, turn_min)VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement psd= cn.prepareStatement(sql);
            psd.setString(1, cel);
            psd.setString(2, ape);
            psd.setString(3, nom);
            psd.setString(4, fecha);
            psd.setString(5, dire);
            psd.setString(6, hora);
            psd.setString(7, minu);
            int n= psd.executeUpdate();
            if(n>0){
                JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL REGISTRO","AVISO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR:" +e);
        }        
    }
    
    private void modificar(){
       Conexion cc= new Conexion();
       Connection cn= cc.conexion();
       String cel= campoCel.getText();
       String ape= campoAp.getText();
       String nom= campoNom.getText();
       String hora= campoHora.getText();
       String minu= campoMin.getText();    
       String fecha= campoFecha.getText();
       String dire= campoDire.getText();
       String sql="UPDATE turnos SET turn_ape='"+ape+"', turn_nom='"+nom+"', turn_fecha='"+fecha+"', turn_dire='"+dire+"', turn_hora='"+hora+"', turn_min='"+minu+"' WHERE turn_cel='"+cel+"' ";
       int resp;
       resp= JOptionPane.showConfirmDialog(null,"¿ESTÁ SEGURA DE MODIFICAR ESTE REGISTRO?","ALERTA", JOptionPane.YES_NO_OPTION);
       if(resp == JOptionPane.YES_OPTION){
    	   try {
			PreparedStatement psd= cn.prepareStatement(sql);
			int x= psd.executeUpdate();
			if(x==1){
				JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO");
			}
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"ERROR :" +e);
		}
       }
    }
    private void eliminar(){ 
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String cel=campoCel.getText();
    	String sql="DELETE FROM turnos WHERE turn_cel=?";
    	int resp;
    	resp=JOptionPane.showConfirmDialog(null,"¿ESTÁ SEGURA DE ELIMINAR EL REGISTRO?","ALERTA", JOptionPane.YES_NO_OPTION);
    	if(resp== JOptionPane.YES_OPTION){
    		try {
				PreparedStatement psd= cn.prepareStatement(sql);
				psd.setString(1,cel);
				int x= psd.executeUpdate();
				if(x>0){
					JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL REGISTRO","AVISO", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Error :" +e);
			}
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoCel = new javax.swing.JTextField();
        campoNom = new javax.swing.JTextField();
        campoDire = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        campoFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoAp = new javax.swing.JTextField();
        campoHora = new javax.swing.JTextField();
        campoMin = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTurnos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Celular");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(20, 30, 60, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Hora");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 190, 50, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 130, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Direccion");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 290, 80, 30);

        campoCel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoCel);
        campoCel.setBounds(110, 30, 210, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoNom);
        campoNom.setBounds(110, 130, 210, 30);

        campoDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoDire);
        campoDire.setBounds(110, 290, 210, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Fecha");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 240, 50, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Hs");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(170, 180, 30, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Mins");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(280, 180, 40, 30);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatsave.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnGuardarActionPerformed(evt);
        	}
        });
        jPanel3.add(btnGuardar);
        btnGuardar.setBounds(10, 430, 140, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatedit.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnModificarActionPerformed(evt);
        	}
        });
        jPanel3.add(btnModificar);
        btnModificar.setBounds(200, 370, 140, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatdelete.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnBorrarActionPerfomed(evt);
        	}
        });
        jPanel3.add(btnBorrar);
        btnBorrar.setBounds(200, 430, 140, 40);

        campoFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoFecha);
        campoFecha.setBounds(110, 240, 210, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/broom.png"))); // NOI18N
        jButton1.setText("LIMPIAR");
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 370, 140, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Apellido");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 80, 80, 22);

        campoAp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoAp);
        campoAp.setBounds(110, 80, 210, 30);
        jPanel3.add(campoHora);
        campoHora.setBounds(110, 180, 50, 30);
        jPanel3.add(campoMin);
        campoMin.setBounds(200, 180, 60, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 370, 480);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Buscar");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 10, 70, 30);

        campoBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(campoBuscar);
        campoBuscar.setBounds(100, 10, 160, 30);
        
        tablaTurnos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaTurnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTurnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaTurnos);

        jTabbedPane1.addTab("Turnos", jScrollPane2);
        
        tablaPacientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPacientes);

        jTabbedPane1.addTab("Pacientes", jScrollPane1);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 60, 600, 400);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(380, 0, 620, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    protected void campoBuscarKeyReleased(KeyEvent evt) {
		cargarTurnos(campoBuscar.getText());		
	}
	protected void btnBorrarActionPerfomed(ActionEvent evt) {
		eliminar();
		cargarTurnos("");
	}
	protected void btnModificarActionPerformed(ActionEvent evt) {
		modificar();
		cargarTurnos("");
		
	}
	protected void btnGuardarActionPerformed(ActionEvent evt) {
		guardar();
		cargarTurnos("");
	}
    private void tablaTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTurnosMouseClicked
        int fila=tablaTurnos.getSelectedRow();
        if(fila>=0){
            campoCel.setText(tablaTurnos.getValueAt(fila,0).toString());
            campoAp.setText(tablaTurnos.getValueAt(fila,1).toString());
            campoNom.setText(tablaTurnos.getValueAt(fila,2).toString());
            campoDire.setText(tablaTurnos.getValueAt(fila,3).toString());
            campoFecha.setText(tablaTurnos.getValueAt(fila,4).toString());
            campoHora.setText(tablaTurnos.getValueAt(fila,5).toString());
            campoMin.setText(tablaTurnos.getValueAt(fila,6).toString());
        }        
    }//GEN-LAST:event_tablaTurnosMouseClicked

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked
        int fila2= tablaPacientes.getSelectedRow();
        if(fila2>=0){
        campoCel.setText(tablaPacientes.getValueAt(fila2,0).toString());
        campoAp.setText(tablaPacientes.getValueAt(fila2,1).toString());
        campoNom.setText(tablaPacientes.getValueAt(fila2,3).toString());
        }
    }//GEN-LAST:event_tablaPacientesMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTurnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JTextField campoAp;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCel;
    private javax.swing.JTextField campoDire;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoHora;
    private javax.swing.JTextField campoMin;
    private javax.swing.JTextField campoNom;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTable tablaTurnos;
    // End of variables declaration//GEN-END:variables
}
