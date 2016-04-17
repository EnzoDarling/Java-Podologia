/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

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

import Conector.Conexion;


public class VentanaVademecum extends javax.swing.JFrame {
	DefaultTableModel model;
	DiseñoLetraFondo diseño;
	Mensajeria mensaje;
        CustomErrorDialog CustomError;
    public VentanaVademecum() {
        initComponents();
        diseño = new DiseñoLetraFondo();
        mensaje = new Mensajeria();
        CustomError = new CustomErrorDialog();
        setSize(977, 548);
        setIcon();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("VADEMECUM");
        cargar("");
        iniciar();
        deshabilitar();
        labelCod.setVisible(false);
        campoCod.setVisible(false);
    }
    private void setIcon() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));		
	}
    public void iniciar(){
        diseño.Mensaje(campoBuscar,mensaje.getNombre(), 0);
    }  
    private void cargar(String valor){
    	String [] titulos= {"Código","Nombre","Posología","Indicaciones"};    	
    	String [] registros= new String [4];
    	String sql="SELECT * FROM vademecum WHERE vad_nom LIKE '%"+valor+"%' ORDER BY vad_nom ASC" ;
    	model= new DefaultTableModel (null, titulos){
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
                    registros[0]=rs.getString("vad_cod");
                    registros[1]=rs.getString("vad_nom");
                    registros[2]=rs.getString("vad_poso");
                    registros[3]=rs.getString("vad_ind");
                    model.addRow(registros);
            }
            tablaVade.setModel(model);
        } catch (Exception e) {
                CustomError.showDialog("<html>Ocurrió un error al cargar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
        }
    }
    private void guardar(){
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String nom= campoNom.getText();
    	String poso= comboPoso.getSelectedItem().toString();
    	String indica= areaIndi.getText();
    	String sql="INSERT INTO vademecum (vad_nom, vad_ind, vad_poso) VALUES (?,?,?)";
        if(nom.equals("") || nom==null || poso.equals("") || poso==null || indica.equals("") || indica==null){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                PreparedStatement psd= cn.prepareStatement(sql);
                psd.setString(1,nom);
                psd.setString(2,indica);
                psd.setString(3,poso);
                int n= psd.executeUpdate();
                if(n>0){
                        JOptionPane.showMessageDialog(null,"SE HA GUARDADO EL REGISTRO","AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                    CustomError.showDialog("<html>Ocurrió un error al guardar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
            }
        }
    }
    private void modificar(){
        Conexion cc= new Conexion();
        Connection cn=cc.conexion();
        String nom= campoNom.getText();
        String indi= areaIndi.getText();
        String poso= comboPoso.getSelectedItem().toString();
        String cod = campoCod.getText();
        Integer codint= Integer.parseInt(cod);
        String sql="UPDATE vademecum SET vad_nom='"+nom+"', vad_ind='"+indi+"', vad_poso='"+poso+"' WHERE vad_cod='"+codint+"'";
        if(nom.equals("") || nom==null || poso.equals("Seleccione") || poso==null || indi.equals("") || indi==null){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            int resp;
            resp= JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE MODIFICAR ESTE REGISTRO?","AVISO",JOptionPane.YES_NO_OPTION);
            if(resp == JOptionPane.YES_OPTION){
                try {
                    PreparedStatement psd= cn.prepareStatement(sql);
                    int x= psd.executeUpdate();
                    if(x==1){
                            JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                                CustomError.showDialog("<html>Ocurrió un error al modificar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
                }
            }
        }
    }
    private void eliminar(){
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String cod= campoCod.getText();
        Integer codint = Integer.parseInt(cod);
    	String sql="DELETE FROM vademecum WHERE vad_cod=?";
    	int resp;
    	resp=JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE ELIMINAR EL REGISTRO?","PREGUNTA", JOptionPane.YES_NO_OPTION);    	
        if(cod.equals("") || cod==null){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            if(resp == JOptionPane.YES_OPTION){
                try {
                    PreparedStatement psd= cn.prepareStatement(sql);
                    psd.setInt(1,codint);
                    int x= psd.executeUpdate();
                    if(x>0){
                            JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL REGISTRO","AVISO",JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                        CustomError.showDialog("<html>Ocurrió un error al eliminar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
                }
            }
        }
    }
    private void limpiar(){
        campoCod.setText("");
    	campoNom.setText("");
    	areaIndi.setText("");
    	comboPoso.setSelectedIndex(0);
    }
    private void habilitar(){
        campoNom.setEnabled(true);
    	areaIndi.setEnabled(true);
    	comboPoso.setEnabled(true);
    }
    private void deshabilitar(){
        campoNom.setEnabled(false);
    	areaIndi.setEnabled(false);
    	comboPoso.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelPoso = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelIndi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaIndi = new javax.swing.JTextArea();
        comboPoso = new javax.swing.JComboBox<>();
        campoNom = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        labelCod = new javax.swing.JLabel();
        campoCod = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVade = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelPoso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPoso.setText("Posología");
        jPanel1.add(labelPoso);
        labelPoso.setBounds(10, 120, 80, 22);

        labelNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNom.setText("Nombre");
        jPanel1.add(labelNom);
        labelNom.setBounds(10, 60, 70, 22);

        labelIndi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelIndi.setText("Indicaciones");
        jPanel1.add(labelIndi);
        labelIndi.setBounds(10, 160, 100, 22);

        areaIndi.setColumns(20);
        areaIndi.setRows(5);
        jScrollPane1.setViewportView(areaIndi);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 380, 200);

        comboPoso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboPoso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1 vez al día", "2 veces al día", "3 veces al día", "cada 24 hs", "1 vez por semana" }));
        jPanel1.add(comboPoso);
        comboPoso.setBounds(120, 120, 170, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoNom);
        campoNom.setBounds(120, 60, 140, 30);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(220, 470, 160, 40);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tick.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(220, 410, 160, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(10, 470, 170, 40);

        labelCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCod.setText("Codigo");
        jPanel1.add(labelCod);
        labelCod.setBounds(10, 10, 70, 22);

        campoCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoCod);
        campoCod.setBounds(120, 10, 140, 30);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(10, 410, 170, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 520);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        labelBuscar.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        labelBuscar.setText("Buscar");
        jPanel2.add(labelBuscar);
        labelBuscar.setBounds(10, 10, 70, 30);

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
        jPanel2.add(campoBuscar);
        campoBuscar.setBounds(100, 10, 180, 30);

        tablaVade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaVade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaVade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaVade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVadeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaVade);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 530, 450);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(410, 0, 550, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargar(campoBuscar.getText());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarFocusLost
        diseño.Mensaje(campoBuscar, mensaje.getNombre(), campoBuscar.getText().trim().length());
    }//GEN-LAST:event_campoBuscarFocusLost

    private void campoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMouseClicked
        diseño.Clic(campoBuscar, mensaje.getNombre());
    }//GEN-LAST:event_campoBuscarMouseClicked

    private void tablaVadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVadeMouseClicked
        labelCod.setVisible(true);
        campoCod.setVisible(true);
        habilitar();
        int fila= tablaVade.getSelectedRow();
        if(fila>=0){
            campoCod.setText(tablaVade.getValueAt(fila, 0).toString());
            campoNom.setText(tablaVade.getValueAt(fila,1).toString());
            comboPoso.setSelectedItem(tablaVade.getValueAt(fila, 2).toString());
            areaIndi.setText(tablaVade.getValueAt(fila, 3).toString());

        }
    }//GEN-LAST:event_tablaVadeMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        limpiar();
        deshabilitar();
        cargar("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        limpiar();
        deshabilitar();
        cargar("");
        campoCod.setVisible(false);
        labelCod.setVisible(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       eliminar();
       limpiar();
       deshabilitar();
       cargar("");
       campoCod.setVisible(false);
       labelCod.setVisible(false);
    }//GEN-LAST:event_btnEliminarActionPerformed
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
            java.util.logging.Logger.getLogger(VentanaVademecum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVademecum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVademecum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVademecum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVademecum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaIndi;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCod;
    private javax.swing.JTextField campoNom;
    private javax.swing.JComboBox<String> comboPoso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelCod;
    private javax.swing.JLabel labelIndi;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPoso;
    private javax.swing.JTable tablaVade;
    // End of variables declaration//GEN-END:variables
}
