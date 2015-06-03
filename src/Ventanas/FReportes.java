/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Cliente;
import Clases.Insumos;
import Clases.Ventas;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.*;

/**
 *
 * @author DiegoAndrés
 */
public class FReportes extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private static FReportes instancia;
    private Cliente cl;
    private static final String[] nombreColumnasClientes = {"RUT ", "NOMBRE ", "DIRECCION", "EMPRESA", "TELEFONO", "MAIL", "TIPO"};
    private static final String[] nombreColumnasStock = {"ID INSUMO ", "CANTIDAD INSUMO", "NOMBRE INSUMO", "PRECIO INSUMO", "UNIDAD DE MEDIDA"};
    private static final String[] nombreColumasVentas = {"ESTADO VENTA ", "FECHA VENTA", "ID COTIZACION", "ID VENTA"};

    /**
     * Creates new form FReportes
     */
    public FReportes() {
      /*  try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        initComponents();
        cargarTabla1();
        cargarTabla2();
        cargarTabla3();
        this.setLocationRelativeTo(null);
        btn_pdf.setToolTipText("Genera un archivo PDF y lo almacena en su disco duro");
    }

    public static FReportes getInstancia() {
        if (instancia == null) {
            instancia = new FReportes();
        }
        return instancia;
    }

    private void abrirReporteCliente() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            //Conexion cdb = (Conexion)FactoriaServicios.getInstancia().getConexionDb();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
            String archivo = "src/Reportes/ReporteCliente.jrxml";
            Map parameters = new HashMap();
            parameters.put("REPORT_CONNECTION", conexion);
            JasperDesign jasperDesign = JRXmlLoader.load(archivo);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException jRException) {

            System.out.println(jRException.getMessage());

        }

    }

    private void abrirReporteStock() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            //Conexion cdb = (Conexion)FactoriaServicios.getInstancia().getConexionDb();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
            String archivo = "src/Reportes/ReporteStock.jrxml";
            Map parameters = new HashMap();
            parameters.put("REPORT_CONNECTION", conexion);
            JasperDesign jasperDesign = JRXmlLoader.load(archivo);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);

        } catch (JRException jRException) {

            System.out.println(jRException.getMessage());

        }

    }

    private void abrirReporteVentas() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
            String archivo = "src/Reportes/Reporteventas.jrxml";
            Map parameters = new HashMap();
            parameters.put("REPORT_CONNECTION", conexion);
            JasperDesign jasperDesign = JRXmlLoader.load(archivo);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException jRException) {

            System.out.println(jRException.getMessage());

        }

    }

    public void imprimirreportecliente() throws IOException, ClassNotFoundException, SQLException {
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", ".pdf", ".PDF");
        archivo.addChoosableFileFilter(new FileNameExtensionFilter(".pdf", ".PDF"));
        archivo.setFileFilter(filter);
        int selection = archivo.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File JFC = archivo.getSelectedFile();
            String PATH = JFC.getAbsolutePath();
            if (!(PATH.endsWith(".pdf"))) {
                File temp = new File(PATH + ".pdf");
                JFC.renameTo(temp);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
                String archivoventas = "src/Reportes/ReporteCliente.jrxml";
                Map parameters = new HashMap();
                parameters.put("REPORT_CONNECTION", conexion);
                JasperDesign jasperDesign = JRXmlLoader.load(archivoventas);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
                JasperExportManager.exportReportToPdfFile(jasperPrint, PATH);
                JOptionPane.showMessageDialog(null, "PDF generado!");

            } catch (JRException e) {
                e.printStackTrace();
            }
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + PATH);
            } else if (osName.startsWith("Mac OS X")) {
                //Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + PATH);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor abre el navegador y ve a: " + PATH);
            }

        }

    }

    public void imprimirreportestock() throws ClassNotFoundException, SQLException, IOException {
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", ".pdf", ".PDF");
        archivo.addChoosableFileFilter(new FileNameExtensionFilter(".pdf", ".PDF"));
        archivo.setFileFilter(filter);
        int selection = archivo.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File JFC = archivo.getSelectedFile();
            String PATH = JFC.getAbsolutePath();
            if (!(PATH.endsWith(".pdf"))) {
                File temp = new File(PATH + ".pdf");
                JFC.renameTo(temp);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
                String archivoventas = "src/Reportes/ReporteStock.jrxml";
                Map parameters = new HashMap();
                parameters.put("REPORT_CONNECTION", conexion);
                JasperDesign jasperDesign = JRXmlLoader.load(archivoventas);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
                JasperExportManager.exportReportToPdfFile(jasperPrint, PATH);
                JOptionPane.showMessageDialog(null, "PDF generado!");

            } catch (JRException e) {
                e.printStackTrace();
            }
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + PATH);
            } else if (osName.startsWith("Mac OS X")) {
                //Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + PATH);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor abre el navegador y ve a: " + PATH);
            }

        }

    }

    public void imprimirreporteventas() throws ClassNotFoundException, SQLException, IOException {
        JFileChooser archivo = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", ".pdf", ".PDF");
        archivo.addChoosableFileFilter(new FileNameExtensionFilter(".pdf", ".PDF"));
        archivo.setFileFilter(filter);
        int selection = archivo.showSaveDialog(null);
        if (selection == JFileChooser.APPROVE_OPTION) {
            File JFC = archivo.getSelectedFile();
            String PATH = JFC.getAbsolutePath();
            if (!(PATH.endsWith(".pdf"))) {
                File temp = new File(PATH + ".pdf");
                JFC.renameTo(temp);
            }
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/facilitator", "root", "");
                String archivoventas = "src/Reportes/Reporteventas.jrxml";
                Map parameters = new HashMap();
                parameters.put("REPORT_CONNECTION", conexion);
                JasperDesign jasperDesign = JRXmlLoader.load(archivoventas);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);
                JasperExportManager.exportReportToPdfFile(jasperPrint, PATH);
                JOptionPane.showMessageDialog(null, "PDF generado!");

            } catch (JRException e) {
                e.printStackTrace();
            }
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Windows")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + PATH);
            } else if (osName.startsWith("Mac OS X")) {
                //Runtime.getRuntime().exec("open -a safari " + url);
                // Runtime.getRuntime().exec("open " + url + "/index.html");
                Runtime.getRuntime().exec("open " + PATH);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor abre el navegador y ve a: " + PATH);
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

        tb = new javax.swing.JTabbedPane();
        jp1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_clientes = new javax.swing.JTable();
        jp2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_stock = new javax.swing.JTable();
        jp3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_ventas = new javax.swing.JTable();
        btn_pdf = new javax.swing.JButton();
        btn_jasperreport = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btn_volver2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REPORTES - Easystem v1.0");
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });

        jt_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_clientes);

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb.addTab("Clientes", jp1);

        jt_stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jt_stock.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jt_stockMouseMoved(evt);
            }
        });
        jScrollPane2.setViewportView(jt_stock);

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb.addTab("Stock", jp2);

        jt_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jt_ventas);

        javax.swing.GroupLayout jp3Layout = new javax.swing.GroupLayout(jp3);
        jp3.setLayout(jp3Layout);
        jp3Layout.setHorizontalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp3Layout.setVerticalGroup(
            jp3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        tb.addTab("Ventas", jp3);

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/pdf_small.png"))); // NOI18N
        btn_pdf.setText("Generar Documento PDF");
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        btn_jasperreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/List.png"))); // NOI18N
        btn_jasperreport.setText("Imprimir Documento ");
        btn_jasperreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_jasperreportActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        btn_volver2.setBackground(new java.awt.Color(0, 0, 0));
        btn_volver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Back.png"))); // NOI18N
        btn_volver2.setToolTipText("Volver");
        btn_volver2.setBorder(null);
        btn_volver2.setBorderPainted(false);
        btn_volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volver2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Volver");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_volver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tb)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_jasperreport, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pdf)))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(tb, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_jasperreport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_pdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        try {
            int seleccion = this.tb.getSelectedIndex();
            switch (seleccion) {
                case 0:
                    imprimirreportecliente();
                    break;
                case 1:
                    imprimirreportestock();
                    break;
                case 2:
                    imprimirreporteventas();
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void jt_stockMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_stockMouseMoved

    }//GEN-LAST:event_jt_stockMouseMoved

    private void btn_jasperreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_jasperreportActionPerformed
        try {
            int seleccion = this.tb.getSelectedIndex();
            switch (seleccion) {
                case 0:
                    abrirReporteCliente();
                    break;
                case 1:
                    abrirReporteStock();
                    break;
                case 2:
                    abrirReporteVentas();
                    break;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_jasperreportActionPerformed

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        int seleccion = this.tb.getSelectedIndex();
        switch (seleccion) {
            case 0:
                cargarTabla1();
                break;
            case 1:
                cargarTabla2();
                break;
            case 2:
                cargarTabla3();
                break;
        }

    }//GEN-LAST:event_tbMouseClicked

    private void btn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volver2ActionPerformed

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
            java.util.logging.Logger.getLogger(FReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FReportes().setVisible(true);
            }
        });
    }

    private void cargarTabla1() {
        ArrayList<Cliente> r;
        Iterator<Cliente> iterador;
        Cliente alguno;
        Object[][] data;
        int index = 0;
        try {
            r = new Cliente().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][7];
            while (iterador.hasNext()) {
                alguno = iterador.next();
                data[index][0] = alguno.getRutCliente();
                data[index][1] = alguno.getNombreCliente();
                data[index][2] = alguno.getDireccionCliente();
                data[index][3] = alguno.getEmpresaCliente();
                data[index][4] = alguno.getTelefonoCliente();
                data[index][5] = alguno.getMailCliente();
                data[index][6] = alguno.getTipoCliente();

                index++;
            }
            dtm = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm.setDataVector(data, nombreColumnasClientes);

            this.jt_clientes.setModel(dtm);
//        } catch (IOException e) {
//            System.out.println("Error de E/S. Descripción : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de conversión. Descripción : " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Error de instanciación. Descripción : " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error de acceso. Descripción : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error a nivel de SQL. Descripción : " + e.getMessage());
        }
    }

    private void cargarTabla2() {
        ArrayList<Insumos> r;
        Iterator<Insumos> iterador;
        Insumos insumo;
        Object[][] data;
        int index = 0;
        try {
            r = new Insumos().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][5];
            while (iterador.hasNext()) {
                insumo = iterador.next();
                data[index][0] = insumo.getIdInsumo();
                data[index][1] = insumo.getCantidadInsumo();
                data[index][2] = insumo.getNombreInsumo();
                data[index][3] = insumo.getPrecioInsumo();
                data[index][4] = insumo.getMedidaInsumo();
                index++;
            }
            dtm = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm.setDataVector(data, nombreColumnasStock);

            this.jt_stock.setModel(dtm);
//        } catch (IOException e) {
//            System.out.println("Error de E/S. Descripción : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de conversión. Descripción : " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Error de instanciación. Descripción : " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error de acceso. Descripción : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error a nivel de SQL. Descripción : " + e.getMessage());
        }
    }

    private void cargarTabla3() {
        ArrayList<Ventas> r;
        Iterator<Ventas> iterador;
        Ventas venta;
        Object[][] data;
        int index = 0;
        try {
            r = new Ventas().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][4];
            while (iterador.hasNext()) {
                venta = iterador.next();
                data[index][0] = venta.getIdVenta();
                data[index][1] = venta.getCotizacion();
                data[index][2] = venta.isEstado();
                data[index][3] = venta.getFechaVenta();
                index++;
            }
            dtm = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm.setDataVector(data, nombreColumasVentas);

            this.jt_ventas.setModel(dtm);
//        } catch (IOException e) {
//            System.out.println("Error de E/S. Descripción : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error de conversión. Descripción : " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("Error de instanciación. Descripción : " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("Error de acceso. Descripción : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error a nivel de SQL. Descripción : " + e.getMessage());
        }
    }

    public void actualizartabla() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_jasperreport;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_volver2;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JTable jt_clientes;
    private javax.swing.JTable jt_stock;
    private javax.swing.JTable jt_ventas;
    private javax.swing.JTabbedPane tb;
    // End of variables declaration//GEN-END:variables
}
