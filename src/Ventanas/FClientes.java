/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Cliente;
import Clases.FixedSizeDocument;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;

/**
 *
 * @author Gupi
 */
public class FClientes extends javax.swing.JFrame {

    /**
     * Creates new form FClientes
     */
    private static FClientes instancia;
    private DefaultTableModel dtm;
    final Cliente cl;

    private static final String[] nombreColumnas = {"RUT ", "NOMBRE ", "DIRECCION", "EMPRESA", "TELEFONO", "MAIL", "TIPO"};

    private FClientes() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.cl = new Cliente();
        this.tf_rutCliente.setEnabled(false);
        tf_rutCliente.setDocument(new FixedSizeDocument(9));
        this.tf_nombreCliente.setEnabled(false);
        this.tf_direccionCliente.setEnabled(false);
        this.tf_empresaCliente.setEnabled(false);
        this.tf_telefonoCliente.setEnabled(false);
        tf_telefonoCliente.setDocument(new FixedSizeDocument(15));
        this.tf_mail.setEnabled(false);
        this.bt_anadir.setEnabled(true);
        this.bt_guardarNuevoCliente.setEnabled(false);
        cargarTabla();

    }

    public static FClientes getInstancia() {
        if (instancia == null) {
            instancia = new FClientes();
        }
        return instancia;

    }

    public void fecha() {
        Calendar cal = Calendar.getInstance();
        java.util.Date fecha = cal.getTime();
        DateFormat formatter = DateFormat.getTimeInstance();
        jlabel_fecha.setText(formatter.format(fecha));
    }

    static public String formatear(String rut) {
        int cont = 0;
        String format;
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        format = "-" + rut.substring(rut.length() - 1);
        for (int i = rut.length() - 2; i >= 0; i--) {
            format = rut.substring(i, i + 1) + format;
            cont++;
            if (cont == 3 && i != 0) {
                format = "." + format;
                cont = 0;
            }
        }
        return format;

    }

    static public boolean validar(String rut) {
        int dvR, dvT, suma = 0;
        int[] serie = {2, 3, 4, 5, 6, 7};
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        dvR = Integer.valueOf(rut.substring(rut.length() - 1));
        for (int i = rut.length() - 2; i >= 0; i--) {
            suma += Integer.valueOf(rut.substring(i, i + 1)) * serie[(rut.length() - 2 - i) % 6];
        }
        dvT = 11 - suma % 11;
        return dvT == dvR;
    }

    private void cargarTabla() {
        ArrayList<Cliente> r;
        Iterator<Cliente> iterador;
        Cliente alguno;
        Object[][] data;
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry entry) {
                String nombre = (String) entry.getValue(1);
                nombre = txt_filtro.getText();
                return true;
            }
        };
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
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtm.setDataVector(data, nombreColumnas);
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
            sorter.setRowFilter(filter);
            jt_registros.setRowSorter(sorter);

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

    public void limpiar() {
        this.tf_rutCliente.setText("");
        this.tf_nombreCliente.setText("");
        this.tf_direccionCliente.setText("");
        this.tf_empresaCliente.setText("");
        this.tf_telefonoCliente.setText("");
        this.tf_mail.setText("");
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
        mi_editar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_registros = new javax.swing.JTable();
        bt_abonar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_rutCliente = new javax.swing.JTextField();
        tf_nombreCliente = new javax.swing.JTextField();
        tf_empresaCliente = new javax.swing.JTextField();
        tf_telefonoCliente = new javax.swing.JTextField();
        tf_mail = new javax.swing.JTextField();
        tf_direccionCliente = new javax.swing.JTextField();
        bt_guardarNuevoCliente = new javax.swing.JButton();
        bt_anadir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_tipocliente = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        btn_volver = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jlabel_fecha = new javax.swing.JLabel();
        jlabel_fecha2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        mi_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Modify.png"))); // NOI18N
        mi_editar.setText("Editar");
        mi_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_editarActionPerformed(evt);
            }
        });
        pu_editar.add(mi_editar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES - Easystem v1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de los Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jt_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rut", "Nombre", "Direccion", "Empresa", "Telefono", "Email"
            }
        ));
        jt_registros.setComponentPopupMenu(pu_editar);
        jt_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jt_registrosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jt_registros);

        bt_abonar.setText("Abonar");
        bt_abonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_abonarActionPerformed(evt);
            }
        });

        jLabel8.setText("Buscar:");

        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_filtroKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_abonar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_abonar)
                    .addComponent(jLabel8)
                    .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Rut");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Direccion");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Empresa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Telefono");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Email");

        tf_rutCliente.setToolTipText("");

        tf_nombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_nombreClienteKeyTyped(evt);
            }
        });

        tf_empresaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_empresaClienteKeyTyped(evt);
            }
        });

        tf_telefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_telefonoClienteKeyTyped(evt);
            }
        });

        bt_guardarNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Save.png"))); // NOI18N
        bt_guardarNuevoCliente.setText("Guardar");
        bt_guardarNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_guardarNuevoClienteActionPerformed(evt);
            }
        });

        bt_anadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/User group.png"))); // NOI18N
        bt_anadir.setText("Añadir");
        bt_anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_anadirActionPerformed(evt);
            }
        });

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Ventanas/Iconos/24x24/Erase.png"))); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tipo");

        cb_tipocliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Particular", "Empresa" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(bt_anadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_guardarNuevoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_empresaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(59, 71, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_mail, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(cb_tipocliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_empresaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_rutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_telefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_guardarNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_anadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_tipocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Volver");

        jlabel_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel_fecha.setForeground(new java.awt.Color(255, 255, 255));

        jlabel_fecha2.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jlabel_fecha2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(413, 413, 413)
                .addComponent(jlabel_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(90, 90, 90)
                .addComponent(jlabel_fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlabel_fecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_abonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_abonarActionPerformed
        try {
            FAbono mi_ventana = FAbono.getInstancia();
            mi_ventana.setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_bt_abonarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            this.cl.cargar();
            this.cargarTabla();

        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.sql.SQLException e) {
            JOptionPane.showMessageDialog(null, "Descripcion : " + e.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void mi_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_editarActionPerformed
        this.tf_rutCliente.setText(String.valueOf(this.cl.getRutCliente()));
        this.tf_nombreCliente.setText(this.cl.getNombreCliente());
        this.tf_direccionCliente.setText(this.cl.getDireccionCliente());
        this.tf_empresaCliente.setText(this.cl.getEmpresaCliente());
        this.tf_telefonoCliente.setText(String.valueOf(this.cl.getTelefonoCliente()));
        this.tf_mail.setText(this.cl.getMailCliente());

        //habilitamos nuevamente
        this.tf_rutCliente.requestFocus();
        this.tf_rutCliente.setEnabled(true);
        this.tf_nombreCliente.setEnabled(true);
        this.tf_direccionCliente.setEnabled(true);
        this.tf_empresaCliente.setEnabled(true);
        this.tf_telefonoCliente.setEnabled(true);
        this.tf_mail.setEnabled(true);
        this.bt_guardarNuevoCliente.setEnabled(true);


    }//GEN-LAST:event_mi_editarActionPerformed

    private void jt_registrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_registrosMousePressed
        int fila = this.jt_registros.rowAtPoint(evt.getPoint());
        int columna = this.jt_registros.columnAtPoint(evt.getPoint());
        /* Muestra los datos en la ventana de edición si corresponde */
        if ((fila > -1) && (columna > -1)) {
            this.cl.setRutCliente((String) this.dtm.getValueAt(fila, 0));
            this.cl.setNombreCliente((String) this.dtm.getValueAt(fila, 1));
            this.cl.setDireccionCliente((String) this.dtm.getValueAt(fila, 2));
            this.cl.setEmpresaCliente((String) this.dtm.getValueAt(fila, 3));
            this.cl.setTelefonoCliente((Integer) this.dtm.getValueAt(fila, 4));
            this.cl.setMailCliente((String) this.dtm.getValueAt(fila, 5));
            this.cl.setTipoCliente((String) this.dtm.getValueAt(fila, 6));

        }


    }//GEN-LAST:event_jt_registrosMousePressed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        limpiar();
        this.tf_rutCliente.setEnabled(false);
        this.tf_nombreCliente.setEnabled(false);
        this.tf_direccionCliente.setEnabled(false);
        this.tf_empresaCliente.setEnabled(false);
        this.tf_telefonoCliente.setEnabled(false);
        this.tf_mail.setEnabled(false);
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_anadirActionPerformed
        this.tf_rutCliente.setEnabled(true);
        this.tf_nombreCliente.setEnabled(true);
        this.tf_direccionCliente.setEnabled(true);
        this.tf_empresaCliente.setEnabled(true);
        this.tf_telefonoCliente.setEnabled(true);
        this.tf_mail.setEnabled(true);
        this.bt_guardarNuevoCliente.setEnabled(true);
        limpiar();

    }//GEN-LAST:event_bt_anadirActionPerformed

    private void bt_guardarNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_guardarNuevoClienteActionPerformed

        System.out.println(formatear(this.tf_rutCliente.getText()));
        String email = this.tf_mail.getText();
        String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(email);

        if (m.find()) {
            this.cl.setRutCliente(this.tf_rutCliente.getText());
            this.cl.setNombreCliente(this.tf_nombreCliente.getText());
            this.cl.setDireccionCliente(this.tf_direccionCliente.getText());
            this.cl.setEmpresaCliente(this.tf_empresaCliente.getText());
            this.cl.setTelefonoCliente(Integer.parseInt(this.tf_telefonoCliente.getText()));
            this.cl.setMailCliente(this.tf_mail.getText());
            this.cl.setTipoCliente(this.cb_tipocliente.getSelectedItem().toString());
            try {
                this.cl.grabar();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                Logger.getLogger(FClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Registro guardado con exito");
            this.tf_rutCliente.setText("");
            this.tf_nombreCliente.setText("");
            this.tf_direccionCliente.setText("");
            this.tf_empresaCliente.setText("");
            this.tf_telefonoCliente.setText("");
            this.tf_mail.setText("");
            this.tf_rutCliente.setEnabled(false);
            this.tf_nombreCliente.setEnabled(false);
            this.tf_direccionCliente.setEnabled(false);
            this.tf_empresaCliente.setEnabled(false);
            this.tf_telefonoCliente.setEnabled(false);
            this.tf_mail.setEnabled(false);
            cargarTabla();

            this.bt_guardarNuevoCliente.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Email Invalido");
            this.tf_mail.requestFocus();
        }

        cargarTabla();

    }//GEN-LAST:event_bt_guardarNuevoClienteActionPerformed

    private void tf_telefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_telefonoClienteKeyTyped
        char c = evt.getKeyChar();

        if (Character.isDigit(c) == false && (c != KeyEvent.VK_BACK_SPACE)) {
            /*se activara solo cuando no se ingresen letras al jtexbox*/
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros", "Aviso Easystem",
                    JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
            this.tf_telefonoCliente.requestFocus();
        }
    }//GEN-LAST:event_tf_telefonoClienteKeyTyped

    private void tf_empresaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_empresaClienteKeyTyped
        char c = evt.getKeyChar();

        if (Character.isDigit(c) == false) {

        } else {
            /*se activa solo cuando no se le ingresan numeros al textBox*/
            JOptionPane.showMessageDialog(null, "Ingrese solo letras", "Aviso Easystem",
                    JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
            this.tf_empresaCliente.requestFocus();
        }
    }//GEN-LAST:event_tf_empresaClienteKeyTyped

    private void tf_nombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nombreClienteKeyTyped
        char c = evt.getKeyChar();

        if (Character.isDigit(c) == false) {

        } else {
            /*se activa solo cuando no se le ingresan numeros al textBox*/
            JOptionPane.showMessageDialog(null, "Ingrese solo letras", "Aviso Easystem",
                    JOptionPane.INFORMATION_MESSAGE);
            evt.consume();
            this.tf_nombreCliente.requestFocus();
        }
    }//GEN-LAST:event_tf_nombreClienteKeyTyped

    private void txt_filtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyPressed
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        jt_registros.setRowSorter(sorter);
        String text = txt_filtro.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }//GEN-LAST:event_txt_filtroKeyPressed

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
            java.util.logging.Logger.getLogger(FClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FClientes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FClientes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_abonar;
    private javax.swing.JButton bt_anadir;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_guardarNuevoCliente;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox cb_tipocliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel_fecha;
    private javax.swing.JLabel jlabel_fecha2;
    private javax.swing.JTable jt_registros;
    private javax.swing.JMenuItem mi_editar;
    private javax.swing.JPopupMenu pu_editar;
    private javax.swing.JTextField tf_direccionCliente;
    private javax.swing.JTextField tf_empresaCliente;
    private javax.swing.JTextField tf_mail;
    private javax.swing.JTextField tf_nombreCliente;
    private javax.swing.JTextField tf_rutCliente;
    private javax.swing.JTextField tf_telefonoCliente;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
