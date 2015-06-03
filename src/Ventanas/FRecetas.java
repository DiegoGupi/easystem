/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Insumos;
import Clases.Producto;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nigga
 */
public class FRecetas extends javax.swing.JFrame {

    /**
     * Creates new form FRecetas
     */
    private static FRecetas instancia;
    private DefaultTableModel dmt;
    Producto pr;
    String data[][] = {};
    String nombreColumnas[] = {"INSUMO ", "CANTIDAD"};
    private Map carrito_compra = new HashMap();

    public FRecetas() {
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        this.pr = new Producto();
        cargacomboproductos();
        cargarComboInsumos();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.dispose();
        dmt = new DefaultTableModel(data, nombreColumnas);
    }

    public static FRecetas getInstancia() {
        if (instancia == null) {
            instancia = new FRecetas();
        }
        return instancia;

    }

    public void fecha() {
        Calendar cal = Calendar.getInstance();
        java.util.Date fecha = cal.getTime();
        DateFormat formatter = DateFormat.getTimeInstance();
        jlabel_fecha.setText(formatter.format(fecha));
    }

    public final void cargacomboproductos() {
        try {
            ArrayList r;
            Iterator iterador;
            Producto i = new Producto();
            r = i.cargarproducto();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Producto) iterador.next();
                this.cb_producto.addItem(i);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocurrio un error de acceso a una clase " + ex.toString());
        } catch (InstantiationException ex) {
            System.out.println("Ocurrio un error de instanciación " + ex.toString());
        } catch (IllegalAccessException ex) {
            System.out.println("Ocurrio un acceso " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error de sentencia SQL " + ex.toString());
        }
    }

    private void cargarComboInsumos() {
        try {
            ArrayList r;
            Iterator iterador;
            Insumos i = new Insumos();
            r = i.cargar();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Insumos) iterador.next();
                this.cb_insumos.addItem(i);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocurrio un error de acceso a una clase " + ex.toString());
        } catch (InstantiationException ex) {
            System.out.println("Ocurrio un error de instanciación " + ex.toString());
        } catch (IllegalAccessException ex) {
            System.out.println("Ocurrio un acceso " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error de sentencia SQL " + ex.toString());
        }
    }

    public final void cargacomboinsumos() {
        try {
            ArrayList r;
            Iterator iterador;
            Insumos i = new Insumos();
            r = i.cargar();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Insumos) iterador.next();
                this.cb_insumos.addItem(i);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocurrio un error de acceso a una clase " + ex.toString());
        } catch (InstantiationException ex) {
            System.out.println("Ocurrio un error de instanciación " + ex.toString());
        } catch (IllegalAccessException ex) {
            System.out.println("Ocurrio un acceso " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error de sentencia SQL " + ex.toString());
        }
    }

    private void limpiar() {
        this.tf_cantidad.setText("");
        this.tf_nuevoProducto.setText("");
        this.tf_precio.setText("");
        dmt.setRowCount(0);

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
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_cantidad = new javax.swing.JTextField();
        tf_nuevoProducto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bt_guardarReceta = new javax.swing.JButton();
        btn_pasar = new javax.swing.JButton();
        cb_insumos = new javax.swing.JComboBox();
        btn_tostock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_insumos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cb_producto = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jlabel_fecha = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlabel_fecha2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receta Nuevo Producto - Easystem v1.0");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Insumo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Cantidad");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Nombre del Nuevo Producto");

        bt_guardarReceta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Save.png"))); // NOI18N
        bt_guardarReceta.setText("Guardar");
        bt_guardarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarRecetaActionPerformed(evt);
            }
        });

        btn_pasar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Forward.png"))); // NOI18N
        btn_pasar.setText(" Agregar");
        btn_pasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pasarActionPerformed(evt);
            }
        });

        cb_insumos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_insumosFocusGained(evt);
            }
        });

        btn_tostock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Add.png"))); // NOI18N
        btn_tostock.setText("Nuevo Insumo");
        btn_tostock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tostockActionPerformed(evt);
            }
        });

        jt_insumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jt_insumos);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Precio Unitario");

        tf_precio.setToolTipText("Precio unitario del producto a generar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_pasar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_guardarReceta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cb_insumos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cantidad)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_tostock)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nuevoProducto)
                            .addComponent(tf_precio))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_nuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_insumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tostock, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_pasar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_guardarReceta)
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Insumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        btn_volver.setBackground(new java.awt.Color(0, 0, 0));
        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Back.png"))); // NOI18N
        btn_volver.setToolTipText("Volver");
        btn_volver.setBorder(null);
        btn_volver.setBorderPainted(false);
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Volver");

        jlabel_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel_fecha.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Usuario Conectado: Admin");

        jlabel_fecha2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jlabel_fecha2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Hora de Conexión");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(276, 276, 276)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jlabel_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_fecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
            .addComponent(btn_volver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pasarActionPerformed
        String insumo = cb_insumos.getSelectedItem().toString();
        String cantidad = tf_cantidad.getText();
        Insumos i = new Insumos();
        String umedida = i.getMedidaInsumo();
        String datos[] = {insumo, cantidad};
        dmt.addRow(datos);
        jt_insumos.setModel(dmt);
    }//GEN-LAST:event_btn_pasarActionPerformed

    private void bt_guardarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarRecetaActionPerformed
        this.pr.setNombreProducto(this.tf_nuevoProducto.getText());
        this.pr.setPrecioProducto(Integer.parseInt(this.tf_precio.getText()));
        this.pr.setEstadoproducto(true);

        try {
            this.pr.grabar();
            JOptionPane.showMessageDialog(null, "Registro guardado con exito");
            limpiar();
            cargacomboproductos();
            cargacomboinsumos();
            jt_insumos.clearSelection();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(FRecetas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_guardarRecetaActionPerformed

    private void btn_tostockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tostockActionPerformed
        FStock mi_ventana = FStock.getInstancia();
        mi_ventana.setVisible(true);
    }//GEN-LAST:event_btn_tostockActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void cb_insumosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_insumosFocusGained
        cargarComboInsumos();
    }//GEN-LAST:event_cb_insumosFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ParseException {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlackStarLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRecetas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_guardarReceta;
    private javax.swing.JButton btn_pasar;
    private javax.swing.JButton btn_tostock;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox cb_insumos;
    private javax.swing.JComboBox cb_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel_fecha;
    private javax.swing.JLabel jlabel_fecha2;
    private javax.swing.JTable jt_insumos;
    private javax.swing.JTextField tf_cantidad;
    private javax.swing.JTextField tf_nuevoProducto;
    private javax.swing.JTextField tf_precio;
    // End of variables declaration//GEN-END:variables
}
