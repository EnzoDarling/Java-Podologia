package Vistas;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import Conector.Conexion;
import java.awt.Toolkit;

public class VentanaFicha extends javax.swing.JFrame {
    CustomErrorDialog CustomError;
    public VentanaFicha() {
        CustomError = new CustomErrorDialog();
        initComponents();
        setSize(900, 520);
        setIcon();
        setTitle("FICHAS MÉDICAS");
        setLocationRelativeTo(null);
        setResizable(false);
        campoCod.setVisible(false);
        labelCod.setVisible(false);
    }
    private void guardar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String ape = campoApe.getText();
        String nom = campoNom.getText();
        String dire = campoDire.getText();
        String edad = campoEdad.getText();
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
        String sql = "INSERT INTO fichasmedicas (fich_ap, fich_nom, fich_dire, fich_edad,"
                + " fich_anticua, fich_dbt, fich_afcard, fich_micosis,"
                + " fich_onicocri, fich_talonagri, fich_hiperquera, fich_hiperhidro,"
                + " fich_edema, fich_datoscli, fich_otraspato, fich_tratam, fich_evolucion) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(campoApe.equals("") || campoApe==null || campoNom.equals("") || campoNom==null || campoDire.equals("") || campoDire==null || campoEdad.equals("") 
                || campoEdad==null || comboAnticuagulado.equals("") || comboAnticuagulado==null || comboDbt.equals("") || comboDbt==null || comboCardiacas.equals("") 
                || comboCardiacas==null || comboMicosis.equals("") || comboMicosis==null || comboOnicocriptosis.equals("") || comboOnicocriptosis==null || comboTalon.equals("") 
                || comboTalon==null || comboHiperqueratosis.equals("") || comboHiperqueratosis==null || comboHiperhidrosis.equals("") || comboHiperhidrosis==null || comboEdema.equals("") || comboEdema==null 
                || areaDClinicos.equals("") || areaDClinicos==null || areaPatologias.equals("") || areaPatologias==null || areaTratamiento.equals("") || areaTratamiento==null || areaEvolucion.equals("") 
                || areaEvolucion==null){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, ape);
                psd.setString(2, nom);
                psd.setString(3, dire);
                psd.setString(4, edad);
                psd.setString(5, anticua);
                psd.setString(6, dbt);
                psd.setString(7, afcard);
                psd.setString(8, micosis);
                psd.setString(9, onicocri);
                psd.setString(10, talonagri);
                psd.setString(11, hiperquera);
                psd.setString(12, hiperhidro);
                psd.setString(13, edema);
                psd.setString(14, datoscli);
                psd.setString(15, otraspato);
                psd.setString(16, tratam);
                psd.setString(17, evol);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "SE HA GUARDADO EL REGISTRO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                CustomError.showDialog("<html>Ocurrió un error al guardar, contacte al personal adecuado sobre este error</html>", 
                                "<html>'"+e+"'</html>");
            }
        }
    }
    private void modificar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String ape = campoApe.getText();
        String nom = campoNom.getText();
        String dire = campoDire.getText();
        String edad = campoEdad.getText();
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
        String sql = "UPDATE fichasmedicas SET fich_ap='" + ape + "',fich_nom='" + nom + "',fich_dire='" + dire + "', fich_edad='" + edad + "',"
                + " fich_anticua='" + anticua + "', fich_dbt='" + dbt + "', fich_afcard='" + afcard + "', fich_micosis='" + micosis + "',"
                + " fich_onicocri='" + onicocri + "', fich_talonagri='" + talonagri + "', fich_hiperquera='" + hiperquera + "', fich_hiperhidro='" + hiperhidro + "',"
                + " fich_edema='" + edema + "', fich_datoscli='" + datoscli + "', fich_otraspato='" + otraspato + "', fich_tratam='" + tratam + "', fich_evolucion='" + evol + "' WHERE fich_cod";        
        if(campoApe.equals("") || campoApe==null || campoNom.equals("") || campoNom==null || campoDire.equals("") || campoDire==null || campoEdad.equals("") 
                || campoEdad==null || comboAnticuagulado.equals("") || comboAnticuagulado==null || comboDbt.equals("") || comboDbt==null || comboCardiacas.equals("") 
                || comboCardiacas==null || comboMicosis.equals("") || comboMicosis==null || comboOnicocriptosis.equals("") || comboOnicocriptosis==null || comboTalon.equals("") 
                || comboTalon==null || comboHiperqueratosis.equals("") || comboHiperqueratosis==null || comboHiperhidrosis.equals("") || comboHiperhidrosis==null || comboEdema.equals("") || comboEdema==null 
                || areaDClinicos.equals("") || areaDClinicos==null || areaPatologias.equals("") || areaPatologias==null || areaTratamiento.equals("") || areaTratamiento==null || areaEvolucion.equals("") 
                || areaEvolucion==null){
            JOptionPane.showMessageDialog(null,"Existen campos vacíos, rellene los campos e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
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
                                "<html>'"+e+"'</html>");
                }
            }
        }
    }
    private void eliminar() {
        Conexion cc = new Conexion();
        Connection cn = cc.conexion();
        String cod = campoCod.getText();
        String sql = "DELETE FROM fichasmedicas WHERE fich_cod=?";
        int resp;
        resp = JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURA DE ELIMINAR EL REGISTRO?", "AVISO", JOptionPane.YES_NO_OPTION);
        if(cod.equals("") || cod==null){
            JOptionPane.showMessageDialog(null,"No ha ingresado un código de ficha médica, ingrese un código de ficha médica e intente nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if (resp == JOptionPane.YES_OPTION) {
                try {
                    PreparedStatement psd = cn.prepareStatement(sql);
                    psd.setString(1, cod);
                    int x = psd.executeUpdate();
                    if (x > 0) {
                        JOptionPane.showMessageDialog(null, "EL REGISTRO SE HA ELIMINADO", "AVISO", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    CustomError.showDialog("<html>Ocurrió un error al cargar, contacte al personal adecuado sobre este error</html>", 
                                "<html>'"+e+"'</html>");
                }
            }
        }
    }
    private void limpiar() {
        campoCod.setVisible(false);
        labelCod.setVisible(false);
        campoApe.setText("");
        campoNom.setText("");
        campoDire.setText("");
        campoEdad.setText("");
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
    }
    private void deshabilitar(){
        campoCod.setVisible(false);
        labelCod.setVisible(false);
        campoApe.setEnabled(false);
        campoNom.setEnabled(false);
        campoDire.setEnabled(false);
        campoEdad.setEnabled(false);
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
    private void habilitar(){
        campoCod.setVisible(true);
        labelCod.setVisible(true);
        campoApe.setEnabled(true);
        campoNom.setEnabled(true);
        campoDire.setEnabled(true);
        campoEdad.setEnabled(true);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelApe = new javax.swing.JLabel();
        labelNom = new javax.swing.JLabel();
        labelDire = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        labelDbt = new javax.swing.JLabel();
        campoApe = new javax.swing.JTextField();
        campoNom = new javax.swing.JTextField();
        campoDire = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
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
        labelCod = new javax.swing.JLabel();
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
        jButton1 = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        labelApe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelApe.setText("Apellido");
        jPanel1.add(labelApe);
        labelApe.setBounds(280, 20, 70, 22);

        labelNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNom.setText("Nombre");
        jPanel1.add(labelNom);
        labelNom.setBounds(570, 20, 80, 22);

        labelDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDire.setText("Dirección");
        jPanel1.add(labelDire);
        labelDire.setBounds(280, 100, 80, 22);

        labelEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelEdad.setText("Edad");
        jPanel1.add(labelEdad);
        labelEdad.setBounds(20, 100, 50, 22);

        labelDbt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelDbt.setText("DBT");
        jPanel1.add(labelDbt);
        labelDbt.setBounds(570, 190, 50, 22);

        campoApe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoApe);
        campoApe.setBounds(390, 20, 110, 30);

        campoNom.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoNom);
        campoNom.setBounds(690, 20, 120, 30);

        campoDire.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoDire);
        campoDire.setBounds(390, 100, 110, 30);

        campoEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoEdad);
        campoEdad.setBounds(120, 100, 110, 30);

        comboHiperhidrosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboHiperhidrosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboHiperhidrosis);
        comboHiperhidrosis.setBounds(690, 110, 120, 30);

        labelCardiacas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCardiacas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCardiacas.setText("Afecciones");
        labelCardiacas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelCardiacas);
        labelCardiacas.setBounds(20, 370, 100, 30);

        labelAnticuagulado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAnticuagulado.setText("Anticuagulado");
        jPanel1.add(labelAnticuagulado);
        labelAnticuagulado.setBounds(270, 190, 120, 22);

        comboTalon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboTalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboTalon);
        comboTalon.setBounds(690, 280, 120, 30);

        comboCardiacas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboCardiacas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboCardiacas);
        comboCardiacas.setBounds(140, 380, 90, 30);

        labelMicosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelMicosis.setText("Micosis");
        jPanel1.add(labelMicosis);
        labelMicosis.setBounds(10, 190, 80, 22);

        comboMicosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboMicosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inter Digital", "Ungueal", "Plantar" }));
        jPanel1.add(comboMicosis);
        comboMicosis.setBounds(110, 190, 120, 30);

        labelOnicocriptosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelOnicocriptosis.setText("Onicocriptosis");
        jPanel1.add(labelOnicocriptosis);
        labelOnicocriptosis.setBounds(10, 290, 120, 22);

        comboAnticuagulado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboAnticuagulado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboAnticuagulado);
        comboAnticuagulado.setBounds(400, 190, 100, 30);

        labelTalon1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTalon1.setText("Talón Agrietado");
        jPanel1.add(labelTalon1);
        labelTalon1.setBounds(540, 280, 130, 22);

        comboDbt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboDbt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboDbt);
        comboDbt.setBounds(690, 190, 120, 30);

        labelHiperquratosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHiperquratosis.setText("Hiperqueratosis");
        jPanel1.add(labelHiperquratosis);
        labelHiperquratosis.setBounds(250, 380, 130, 22);

        comboHiperqueratosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboHiperqueratosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lateral", "Superior", "Metatarsal" }));
        jPanel1.add(comboHiperqueratosis);
        comboHiperqueratosis.setBounds(400, 380, 100, 30);

        labelHiperhidrosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHiperhidrosis.setText("HiperHidrosis");
        jPanel1.add(labelHiperhidrosis);
        labelHiperhidrosis.setBounds(560, 110, 110, 22);

        comboEdema.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboEdema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboEdema);
        comboEdema.setBounds(400, 280, 100, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Edema");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(260, 280, 60, 22);

        comboOnicocriptosis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboOnicocriptosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));
        jPanel1.add(comboOnicocriptosis);
        comboOnicocriptosis.setBounds(140, 290, 90, 30);
        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(-30, -30, 5, 5);

        labelCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCod.setText("Código");
        jPanel1.add(labelCod);
        labelCod.setBounds(10, 20, 70, 22);

        campoCod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(campoCod);
        campoCod.setBounds(120, 20, 110, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cardíacas");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 400, 90, 30);

        jTabbedPane2.addTab("Página 1", jPanel1);

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
        labelPatologias.setBounds(440, 10, 140, 22);

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
        btnGuardar.setBounds(160, 410, 150, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jButton1.setText("NUEVO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 410, 140, 40);

        btnMostrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tablaexcel.png"))); // NOI18N
        btnMostrar.setText("MOSTRAR FICHAS");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnMostrar);
        btnMostrar.setBounds(650, 410, 230, 40);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pencil.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnModificar);
        btnModificar.setBounds(320, 410, 170, 40);

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete.png"))); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel3.add(btnBorrar);
        btnBorrar.setBounds(500, 410, 140, 40);

        jTabbedPane2.addTab("Página 2", jPanel3);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(0, 0, 900, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
       VentanaFichaMedica miVFM = new VentanaFichaMedica();
        miVFM.setVisible(true);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
       eliminar();
       limpiar();
       deshabilitar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificar();
        limpiar();
        deshabilitar();        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        limpiar();
        deshabilitar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        habilitar();
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed
 
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
    private javax.swing.JTextArea areaDClinicos;
    private javax.swing.JTextArea areaEvolucion;
    private javax.swing.JTextArea areaPatologias;
    private javax.swing.JTextArea areaTratamiento;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JTextField campoApe;
    private javax.swing.JTextField campoCod;
    private javax.swing.JTextField campoDire;
    private javax.swing.JTextField campoEdad;
    private javax.swing.JTextField campoNom;
    private javax.swing.JComboBox<String> comboAnticuagulado;
    private javax.swing.JComboBox<String> comboCardiacas;
    private javax.swing.JComboBox<String> comboDbt;
    private javax.swing.JComboBox<String> comboEdema;
    private javax.swing.JComboBox<String> comboHiperhidrosis;
    private javax.swing.JComboBox<String> comboHiperqueratosis;
    private javax.swing.JComboBox<String> comboMicosis;
    private javax.swing.JComboBox<String> comboOnicocriptosis;
    private javax.swing.JComboBox<String> comboTalon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelAnticuagulado;
    private javax.swing.JLabel labelApe;
    private javax.swing.JLabel labelCardiacas;
    private javax.swing.JLabel labelCod;
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
    private javax.swing.JLabel labelTratamiento;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("podologia32x32.png")));
    }
}
