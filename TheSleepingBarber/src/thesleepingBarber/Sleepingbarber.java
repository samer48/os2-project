package thesleepingBarber;

import javax.swing.*;

public class Sleepingbarber extends javax.swing.JFrame {
        
    public Sleepingbarber() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooseTitle = new javax.swing.JTextField();
        BarberTitle = new javax.swing.JTextField();
        ChairsTitle = new javax.swing.JTextField();
        CustomersTitle = new javax.swing.JTextField();
        Start = new javax.swing.JButton();
        noOFbarbers = new javax.swing.JTextField();
        noOFchairs = new javax.swing.JTextField();
        noOFcustomers = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sleeping Teaching Assistant");
        getContentPane().setLayout(null);

        ChooseTitle.setEditable(false);
        ChooseTitle.setBackground(new java.awt.Color(255, 51, 51));
        ChooseTitle.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ChooseTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ChooseTitle.setText("Choose Number of:");
        getContentPane().add(ChooseTitle);
        ChooseTitle.setBounds(0, 0, 600, 50);

        BarberTitle.setEditable(false);
        BarberTitle.setBackground(new java.awt.Color(0, 51, 255));
        BarberTitle.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        BarberTitle.setForeground(new java.awt.Color(255, 255, 255));
        BarberTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BarberTitle.setText("Barbers");
        getContentPane().add(BarberTitle);
        BarberTitle.setBounds(10, 60, 179, 28);

        ChairsTitle.setEditable(false);
        ChairsTitle.setBackground(new java.awt.Color(0, 51, 255));
        ChairsTitle.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        ChairsTitle.setForeground(new java.awt.Color(255, 255, 255));
        ChairsTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ChairsTitle.setText("Chairs");
        getContentPane().add(ChairsTitle);
        ChairsTitle.setBounds(10, 160, 179, 28);

        CustomersTitle.setEditable(false);
        CustomersTitle.setBackground(new java.awt.Color(0, 51, 255));
        CustomersTitle.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        CustomersTitle.setForeground(new java.awt.Color(255, 255, 255));
        CustomersTitle.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomersTitle.setText("Customers");
        getContentPane().add(CustomersTitle);
        CustomersTitle.setBounds(10, 250, 179, 28);

        Start.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        Start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thesleepingBarber/Zstart.jpg"))); // NOI18N
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start);
        Start.setBounds(400, 50, 200, 100);

        noOFbarbers.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(noOFbarbers);
        noOFbarbers.setBounds(10, 110, 179, 31);

        noOFchairs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(noOFchairs);
        noOFchairs.setBounds(10, 200, 179, 31);

        noOFcustomers.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(noOFcustomers);
        noOFcustomers.setBounds(10, 300, 179, 31);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thesleepingBarber/Zoffice.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 610, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        try {
            int NumberOFbarbers, NumberOFchairs, NumberOFcustomers;
            if (Integer.parseInt( noOFbarbers.getText() ) > 0 && Integer.parseInt( noOFbarbers.getText() ) < 21)
                NumberOFbarbers = Integer.parseInt( noOFbarbers.getText() );
            else throw new Exception();
            if (Integer.parseInt( noOFchairs.getText() ) > 0 && Integer.parseInt( noOFchairs.getText() ) < 51)
                NumberOFchairs = Integer.parseInt( noOFchairs.getText() );
            else throw new Exception();
            if (Integer.parseInt( noOFcustomers.getText() ) > 0 && Integer.parseInt( noOFcustomers.getText() ) < 251)
                NumberOFcustomers = Integer.parseInt( noOFcustomers.getText() );
            else throw new Exception();
            
            Start S = new Start(NumberOFbarbers, NumberOFcustomers, NumberOFchairs);
            S.setLocation(500,200);
            S.setSize(645,585);
            S.setVisible(true);
            dispose();

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }  catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sleepingbarber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        
        catch (IllegalArgumentException ex) { JOptionPane.showMessageDialog(null,"Invalid inputs!","Error",JOptionPane.ERROR_MESSAGE); }
        catch (Exception ex) { JOptionPane.showMessageDialog(null,"You Should Enter: \n Barbers in Range(1:20) \n Chairs in Range(1:50) \n customers in Range(1:250)","Info",JOptionPane.INFORMATION_MESSAGE); }
    }//GEN-LAST:event_StartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarberTitle;
    private javax.swing.JTextField ChairsTitle;
    private javax.swing.JTextField ChooseTitle;
    private javax.swing.JTextField CustomersTitle;
    private javax.swing.JButton Start;
    private javax.swing.JLabel background;
    private javax.swing.JTextField noOFbarbers;
    private javax.swing.JTextField noOFchairs;
    private javax.swing.JTextField noOFcustomers;
    // End of variables declaration//GEN-END:variables

}
