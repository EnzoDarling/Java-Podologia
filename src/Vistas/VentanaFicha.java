package Vistas;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Conector.Conexion;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class VentanaFicha extends javax.swing.JFrame {

    CustomErrorDialog CustomError;
    DefaultTableModel model;
    DefaultTableModel model2;
    DiseñoLetraFondo diseño = new DiseñoLetraFondo();    
    Mensajeria mensaje = new Mensajeria();
    Integer convCod=0;
    public VentanaFicha() {        
        CustomError = new CustomErrorDialog();
        initComponents();
        setSize(941, 520);
        setIcon();
        setTitle("FICHAS MÉDICAS");
        setLocationRelativeTo(null);
        setResizable(false);
        deshabilitar();
        campoCod.setVisible(false);
        etiqCod.setVisible(false);
        iniciar();
        cargar("");
        cargarPacientes("");
        deshabilitarbotones();
    }
    private void iniciar() {
       diseño.Mensaje(campoBuscar,mensaje.getApellido(), 0);
       diseño.Mensaje(campoBuscarPacientes,mensaje.getApellido(), 0);
    }
    private void cargar(String valor){
        String [] titulos={"Codigo","Apellido","Nombre","Dire","Anticuagulado",
            "DBT","Af.Cardiacas","Micosis"};
        String [] titulos2 = {"Onicocriptosis","T.Agrietado","Hiperqueratosis",
            "Hiperhidrosis","Edema","D.Clinicos","Otras Pat.","Tratamiento","Evolucion"};
        String [] registros= new String[8];
        String [] registros2= new String[10];
        String sql="SELECT * FROM fichasmedicas WHERE fich_ap LIKE '%"+valor+"%' ORDER BY fich_ap ASC";
        model= new DefaultTableModel(null,titulos){
    	    @Override
    	    public boolean isCellEditable(int row, int column) {
    	       //all cells false
    	       return false;
    	    }
    	};
        model2 = new DefaultTableModel(null, titulos2){
            @Override
            public boolean isCellEditable(int row, int column){
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
                registros[4]=rs.getString("fich_anticua");
                registros[5]=rs.getString("fich_dbt");
                registros[6]=rs.getString("fich_afcard");
                registros[7]=rs.getString("fich_micosis");
                model.addRow(registros);
                /*CARGA DE REGISTROS PARA LA SEGUNDA TABLA DE FICHAS*/
                registros2[0]=rs.getString("fich_onicocri");
                registros2[1]=rs.getString("fich_talonagri");
                registros2[2]=rs.getString("fich_hiperquera");
                registros2[3]=rs.getString("fich_hiperhidro");
                registros2[4]=rs.getString("fich_edema");
                registros2[5]=rs.getString("fich_datoscli");
                registros2[6]=rs.getString("fich_otraspato");
                registros2[7]=rs.getString("fich_tratam");
                registros2[8]=rs.getString("fich_evolucion");
                model2.addRow(registros2);
            }
            tablaFichaMedica.setModel(model);
            tablaFichaMedica2.setModel(model2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR :"+e,"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarPacientes(String valor){
        String [] titulos= {"Tel/Cel","Apellido", "Nombre", "Domicilio"};
        String [] registros = new String[4];
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
    private void guardar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String ape = campoApe.getText();
        String nom = campoNom.getText();
        String dire = campoDire.getText();
        String anticua = comboAnticuagulado.getSelectedItem().toString();
        String dbt = comboDbt.getSelectedItem().toString();
        String afcard = comboCardiacas.getSelectedItem().toString();
        String micosis = comboMicosis.getSelectedItem().toString();
        String onicocri = comboOnicocriptosis.getSelectedItem().toString();
        String talonagri = comboTalon.getSelectedItem().toString();
        String hiperquera = comboHiperqueratosis.getSelectedItem().toString();
        String hiperhidro = comboHiperhidrosis.getSelectedItem().toString();
        String edema = comboEdema.getSelectedItem().toString();
        String datoscli = areaDClinicos.getText();
        String otraspato = areaPatologias.getText();
        String tratam = areaTratamiento.getText();
        String evol = areaEvolucion.getText();
        String sql = "INSERT INTO fichasmedicas (fich_ap, fich_nom, fich_dire,"
                + " fich_anticua, fich_dbt, fich_afcard, fich_micosis,"
                + " fich_onicocri, fich_talonagri, fich_hiperquera, fich_hiperhidro,"
                + " fich_edema, fich_datoscli, fich_otraspato, fich_tratam, fich_evolucion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if (campoApe.equals("") || campoApe == null || campoNom.equals("") || campoNom == null || campoDire.equals("") || 
                campoDire == null ||  comboAnticuagulado.equals("Seleccione") 
                || comboAnticuagulado == null || comboDbt.equals("Seleccione") || comboDbt == null || comboCardiacas.equals("Seleccione")
                || comboCardiacas == null || comboMicosis.equals("Seleccione") || comboMicosis == null || 
                comboOnicocriptosis.equals("Seleccione") || comboOnicocriptosis == null || comboTalon.equals("Seleccione")
                || comboTalon == null || comboHiperqueratosis.equals("Seleccione") || comboHiperqueratosis == null 
                || comboHiperhidrosis.equals("Seleccione") || comboHiperhidrosis == null || comboEdema.equals("Seleccione") 
                || comboEdema == null || areaDClinicos.equals("") || areaDClinicos == null || areaPatologias.equals("") 
                || areaPatologias == null || areaTratamiento.equals("") || areaTratamiento == null || areaEvolucion.equals("")
                || areaEvolucion == null) {
            JOptionPane.showMessageDialog(null, "Existen campos vacíos, rellene los campos e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, ape);
                psd.setString(2, nom);
                psd.setString(3, dire);
                psd.setString(4, anticua);
                psd.setString(5, dbt);
                psd.setString(6, afcard);
                psd.setString(7, micosis);
                psd.setString(8, onicocri);
                psd.setString(9, talonagri);
                psd.setString(10, hiperquera);
                psd.setString(11, hiperhidro);
                psd.setString(12, edema);
                psd.setString(13, datoscli);
                psd.setString(14, otraspato);
                psd.setString(15, tratam);
                psd.setString(16, evol);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL REGISTRO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                CustomError.showDialog("<html>Ocurrió un error al guardar, contacte al personal adecuado sobre este error</html>",
                        "<html>'" + e + "'</html>");
            }
        }
    }

    private void modificar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String cod =campoCod.getText();
        String ape = campoApe.getText();
        String nom = campoNom.getText();
        String dire = campoDire.getText();
        String anticua = comboAnticuagulado.getSelectedItem().toString();
        String dbt = comboDbt.getSelectedItem().toString();
        String afcard = comboCardiacas.getSelectedItem().toString();
        String micosis = comboMicosis.getSelectedItem().toString();
        String onicocri = comboOnicocriptosis.getSelectedItem().toString();
        String talonagri = comboTalon.getSelectedItem().toString();
        String hiperquera = comboHiperqueratosis.getSelectedItem().toString();
        String hiperhidro = comboHiperhidrosis.getSelectedItem().toString();
        String edema = comboEdema.getSelectedItem().toString();
        String datoscli = areaDClinicos.getText();
        String otraspato = areaPatologias.getText();
        String tratam = areaTratamiento.getText();
        String evol = areaEvolucion.getText();
        convCod= Integer.parseInt(cod);
        String sql = "UPDATE fichasmedicas SET fich_ap='" + ape + "',fich_nom='" + nom + "',fich_dire='" + dire + "', fich_anticua='" + anticua + "', fich_dbt='" + dbt + "', fich_afcard='" + afcard + "', fich_micosis='" + micosis + "',"
                + " fich_onicocri='" + onicocri + "', fich_talonagri='" + talonagri + "', fich_hiperquera='" + hiperquera + "', fich_hiperhidro='" + hiperhidro + "',"
                + " fich_edema='" + edema + "', fich_datoscli='" + datoscli + "', fich_otraspato='" + otraspato + "', fich_tratam='" + tratam + "', fich_evolucion='" + evol + "' WHERE fich_cod='"+convCod+"'";
        if (campoApe.equals("") || campoApe == null || campoNom.equals("") || campoNom == null || campoDire.equals("") || campoDire == null || comboAnticuagulado.equals("Seleccione") || comboAnticuagulado == null || comboDbt.equals("Seleccione") || comboDbt == null || comboCardiacas.equals("Seleccione")
                || comboCardiacas == null || comboMicosis.equals("Seleccione") || comboMicosis == null || comboOnicocriptosis.equals("Seleccione") || comboOnicocriptosis == null || comboTalon.equals("Seleccione")
                || comboTalon == null || comboHiperqueratosis.equals("Seleccione") || comboHiperqueratosis == null || comboHiperhidrosis.equals("Seleccione") || comboHiperhidrosis == null || comboEdema.equals("Seleccione") || comboEdema == null
                || areaDClinicos.equals("") || areaDClinicos == null || areaPatologias.equals("") || areaPatologias == null || areaTratamiento.equals("") || areaTratamiento == null || areaEvolucion.equals("")
                || areaEvolucion == null) {
            JOptionPane.showMessageDialog(null, "Existen campos vacíos, rellene los campos e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int resp;
            resp = JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURA DE MODIFICAR EL REGISTRO?", "AVISO", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    PreparedStatement psd = cn.prepareStatement(sql);
                    int x = psd.executeUpdate();
                    if (x == 1) {
                        JOptionPane.showMessageDialog(null, "SE HA MODIFICADO EL REGISTRO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    CustomError.showDialog("<html>Ocurrió un error al modificar, contacte al personal adecuado sobre este error</html>",
                            "<html>'" + e + "'</html>");
                }
            }
        }
    }

    private void eliminar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String cod = campoCod.getText();
        convCod= Integer.parseInt(cod);
        String sql = "DELETE FROM fichasmedicas WHERE fich_cod=?";
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURA DE ELIMINAR EL REGISTRO?", "AVISO", JOptionPane.YES_NO_OPTION);
        if (cod.equals("") || cod == null) {
            JOptionPane.showMessageDialog(null, "No ha ingresado un código de ficha médica, ingrese un código de ficha médica e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (resp == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setInt(1,convCod);
                int x = psd.executeUpdate();
                if (x > 0) {
                    JOptionPane.showMessageDialog(null, "EL REGISTRO SE HA ELIMINADO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                CustomError.showDialog("<html>Ocurrió un error al cargar, contacte al personal adecuado sobre este error</html>",
                        "<html>'" + e + "'</html>");
            }
        }
    }

    private void limpiar() {        
        campoApe.setText("");
        campoNom.setText("");
        campoDire.setText("");
        comboAnticuagulado.setSelectedIndex(0);
        comboDbt.setSelectedIndex(0);
        comboCardiacas.setSelectedIndex(0);
        comboMicosis.setSelectedIndex(0);
        comboOnicocriptosis.setSelectedIndex(0);
        comboTalon.setSelectedIndex(0);
        comboHiperqueratosis.setSelectedIndex(0);
        comboHiperhidrosis.setSelectedIndex(0);
        comboEdema.setSelectedIndex(0);
        areaDClinicos.setText("");
        areaPatologias.setText("");
        areaTratamiento.setText("");
        areaEvolucion.setText("");
        campoCod.setText("");
    }

    private void deshabilitar() {
        campoCod.setVisible(false);
        etiqCod.setVisible(false);
        campoApe.setEnabled(false);
        campoNom.setEnabled(false);
        campoDire.setEnabled(false);
        comboAnticuagulado.setEnabled(false);
        comboDbt.setEnabled(false);
        comboCardiacas.setEnabled(false);
        comboMicosis.setEnabled(false);
        comboOnicocriptosis.setEnabled(false);
        comboTalon.setEnabled(false);
        comboHiperqueratosis.setEnabled(false);
        comboHiperhidrosis.setEnabled(false);
        comboEdema.setEnabled(false);
        areaDClinicos.setEnabled(false);
        areaPatologias.setEnabled(false);
        areaTratamiento.setEnabled(false);
        areaEvolucion.setEnabled(false);
    }

    private void habilitar() {      
        campoApe.setEnabled(true);
        campoNom.setEnabled(true);
        campoDire.setEnabled(true);
        comboAnticuagulado.setEnabled(true);
        comboDbt.setEnabled(true);
        comboCardiacas.setEnabled(true);
        comboMicosis.setEnabled(true);
        comboOnicocriptosis.setEnabled(true);
        comboTalon.setEnabled(true);
        comboHiperqueratosis.setEnabled(true);
        comboHiperhidrosis.setEnabled(true);
        comboEdema.setEnabled(true);
        areaDClinicos.setEnabled(true);
        areaPatologias.setEnabled(true);
        areaTratamiento.setEnabled(true);
        areaEvolucion.setEnabled(true);
    }

    private void habilitarbotones(){
    btnGuardar.setEnabled(true);
    btnModificar.setEnabled(true);
    btnBorrar.setEnabled(true);
    }
    private void deshabilitarbotones(){
    btnModificar.setEnabled(false);
    btnGuardar.setEnabled(false);
    btnBorrar.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelApe = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelDire = new javax.swing.JLabel();
        labelDbt = new javax.swing.JLabel();
        campoApe = new javax.swing.JTextField();
        campoNom = new javax.swing.JTextField();
        campoDire = new javax.swing.JTextField();
        comboHiperhidrosis = new javax.swing.JComboBox<>();
        labelCardiacas = new javax.swing.JLabel();
        labelAnticuagulado = new javax.swing.JLabel();
        comboTalon = new javax.swing.JComboBox<>();
        comboCardiacas = new javax.swing.JComboBox<>();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        etiqCod = new javax.swing.JLabel();
        campoCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDClinicos = new javax.swing.JTextArea();
        labelDClinicos = new javax.swing.JLabel();
        labelPatologias = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaPatologias = new javax.swing.JTextArea();
        labelTratamiento = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaTratamiento = new javax.swing.JTextArea();
        labelEvolucion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaEvolucion = new javax.swing.JTextArea();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        campoBuscarPacientes = new javax.swing.JTextField();
        labelBuscarPacientes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        campoBuscar = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaFichaMedica = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaFichaMedica2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelApe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelApe.setText("Apellido");
        jPanel1.add(labelApe);
        labelApe.setBounds(320, 20, 80, 22);

        labelNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNom.setText("Nombre");
        jPanel1.add(labelNom);
        labelNom.setBounds(630, 20, 80, 22);

        labelDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDire.setText("Dirección");
        jPanel1.add(labelDire);
        labelDire.setBounds(10, 90, 100, 22);

        labelDbt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDbt.setText("DBT");
        jPanel1.add(labelDbt);
        labelDbt.setBounds(650, 190, 50, 22);

        campoApe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoApe);
        campoApe.setBounds(440, 20, 130, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoNom);
        campoNom.setBounds(760, 20, 140, 30);

        campoDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoDire);
        campoDire.setBounds(130, 90, 130, 30);

        comboHiperhidrosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboHiperhidrosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboHiperhidrosis);
        comboHiperhidrosis.setBounds(460, 90, 140, 30);

        labelCardiacas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCardiacas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardiacas.setText("Afecciones");
        labelCardiacas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelCardiacas);
        labelCardiacas.setBounds(10, 370, 100, 30);

        labelAnticuagulado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAnticuagulado.setText("Anticuagulado");
        jPanel1.add(labelAnticuagulado);
        labelAnticuagulado.setBounds(290, 190, 140, 22);

        comboTalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboTalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboTalon);
        comboTalon.setBounds(770, 280, 140, 30);

        comboCardiacas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboCardiacas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboCardiacas);
        comboCardiacas.setBounds(140, 380, 140, 30);

        labelMicosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMicosis.setText("Micosis");
        jPanel1.add(labelMicosis);
        labelMicosis.setBounds(10, 190, 80, 22);

        comboMicosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboMicosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Inter Digital", "Ungueal", "Plantar" }));
        jPanel1.add(comboMicosis);
        comboMicosis.setBounds(110, 190, 140, 30);

        labelOnicocriptosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelOnicocriptosis.setText("Onicocriptosis");
        jPanel1.add(labelOnicocriptosis);
        labelOnicocriptosis.setBounds(10, 290, 130, 22);

        comboAnticuagulado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboAnticuagulado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboAnticuagulado);
        comboAnticuagulado.setBounds(440, 190, 150, 30);

        labelTalon1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTalon1.setText("Talón Agrietado");
        jPanel1.add(labelTalon1);
        labelTalon1.setBounds(610, 280, 150, 22);

        comboDbt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboDbt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboDbt);
        comboDbt.setBounds(770, 190, 140, 30);

        labelHiperquratosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHiperquratosis.setText("Hiperqueratosis");
        jPanel1.add(labelHiperquratosis);
        labelHiperquratosis.setBounds(620, 90, 150, 22);

        comboHiperqueratosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboHiperqueratosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Lateral", "Superior", "Metatarsal" }));
        jPanel1.add(comboHiperqueratosis);
        comboHiperqueratosis.setBounds(770, 90, 140, 30);

        labelHiperhidrosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHiperhidrosis.setText("HiperHidrosis");
        jPanel1.add(labelHiperhidrosis);
        labelHiperhidrosis.setBounds(310, 90, 130, 22);

        comboEdema.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboEdema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboEdema);
        comboEdema.setBounds(440, 280, 150, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Edema");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(350, 280, 60, 22);

        comboOnicocriptosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboOnicocriptosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel1.add(comboOnicocriptosis);
        comboOnicocriptosis.setBounds(150, 290, 140, 30);
        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(-30, -30, 5, 5);

        etiqCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiqCod.setText("Código");
        jPanel1.add(etiqCod);
        etiqCod.setBounds(10, 20, 70, 22);

        campoCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoCod);
        campoCod.setBounds(120, 20, 140, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cardíacas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 400, 100, 30);

        jTabbedPane2.addTab("Formulario Pág. 1", jPanel1);

        jPanel3.setLayout(null);

        areaDClinicos.setColumns(20);
        areaDClinicos.setRows(5);
        jScrollPane1.setViewportView(areaDClinicos);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 390, 160);

        labelDClinicos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDClinicos.setText("Datos Clínicos");
        jPanel3.add(labelDClinicos);
        labelDClinicos.setBounds(20, 10, 130, 22);

        labelPatologias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelPatologias.setText("Otras Patologías");
        jPanel3.add(labelPatologias);
        labelPatologias.setBounds(440, 10, 160, 22);

        areaPatologias.setColumns(20);
        areaPatologias.setRows(5);
        jScrollPane2.setViewportView(areaPatologias);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(430, 40, 450, 160);

        labelTratamiento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTratamiento.setText("Tratamiento");
        jPanel3.add(labelTratamiento);
        labelTratamiento.setBounds(10, 210, 120, 22);

        areaTratamiento.setColumns(20);
        areaTratamiento.setRows(5);
        jScrollPane4.setViewportView(areaTratamiento);

        jPanel3.add(jScrollPane4);
        jScrollPane4.setBounds(10, 240, 390, 160);

        labelEvolucion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelEvolucion.setText("Evolución");
        jPanel3.add(labelEvolucion);
        labelEvolucion.setBounds(430, 210, 90, 22);

        areaEvolucion.setColumns(20);
        areaEvolucion.setRows(5);
        jScrollPane3.setViewportView(areaEvolucion);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(430, 240, 450, 160);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tick.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);
        btnGuardar.setBounds(190, 410, 160, 40);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(10, 410, 140, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar);
        btnModificar.setBounds(400, 410, 170, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrar);
        btnBorrar.setBounds(630, 410, 150, 40);

        jTabbedPane2.addTab("Formulario Pág. 2", jPanel3);

        jPanel4.setLayout(null);

        tablaPacientes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
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
        jScrollPane6.setViewportView(tablaPacientes);

        jPanel4.add(jScrollPane6);
        jScrollPane6.setBounds(10, 62, 910, 390);

        campoBuscarPacientes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoBuscarPacientes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoBuscarPacientesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoBuscarPacientesFocusLost(evt);
            }
        });
        campoBuscarPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoBuscarPacientesMouseClicked(evt);
            }
        });
        campoBuscarPacientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoBuscarPacientesKeyReleased(evt);
            }
        });
        jPanel4.add(campoBuscarPacientes);
        campoBuscarPacientes.setBounds(120, 20, 180, 30);

        labelBuscarPacientes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelBuscarPacientes.setText("Buscar");
        jPanel4.add(labelBuscarPacientes);
        labelBuscarPacientes.setBounds(20, 20, 70, 20);

        jTabbedPane2.addTab("Lista Pacientes", jPanel4);

        jPanel2.setLayout(null);

        labelCodigo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        labelCodigo.setText("Buscar");
        jPanel2.add(labelCodigo);
        labelCodigo.setBounds(20, 20, 70, 24);

        campoBuscar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        campoBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoBuscarFocusGained(evt);
            }
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
        campoBuscar.setBounds(120, 20, 180, 30);

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
        jScrollPane5.setViewportView(tablaFichaMedica);

        jTabbedPane3.addTab("Lista 1", jScrollPane5);

        jScrollPane7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tablaFichaMedica2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tablaFichaMedica2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFichaMedica2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFichaMedica2MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaFichaMedica2);

        jTabbedPane3.addTab("Lista 2", jScrollPane7);

        jPanel2.add(jTabbedPane3);
        jTabbedPane3.setBounds(0, 60, 930, 400);

        jTabbedPane2.addTab("Lista Fichas", jPanel2);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(0, 0, 940, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminar();
        cargar("");
        limpiar();
        deshabilitar();
        campoCod.setVisible(false);
        etiqCod.setVisible(false);
        deshabilitarbotones();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        cargar("");
        limpiar();
        deshabilitar();
        campoCod.setVisible(false);
        etiqCod.setVisible(false);
        deshabilitarbotones();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        cargar("");
        limpiar();
        deshabilitar();
        deshabilitarbotones();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        habilitar();
        campoCod.setVisible(false);
        etiqCod.setVisible(false);
        deshabilitarbotones();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void campoBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarMouseClicked
        diseño.Clic(campoBuscar, mensaje.getApellido());
    }//GEN-LAST:event_campoBuscarMouseClicked

    private void campoBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarFocusLost
        diseño.Mensaje(campoBuscar, mensaje.getApellido(), campoBuscar.getText().trim().length());
    }//GEN-LAST:event_campoBuscarFocusLost

    private void tablaFichaMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFichaMedicaMouseClicked
        campoCod.setVisible(true);
        etiqCod.setVisible(true); 
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        habilitar();
        limpiar();
    	int fila=tablaFichaMedica.getSelectedRow();
    	if(fila>=0){   		
            campoCod.setText(tablaFichaMedica.getValueAt(fila,0).toString());
            campoApe.setText(tablaFichaMedica.getValueAt(fila,1).toString());
            campoNom.setText(tablaFichaMedica.getValueAt(fila,2).toString());
            campoDire.setText(tablaFichaMedica.getValueAt(fila,3).toString());
            comboAnticuagulado.setSelectedItem(tablaFichaMedica.getValueAt(fila,4).toString());
            comboDbt.setSelectedItem(tablaFichaMedica.getValueAt(fila,5).toString());
            comboCardiacas.setSelectedItem(tablaFichaMedica.getValueAt(fila,6).toString());
            comboMicosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,7).toString());
            /*CLICK PARA LA SEGUNDA TABLA*/
            /*comboOnicocriptosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,9).toString());            
            comboTalon.setSelectedItem(tablaFichaMedica.getValueAt(fila,10).toString());
            comboHiperqueratosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,11).toString());
            comboHiperhidrosis.setSelectedItem(tablaFichaMedica.getValueAt(fila,12).toString());
            comboEdema.setSelectedItem(tablaFichaMedica.getValueAt(fila,13).toString());
            areaDClinicos.setText(tablaFichaMedica.getValueAt(fila,14).toString());
            areaPatologias.setText(tablaFichaMedica.getValueAt(fila,15).toString());
            areaTratamiento.setText(tablaFichaMedica.getValueAt(fila,16).toString());
            areaEvolucion.setText(tablaFichaMedica.getValueAt(fila,17).toString());*/
        }
    }//GEN-LAST:event_tablaFichaMedicaMouseClicked

    private void campoBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarFocusGained
        diseño.Mensaje(campoBuscar, mensaje.getApellido(), campoBuscar.getText().trim().length());
    }//GEN-LAST:event_campoBuscarFocusGained

    private void campoBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarKeyReleased
        cargar(campoBuscar.getText());
    }//GEN-LAST:event_campoBuscarKeyReleased

    private void campoBuscarPacientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscarPacientesKeyReleased
        cargarPacientes(campoBuscarPacientes.getText());
    }//GEN-LAST:event_campoBuscarPacientesKeyReleased

    private void campoBuscarPacientesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarPacientesFocusLost
        diseño.Mensaje(campoBuscarPacientes, mensaje.getApellido(), campoBuscarPacientes.getText().trim().length());
    }//GEN-LAST:event_campoBuscarPacientesFocusLost

    private void campoBuscarPacientesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoBuscarPacientesFocusGained
    	diseño.Mensaje(campoBuscarPacientes, mensaje.getApellido(), campoBuscarPacientes.getText().trim().length());
    }//GEN-LAST:event_campoBuscarPacientesFocusGained

    private void campoBuscarPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoBuscarPacientesMouseClicked
    	diseño.Clic(campoBuscarPacientes, mensaje.getApellido());
    }//GEN-LAST:event_campoBuscarPacientesMouseClicked

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked
        habilitar();
        btnGuardar.setEnabled(true);
    	int fila=tablaPacientes.getSelectedRow();
        if(fila>=0){            
            campoApe.setText(tablaPacientes.getValueAt(fila,1).toString());
            campoNom.setText(tablaPacientes.getValueAt(fila,2).toString());
            campoDire.setText(tablaPacientes.getValueAt(fila,3).toString());
        }else{
        	JOptionPane.showMessageDialog(null,"No se seleccionó ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void tablaFichaMedica2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFichaMedica2MouseClicked
       int fila=tablaFichaMedica2.getSelectedRow();
    	if(fila>=0){   		
            /*campoCod.setText(tablaFichaMedica2.getValueAt(fila,0).toString());
            campoApe.setText(tablaFichaMedica2.getValueAt(fila,1).toString());
            campoNom.setText(tablaFichaMedica2.getValueAt(fila,2).toString());
            campoDire.setText(tablaFichaMedica2.getValueAt(fila,3).toString());
            campoEdad.setText(tablaFichaMedica2.getValueAt(fila,4).toString());
            comboAnticuagulado.setSelectedItem(tablaFichaMedica2.getValueAt(fila,5).toString());
            comboDbt.setSelectedItem(tablaFichaMedica2.getValueAt(fila,6).toString());
            comboCardiacas.setSelectedItem(tablaFichaMedica2.getValueAt(fila,7).toString());
            comboMicosis.setSelectedItem(tablaFichaMedica2.getValueAt(fila,8).toString());*/
            /*SEGUNDA TABLA*/
            comboOnicocriptosis.setSelectedItem(tablaFichaMedica2.getValueAt(fila,0).toString());            
            comboTalon.setSelectedItem(tablaFichaMedica2.getValueAt(fila,1).toString());
            comboHiperqueratosis.setSelectedItem(tablaFichaMedica2.getValueAt(fila,2).toString());
            comboHiperhidrosis.setSelectedItem(tablaFichaMedica2.getValueAt(fila,3).toString());
            comboEdema.setSelectedItem(tablaFichaMedica2.getValueAt(fila,4).toString());
            areaDClinicos.setText(tablaFichaMedica2.getValueAt(fila,5).toString());
            areaPatologias.setText(tablaFichaMedica2.getValueAt(fila,6).toString());
            areaTratamiento.setText(tablaFichaMedica2.getValueAt(fila,7).toString());
            areaEvolucion.setText(tablaFichaMedica2.getValueAt(fila,8).toString());
        }
    }//GEN-LAST:event_tablaFichaMedica2MouseClicked

    public static void main(String args[]) {
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
    public javax.swing.JTextArea areaDClinicos;
    public javax.swing.JTextArea areaEvolucion;
    public javax.swing.JTextArea areaPatologias;
    public javax.swing.JTextArea areaTratamiento;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    public javax.swing.JTextField campoApe;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoBuscarPacientes;
    public javax.swing.JTextField campoCod;
    public javax.swing.JTextField campoDire;
    public javax.swing.JTextField campoNom;
    public javax.swing.JComboBox<String> comboAnticuagulado;
    public javax.swing.JComboBox<String> comboCardiacas;
    public javax.swing.JComboBox<String> comboDbt;
    public javax.swing.JComboBox<String> comboEdema;
    public javax.swing.JComboBox<String> comboHiperhidrosis;
    public javax.swing.JComboBox<String> comboHiperqueratosis;
    public javax.swing.JComboBox<String> comboMicosis;
    public javax.swing.JComboBox<String> comboOnicocriptosis;
    public javax.swing.JComboBox<String> comboTalon;
    public javax.swing.JLabel etiqCod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel labelAnticuagulado;
    private javax.swing.JLabel labelApe;
    private javax.swing.JLabel labelBuscarPacientes;
    private javax.swing.JLabel labelCardiacas;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDClinicos;
    private javax.swing.JLabel labelDbt;
    private javax.swing.JLabel labelDire;
    private javax.swing.JLabel labelEvolucion;
    private javax.swing.JLabel labelHiperhidrosis;
    private javax.swing.JLabel labelHiperquratosis;
    private javax.swing.JLabel labelMicosis;
    private javax.swing.JLabel labelNom;
    private javax.swing.JLabel labelOnicocriptosis;
    private javax.swing.JLabel labelPatologias;
    private javax.swing.JLabel labelTalon1;
    private javax.swing.JLabel labelTratamiento;
    private javax.swing.JTable tablaFichaMedica;
    private javax.swing.JTable tablaFichaMedica2;
    private javax.swing.JTable tablaPacientes;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
}
