/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pb138.gui.list;

import cz.muni.fi.pb138.Devices.Device;
import cz.muni.fi.pb138.Managers.DeviceManager;
import cz.muni.fi.pb138.gui.Main;
import cz.muni.fi.pb138.Managers.DeviceManagerImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;

/**
 *
 * @author Magdalena Kunikova
 */
public class DeviceList extends javax.swing.JFrame {
    //private InvoiceForm invoiceForm;
    Main mainFrame;
    public List<Device> devices;
    public int rowIndex;
    private SwingWorker swingWorker;
    private DeviceManager deviceManager;
    public final int REMOVE = 0;
    public final int ADD = 1;
    public final int EDIT = 2;
    /**
     * Creates new form DeviceList
     */
    public DeviceList() {
        this.devices = new ArrayList<Device>();
        //this.invoiceForm = new InvoiceForm();
        this.rowIndex = -1;
        this.deviceManager = new DeviceManagerImpl();
        initComponents();
    }
    
    
    public DeviceList( Main mainFrame ) {
        this.deviceManager = new DeviceManagerImpl();
        this.devices = deviceManager.listAllDevices();
        this.mainFrame = mainFrame;
        this.rowIndex = -1;
        initComponents();
        buttonDeleteDevice.setEnabled( false );
        buttonEditDevice.setEnabled( false );
        buttonNewDevice.setEnabled( false );
    }
    
    
    private class editSwingWorker extends SwingWorker<Integer, Void> {
        DeviceList deviceList;

        public editSwingWorker( DeviceList deviceList ) {
            this.deviceList = deviceList;
        }

        @Override
        protected Integer doInBackground() throws Exception {
        //    rowIndex = tableDevices.getSelectedRow();
        //    Device_TableModel deviceModel = ( Device_TableModel ) tableDevices.getModel();
        //    Integer deviceNum = (Integer) deviceModel.getValueAt( rowIndex, 2 );
        //    Device device = deviceManager.getContactByIco(contactICO);
        //    DeviceForm deviceForm = new DeviceForm( deviceList, device );
        //    deviceForm.setVisible(true);
            return 0;
        }

        @Override
        protected void done() {
            swingWorker = null;
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNewDevice = new javax.swing.JButton();
        buttonEditDevice = new javax.swing.JButton();
        buttonDeleteDevice = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonNewDevice.setText("New device");
        buttonNewDevice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewDeviceActionPerformed(evt);
            }
        });

        buttonEditDevice.setText("Edit device");

        buttonDeleteDevice.setText("Delete device");

        buttonSave.setText("Save");

        buttonCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonNewDevice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(buttonEditDevice)
                        .addGap(46, 46, 46)
                        .addComponent(buttonDeleteDevice))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancel)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNewDevice)
                    .addComponent(buttonEditDevice)
                    .addComponent(buttonDeleteDevice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonCancel))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNewDeviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewDeviceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonNewDeviceActionPerformed

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
            java.util.logging.Logger.getLogger(DeviceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeviceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeviceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeviceList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeviceList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonDeleteDevice;
    private javax.swing.JButton buttonEditDevice;
    private javax.swing.JButton buttonNewDevice;
    private javax.swing.JButton buttonSave;
    // End of variables declaration//GEN-END:variables
}
