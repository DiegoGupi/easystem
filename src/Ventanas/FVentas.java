/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Cliente;
import Clases.Insumos;
import Clases.Producto;
import Clases.carrito;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import mondrian.olap.Category;

/**
 *
 * @author Nigga
 */
public class FVentas extends javax.swing.JFrame {

    /**
     * Creates new form FVentas
     */
    private static FVentas instancia;
    private DefaultTableModel dtm, dtm2, dtm3;
    String data[][] = {};
    String nombreColumnas[] = {"PRODUCTO ", "CANTIDAD", "TOTAL"};
    String nombreColumnap[] = {"PRODUCTO"};
    String nombreColumnai[] = {"INSUMO", "CANTIDAD", "MEDIDA", "TOTAL"};

    public FVentas() {
        /* try {
         UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
         } catch (Exception e) {
         e.printStackTrace();
         }*/
        initComponents();
        cargacombocliente();
        //cargacomboproductos();
        cargarTabla();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.dispose();
        dtm = new DefaultTableModel(data, nombreColumnas);
        dtm2 = new DefaultTableModel(data, nombreColumnap);
        dtm3 = new DefaultTableModel(data, nombreColumnai);
    }

    public static FVentas getInstancia() {
        if (instancia == null) {
            instancia = new FVentas();
        }
        return instancia;

    }

    public void fecha() {
        Calendar cal = Calendar.getInstance();
        java.util.Date fecha = cal.getTime();
        DateFormat formatter = DateFormat.getTimeInstance();
        jlabel_fecha.setText(formatter.format(fecha));
    }

    public final void cargacombocliente() {
        try {
            ArrayList r;
            Iterator iterador;
            Cliente i = new Cliente();
            r = i.cargarcliente();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Cliente) iterador.next();
                this.cb_clienteVentas.addItem(i);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocuxrrio un error de acceso a una clase " + ex.toString());
        } catch (InstantiationException ex) {
            System.out.println("Ocurrio un error de instanciación " + ex.toString());
        } catch (IllegalAccessException ex) {
            System.out.println("Ocurrio un acceso " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error de sentencia SQL " + ex.toString());
        }

    }

