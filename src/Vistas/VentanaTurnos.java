/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conector.Conexion;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
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
DiseñoLetraFondo diseño;
Mensajeria mensaje;
CustomErrorDialog CustomError;
    /**
     * Creates new form VentanaTurnos2
     */
    public VentanaTurnos() {
        initComponents();
        diseño = new DiseñoLetraFondo();
        mensaje = new Mensajeria();
        CustomError = new CustomErrorDialog();
        setSize(1045, 520);
        setTitle("TURNOS");
        setIcon();
        setLocationRelativeTo(null);        
        deshabilitar();
        cargarTurnos("");
        cargarPacientes();
        iniciar();
    }
    public void iniciar(){
        diseño.Mensaje(campoBuscar,mensaje.getApellido(), 0);
    }
    private void cargarTurnos(String valor){
        String [] titulos = {"Tel/Cel","Apellido","Nombre","Domicilio","Fecha","Hora","Min"};
        String [] registros= new String[7];
        String sql="SELECT * FROM turnos WHERE turn_ape LIKE '%"+valor+"%' ORDER BY turn_ape ASC";
        model = new DefaultTableModel (null, titulos){

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
            CustomError.showDialog("<html>Ocurrió un error al cargar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
        }
    } 
    private void cargarPacientes(){
        String [] titulos = {"Tel/Cel","Apellido","Nombre","Domicilio"};
        String [] registros= new String[5];
        String sql="SELECT * FROM pacientes ORDER BY pac_ap ASC";
        model = new DefaultTableModel (null, titulos){
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
                registros[0]=rs.getString("pac_cel");
                registros[1]=rs.getString("pac_ap");
                registros[2]=rs.getString("pac_nom");
                registros[3]=rs.getString("pac_dom");
                model.addRow(registros);
            }
            tablaPacientes.setModel(model);
        } catch (Exception e) {
            CustomError.showDialog("<html>Ocurrió un error al cargar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
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
    if(cel.equals("") || cel==null || ape.equals("") || ape==null || nom.equals("") || nom==null || fecha.equals("") || fecha==null || dire.equals("")|| dire==null || hora.equals("") || hora==null ||  minu.equals("") || minu==null){
        JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente","Error", JOptionPane.ERROR_MESSAGE);
    }else{
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
                CustomError.showDialog("<html>Ocurrió un error al guardar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
            }        
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
       if(cel.equals("") || cel==null || ape.equals("") || ape==null || nom.equals("") || nom==null || fecha.equals("") || fecha==null || dire.equals("")|| dire==null || hora.equals("") || hora==null ||  minu.equals("") || minu==null){
           JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos vacíos e intente nuevamente","Error", JOptionPane.ERROR_MESSAGE);
       }else{
       int resp;
       resp= JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE MODIFICAR ESTE REGISTRO?","ALERTA", JOptionPane.YES_NO_OPTION);
       if(resp == JOptionPane.YES_OPTION){
    	   try {
			PreparedStatement psd= cn.prepareStatement(sql);
			int x= psd.executeUpdate();
			if(x==1){
				JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO");
			}
		} catch (Exception e) {
                        CustomError.showDialog("<html>Ocurrió un error al modificar, contacte al personal adecuado sobre este error</html>", 
                    "<html>'"+e+"'</html>");
		}
       }
    }}
    private void eliminar(){ 
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String cel=campoCel.getText();
    	String sql="DELETE FROM turnos WHERE turn_cel=?";
    	
        if(cel.equals("") || cel==null){
            JOptionPane.showMessageDialog(null,"No ingresó un número de celular para eliminar, ingrese un número de celular e intente nuevamente");
        }else{
            int resp;
            resp=JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE ELIMINAR EL REGISTRO?","ALERTA", JOptionPane.YES_NO_OPTION);
            if(resp== JOptionPane.YES_OPTION){
                try {
                    PreparedStatement psd= cn.prepareStatement(sql);
                    psd.setString(1,cel);
                    int x= psd.executeUpdate();
                    if(x>0){
                            JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL REGISTRO","AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                        CustomError.showDialog("<html>Ocurrió un error al eliminar, contacte al personal adecuado sobre este error</html>", 
                    "<html>'"+e+"'</html>");
                }
            }
        }
    }
    private void limpiar(){
    	campoAp.setText("");
    	campoCel.setText("");
    	campoDire.setText("");
    	campoFecha.setText("");
    	campoHora.setText("");
    	campoMin.setText("");
    	campoNom.setText("");
    }
    private void habilitar(){
    	campoAp.setEnabled(true);
    	campoCel.setEnabled(true);
    	campoDire.setEnabled(true);
    	campoFecha.setEnabled(true);
    	campoHora.setEnabled(true);
    	campoMin.setEnabled(true);
    	campoNom.setEnabled(true);
    }
    private void deshabilitar(){
    	campoAp.setEnabled(false);
    	campoCel.setEnabled(false);
    	campoDire.setEnabled(false);
    	campoFecha.setEnabled(false);
    	campoHora.setEnabled(false);
    	campoMin.setEnabled(false);
    	campoNom.setEnabled(false);
    }
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
        btnNuevo = new javax.swing.JButton();
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
        jLabel1.setBounds(20, 30, 80, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Hora");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(30, 190, 50, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 130, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Direccion");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 290, 90, 30);

        campoCel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoCel);
        campoCel.setBounds(130, 30, 210, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoNom);
        campoNom.setBounds(130, 130, 210, 30);

        campoDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoDire);
        campoDire.setBounds(130, 290, 210, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Fecha");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 240, 60, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Hs");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(190, 180, 30, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Mins");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(300, 180, 40, 30);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tick.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);
        btnGuardar.setBounds(10, 430, 160, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar);
        btnModificar.setBounds(190, 370, 170, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrar);
        btnBorrar.setBounds(190, 430, 170, 40);

        campoFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoFecha);
        campoFecha.setBounds(130, 240, 210, 30);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit-clear.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(10, 370, 160, 40);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Apellido");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 80, 80, 22);

        campoAp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoAp);
        campoAp.setBounds(130, 80, 210, 30);

        campoHora.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoHora);
        campoHora.setBounds(130, 180, 50, 30);

        campoMin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(campoMin);
        campoMin.setBounds(220, 180, 60, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 370, 480);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Buscar");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 10, 70, 30);

        campoBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoBuscarFocusLost(evt);
            }
        });
        campoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoBuscarMouseClicked(evt);
            }
        });
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(campoBuscar);
        campoBuscar.setBounds(100, 10, 190, 30);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        tablaTurnos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jTabbedPane1.setBounds(0, 60, 630, 410);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(380, 0, 640, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    			
    private void tablaTurnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTurnosMouseClicked
        habilitar();
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
        habilitar();
    	int fila2= tablaPacientes.getSelectedRow();
        if(fila2>=0){
        campoCel.setText(tablaPacientes.getValueAt(fila2,0).toString());
        campoAp.setText(tablaPacientes.getValueAt(fila2,1).toString());
        campoNom.setText(tablaPacientes.getValueAt(fila2,3).toString());
        }
    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        habilitar();   
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        limpiar();
        deshabilitar();
        cargarTurnos("");
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        limpiar();
        deshabilitar();
        cargarTurnos("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminar();
        limpiar();
        deshabilitar();
        cargarTurnos("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargarTurnos(campoBuscar.getText());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMouseClicked
        diseño.Clic(campoBuscar, mensaje.getApellido());
    }//GEN-LAST:event_campoBuscarMouseClicked

    private void campoBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarFocusLost
        diseño.Mensaje(campoBuscar, mensaje.getApellido(), campoBuscar.getText().trim().length());
    }//GEN-LAST:event_campoBuscarFocusLost

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
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField campoAp;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCel;
    private javax.swing.JTextField campoDire;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoHora;
    private javax.swing.JTextField campoMin;
    private javax.swing.JTextField campoNom;
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

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
}
