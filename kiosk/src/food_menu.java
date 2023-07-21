
import java.awt.Image;
import java.sql.Connection;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class food_menu extends javax.swing.JFrame {

    /**
     * Creates new form food_menu
     */
    String order_id="";
    Connection con;
    public food_menu() {
        
        initComponents();
        bill_note();
    }
    
    public void bill_note(){
        
        
        Date d=new Date();
        SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
        String date=s.format(d);
        
        DateTimeFormatter times=DateTimeFormatter.ofPattern("hh : mm a");
        LocalDateTime now=LocalDateTime.now();
        String time=times.format(now);
        
        
            try {
            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("insert into customer(time,date) values (?,?)");
            st.setString(1, time);
            st.setString(2, date);
            st.executeUpdate();            
            

        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {

            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("select customer_id from customer where time=? and date=?");
            st.setString(1, time);
            st.setString(2, date);
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                
                order_id=rs.getString("customer_id");
                
            }
                
            
        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        lbl_note_cafe.setText("***********************************************Cafe**********************************************");
        lbl_note_DateTime.setText("Time: "+time+"  Date: "+date);
        lbl_note_purchase_id.setText("Order Id: "+order_id);
        lbl_note_close.setText("*************************************************************************************************");
        
        
    }
    
    public void show_foods(){
        
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        lbl_item_count.setText("1");
        int selectedRow=jTable1.getSelectedRow();

        lbl_item.setText(table.getValueAt(selectedRow, 0).toString());
        jButton7.setVisible(true);

        try {
            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("select * from item where name=?");
            st.setString(1, table.getValueAt(selectedRow,0).toString());
            ResultSet rs=st.executeQuery();

            while(rs.next()){

                String price=rs.getString("price");
                String name=rs.getString("name");
                byte[] pic=rs.getBytes("img");
                ImageIcon image=new ImageIcon(pic);
                Image im=image.getImage();
                Image myimg=im.getScaledInstance(lblimg.getWidth(),lblimg.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage=new ImageIcon(myimg);

                item_img.setIcon(newImage);
                lbl_item_name.setText(name);
                lbl_item_price.setText(price);

            }

        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void customer_item(String item,int quantity){
        
    }
    
    public void cal_total(){
        DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
        int numrow=jTable2.getRowCount();
        double tot=0;
        
        for(int i=0;i<numrow;i++){
            double val=Double.valueOf(jTable2.getValueAt(i, 2).toString());
            tot +=val;
        }
        
        lbl_total.setText(Double.toString(tot));
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        food_panels = new javax.swing.JPanel();
        food = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblimg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_item = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        $ = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lbl_count = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_note_cafe = new javax.swing.JLabel();
        lbl_note_DateTime = new javax.swing.JLabel();
        lbl_note_close = new javax.swing.JLabel();
        lbl_note_purchase_id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lbl_total = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        item_img = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_item_name = new javax.swing.JLabel();
        lbl_item_price = new javax.swing.JLabel();
        $3 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        lbl_item_count = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHOOSE YOUR FAVOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sweet_icon.png"))); // NOI18N
        jButton1.setText("Sweets");
        jButton1.setBorderPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 270, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food_icon.png"))); // NOI18N
        jButton3.setText("Foods");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 270, 250));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drinks_icon.png"))); // NOI18N
        jButton4.setText("Drinks");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 270, 250));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 330, 820));

        food_panels.setBackground(new java.awt.Color(255, 255, 255));
        food_panels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        food.setBackground(new java.awt.Color(255, 255, 255));
        food.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Food Item", "Price"
            }
        )

    );
    jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jTable1.setIntercellSpacing(new java.awt.Dimension(4, 4));
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable1);

    food.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 280));
    food.add(lblimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 420, 320));
    food.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 250));

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lbl_item.setBackground(new java.awt.Color(153, 153, 153));
    lbl_item.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
    lbl_item.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_item.setText("ITEM");
    jPanel3.add(lbl_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 360, 50));

    lbl_price.setBackground(new java.awt.Color(102, 255, 0));
    lbl_price.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
    lbl_price.setForeground(new java.awt.Color(250, 90, 34));
    lbl_price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lbl_price.setText("45");
    jPanel3.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 210, 45));

    $.setBackground(new java.awt.Color(102, 255, 0));
    $.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
    $.setForeground(new java.awt.Color(250, 90, 34));
    $.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    $.setText("$");
    jPanel3.add($, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, 45));

    jButton6.setText("-");
    jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton6MouseClicked(evt);
        }
    });
    jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, 30));

    jButton5.setText("+");
    jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton5MouseClicked(evt);
        }
    });
    jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 70, 30));

    lbl_count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    lbl_count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_count.setText("1");
    jPanel3.add(lbl_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 50, -1));

    jButton7.setBackground(new java.awt.Color(55, 184, 117));
    jButton7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jButton7.setForeground(new java.awt.Color(255, 255, 255));
    jButton7.setText("ADD");
    jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton7MouseClicked(evt);
        }
    });
    jButton7.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentHidden(java.awt.event.ComponentEvent evt) {
            jButton7ComponentHidden(evt);
        }
    });
    jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 50));

    food.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 360, 350));

    food_panels.add(food, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 280));

    jPanel1.add(food_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 860, 280));

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lbl_note_cafe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jPanel5.add(lbl_note_cafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 20));

    lbl_note_DateTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jPanel5.add(lbl_note_DateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 590, 20));

    lbl_note_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jPanel5.add(lbl_note_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 590, 20));

    lbl_note_purchase_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jPanel5.add(lbl_note_purchase_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 590, 20));

    jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 100));

    jLabel7.setText("jLabel2");
    jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    jTable2.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Item name", "Quantity", "Price"
        }
    ));
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(jTable2);

    jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 590, 470));

    lbl_total.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
    jPanel4.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 630, 190, 40));

    jLabel5.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
    jLabel5.setText("Total");
    jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 100, 40));

    jButton8.setBackground(new java.awt.Color(55, 184, 117));
    jButton8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
    jButton8.setForeground(new java.awt.Color(255, 255, 255));
    jButton8.setText("CONTINUE");
    jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton8MouseClicked(evt);
        }
    });
    jButton8.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentHidden(java.awt.event.ComponentEvent evt) {
            jButton8ComponentHidden(evt);
        }
    });
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });
    jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 710, 450, 60));

    jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 90, 590, 820));

    jButton2.setBackground(new java.awt.Color(230, 57, 70));
    jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    jButton2.setText("EXIT");
    jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton2MouseClicked(evt);
        }
    });
    jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1689, 915, 230, 40));

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel10.add(item_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 420, 320));

    jPanel11.setBackground(new java.awt.Color(255, 255, 255));
    jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    lbl_item_name.setBackground(new java.awt.Color(153, 153, 153));
    lbl_item_name.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
    lbl_item_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_item_name.setText("ITEM");
    jPanel11.add(lbl_item_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 360, 50));

    lbl_item_price.setBackground(new java.awt.Color(102, 255, 0));
    lbl_item_price.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
    lbl_item_price.setForeground(new java.awt.Color(250, 90, 34));
    lbl_item_price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lbl_item_price.setText("45");
    jPanel11.add(lbl_item_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 210, 45));

    $3.setBackground(new java.awt.Color(102, 255, 0));
    $3.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
    $3.setForeground(new java.awt.Color(250, 90, 34));
    $3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    $3.setText("$");
    jPanel11.add($3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 140, 45));

    jButton15.setText("-");
    jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton15MouseClicked(evt);
        }
    });
    jPanel11.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, 30));

    jButton16.setText("+");
    jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton16MouseClicked(evt);
        }
    });
    jPanel11.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 70, 30));

    lbl_item_count.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    lbl_item_count.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    lbl_item_count.setText("1");
    jPanel11.add(lbl_item_count, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 50, -1));

    jButton17.setBackground(new java.awt.Color(55, 184, 117));
    jButton17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
    jButton17.setForeground(new java.awt.Color(255, 255, 255));
    jButton17.setText("ADD");
    jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jButton17MouseClicked(evt);
        }
    });
    jButton17.addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentHidden(java.awt.event.ComponentEvent evt) {
            jButton17ComponentHidden(evt);
        }
    });
    jButton17.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton17ActionPerformed(evt);
        }
    });
    jPanel11.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 190, 50));

    jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 360, 350));

    jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 860, 520));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 960));

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        food.setVisible(true);
        
        //bill_note();
        
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        table.setRowCount(0);
        
        try {

            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("select * from item where category=?");
            st.setString(1, "food");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                
                String name=rs.getString("name");
                String price=rs.getString("price");                
                String tbdata[]={name,price};
                
                table.addRow(tbdata);
                
            }
                
            
        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        food.setVisible(true);
        
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        table.setRowCount(0);
        
            try {

            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("select * from item where category=?");
            st.setString(1, "drink");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                
                String name=rs.getString("name");
                String price=rs.getString("price");                
                String tbdata[]={name,price};
                
                table.addRow(tbdata);
                
            }
                
            
        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        food.setVisible(true);
        
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        table.setRowCount(0);
        
            try {

            con = sql_connection.getConnection();
            PreparedStatement st=con.prepareStatement("select * from item where category=?");
            st.setString(1, "sweet");
            ResultSet rs=st.executeQuery();
            
            while(rs.next()){
                
                String name=rs.getString("name");
                String price=rs.getString("price");                
                String tbdata[]={name,price};
                
                table.addRow(tbdata);
                
            }
                
            
        } catch (Exception ex) {
            Logger.getLogger(food_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        show_foods();

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton7ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton7ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ComponentHidden

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:

        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());

        int count=Integer.valueOf(lbl_count.getText());
        count++;

        lbl_count.setText(Integer.toString(count));
        lbl_price.setText(String.valueOf(item_price*count));
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        int count=Integer.valueOf(lbl_count.getText());

        if(count>1){
            count--;

            DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
            double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());

            lbl_count.setText(Integer.toString(count));
            lbl_price.setText(String.valueOf(item_price*count));
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());
        
        String name=lbl_item.getText();
        int quantity=Integer.parseInt(lbl_count.getText());
        double price=item_price*quantity;
        
        String tblData[]={name,String.valueOf(quantity),String.valueOf(price)};
        
        DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
        table2.addRow(tblData);
        
        cal_total();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // Continue:
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        try {
            Statement st = con.createStatement();
            
            for(int i = 0; i < model.getRowCount(); i++){
                
                String itemName = model.getValueAt(i, 0).toString();
                int quantity = Integer.valueOf(model.getValueAt(i, 1).toString());
                int orderId=Integer.parseInt(order_id);
                System.out.println(orderId+" "+itemName+" "+quantity);

                //String sqlQuery = "INSERT INTO `customer_item`(`id`, `name`, `quantity`) VALUES ("+order_id+",'"+itemName+"','"+quantity+"')";
                String sqlQuery = "INSERT INTO `customer_item`(`id`, `name`, `quantity`) VALUES ('"+order_id+"','"+itemName+"','"+quantity+"')";
                
                st.addBatch(sqlQuery);
                
                //st.executeBatch();
            }
            String sqlQuery1 = "INSERT INTO `order_status`(`order_id`) VALUES ('"+order_id+"')";
            st.addBatch(sqlQuery1);
            int[] rowsInserted = st.executeBatch();
            System.out.println("Data Inserted");
            System.out.println("rowsInserted Count = " + rowsInserted.length);
            
            order_confirm f=new order_confirm();
            f.show();
            dispose();
            
        } catch (SQLException ex) {
            System.out.print("Error inserting data");
        }
        
        
        
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton8ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ComponentHidden

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        kiosk_main k=new kiosk_main();
        k.show();
        dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
        int count=Integer.valueOf(lbl_item_count.getText());

        if(count>1){
            count--;

            DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
            double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());

            lbl_item_count.setText(Integer.toString(count));
            lbl_item_price.setText(String.valueOf(item_price*count));
        }
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        // TODO add your handling code here
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());

        int count=Integer.valueOf(lbl_item_count.getText());
        count++;

        lbl_item_count.setText(Integer.toString(count));
        lbl_item_price.setText(String.valueOf(item_price*count));
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
        double item_price=Double.parseDouble(table.getValueAt(jTable1.getSelectedRow(),1).toString());
        
        
        String name=lbl_item_name.getText();
        int quantity=Integer.parseInt(lbl_item_count.getText());
        double price=item_price*quantity;
        
        String tblData[]={name,String.valueOf(quantity),String.valueOf(price)};
        
        DefaultTableModel table2=(DefaultTableModel)jTable2.getModel();
        table2.addRow(tblData);
        
        cal_total();
        
        int selectedRow=jTable1.getSelectedRow();
        String food_id=table.getValueAt(selectedRow, 0).toString();
        System.out.println(food_id);
        customer_item(food_id,quantity);
        
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton17ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ComponentHidden

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(food_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(food_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(food_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(food_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new food_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel $;
    private javax.swing.JLabel $3;
    private javax.swing.JPanel food;
    private javax.swing.JPanel food_panels;
    private javax.swing.JLabel item_img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbl_count;
    private javax.swing.JLabel lbl_item;
    private javax.swing.JLabel lbl_item_count;
    private javax.swing.JLabel lbl_item_name;
    private javax.swing.JLabel lbl_item_price;
    private javax.swing.JLabel lbl_note_DateTime;
    private javax.swing.JLabel lbl_note_cafe;
    private javax.swing.JLabel lbl_note_close;
    private javax.swing.JLabel lbl_note_purchase_id;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lblimg;
    // End of variables declaration//GEN-END:variables
}