    private void cargarTabla() {
        ArrayList<Producto> r;
        Iterator<Producto> iterador;
        Producto alguno;
        Object[][] data;
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry entry) {
                String nombre = (String) entry.getValue(0);
                nombre = tf_filtroProducto.getText();
                return true;
            }
        };
        int index = 0;
        try {
            r = new Producto().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][1];
            while (iterador.hasNext()) {
                alguno = iterador.next();
                data[index][0] = alguno.getNombreProducto();

                index++;
            }
            dtm2 = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm2.setDataVector(data, nombreColumnap);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm2);
            sorter.setRowFilter(filter);
            jt_productos.setRowSorter(sorter);

            this.jt_productos.setModel(dtm2);

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

    private void cargarTablaInsumos() {
        ArrayList<Producto> r;
        Iterator<Producto> iterador;
        Producto alguno;
        Object[][] data;
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(RowFilter.Entry entry) {
                String nombre = (String) entry.getValue(0);
                nombre = tf_filtroProducto.getText();
                return true;
            }
        };
        int index = 0;
        try {
            r = new Producto().cargar();
            iterador = r.iterator();
            //pasa los datos a la tabla
            data = new Object[r.size()][2];
            while (iterador.hasNext()) {
                alguno = iterador.next();
                data[index][0] = alguno.getNombreProducto();

                index++;
            }
            dtm2 = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm2.setDataVector(data, nombreColumnap);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm2);
            sorter.setRowFilter(filter);
            jt_productos.setRowSorter(sorter);

            this.jt_productos.setModel(dtm2);

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

    @SuppressWarnings("UnusedAssignment")
    private void cargarinsumosporproducto() throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException {
//        ArrayList r1 = null;
//        Iterator iterador2;
//        int precioproducto = 0;
        Insumos i = new Insumos();
//        try {
//            int id_producto = 0;
//            r1 = i.cargainsumos2(precioproducto);
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
//            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        iterador2 = r1.iterator();
//        while (iterador2.hasNext()) {
//            carrito tmp_carrito = new carrito();
//            tmp_carrito.setnombreinsumo(i.getNombreInsumo());
//            tmp_carrito.setCantidad(i.getCantidadInsumo());
//            tmp_carrito.setPrecio(Integer.toString(i.getPrecioInsumo()));
        i.cargainsumos2(1);
        String nombrein, cantidadin, precioin;
        nombrein = i.getNombreInsumo();
        cantidadin = Integer.toString(i.getCantidadInsumo());
        precioin = Integer.toString(i.getPrecioInsumo());
//            precioproducto = i.getIdInsumo();
//            i = (Insumos) iterador2.next();
//            String insumo = i.getNombreInsumo();
//            int cantidad = i.getCantidadInsumo();
//            String medida = i.getMedidaInsumo();
//            int precio = i.getPrecioInsumo();

        tx_insumos.setText(nombrein + " " + cantidadin + " " + precioin);
//            String datos[] = {insumo, String.valueOf(cantidad), medida, String.valueOf(precio)};
//            dtm.addRow(datos);

//        }
    }

    public final void cargaprecio() {
        try {
            ArrayList r;
            Iterator iterador;
            Producto i = new Producto();
            r = i.cargar();

            iterador = r.iterator();
            while (iterador.hasNext()) {
                i = (Producto) iterador.next();
                int precioProducto = i.getPrecioProducto();

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

    public double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10, decimales)) / Math.pow(10, decimales);
    }

    private void suma() {
        int total = 0;
        //recorrer todas las filas de la segunda columna y va sumando las cantidades
        for (int i = 0; i < dtm.getRowCount(); i++) {
            int numero = 0;
            try {
                //capturamos valor de celda
                numero = Integer.valueOf(dtm.getValueAt(i, 2).toString());
            } catch (NumberFormatException nfe) { //si existe un error se coloca 0 a la celda
                numero = 0;
                dtm.setValueAt(0, i, 1);
            }
            //se suma al total
            total += numero;
        }
        //muestra en el componente
        this.tf_netoPedido.setText(String.valueOf(total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_clienteVentas = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        tf_cantidadCotizacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_filtroProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jt_productos = new javax.swing.JTable();
        bt_agregarCotizacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_detallepedido = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tf_netoPedido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_descuentoPedido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_totalPedido = new javax.swing.JTextField();
        tf_ingresarVenta = new javax.swing.JButton();
        bt_ingresarFiado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_totalInsumos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tx_insumos = new javax.swing.JTextArea();
        bt_generarCotizacion = new javax.swing.JButton();
        bt_nuevoCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btn_volver2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jlabel_fecha1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlabel_fecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTAS - Easystem v1.0");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cliente");

        cb_clienteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clienteVentasActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tf_cantidadCotizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cantidadCotizacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_cantidadCotizacionKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cantidad");

        tf_filtroProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_filtroProductoActionPerformed(evt);
            }
        });
        tf_filtroProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_filtroProductoKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Filtro Producto");

        jt_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jt_productos);

        bt_agregarCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Add.png"))); // NOI18N
        bt_agregarCotizacion.setText("Agregar Al Pedido");
        bt_agregarCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_agregarCotizacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_filtroProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(tf_cantidadCotizacion)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bt_agregarCotizacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_filtroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cantidadCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_agregarCotizacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jt_detallepedido.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jt_detallepedidoComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(jt_detallepedido);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Total Neto");

        tf_netoPedido.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("%Descuento");

        tf_descuentoPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_descuentoPedidoFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("TOTAL");

        tf_totalPedido.setEditable(false);
        tf_totalPedido.setEnabled(false);
        tf_totalPedido.setFocusable(false);

        tf_ingresarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Shopping cart.png"))); // NOI18N
        tf_ingresarVenta.setText("Ingresar Venta");
        tf_ingresarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ingresarVentaActionPerformed(evt);
            }
        });

        bt_ingresarFiado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Dollar.png"))); // NOI18N
        bt_ingresarFiado.setText("Ingresar como Fiado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_ingresarFiado)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_ingresarVenta)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_netoPedido)
                            .addComponent(tf_descuentoPedido)
                            .addComponent(tf_totalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_netoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_descuentoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_totalPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_ingresarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_ingresarFiado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Insumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Total");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("MARGEN DE GANANCIA :");

        tx_insumos.setColumns(20);
        tx_insumos.setRows(5);
        jScrollPane4.setViewportView(tx_insumos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(182, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(41, 41, 41)
                        .addComponent(tf_totalInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_totalInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_generarCotizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Text preview.png"))); // NOI18N
        bt_generarCotizacion.setText("GENERAR COTIZACION");

        bt_nuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Male.png"))); // NOI18N
        bt_nuevoCliente.setText("Nuevo Cliente");
        bt_nuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nuevoClienteActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

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

        jlabel_fecha1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel_fecha1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Usuario Conectado: Admin");

        jlabel_fecha.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jlabel_fecha.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Hora de Conexión");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(276, 276, 276)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jlabel_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_volver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_generarCotizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_clienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_nuevoCliente)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_clienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_nuevoCliente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_generarCotizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ingresarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ingresarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ingresarVentaActionPerformed

    private void bt_nuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nuevoClienteActionPerformed
        FClientes mi_ventana = FClientes.getInstancia();
        mi_ventana.setVisible(true);
    }//GEN-LAST:event_bt_nuevoClienteActionPerformed

    private void bt_agregarCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_agregarCotizacionActionPerformed

        try {
            cargarinsumosporproducto();
        } catch (SQLException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        }

//Selecciona el dato de la tabla mediante el index y lo envia a la tabla detalle pedido
        int selectedRowIndex = jt_productos.getSelectedRow();
        int selectedColumnIndex = jt_productos.getSelectedColumn();
        String productonew = (String) jt_productos.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
        ArrayList r = null;
        Iterator iterador;
        Producto p = new Producto();
        try {
            int cantidadproducto = Integer.valueOf(tf_cantidadCotizacion.getText());
            r = p.cargarprecio(productonew, cantidadproducto);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        }

        iterador = r.iterator();
        while (iterador.hasNext()) {
            p = (Producto) iterador.next();
            int precioProducto = p.getPrecioProducto();
            String cantidadproducto = tf_cantidadCotizacion.getText();
            String datos[] = {productonew, cantidadproducto, String.valueOf(precioProducto)};
            dtm.addRow(datos);
            jt_detallepedido.setModel(dtm);
            tf_cantidadCotizacion.setText("");
            suma();
        }

    }//GEN-LAST:event_bt_agregarCotizacionActionPerformed

    private void cb_clienteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clienteVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_clienteVentasActionPerformed

    private void btn_volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volver2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volver2ActionPerformed

    private void tf_filtroProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_filtroProductoKeyPressed
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm2);
        jt_productos.setRowSorter(sorter);
        String text = tf_filtroProducto.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_tf_filtroProductoKeyPressed

    private void tf_descuentoPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_descuentoPedidoFocusLost
        double valor = Double.parseDouble(this.tf_netoPedido.getText());
        double porcentajedescuento = Double.parseDouble(this.tf_descuentoPedido.getText());
        double descuento = (porcentajedescuento / 100) * valor;
        double valorfinal = valor - descuento;
        this.tf_totalPedido.setText(Double.toString(redondear(valorfinal, 0)));
    }//GEN-LAST:event_tf_descuentoPedidoFocusLost

    private void jt_detallepedidoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jt_detallepedidoComponentAdded
        try {
            cargarinsumosporproducto();
        } catch (SQLException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jt_detallepedidoComponentAdded

    private void tf_cantidadCotizacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cantidadCotizacionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cantidadCotizacionKeyPressed

    private void tf_cantidadCotizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cantidadCotizacionKeyTyped
        char c = evt.getKeyChar();

        if (Character.isDigit(c) == false && (c != KeyEvent.VK_BACK_SPACE)) {
            /*se activara solo cuando no se ingresen letras al jtexbox*/
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros", "Aviso Easystem",
                    JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
            this.tf_cantidadCotizacion.setText("");
            this.tf_cantidadCotizacion.requestFocus();
        }
    }//GEN-LAST:event_tf_cantidadCotizacionKeyTyped

    private void tf_filtroProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_filtroProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_filtroProductoActionPerformed

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
            java.util.logging.Logger.getLogger(FVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FVentas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FVentas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_agregarCotizacion;
    private javax.swing.JButton bt_generarCotizacion;
    private javax.swing.JButton bt_ingresarFiado;
    private javax.swing.JButton bt_nuevoCliente;
    private javax.swing.JButton btn_volver2;
    private javax.swing.JComboBox cb_clienteVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlabel_fecha;
    private javax.swing.JLabel jlabel_fecha1;
    private javax.swing.JTable jt_detallepedido;
    private javax.swing.JTable jt_productos;
    private javax.swing.JTextField tf_cantidadCotizacion;
    private javax.swing.JTextField tf_descuentoPedido;
    private javax.swing.JTextField tf_filtroProducto;
    private javax.swing.JButton tf_ingresarVenta;
    private javax.swing.JTextField tf_netoPedido;
    private javax.swing.JTextField tf_totalInsumos;
    private javax.swing.JTextField tf_totalPedido;
    private javax.swing.JTextArea tx_insumos;
    // End of variables declaration//GEN-END:variables
}
