package thesleepingBarber;

import javax.swing.*;
import javax.swing.table.*;

public class Start extends javax.swing.JFrame {
    
    private Functions module;
    private barber[] barbers;
    private Customer[] customers;
    private Thread[] barbersThreads;
    private Thread[] customersThreads;
    
    private int numberOFcustomers;
    private int numberOFbarbers;
    private int numberOFchairs;
                       
    public static DefaultTableModel barbersTable = new DefaultTableModel();
    public static DefaultTableModel customersTable = new DefaultTableModel();

    public Start(int noOFbarbers,int noOFcustomers, int noOFchairs) {
        initComponents();
        
        numberOFcustomers = noOFcustomers;
        numberOFbarbers = noOFbarbers;
        numberOFchairs = noOFchairs;
        
        module = new Functions(numberOFbarbers,numberOFcustomers,numberOFchairs, this);
        barbers = new barber[numberOFbarbers];
        customers = new Customer[numberOFcustomers];
        barbersThreads = new Thread[numberOFbarbers];
        customersThreads = new Thread[numberOFcustomers];
        
        for (int i = 0; i < numberOFbarbers; i++) barbers[i] = new barber(module, i);
        for (int i = 0; i < numberOFcustomers; i++) customers[i] = new Customer(module, i);
        
        BarbersTable.setModel(barbersTable);
        CustomersTable.setModel(customersTable);
        
        barbersTable.addColumn("Barber Number");
        barbersTable.addColumn("Current State");
        customersTable.addColumn("Customer Number");
        customersTable.addColumn("Current State");

        for (int i = 0; i < numberOFbarbers; i++) barbersTable.addRow(new Object[]{i," "});
        for (int i = 0; i < numberOFcustomers; i++) customersTable.addRow(new Object[]{i," "});

        for(int i=0; i<numberOFbarbers; i++) barbersThreads[i]= new Thread(barbers[i]);
        for(int i=0; i<numberOFcustomers; i++) customersThreads[i]= new Thread(customers[i]);

        for(int i=0; i<numberOFbarbers; i++) barbersThreads[i].start();
        for(int i=0; i<numberOFcustomers; i++) customersThreads[i].start();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SleepingbarbersNumber1 = new javax.swing.JTextField();
        barbersTitle = new javax.swing.JTextField();
        CustomersCommingLatersTitle = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        customersTitle = new javax.swing.JTextField();
        Barbers_CustomersWorkingTitle = new javax.swing.JTextField();
        CustomersComingLaterNumber = new javax.swing.JTextField();
        CustomersWaitingTitle = new javax.swing.JTextField();
        BarbersSleepingTitle = new javax.swing.JTextField();
        SleepingbarbersNumber = new javax.swing.JTextField();
        WorkingBarbersCustomersNumber = new javax.swing.JTextField();
        CustomersWaitingNumber = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomersTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        BarbersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        SleepingbarbersNumber1.setEditable(false);
        SleepingbarbersNumber1.setBackground(new java.awt.Color(255, 255, 255));
        SleepingbarbersNumber1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        SleepingbarbersNumber1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Start");
        setBackground(new java.awt.Color(153, 153, 0));
        getContentPane().setLayout(null);

        barbersTitle.setEditable(false);
        barbersTitle.setBackground(new java.awt.Color(255, 51, 255));
        barbersTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        barbersTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        barbersTitle.setText("Barbers");
        getContentPane().add(barbersTitle);
        barbersTitle.setBounds(0, 240, 310, 34);

        CustomersCommingLatersTitle.setEditable(false);
        CustomersCommingLatersTitle.setBackground(new java.awt.Color(204, 102, 0));
        CustomersCommingLatersTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        CustomersCommingLatersTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomersCommingLatersTitle.setText("Customers Coming Laters");
        getContentPane().add(CustomersCommingLatersTitle);
        CustomersCommingLatersTitle.setBounds(0, 180, 310, 40);

        back.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thesleepingBarber/Zstop.jpg"))); // NOI18N
        back.setToolTipText("");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(210, 490, 198, 54);

        customersTitle.setEditable(false);
        customersTitle.setBackground(new java.awt.Color(255, 51, 255));
        customersTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        customersTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        customersTitle.setText("Customers");
        getContentPane().add(customersTitle);
        customersTitle.setBounds(320, 240, 310, 34);

        Barbers_CustomersWorkingTitle.setEditable(false);
        Barbers_CustomersWorkingTitle.setBackground(new java.awt.Color(204, 102, 0));
        Barbers_CustomersWorkingTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Barbers_CustomersWorkingTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Barbers_CustomersWorkingTitle.setText("Barbers(Customers) Working");
        getContentPane().add(Barbers_CustomersWorkingTitle);
        Barbers_CustomersWorkingTitle.setBounds(0, 60, 310, 40);

        CustomersComingLaterNumber.setEditable(false);
        CustomersComingLaterNumber.setBackground(new java.awt.Color(255, 255, 255));
        CustomersComingLaterNumber.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        CustomersComingLaterNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomersComingLaterNumber.setText("0");
        CustomersComingLaterNumber.setToolTipText("");
        getContentPane().add(CustomersComingLaterNumber);
        CustomersComingLaterNumber.setBounds(320, 180, 310, 40);

        CustomersWaitingTitle.setEditable(false);
        CustomersWaitingTitle.setBackground(new java.awt.Color(204, 102, 0));
        CustomersWaitingTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        CustomersWaitingTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomersWaitingTitle.setText("CustomersWaiting");
        getContentPane().add(CustomersWaitingTitle);
        CustomersWaitingTitle.setBounds(0, 120, 310, 40);

        BarbersSleepingTitle.setEditable(false);
        BarbersSleepingTitle.setBackground(new java.awt.Color(204, 102, 0));
        BarbersSleepingTitle.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        BarbersSleepingTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BarbersSleepingTitle.setText("Barbers Sleeping");
        getContentPane().add(BarbersSleepingTitle);
        BarbersSleepingTitle.setBounds(0, 0, 310, 40);

        SleepingbarbersNumber.setEditable(false);
        SleepingbarbersNumber.setBackground(new java.awt.Color(255, 255, 255));
        SleepingbarbersNumber.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        SleepingbarbersNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SleepingbarbersNumber.setText("0");
        getContentPane().add(SleepingbarbersNumber);
        SleepingbarbersNumber.setBounds(320, 0, 310, 40);

        WorkingBarbersCustomersNumber.setEditable(false);
        WorkingBarbersCustomersNumber.setBackground(new java.awt.Color(255, 255, 255));
        WorkingBarbersCustomersNumber.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        WorkingBarbersCustomersNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        WorkingBarbersCustomersNumber.setText("0");
        getContentPane().add(WorkingBarbersCustomersNumber);
        WorkingBarbersCustomersNumber.setBounds(320, 60, 310, 40);

        CustomersWaitingNumber.setEditable(false);
        CustomersWaitingNumber.setBackground(new java.awt.Color(255, 255, 255));
        CustomersWaitingNumber.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        CustomersWaitingNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomersWaitingNumber.setText("0");
        getContentPane().add(CustomersWaitingNumber);
        CustomersWaitingNumber.setBounds(320, 120, 310, 40);

        CustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(CustomersTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 280, 310, 190);

        BarbersTable.setBackground(new java.awt.Color(240, 240, 240));
        BarbersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(BarbersTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(0, 280, 310, 190);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thesleepingBarber/Zdisk.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void sleepingbarbersNumber(int SleepingBarbersNo) {
        SleepingbarbersNumber.setText(SleepingBarbersNo+"");    }
    
    public void workingbarbersNumber(int WorkingBarbersCustomersNo) {
        WorkingBarbersCustomersNumber.setText(WorkingBarbersCustomersNo+"");  }
    
    public void customersWaitingNumbers(int CustomersWAITINGno) {
        CustomersWaitingNumber.setText(CustomersWAITINGno+"");    }
    
    public void customersComingLaterNumber(int CustomersCOMINGLATERno) {
        CustomersComingLaterNumber.setText(CustomersCOMINGLATERno+""); }
    
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        try {
            for(int i=0; i<numberOFbarbers; i++) barbersThreads[i].stop();
            for(int i=0; i<numberOFcustomers; i++) customersThreads[i].stop();
            
            barbersTable.setRowCount(0);
            barbersTable.setColumnCount(0);
            customersTable.setRowCount(0);
            customersTable.setColumnCount(0);
                    
            Sleepingbarber F = new Sleepingbarber();
            F.setLocation(500,200);
            F.setSize(615,390);
            F.setVisible(true);
            dispose();

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarbersSleepingTitle;
    private javax.swing.JTable BarbersTable;
    private javax.swing.JTextField Barbers_CustomersWorkingTitle;
    private javax.swing.JTextField CustomersComingLaterNumber;
    private javax.swing.JTextField CustomersCommingLatersTitle;
    private javax.swing.JTable CustomersTable;
    private javax.swing.JTextField CustomersWaitingNumber;
    private javax.swing.JTextField CustomersWaitingTitle;
    private javax.swing.JTextField SleepingbarbersNumber;
    private javax.swing.JTextField SleepingbarbersNumber1;
    private javax.swing.JTextField WorkingBarbersCustomersNumber;
    private javax.swing.JButton back;
    private javax.swing.JTextField barbersTitle;
    private javax.swing.JTextField customersTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
