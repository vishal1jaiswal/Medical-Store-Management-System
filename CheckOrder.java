/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvelsgroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp-pc
 */
public class CheckOrder extends javax.swing.JFrame {

    /**
     * Creates new form CheckOrder
     */
    DefaultTableModel model;
    private Connection conn;
    public CheckOrder() {
        initComponents();
        jLabel4.setVisible(false);
        conn=MySQLConnect.ConnectDB();
        model=(DefaultTableModel)orderList.getModel();
        refreshfunction();
        
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
        deleteorderbutton = new javax.swing.JButton();
        orderidinput = new javax.swing.JTextField();
        cancelbutton = new javax.swing.JButton();
        closeorderbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderList = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(691, 438));
        setSize(new java.awt.Dimension(691, 438));

        deleteorderbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteorderbutton.setText("Delete Order");
        deleteorderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteorderbuttonActionPerformed(evt);
            }
        });

        cancelbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelbutton.setForeground(java.awt.Color.red);
        cancelbutton.setText("Cancel");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });

        closeorderbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closeorderbutton.setText("Accept Order");
        closeorderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeorderbuttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Order ID");

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("  NO CURRENT ORDERS!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cancelbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(closeorderbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(orderidinput, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderidinput))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        orderList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Medicine Name", "Quantity", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(orderList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 157));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Check Orders");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     private void display(ResultSet rs)
    {
        DefaultTableModel model=(DefaultTableModel)orderList.getModel();
        model.setRowCount(0);
        try
        {
        do
        {
            Object[] obj ={rs.getInt("OID"),rs.getString("medname"),rs.getInt("qty"),rs.getInt("cost")}; 
            model.addRow(obj);
        }while(rs.next());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    private void refreshfunction()
    {
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select * from userorder";
        try{
            pst=conn.prepareStatement(st);
            rs=pst.executeQuery();
            if(rs.first())
            {
                jLabel4.setVisible(false);
                display(rs);
            }
            else
            {
                model.setRowCount(0);
                jLabel4.setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void deleteorderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteorderbuttonActionPerformed
        deletefunc();
    }//GEN-LAST:event_deleteorderbuttonActionPerformed

    private void deletefunc()
    {
        PreparedStatement pst=null;
        String st="delete from userorder where OID=?";
        try{
            pst=conn.prepareStatement(st);
            String soid=orderidinput.getText();
            int oid=Integer.parseInt(soid);
            pst.setInt(1, oid);
            int no=pst.executeUpdate();
            if(no==0)
            {
                JOptionPane.showMessageDialog(this, "Order Not Found");
            }
            refreshfunction();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error Occured!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void closeorderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeorderbuttonActionPerformed
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select * from userorder where OID=?";
        try{
            pst=conn.prepareStatement(st);
            String soid=orderidinput.getText();
            int oid=Integer.parseInt(soid);
            pst.setInt(1, oid);
            rs=pst.executeQuery();
            if(rs.first())
            {
                int addon=rs.getInt("qty");
                String mname=rs.getString("medname").toLowerCase();
                int cst=rs.getInt("cost");
                PreparedStatement pst2=null;
                String st2="select * from medicines where medname=?";
                pst2=conn.prepareStatement(st2);
                pst2.setString(1, mname);
                rs=null;
                rs=pst2.executeQuery();
                //int check=pst2.executeUpdate();
                if(rs.first())
                {
                    int total=addon+rs.getInt("qty");
                    PreparedStatement pst3=null;
                    String st3="update medicines set qty=? where medname=?";
                    pst3=conn.prepareStatement(st3);
                    pst3.setInt(1, total);
                    pst3.setString(2, mname.toLowerCase());
                    int check=pst3.executeUpdate();
                    if(check==1)
                    {
                        JOptionPane.showMessageDialog(this, "Order closed!");
                        deletefunc();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Something's wrong dude!");
                    }
                }
                else if(!rs.first())
                {
                    PreparedStatement pst3=null;
                    String st3="insert into medicines (medname, qty, cost, compartment) values(?,?,?,?)";
                    pst3=conn.prepareStatement(st3);
                    pst3.setInt(2, addon);
                    pst3.setString(1, mname.toLowerCase());
                    pst3.setInt(3, cst);
                    String cmp=new String();
                    cmp=JOptionPane.showInputDialog(this, "Enter the compartment:", cmp, 1);
                    pst3.setString(4, cmp);
                    int check=pst3.executeUpdate();
                    if(check==1)
                    {
                        JOptionPane.showMessageDialog(this, "Order closed!");
                        deletefunc();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Something's wrong dude!");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "No Results Found!");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_closeorderbuttonActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void orderListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderListMouseClicked
        int i=orderList.getSelectedRow();
        orderidinput.setText(orderList.getValueAt(i, 0)+"");
        
    }//GEN-LAST:event_orderListMouseClicked

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
            java.util.logging.Logger.getLogger(CheckOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOrder().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton closeorderbutton;
    private javax.swing.JButton deleteorderbutton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderList;
    private javax.swing.JTextField orderidinput;
    // End of variables declaration//GEN-END:variables
}
