/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import mycode.dbconnect;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Acer
 */

public class sold extends javax.swing.JPanel {

    /**
     * Creates new form sold
     */
      Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs =null;
    
    public sold() {
        initComponents();
        jPanel1.setBackground(new Color(255,255,255,180));
        con =dbconnect.connect();
        showDate();
       data_load();
        tableload();
        jTable1.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,24));
        jTable1.getTableHeader().setOpaque(false);
       
        jTable1.getTableHeader().setBackground(new Color(255,51,51));
        jTable1.getTableHeader().setForeground( Color.BLACK);
        jTable1.setRowHeight(25);
            
    }
     void showDate(){
    
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
    Date d = new Date();
    date.setText(s.format(d));
    }
     public void tableload()
    {
       try{
      
         String sql = "SELECT date as 'Date' , sold_name  as 'Description', sold_box as 'No Of Sold Boxess' ,sold_pac as 'No Of Sold Loose Packet' , sold_tot as 'No Of Total Sold'  FROM sold" ;
         pst=con.prepareStatement(sql);
         rs=pst.executeQuery();
         
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
               
       }catch(Exception e){
        
    }
    }
     public void data_load(){
        
       try{
           
          Statement s = dbconnect.connect().createStatement(); 
          ResultSet rs = s.executeQuery("SELECT * FROM add1");
          Vector v = new Vector();
          while(rs.next()){
              
            v.add(rs.getString("product_name"));
            
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            jComboBox1.setModel(com);
              
              
          }
          
           
           
           
       } catch(Exception e){
           
       }}
   
      public void date(){
    
         
         SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
     String fdate = df1.format(jDateChooser3.getDate());
     
     SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
     String tdate = df2.format(jDateChooser4.getDate());
     
             
     try{
            
           DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
           dt.setRowCount(0);
           Statement  s = dbconnect.connect().createStatement();
           ResultSet rs=s.executeQuery("SELECT * FROM sold WHERE date BETWEEN  '"+fdate+"' AND '"+tdate+"' ");
            
           while(rs.next()){
               
             Vector v = new Vector();  
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
              
              
              
              dt.addRow(v);
           }
            
        }catch(SQLException e){
            
           System.out.println(e);
            
        }
         
         
         
         
     }
      
      
      public void cal(){
      
          String name =jComboBox1.getSelectedItem().toString();
          
           
         SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
     String fdate = df1.format(jDateChooser1.getDate());
     
     SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
     String tdate = df2.format(jDateChooser2.getDate());
     
             
     try{
            
           DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
           dt.setRowCount(0);
           Statement  s = dbconnect.connect().createStatement();
           ResultSet rs=s.executeQuery("SELECT * FROM sold WHERE date BETWEEN  '"+fdate+"' AND '"+tdate+"' AND sold_name='"+name+"' ");
            
           while(rs.next()){
               
             Vector v = new Vector();  
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
              v.add(rs.getString(5));
              v.add(rs.getString(6));
              
              
              
              dt.addRow(v);
           }
            
        }catch(SQLException e){
            
           System.out.println(e);
            
        }
         
    
    
}
       public void sold_total(){
        
        int numofrow = jTable1.getRowCount();
        
        
        double total = 0;
        double packet=0;
        double fina=0;
        for(int i =0 ; i<numofrow;i++){
            
           
           double value = Double.valueOf(jTable1.getValueAt(i,2).toString());
           total+=value;
           double value1 = Double.valueOf(jTable1.getValueAt(i,3).toString());
           packet+=value1;
           double value2 = Double.valueOf(jTable1.getValueAt(i,4).toString());
           fina+=value2;
        }
        String tot=String.format("%.0f", total); 
        String tot1=String.format("%.0f", packet); 
        String tot2=String.format("%.0f", fina); 
      // jLabel6.setText(Double.toString(tot));
       jLabel10.setText(tot);
       jLabel8.setText(tot1);
       jLabel9.setText(tot2);
       
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1920, 840));
        setMinimumSize(new java.awt.Dimension(1920, 840));
        setPreferredSize(new java.awt.Dimension(1920, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel10.setText("0");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 180, 25));

        jLabel9.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel9.setText("0");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 180, 25));

        jLabel8.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel8.setText("0");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 180, 25));

        date.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 210, 25));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 50, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/Search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 50, 40));

        jDateChooser2.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 250, 25));

        jDateChooser1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 250, 25));

        jDateChooser4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 250, 25));

        jDateChooser3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 250, 25));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 870, 560));

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel3.setText("date  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/date.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel4.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel4.setText("from  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 70, 25));

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel5.setText("to       :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 70, 25));

        jComboBox1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 310, 25));

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel6.setText("name  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 25));

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel7.setText("box");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 100, 25));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel11.setText("packet");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 100, 25));

        jLabel12.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel12.setText("total");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 100, 25));

        jLabel13.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel13.setText("sold   :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 60, 25));

        jLabel14.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel14.setText("-------------------------------------------------------------");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 490, 10));

        jLabel15.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel15.setText("from  :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, 25));

        jLabel16.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        jLabel16.setText("to       :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 25));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 560));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/sold.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       cal();
       sold_total();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        date();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
