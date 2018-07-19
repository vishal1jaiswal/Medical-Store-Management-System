package marvelsgroup;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class BillClass extends javax.swing.JFrame {
    
    
    Thread t ;
    private Connection conn=null;
    private float total;
    ArrayList<BillMedsClass> arra=new ArrayList<BillMedsClass>();
    public BillClass() 
    {
        initComponents();
        conn=MySQLConnect.ConnectDB();
        filler();
        total=0;
        jLabel6.setVisible(false);
        qtybox.setEditable(false);
        addbutton.setEnabled(false);
        delbutton.setEnabled(false);
        
        nextbutton.setEnabled(false);
        
        
        
        t = new Thread(new Runnable() {
            @Override
            public void run() {

                 qtybox.setBorder(BorderFactory.createLineBorder(Color.RED));

            }
            
        });
       
    }
    private void filler()
    {
        PreparedStatement pst=null;
        ResultSet rs=null;
        String st="Select medname, qty, cost from medicines where medname like ?";
        try
        {
            pst=conn.prepareStatement(st);
            pst.setString(1, mednamebox.getText().toLowerCase()+"%");
            rs=pst.executeQuery();
            displaynames(rs);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }
   public BillClass(ArrayList<BillMedsClass> x, float tot)
    {
        initComponents();
        filler();
        arra = (ArrayList<BillMedsClass>)x.clone();
        total=tot;
        jLabel6.setVisible(false);
        qtybox.setEditable(false);
        addbutton.setEnabled(false);
        delbutton.setEnabled(false);
        
        display();
        totalbox.setText(total+"");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qtybox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ratebox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        batchnobox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        expdatebox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        medlist = new javax.swing.JTable();
        addbutton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        totalbox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        delmodsrnobox = new javax.swing.JTextField();
        delbutton = new javax.swing.JButton();
        nextbutton = new javax.swing.JButton();
        cancelbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mednamelist = new javax.swing.JTable();
        mednamebox = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BILLING");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Medicine Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Qty");

        qtybox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        qtybox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qtyboxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtyboxFocusLost(evt);
            }
        });
        qtybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyboxActionPerformed(evt);
            }
        });
        qtybox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyboxKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Rate");

        ratebox.setEditable(false);
        ratebox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rateboxFocusGained(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Batch No.");

        batchnobox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                batchnoboxFocusGained(evt);
            }
        });
        batchnobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchnoboxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Expiry Date");

        medlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr. No", "Medicine Name", "Quantity", "Rate", "Batch No.", "Expiry Date", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        medlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medlist);

        addbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbutton.setText("Add Item");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Total");

        totalbox.setEditable(false);
        totalbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalbox.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SR. NO.");

        delbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        delbutton.setText("Delete Item");
        delbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbuttonActionPerformed(evt);
            }
        });

        nextbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nextbutton.setText("Next");
        nextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbuttonActionPerformed(evt);
            }
        });

        cancelbutton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cancelbutton.setForeground(java.awt.Color.red);
        cancelbutton.setText("Cancel Bill");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mednamelist.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mednamelist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Quantity", "Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mednamelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mednamelistMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mednamelistMouseReleased(evt);
            }
        });
        mednamelist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mednamelistKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(mednamelist);

        mednamebox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mednameboxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mednameboxFocusLost(evt);
            }
        });
        mednamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mednameboxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mednameboxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 243, Short.MAX_VALUE)
                        .addComponent(cancelbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nextbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(expdatebox)
                                    .addComponent(batchnobox)
                                    .addComponent(ratebox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(qtybox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(mednamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delmodsrnobox, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(delbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {batchnobox, expdatebox, mednamebox, qtybox, ratebox});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelbutton, nextbutton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mednamebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(qtybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ratebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(batchnobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(expdatebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(delmodsrnobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delbutton)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextbutton)
                        .addComponent(cancelbutton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {mednamebox, qtybox});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int[] checkavail(String medname, int qty)
    {
        PreparedStatement pst=null;
        String st="select medname, qty, cost from medicines where medname=?";
        ResultSet rs=null;
        int arr[]=new int[2];
        try
        {
            pst=conn.prepareStatement(st);
            pst.setString(1, medname);
            rs=pst.executeQuery();
            if(rs.first())
            {
                int cqty=Integer.parseInt(rs.getString("qty"));
                if(qty>cqty){
                 arr[0]=0;
                  arr[1]=Integer.parseInt(rs.getString("cost"));
                
                 return arr;
                }
                else if(qty<=cqty && qty > 0)
                {
                arr[0]=1;
                 arr[1]=Integer.parseInt(rs.getString("cost"));
                
                return arr;
                }
            }
            if(!rs.first())
            {
                arr[0]=-1;
                 arr[1]=0;
                    return arr;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        
        arr[0]=-2;
        arr[1]=0;
        return arr;
    }
    private void qtyboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyboxActionPerformed
    }//GEN-LAST:event_qtyboxActionPerformed

    private void batchnoboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchnoboxActionPerformed
    }//GEN-LAST:event_batchnoboxActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void qtyboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyboxKeyTyped
    }//GEN-LAST:event_qtyboxKeyTyped

    private void qtyboxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyboxFocusLost
        int key[]=checkavail(((String)mednamebox.getText()).toLowerCase(), Integer.parseInt(qtybox.getText()) );
        jLabel6.setVisible(false);
        if(key[0] == 1)
        {
            qtybox.setEditable(true);
            addbutton.setEnabled(true);
            batchnobox.setEditable(true);
            expdatebox.setEditable(true);
            jLabel6.setForeground(new Color(0,115,19,255));
            jLabel6.setVisible(true);
            jLabel6.setText("AVAILABLE");
            ratebox.setText(key[1]+"");
            t.stop();
            qtybox.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            
        } else if(key[0] == 0) {
            qtybox.setEditable(false);
            addbutton.setEnabled(false);
            batchnobox.setEditable(false);
            expdatebox.setEditable(false);
            jLabel6.setForeground(Color.RED);
            jLabel6.setVisible(true);
            jLabel6.setText("NOT AVAILABLE");
            ratebox.setText(key[1]+"");
            qtybox.setBorder(BorderFactory.createLineBorder(Color.red));

        } else {

            jLabel6.setForeground(Color.RED);
            jLabel6.setVisible(true);
            jLabel6.setText("KAITARI GADBAD AHE");

        }
        
        //t.start() ;
    }//GEN-LAST:event_qtyboxFocusLost

    private void qtyboxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyboxFocusGained
        jLabel6.setVisible(false);
        int key[]=checkavail(((String)mednamebox.getText()).toLowerCase(), Integer.parseInt(qtybox.getText()) );
        if(key[0]==-1)
            qtybox.setEditable(false);
        else
            qtybox.setEditable(true);
        
    }//GEN-LAST:event_qtyboxFocusGained

    private boolean listcheck(String name)
    {
        for(int i=0; i<arra.size(); i++)
        {
            if(arra.get(i).medname.equals(name))
                return false;
        }
        return true;
    }
    
    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        nextbutton.setEnabled(true);
        delbutton.setEnabled(true);
        BillMedsClass bmc =new BillMedsClass();
        bmc.bno=batchnobox.getText();
        bmc.exdate=expdatebox.getText();
        bmc.medname=((String)mednamebox.getText()).toUpperCase();
        bmc.qty=Integer.parseInt(qtybox.getText());
        bmc.rate=Float.parseFloat(ratebox.getText());
        bmc.amt=(bmc.qty*bmc.rate);
        arra.add(bmc);
        total+=bmc.amt;
        display();
        totalbox.setText(total+"");
        mednamebox.repaint();
        qtybox.setText("");
        ratebox.setText("");
        batchnobox.setText("");
        expdatebox.setText("");
        mednamebox.setFocusable(true);
        qtybox.setBorder(BorderFactory.createLineBorder(new Color(153,153,153)));

        
    }//GEN-LAST:event_addbuttonActionPerformed

    private void delbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbuttonActionPerformed
        float da;
        int index=Integer.parseInt(delmodsrnobox.getText());
        try
        {
            da=arra.get(index-1).amt;

            arra.remove(index-1);
            total-=da;
            display();
            totalbox.setText(total+"");
            delmodsrnobox.setText("");

        }
        catch(IndexOutOfBoundsException e)
        {
            JOptionPane.showMessageDialog(this, "Invalid Sr.No.!");
        }
        if(arra.size()==0)
        {
             delbutton.setEnabled(false);
             
             nextbutton.setEnabled(false);
        }
        qtybox.setBorder(BorderFactory.createLineBorder(new Color(153,153,153)));

    }//GEN-LAST:event_delbuttonActionPerformed

    private void nextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbuttonActionPerformed
        FinalBill fb=new FinalBill(arra, total);
        fb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nextbuttonActionPerformed

    private void rateboxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateboxFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_rateboxFocusGained

    private void batchnoboxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_batchnoboxFocusGained
        jLabel6.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_batchnoboxFocusGained

    private void mednameboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mednameboxKeyTyped
        
    }//GEN-LAST:event_mednameboxKeyTyped

    private void mednamelistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mednamelistKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mednamelistKeyPressed

    private void mednameboxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mednameboxFocusGained
        ratebox.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_mednameboxFocusGained

    private void mednameboxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mednameboxFocusLost
        int key[]=checkavail(mednamebox.getText().toLowerCase(), 0);
        boolean flag;
        flag=listcheck(mednamebox.getText().toUpperCase());
        System.out.println(key);
        if(key[0] == -1 || flag==false)
        {
            if(!mednamebox.getText().equals(""))
            {
            }
            qtybox.setEditable(false);
            addbutton.setEnabled(false);
            batchnobox.setEditable(false);
            expdatebox.setEditable(false);

        }
        else if(flag==true)
        {
            qtybox.setEditable(true);
            batchnobox.setEditable(true);
            expdatebox.setEditable(true);
            addbutton.setEnabled(true);
        }
    }//GEN-LAST:event_mednameboxFocusLost

    private void mednameboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mednameboxKeyReleased
        filler();// TODO add your handling code here:
    }//GEN-LAST:event_mednameboxKeyReleased

    private void mednamelistMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mednamelistMouseReleased
     
        
    }//GEN-LAST:event_mednamelistMouseReleased

    private void mednamelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mednamelistMouseClicked
        qtybox.setBorder(BorderFactory.createLineBorder(new Color(153,153,153)));
        jLabel6.setVisible(false);
        qtybox.setText("");
        ratebox.setText("");
        int in=mednamelist.getSelectedRow();
        mednamebox.setText((String)mednamelist.getValueAt(in, 0));
        qtybox.setEditable(true);
        batchnobox.setEditable(true);
        expdatebox.setEditable(true);
        addbutton.setEnabled(true);
    }//GEN-LAST:event_mednamelistMouseClicked

    private void medlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medlistMouseClicked
        int in=medlist.getSelectedRow();
        delmodsrnobox.setText(medlist.getValueAt(in, 0)+"");
    }//GEN-LAST:event_medlistMouseClicked
    private void displaynames(ResultSet rs)
    {
        
        DefaultTableModel model=(DefaultTableModel)mednamelist.getModel();
        model.setRowCount(0);
        try
        {
            while(rs.next())
            {
                Object[] obj ={rs.getString(1),rs.getInt(2), rs.getInt(3)}; 
                model.addRow(obj);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    private void display()
    {
        
        DefaultTableModel model=(DefaultTableModel)medlist.getModel();
        model.setRowCount(0);
        for(int i=0; i<arra.size(); i++)
        {
            Object[] obj ={i+1, arra.get(i).medname, arra.get(i).qty, arra.get(i).rate, arra.get(i).bno, arra.get(i).exdate, arra.get(i).amt}; 
            model.addRow(obj);
        }
    }
    
//    public void changeScreenCOlor(int key, JFrame frame) {
//    
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//               
//                frame.getContentPane().setBackground(new Color(,,)); // input numbers for colors in RGB
//                
//            }
//        });
//    }
    
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
            java.util.logging.Logger.getLogger(BillClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JTextField batchnobox;
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton delbutton;
    private javax.swing.JTextField delmodsrnobox;
    private javax.swing.JTextField expdatebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable medlist;
    private javax.swing.JTextField mednamebox;
    private javax.swing.JTable mednamelist;
    private javax.swing.JButton nextbutton;
    private javax.swing.JTextField qtybox;
    private javax.swing.JTextField ratebox;
    private javax.swing.JTextField totalbox;
    // End of variables declaration//GEN-END:variables
}
