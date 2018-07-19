/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marvelsgroup;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp-pc
 */
public class OrderFrame extends javax.swing.JFrame {

    private Connection conn;
    DefaultTableModel model;
    public OrderFrame() {
        initComponents();
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        model=(DefaultTableModel)displaylist.getModel();
        conn=MySQLConnect.ConnectDB();
        filler();
    }
    
    private void filler()
    {
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select medname from medicines order by medname";
        try
        {
            pst=conn.prepareStatement(st);
            rs=pst.executeQuery();
            while(rs.next())
            {
                searchmedname.addItem(rs.getString(1).toUpperCase());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        orderqty = new javax.swing.JTextField();
        placeorderbutton = new javax.swing.JButton();
        cancelorderbutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        currentordersbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        costbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaylist = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchmedname = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(691, 438));
        setSize(new java.awt.Dimension(691, 438));

        availbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        availbutton.setText("Check Availability");
        availbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availbuttonActionPerformed(evt);
            }
        });

        orderqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                orderqtyFocusGained(evt);
            }
        });
        orderqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                orderqtyKeyTyped(evt);
            }
        });

        placeorderbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        placeorderbutton.setText("Place Order");
        placeorderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeorderbuttonActionPerformed(evt);
            }
        });

        cancelorderbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelorderbutton.setForeground(java.awt.Color.red);
        cancelorderbutton.setText("Cancel");
        cancelorderbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelorderbuttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Order Quantity");

        currentordersbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        currentordersbutton.setText("Show Current Orders");
        currentordersbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentordersbuttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cost/Unit");

        costbox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                costboxFocusGained(evt);
            }
        });

        displaylist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Medicine Name", "Quantity", "Cost/Unit"
            }
        ));
        jScrollPane1.setViewportView(displaylist);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("abc");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(java.awt.Color.red);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText(".");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 157));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Place Orders");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Medicine Name");

        searchmedname.setEditable(true);
        searchmedname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchmedname.setMaximumRowCount(10);
        searchmedname.setInheritsPopupMenu(true);
        searchmedname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchmednameFocusLost(evt);
            }
        });
        searchmedname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchmednameActionPerformed(evt);
            }
        });
        searchmedname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchmednameKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(availbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentordersbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(orderqty)
                .addGap(25, 25, 25)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costbox)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(placeorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel2)
                .addContainerGap(421, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchmedname, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchmedname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(availbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentordersbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(placeorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelorderbutton, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
     private void display(ResultSet rs, String p)
    {
        
        model.setRowCount(0);
        try
        {
        do
        {
            Object[] obj ={rs.getInt(p),rs.getString("medname"),rs.getInt("qty"),rs.getInt("cost")}; 
            model.addRow(obj);
        }while(rs.next());

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
     
   
    
    private void placeorderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeorderbuttonActionPerformed
        try
        {
            String oqty=orderqty.getText();
            int ioqty=Integer.parseInt(oqty);
            PreparedStatement pst=null;
            pst=conn.prepareStatement("insert into userorder(medname, qty, cost) values(?,?,?)");
            pst.setString(1,((String)searchmedname.getSelectedItem()).toLowerCase());
            pst.setInt(2, ioqty);
            pst.setInt(3, Integer.parseInt(costbox.getText()));
            int no=pst.executeUpdate();
            if(no==1)
            {   
                model.setRowCount(0);
                jLabel6.setVisible(false);
                jLabel5.setVisible(false);
                JOptionPane.showMessageDialog(this, "Order Placed Successfully!");
            }
            else
            {
                model.setRowCount(0);
                jLabel6.setVisible(false);
                jLabel5.setVisible(false);
                JOptionPane.showMessageDialog(this, "Something's wrong here!");
            }
        }
        catch(Exception e)
        {
            jLabel5.setVisible(false);
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_placeorderbuttonActionPerformed

    private void availbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availbuttonActionPerformed
        jLabel6.setVisible(false);
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select * from medicines where medname=?";
        
        try{
            pst=conn.prepareStatement(st);
            pst.setString(1, ((String)searchmedname.getSelectedItem()).toLowerCase());
            rs=pst.executeQuery();
            if(rs.first())
            {
                jLabel5.setText("AVAILABLE STOCKS");
                jLabel5.setVisible(true);
                display(rs, "ID");
            }
            else
            {
                jLabel5.setText("AVAILABLE STOCKS");
                jLabel5.setVisible(true);
                model.setRowCount(0);
                jLabel6.setText("Stocks Empty!");
                jLabel6.setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_availbuttonActionPerformed

    private void currentordersbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentordersbuttonActionPerformed
        jLabel6.setVisible(false);
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select * from userorder where medname=?";
        try{
            pst=conn.prepareStatement(st);
            pst.setString(1, ((String)searchmedname.getSelectedItem()).toLowerCase());
            rs=pst.executeQuery();
            if(rs.first())
            {
                jLabel5.setText("CURRENT ORDERS");
                jLabel5.setVisible(true);
                display(rs, "OID");
            }
            else
            {
                jLabel5.setText("CURRENT ORDERS");
                jLabel5.setVisible(true);
                model.setRowCount(0);
                jLabel6.setText("No Current Order(s) Of "+((String)searchmedname.getSelectedItem()).toUpperCase()+"!");
                jLabel6.setVisible(true);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_currentordersbuttonActionPerformed

    private void cancelorderbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelorderbuttonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelorderbuttonActionPerformed
          
    private void orderqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderqtyKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_orderqtyKeyTyped

    private void searchmednameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchmednameKeyTyped
    /*    searchmedname.removeAllItems();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select medname from medicines where medname like ?";
        String x=((String) searchmedname.getSelectedItem());
        try
        {
            pst=conn.prepareStatement(st);
            pst.setString(1,x.toLowerCase()+"%");
            rs=pst.executeQuery();
            searchmedname.addItem(x);
            while(rs.next())
            {
                searchmedname.addItem(rs.getString(1).toUpperCase());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }*/
    }//GEN-LAST:event_searchmednameKeyTyped

    private void searchmednameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchmednameActionPerformed
    /*    searchmedname.removeAllItems();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select medname from medicines where medname like ?";
        String x=((String) searchmedname.getItemAt(0));
        try
        {
            pst=conn.prepareStatement(st);
            pst.setString(1,x.toLowerCase()+"%");
            rs=pst.executeQuery();
            searchmedname.addItem(x);
            while(rs.next())
            {
                searchmedname.addItem(rs.getString(1).toUpperCase());
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }        // TODO add your handling code here:*/
    }//GEN-LAST:event_searchmednameActionPerformed

    private void costboxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_costboxFocusGained
jLabel6.setVisible(false);
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select cost from medicines where medname=?";
        
        try{
            pst=conn.prepareStatement(st);
            pst.setString(1, ((String)searchmedname.getSelectedItem()).toLowerCase());
            rs=pst.executeQuery();
            if(rs.first())
            {
                costbox.setText(rs.getInt(1)+"");
            }       
            else
            {
                costbox.setText("");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_costboxFocusGained

    private void orderqtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_orderqtyFocusGained
jLabel6.setVisible(false);
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select cost from medicines where medname=?";
        
        try{
            pst=conn.prepareStatement(st);
            pst.setString(1, ((String)searchmedname.getSelectedItem()).toLowerCase());
            rs=pst.executeQuery();
            if(rs.first())
            {
                costbox.setText(rs.getInt(1)+"");
            }       
            else
            {
                costbox.setText("");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_orderqtyFocusGained

    private void searchmednameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchmednameFocusLost
        
    }//GEN-LAST:event_searchmednameFocusLost

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
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton availbutton;
    private javax.swing.JButton cancelorderbutton;
    private javax.swing.JTextField costbox;
    private javax.swing.JButton currentordersbutton;
    private javax.swing.JTable displaylist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderqty;
    private javax.swing.JButton placeorderbutton;
    private javax.swing.JComboBox<String> searchmedname;
    // End of variables declaration//GEN-END:variables
}
