/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Cliente;
import Clases.Insumos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nigga
 */
public class FStock extends javax.swing.JFrame {

    /**
     * Creates new form FStock
     */
    private static FStock instancia;
    private DefaultTableModel dtm;
    private Insumos in;
    private static final String[] nombreColumnas = {"ID ", "NOMBRE ", "UNIDAD MEDIDA", "PRECIO", "CANTIDAD"};

    private FStock() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.in = new Insumos();
        this.tf_nuevoInsumo.setEnabled(false);

        this.dispose();
    }
    
    private void cargarComboBox() {
        try {
            ArrayList r;
            Iterator iterador;
            Insumos i = new Insumos();
            r = i.cargar();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Insumos) iterador.next();
                this.cb_insumo.addItem(i);
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

    public static FStock getInstancia() {
        if (instancia == null) {
            instancia = new FStock();
        }
        return instancia;
    }

    private void cargarTabla() {
        ArrayList<Insumos> r;
        Iterator<Insumos> iterador;
        Insumos alguno;
        Object[][] data;
        int index = 0;
        try {
            r = new Insumos().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][5];
            while (iterador.hasNext()) {
                alguno = iterador.next();
                data[index][0] = alguno.getIdInsumo();
                data[index][1] = alguno.getNombreInsumo();
                data[index][2] = alguno.getMedidaInsumo();
                data[index][3] = alguno.getPrecioInsumo();
                data[index][4] = alguno.getCantidadInsumo();


                index++;
            }
            dtm = new DefaultTableModel() {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm.setDataVector(data, nombreColumnas);

            this.jt_registros.setModel(dtm);
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pu_editar = new javax.swing.JPopupMenu();
        editar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        lb_producto = new javax.swing.JLabel();
        lb_cantidad = new javax.swing.JLabel();
        cb_insumo = new javax.swing.JComboBox();
        cb_cantidad2 = new javax.swing.JComboBox();
        bt_guardarInsumo = new javax.swing.JButton();
        bt_añadirNuevoInsumo = new javax.swing.JButton();
        tf_nuevoInsumo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_precioInsumo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_cantidadInsumo = new javax.swing.JTextField();
        bt_cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_registros = new javax.swing.JTable();
        bt_volver = new javax.swing.JButton();

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        pu_editar.add(editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STOCK- Facilitator 1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso de Insumos"));

        lb_producto.setText("Insumo");

        lb_cantidad.setText("Cantidad");

        bt_guardarInsumo.setText("Guardar");
        bt_guardarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarInsumoActionPerformed(evt);
            }
        });

        bt_añadirNuevoInsumo.setText("Añadir +");
        bt_añadirNuevoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_añadirNuevoInsumoActionPerformed(evt);
            }
        });

        jLabel1.setText("Precio");

        jLabel2.setText("Medida");

        jLabel3.setText("Nombre Nuevo Insumo");

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_producto)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_precioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_nuevoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_cantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(bt_guardarInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt_añadirNuevoInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addComponent(lb_cantidad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_producto)
                    .addComponent(cb_insumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_añadirNuevoInsumo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_nuevoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cantidad)
                    .addComponent(tf_cantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_precioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_guardarInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Existencia en Bodega"));

        jt_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Cantidad", "Unidad Medida", "Precio"
            }
        ));
        jt_registros.setComponentPopupMenu(pu_editar);
        jt_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jt_registrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jt_registros);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        bt_volver.setText("VOLVER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_añadirNuevoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_añadirNuevoInsumoActionPerformed
        this.cb_insumo.setEnabled(false);
        this.tf_nuevoInsumo.setEnabled(true);
        this.tf_cantidadInsumo.setEnabled(true);
        this.tf_precioInsumo.setEnabled(true);
        this.cb_cantidad2.setEnabled(true);
        
    }//GEN-LAST:event_bt_añadirNuevoInsumoActionPerformed

    private void bt_guardarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarInsumoActionPerformed
       this.in.setNombreInsumo(this.tf_nuevoInsumo.getText());
       this.in.setCantidadInsumo(Integer.parseInt(this.tf_cantidadInsumo.getText()));
       this.in.setPrecioInsumo(Integer.parseInt(this.tf_precioInsumo.getText()));
       this.in.setMedidaInsumo(Integer.valueOf(this.cb_cantidad2.getSelectedIndex()));
       
//       Insumos i = (Insumos) this.cb_cantidad2.getSelectedItem();
       
        try {
//            this.c.setPais(p);
            this.in.grabar();
            JOptionPane.showMessageDialog(null, "Registro guardado con exito");
            this.cb_insumo.setSelectedIndex(1);
            this.tf_nuevoInsumo.setText("");
            this.tf_cantidadInsumo.setText("");
            this.tf_precioInsumo.setText("");

            this.cargarTabla();
            
        } catch (java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.lang.IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.lang.InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.lang.NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_bt_guardarInsumoActionPerformed

    private void jt_registrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_registrosMousePressed
         int fila = this.jt_registros.rowAtPoint(evt.getPoint());
        int columna = this.jt_registros.columnAtPoint(evt.getPoint());
        /* Muestra los datos en la ventana de edición si corresponde */
        if ((fila > -1) && (columna > -1)) {
            this.in.setIdInsumo((Integer) this.dtm.getValueAt(fila, 0));
            this.in.setNombreInsumo((String) this.dtm.getValueAt(fila, 1));
            this.in.setMedidaInsumo((Integer) this.dtm.getValueAt(fila, 2));            
            this.in.setPrecioInsumo((Integer) this.dtm.getValueAt(fila, 3));
            this.in.setCantidadInsumo((Integer) this.dtm.getValueAt(fila, 4));

                
        }    
    }//GEN-LAST:event_jt_registrosMousePressed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
//        this.cb_insumo.setSelectedItem(this.in.getNombreInsumo());
        this.cb_insumo.setEnabled(false);
        this.tf_nuevoInsumo.setEnabled(true);
        this.tf_nuevoInsumo.setText(this.in.getNombreInsumo());
        this.tf_cantidadInsumo.setText(String.valueOf(this.in.getCantidadInsumo()));
        this.tf_precioInsumo.setText(String.valueOf(this.in.getPrecioInsumo()));
        this.cb_cantidad2.setSelectedItem(this.in.getMedidaInsumo());
        
        
        
        
    }//GEN-LAST:event_editarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        
//        this.cb_insumo.setSelectedIndex(0);
        this.tf_nuevoInsumo.setText("");
        this.tf_cantidadInsumo.setText("");
        this.tf_precioInsumo.setText("");
        this.tf_nuevoInsumo.setEnabled(false);
//        this.bt_guardarInsumo.setEnabled(false);
        
//        this.cb_cantidad2.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
            this.in.cargar();
            this.cargarTabla();
             cargarComboBox();
        
         } catch (java.lang.ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.lang.IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.lang.InstantiationException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        }
       
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(FStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FStock().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_añadirNuevoInsumo;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_guardarInsumo;
    private javax.swing.JButton bt_volver;
    private javax.swing.JComboBox cb_cantidad2;
    private javax.swing.JComboBox cb_insumo;
    private javax.swing.JMenuItem editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_registros;
    private javax.swing.JLabel lb_cantidad;
    private javax.swing.JLabel lb_producto;
    private javax.swing.JPopupMenu pu_editar;
    private javax.swing.JTextField tf_cantidadInsumo;
    private javax.swing.JTextField tf_nuevoInsumo;
    private javax.swing.JTextField tf_precioInsumo;
    // End of variables declaration//GEN-END:variables
}
