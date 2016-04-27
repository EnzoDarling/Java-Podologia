/*
    ************ Flat Icons from http://flaticon.com ****************
 */
package Vistas;
import Conector.Conexion;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo
 */

public class VentanaPacientes extends javax.swing.JFrame {
DefaultTableModel model;
DiseñoLetraFondo diseño;
Mensajeria mensaje;
CustomErrorDialog CustomError;
    /**
     * Creates new form VentanaPacientes2
     */
    public VentanaPacientes() {
        initComponents();
        diseño = new DiseñoLetraFondo();
        mensaje = new Mensajeria();
        CustomError = new CustomErrorDialog();
        setSize(961, 450);
        setIcon();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("PACIENTES");
        cargar("");
        deshabilitar();
        iniciar();
    }
    public void iniciar(){
        diseño.Mensaje(campoBuscar,mensaje.getApellido(), 0);
    }    
    private void cargar(String valor){
        String [] titulos= {"Tel/Cel","Apellido", "Nombre", "Domicilio"};
        String [] registros = new String[5];
        String sql="SELECT * FROM pacientes WHERE pac_ap LIKE '%"+valor+"%' ORDER BY pac_ap ASC";
        model= new DefaultTableModel (null,titulos){
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
        String ape=campoApe.getText();
        String nom= campoNom.getText();
        String tel= campoTel.getText();
        String dom= campoDom.getText();        
        String sql="INSERT INTO pacientes (pac_cel, pac_ap, pac_nom, pac_dom) VALUES(?,?,?,?)";
        if(ape.equals("") || ape==null || nom.equals("") || nom==null || tel.equals("") || tel==null || dom.equals("") || dom==null){
	        JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos y intente nuevamente");
        }else{
        	try {
	            PreparedStatement psd= cn.prepareStatement(sql);
	            psd.setString(1,tel);
	            psd.setString(2,ape);
	            psd.setString(3,nom);
	            psd.setString(4,dom);
	            int n=psd.executeUpdate();            
	            if(n>0){
	                JOptionPane.showMessageDialog(null,"SE HA GUARDADO EL REGISTRO","AVISO",JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (Exception e) {
	        		CustomError.showDialog("<html>Ocurrió un error al guardar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
	        }
        }
        cargar("");
    }
    private void eliminar(){
        Conexion cc= new Conexion();
        Connection cn=cc.conexion();
        String cel= campoTel.getText();
        String sql= "DELETE FROM pacientes WHERE pac_cel=?";
        
        if(cel.equals("") || cel==null){
	        JOptionPane.showMessageDialog(null,"No se ingresó un número de celular, ingrese un número de celular e intente nuevamente");
        }else {
        	int resp;
            resp=JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE ELIMINAR ESTE REGISTRO?","ALERTA",JOptionPane.YES_NO_OPTION);
        	if(resp== JOptionPane.YES_OPTION){
                try {
                    PreparedStatement psd=cn.prepareStatement(sql);
                    psd.setString(1,cel);
                    int x= psd.executeUpdate();
                    if(x>0){
                        JOptionPane.showMessageDialog(null,"SE HA ELIMNADO EL REGISTRO","AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    CustomError.showDialog("<html>Ocurrió un error en la base de datos al eliminar, contacte al personal adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
                }
            }
        }
        cargar("");
    }
    private void modificar(){
        Conexion cc= new Conexion();
        Connection cn= cc.conexion();
        String cel= campoTel.getText();
        String ap= campoApe.getText();
        String nom= campoNom.getText();
        String dom= campoDom.getText();
        String sql= "UPDATE pacientes SET pac_ap='"+ap+"', pac_nom='"+nom+"', pac_dom='"+dom+"' WHERE pac_cel='"+cel+"'";        
        if(ap.equals("") || ap==null || nom.equals("") || nom==null || cel.equals("") || cel==null || dom.equals("") || dom==null){
	        JOptionPane.showMessageDialog(null,"Existen campos vacíos, debe rellenar para continuar");
        }else{
        	int resp = JOptionPane.showConfirmDialog(null,"¿ESTA SEGURA DE MODIFICAR ESTE REGISTRO?","ALERTA",JOptionPane.YES_NO_OPTION);	
        	if(resp == JOptionPane.YES_OPTION){
                try {
                    PreparedStatement psd= cn.prepareStatement(sql);
                    int x= psd.executeUpdate();
                    if(x==1){
                        JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO");                }   
                } catch (Exception e) {
                    CustomError.showDialog("<html>Ocurrió un error al modificar los datos, contacte al personala adecuado sobre este error</html>", 
                            "<html>'"+e+"'</html>");
                }
            }
        } 
    }
    private void limpiar(){
        campoApe.setText("");
        campoNom.setText("");
        campoTel.setText("");
        campoDom.setText("");
    }
    private void habilitar(){
    	campoApe.setEnabled(true);
        campoNom.setEnabled(true);
        campoTel.setEnabled(true);
        campoDom.setEnabled(true);
    }
    private void habilitarbotones(){
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
    }
    private void deshabilitarbotones(){
    btnBorrar.setEnabled(false);
    btnModificar.setEnabled(false);
    btnGuardar.setEnabled(false);
    }
    private void deshabilitar(){
    	campoApe.setEnabled(false);
        campoNom.setEnabled(false);
        campoTel.setEnabled(false);
        campoDom.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        labelBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        labelDomicilio = new javax.swing.JLabel();
        campoNom = new javax.swing.JTextField();
        campoApe = new javax.swing.JTextField();
        campoTel = new javax.swing.JTextField();
        campoDom = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

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
        campoBuscar.setBounds(110, 10, 220, 30);

        labelBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelBuscar.setText("Buscar");
        jPanel2.add(labelBuscar);
        labelBuscar.setBounds(14, 14, 60, 30);

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

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 500, 350);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(430, 0, 520, 410);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNombre.setText("Nombre");
        jPanel1.add(labelNombre);
        labelNombre.setBounds(20, 140, 90, 30);

        labelApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelApellido.setText("Apellido");
        jPanel1.add(labelApellido);
        labelApellido.setBounds(20, 80, 90, 30);

        labelTel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTel.setText("Tel/Cel");
        jPanel1.add(labelTel);
        labelTel.setBounds(20, 20, 70, 30);

        labelDomicilio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDomicilio.setText("Domicilio");
        jPanel1.add(labelDomicilio);
        labelDomicilio.setBounds(20, 200, 100, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoNom);
        campoNom.setBounds(130, 140, 190, 30);

        campoApe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoApe);
        campoApe.setBounds(130, 80, 190, 30);

        campoTel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoTel);
        campoTel.setBounds(130, 20, 190, 30);

        campoDom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoDom);
        campoDom.setBounds(130, 200, 190, 30);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tick.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(10, 350, 160, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar);
        btnBorrar.setBounds(240, 350, 170, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar);
        btnModificar.setBounds(240, 280, 170, 40);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(10, 280, 160, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
	private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLimpiarActionPerformed
        limpiar();
        habilitar();
    }//GEN-LAST:event_campoLimpiarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        limpiar();
        deshabilitar();
        cargar("");
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        limpiar();
        deshabilitar();
        cargar("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminar();
        limpiar();
        deshabilitar();
        cargar("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked
        habilitar();
    	int fila=tablaPacientes.getSelectedRow();
        if(fila>=0){
            campoTel.setText(tablaPacientes.getValueAt(fila,0).toString());
            campoApe.setText(tablaPacientes.getValueAt(fila,1).toString());
            campoNom.setText(tablaPacientes.getValueAt(fila,2).toString());
            campoDom.setText(tablaPacientes.getValueAt(fila,3).toString());
        }else{
        	JOptionPane.showMessageDialog(null,"No se seleccionó ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargar(campoBuscar.getText());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarFocusLost
        diseño.Mensaje(campoBuscar, mensaje.getApellido(), campoBuscar.getText().trim().length());
    }//GEN-LAST:event_campoBuscarFocusLost

    private void campoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMouseClicked
        diseño.Clic(campoBuscar, mensaje.getApellido());
    }//GEN-LAST:event_campoBuscarMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField campoApe;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoDom;
    private javax.swing.JTextField campoNom;
    private javax.swing.JTextField campoTel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JLabel labelDomicilio;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTel;
    private javax.swing.JTable tablaPacientes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
}
