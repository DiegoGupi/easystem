/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Insumos;
import Clases.Producto;
import Clases.Receta;
import Clases.Recetadetalle;
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
import javax.swing.DefaultComboBoxModel;
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
    private final DefaultTableModel dmt;

    Producto pr;
    Receta rc;
    String data[][] = {};
    String nombreColumnas[] = {"INSUMO ", "CANTIDAD"};
    private Map carrito_compra = new HashMap();
    private final static String newline = "\n";

    public FRecetas() {
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        initComponents();
        this.pr = new Producto();
        this.rc = new Receta();
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
        //jlabel_fecha.setText(formatter.format(fecha));
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

    private void cargarinsumosporproducto() {

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

    public DefaultComboBoxModel ListaProductos(Map carrito_compra) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Iterator it = carrito_compra.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            Recetadetalle itm = (Recetadetalle) e.getValue();
            model.addElement(itm.getnombreinsumo() + " | " + itm.getCantidad());
        }
        return model;
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
        jLabel7 = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tx_detalle = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtinsumosporproducto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_producto = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Precio Unitario");

        tf_precio.setToolTipText("Precio unitario del producto a generar");

        tx_detalle.setColumns(20);
        tx_detalle.setRows(5);
        jScrollPane3.setViewportView(tx_detalle);

        jLabel5.setText("CANTIDAD");

        jLabel8.setText("INSUMO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_precio)
                                .addGap(2, 2, 2))
                            .addComponent(tf_nuevoProducto)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_insumos, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_tostock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_pasar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_guardarReceta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(56, 56, 56)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_guardarReceta))
                    .addComponent(btn_pasar))
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Receta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jtinsumosporproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtinsumosporproducto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(887, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
            .addComponent(btn_volver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Producto");

        jTextField1.setToolTipText("buscar...");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel2.setText("Lista");

        jLabel4.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(113, 113, 113)))
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

//        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dmt);
//        cb_producto.setRowSorter(sorter);
//        String text = cb_producto.getSelectedItem().toString();
//        if (text.length() == 0) {
//            sorter.setRowFilter(null);
//        } else {
//            sorter.setRowFilter(RowFilter.regexFilter(text));
//        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void btn_tostockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tostockActionPerformed
        FStock mi_ventana = FStock.getInstancia();
        mi_ventana.setVisible(true);
    }//GEN-LAST:event_btn_tostockActionPerformed

    private void cb_insumosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_insumosFocusGained
        cargarComboInsumos();
    }//GEN-LAST:event_cb_insumosFocusGained

    private void btn_pasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pasarActionPerformed

        tx_detalle.append("        " + this.tf_cantidad.getText() + "                                        " + this.cb_insumos.getSelectedItem().toString() + newline);

//        String insumo = cb_insumos.getSelectedItem().toString();
//        String cantidad = tf_cantidad.getText();
//        Insumos i = new Insumos();
//        String umedida = i.getMedidaInsumo();
//        String datos[] = {insumo, cantidad};
//        dmt.addRow(datos);
//        jt_insumos.setModel(dmt);
    }//GEN-LAST:event_btn_pasarActionPerformed

    private void bt_guardarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarRecetaActionPerformed
        if (this.tf_precio == null || this.tf_nuevoProducto == null) {
            JOptionPane.showMessageDialog(null, "Falta precio o nombre del producto");
            tf_cantidad.requestFocus();
        } else {

            this.pr.setNombreProducto(this.tf_nuevoProducto.getText());
            this.pr.setPrecioProducto(Integer.parseInt(this.tf_precio.getText()));
            this.pr.setEstadoproducto(true);
            this.rc.setDetalleReceta(this.tx_detalle.getText().replaceAll("\\s+",""));


            try {
                this.pr.grabar();
                this.rc.grabar();
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                limpiar();
                cargacomboproductos();
                cargacomboinsumos();
                tx_detalle.setText(newline);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(FRecetas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_guardarRecetaActionPerformed

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtinsumosporproducto;
    private javax.swing.JTextField tf_cantidad;
    private javax.swing.JTextField tf_nuevoProducto;
    private javax.swing.JTextField tf_precio;
    private javax.swing.JTextArea tx_detalle;
    // End of variables declaration//GEN-END:variables
}
