
package Views;

import Model.*;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewUserMenu extends javax.swing.JFrame {
    ClsConnection connection = new ClsConnection();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTabla;
    
    public ViewUserMenu() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.loadTableEmployee();
    }

    //se crea el metodo que lista los empleados de la bd
    private void loadTableEmployee(){
        String search = txtSearchEmpl.getText();
        
        if(search.isEmpty()){
            String query = "SELECT * FROM empleados";
            try{
            
                cn = connection.getConnection();
                //Creamos el queryConsulta

                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta

                rs = st.executeQuery(query);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos

                Object[] empleados = new Object[6];
                contenidoTabla = (DefaultTableModel) tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentr registros en la
                // base de datos se ingresa al while
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);

                    tblEmpleados.setModel(contenidoTabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al cargar los datos en la tabla");
            }
        }else{
            String query = "SELECT * FROM empleados WHERE nombreEmp like '%"+ search +"%' OR apellidos like '%"+ search +"%';";
            try{
            
                cn = connection.getConnection();
                //Creamos el queryConsulta

                st = cn.createStatement();
                // Ejecutamos el query que contiene la variable queryConsulta

                rs = st.executeQuery(query);
                // Creamos un objeto que almacena todos los registros de empleados
                // que existen en la base de datos

                Object[] empleados = new Object[6];
                contenidoTabla = (DefaultTableModel) tblEmpleados.getModel();
                // Mientras el resultado del queryConsulta encuentr registros en la
                // base de datos se ingresa al while
                while (rs.next()) {
                    empleados[0] = rs.getInt("idEmp");
                    empleados[1] = rs.getString("nombreEmp");
                    empleados[2] = rs.getString("apellidos");
                    empleados[3] = rs.getString("tipoDocumento");
                    empleados[4] = rs.getString("documento");
                    empleados[5] = rs.getString("correo");
                    contenidoTabla.addRow(empleados);

                    tblEmpleados.setModel(contenidoTabla);
                }

            } catch (SQLException e) {
                System.out.println("Error al cargar los datos en la tabla");
            }
        }
    }
    
    private void deleteRowTable(){
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTabla.removeRow(i);
            i=i-1;
        }
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnSearchEmpl = new javax.swing.JButton();
        txtSearchEmpl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Images/logo.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "Nombre", "Apellidos", "Tipo Documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tblEmpleados.getColumnModel().getColumn(5).setResizable(false);
        }

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Images/addUser (1).jpeg"))); // NOI18N
        btnAddUser.setText("Adicionar");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnSearchEmpl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Images/search1 (1).png"))); // NOI18N
        btnSearchEmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmplActionPerformed(evt);
            }
        });

        txtSearchEmpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchEmplKeyReleased(evt);
            }
        });

        jLabel4.setText("Nombre empleado");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(txtSearchEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchEmpl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("INFORMACÍON DE EMPLEADOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(121, 121, 121)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        ViewAddUser addUser = new ViewAddUser(this, true);
        addUser.setVisible(true);
        deleteRowTable();
        loadTableEmployee();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnSearchEmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmplActionPerformed
       
       deleteRowTable();
       loadTableEmployee();
        
        
    }//GEN-LAST:event_btnSearchEmplActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada " + row);
        if (row<0){
            JOptionPane.showMessageDialog(this, "Seleccione un empleado", "", JOptionPane.WARNING_MESSAGE);
        }else{
            int id = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            String nombre = (String)tblEmpleados.getValueAt(row, 1);
            String apellidos = (String)tblEmpleados.getValueAt(row, 2);
            String tipoDocumento = (String)tblEmpleados.getValueAt(row, 3);
            String documento = (String)tblEmpleados.getValueAt(row, 4);
            String email = (String)tblEmpleados.getValueAt(row, 5);
            
            System.out.println("id " +id +" nombre " +nombre + " apellidos " + apellidos + " tipo doc " + tipoDocumento+ " documento " + documento + " correo " +email);
            ViewShowUser showUser = new ViewShowUser(this, true);
            showUser.receiveDataViewUserMenu(id, nombre, apellidos, tipoDocumento, documento, email);
            showUser.setVisible(true);
            
            // se cargan nuevament los datos en la tabla
            deleteRowTable();
            loadTableEmployee();
        }
        
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void txtSearchEmplKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchEmplKeyReleased
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            deleteRowTable();
            loadTableEmployee();
        }

       
    }//GEN-LAST:event_txtSearchEmplKeyReleased

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
            java.util.logging.Logger.getLogger(ViewUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSearchEmpl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearchEmpl;
    // End of variables declaration//GEN-END:variables
}
