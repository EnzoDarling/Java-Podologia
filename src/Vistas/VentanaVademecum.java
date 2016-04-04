/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.event.ActionEvent;
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
    public VentanaVademecum() {
        initComponents();
        setSize(1050, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("VADEMECUM");
        cargar("");
        labelCod.setVisible(false);
        campoCod.setVisible(false);
    }
    private void cargar(String valor){
    	String [] titulos= {"C�digo","Nombre","Posolog�a","Indicaciones"};    	
    	String [] registros= new String [4];
    	String sql="SELECT * FROM vademecum WHERE vad_nom LIKE '%"+valor+"%' ORDER BY vad_nom ASC" ;
    	model= new DefaultTableModel (null, titulos);
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
			JOptionPane.showMessageDialog(null,"ERROR :" +e, "ALERTA", JOptionPane.ERROR_MESSAGE);
		}
    }
    private void guardar(){
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String nom= campoNom.getText();
    	String poso= comboPoso.getSelectedItem().toString();
    	String indica= areaIndi.getText();
    	String sql="INSERT INTO vademecum (vad_nom, vad_ind, vad_poso) VALUES (?,?,?)";
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
			JOptionPane.showMessageDialog(null,"ERROR: "+e,"ALERTA", JOptionPane.ERROR_MESSAGE);
		}
    }
    private void modificar(){
	    Conexion cc= new Conexion();
	    Connection cn=cc.conexion();
	    String nom= campoNom.getText();
	    String indi=areaIndi.getText();
	    String poso= comboPoso.getSelectedItem().toString();
	    String sql="UPDATE vademecum SET vade_nom='"+nom+"', vade_ind='"+indi+"', vade_poso='"+poso+"' WHERE vad_cod";
	    int resp;
	    resp= JOptionPane.showConfirmDialog(null,"¿ESTÁ SEGURA DE MODIFICAR ESTE REGISTRO?","AVISO",JOptionPane.YES_NO_OPTION);
	    if(resp == JOptionPane.YES_OPTION){
	    	try {
				PreparedStatement psd= cn.prepareStatement(sql);
				int x= psd.executeUpdate();
				if(x==1){
					JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO","AVISO",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"ERROR :" +e, "ALERTA", JOptionPane.ERROR_MESSAGE);
			}
	    }
    }
    private void eliminar(){
    	Conexion cc= new Conexion();
    	Connection cn= cc.conexion();
    	String cod= campoCod.getText();
    	String sql="DELETE FROM vademecum WHERE vad_cod=?";
    	int resp;
    	resp=JOptionPane.showConfirmDialog(null,"�EST� SEGURA DE ELIMINAR EL REGISTRO?","PREGUNTA", JOptionPane.YES_NO_OPTION);
    	if(resp == JOptionPane.YES_OPTION){
    		try {
				PreparedStatement psd= cn.prepareStatement(sql);
				psd.setString(1,cod);
				int x= psd.executeUpdate();
				if(x>0){
					JOptionPane.showMessageDialog(null,"SE HA ELIMINADO EL REGISTRO","AVISO",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR :"+e, "ALERTA",JOptionPane.ERROR_MESSAGE);
			}
    	}
    }
    private void limpiar(){
    	campoNom.setText("");
    	areaIndi.setText("");
    	comboPoso.setSelectedIndex(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelPoso = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelIndi = new javax.swing.JLabel();
        labelCod = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaIndi = new javax.swing.JTextArea();
        comboPoso = new javax.swing.JComboBox<>();
        campoNom = new javax.swing.JTextField();
        campoCod = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelBuscar = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVade = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelPoso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPoso.setText("Posolog�a");
        jPanel1.add(labelPoso);
        labelPoso.setBounds(20, 92, 80, 21);
        
        labelCod.setFont(new java.awt.Font("Tahoma", 0, 18));
        labelCod.setText("Codigo");
        jPanel1.add(labelCod);
        labelCod.setBounds(20,5,70,21);

        labelNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNom.setText("Nombre");
        jPanel1.add(labelNom);
        labelNom.setBounds(20, 40, 70, 21);

        labelIndi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelIndi.setText("Indicaciones");
        jPanel1.add(labelIndi);
        labelIndi.setBounds(20, 140, 100, 21);
        
        areaIndi.setFont(new java.awt.Font("Tahoma", 0, 18));
        areaIndi.setColumns(30);
        areaIndi.setRows(10);
        jScrollPane1.setViewportView(areaIndi);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 180, 380, 350);

        comboPoso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboPoso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 vez al d�a", "2 veces al d�a", "3 veces al d�a", "cada 24 hs", "1 vez por semana" }));
        jPanel1.add(comboPoso);
        comboPoso.setBounds(130, 92, 140, 30);
        
        campoCod.setFont(new java.awt.Font("Tahoma", 0 , 18));
        jPanel1.add(campoCod);
        campoCod.setBounds(130,5, 140,30);
        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoNom);
        campoNom.setBounds(130, 40, 140, 30);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatdelete.png")));
        btnEliminar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnEliminarActionPerformed(evt);
        	}
        });
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar);
        btnEliminar.setBounds(240, 540, 150, 40);
        
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/broom.png")));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        	btnLimpiarActionPerformed(evt);	
        	}
        });
        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar);
        btnLimpiar.setBounds(20, 590, 130, 40);
        

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatsave.png")));
        btnGuardar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnGuardarActionPerformed(evt);
        	}
        });
        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(20, 540, 130, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flatedit.png")));
        btnModificar.addActionListener(new java.awt.event.ActionListener(){
        	public void actionPerformed(java.awt.event.ActionEvent evt){
        		btnModificarActionPerformed(evt);
        	}
        });
        btnModificar.setText("Modificar");
        jPanel1.add(btnModificar);
        btnModificar.setBounds(240, 590, 150, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(5, 10, 470, 660);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        labelBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBuscar.setText("Buscar");
        jPanel2.add(labelBuscar);
        labelBuscar.setBounds(10, 10, 70, 30);
        jPanel2.add(campoBuscar);
        campoBuscar.setBounds(100, 10, 180, 30);
        campoBuscar.addKeyListener(new java.awt.event.KeyAdapter(){
        	public void keyReleased(java.awt.event.KeyEvent evt){
        		campoBuscarKeyReleased(evt);
        	}
        });

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
        tablaVade.addMouseListener(new java.awt.event.MouseAdapter(){
        	public void mouseClicked(java.awt.event.MouseEvent evt){
        		tablaPacientesMouseClicked(evt);
        	}
        });
        jScrollPane2.setViewportView(tablaVade);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 60, 530, 530);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(480, 10, 550, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void campoBuscarKeyReleased(KeyEvent evt) {
		cargar(campoBuscar.getText());
	}
	protected void btnModificarActionPerformed(ActionEvent evt) {
		modificar();
	}
    protected void btnGuardarActionPerformed(ActionEvent evt) {
    	guardar();
	}
	protected void btnLimpiarActionPerformed(ActionEvent evt) {
		limpiar();
	}
	protected void btnEliminarActionPerformed(ActionEvent evt) {
		eliminar();
	}
	protected void tablaPacientesMouseClicked(MouseEvent evt) {
		labelCod.setVisible(true);
		campoCod.setVisible(true);
    	int fila= tablaVade.getSelectedRow();
		if(fila>=0){
			campoCod.setText(tablaVade.getValueAt(fila, 0).toString());
			campoNom.setText(tablaVade.getValueAt(fila,1).toString());
			comboPoso.setSelectedItem(tablaVade.getValueAt(fila, 2).toString());
			areaIndi.setText(tablaVade.getValueAt(fila, 3).toString());
			
		}
	}
	
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
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCod;
    private javax.swing.JTextField campoNom;
    private javax.swing.JComboBox<String> comboPoso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCod;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelIndi;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelPoso;
    private javax.swing.JTable tablaVade;
    // End of variables declaration//GEN-END:variables
}
