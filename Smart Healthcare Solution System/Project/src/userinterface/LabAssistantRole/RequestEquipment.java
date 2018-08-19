/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.LabAssistantRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.InventoryManagerOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.Product.Product;
import Business.Product.ProductDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabRequestEquipment;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Constants;

/**
 *
 * @author haroonperveez
 */
public class RequestEquipment extends javax.swing.JPanel {

    /**
     * Creates new form RequestsFundsJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private LabOrganization labOrganization;
    private Enterprise enterprise;
    private Order order;
    boolean checkedOut=false;
    
    public RequestEquipment(JPanel userProcessContainer, UserAccount account, LabOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise=enterprise;
        this.labOrganization = (LabOrganization)organization;
        if(!checkedOut)
        {
            this.order=new Order();            
        }
        populateRequestTable();
        fillProductCombo();
    }
    
    public void fillProductCombo()
    {
        productListComboBox.removeAllItems();        
        int i=0;
        ProductDirectory pd=null;
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof InventoryManagerOrganization)
            {
                pd=((InventoryManagerOrganization)org).getProductDirectory();
            }
        }
        if(pd.getProductList().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No products found in the directory. Update list before proceeding", "Warning", JOptionPane.WARNING_MESSAGE);
            return;            
        }
        Product[] pArr=new Product[pd.getProductList().size()];
        for(Product s:pd.getProductList())
        {
           pArr[i]=s;
           i++;
        }        
        productListComboBox.setModel(new javax.swing.DefaultComboBoxModel(pArr));
        productListComboBox.setSelectedIndex(0);
    }
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) eqipReqJTable.getModel();
        
        model.setRowCount(0);
        for (OrderItem oi : order.getOrderItemList())
        {
            Object[] row = new Object[4];
            row[0] = oi;
            row[1] = oi.getQuantity();
            row[2] = String.valueOf(oi.getProduct().getProductPrice()*oi.getQuantity());
            row[3] = "Pending";            
            model.addRow(row);
            
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eqipReqJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productListComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarearemarks = new javax.swing.JTextArea();
        btnPlaceOrder = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        btnRemove = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(44, 62, 80));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel5.setText("Request Equipments");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        eqipReqJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Quantity", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(eqipReqJTable);

        jLabel1.setText("Product:");

        jLabel2.setText("Quantity:");

        productListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Remarks:");

        btnAddToCart.setText("Add To Order");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        txtarearemarks.setColumns(20);
        txtarearemarks.setRows(5);
        jScrollPane2.setViewportView(txtarearemarks);

        btnPlaceOrder.setText("Place Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnRemove.setText("Remove Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jButton1.setText("Manage Requests");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRemove)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(productListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnAddToCart)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnPlaceOrder)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBack))
                                            .addComponent(jScrollPane2))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddToCart)
                            .addComponent(btnPlaceOrder)
                            .addComponent(btnBack)))
                    .addComponent(jLabel3))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(492, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        Product p = (Product)productListComboBox.getSelectedItem();
        int reqQuantity=(Integer)(quantitySpinner.getValue());
        if(reqQuantity<=0)
        {
            JOptionPane.showMessageDialog(null, "Quantity cannot be 0.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try
        {
                boolean present=false;                
                for(OrderItem item:order.getOrderItemList())
                {
                    if(item.getProduct().equals(p))
                    {
                        item.setQuantity(reqQuantity+item.getQuantity());
                        present=true;
                        populateRequestTable();
                        break;
                    }
                }
                if(!present)
                {
                    order.addOrderItem(p, reqQuantity);
                    populateRequestTable();
                }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Enter valid details.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;

        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        DefaultTableModel model = (DefaultTableModel) eqipReqJTable.getModel();   
        if(model.getRowCount() == 0)
        {
            JOptionPane.showMessageDialog(null, "Add atleast one product", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(enterprise instanceof HospitalEnterprise)
        {
            checkedOut=true;            
            ((HospitalEnterprise)enterprise).getMoc().addOrder(order);
            LabRequestEquipment request = new LabRequestEquipment(order);
            request.setMessage(txtarearemarks.getText());
            request.setSender(userAccount);
            request.setStatus(Constants.Status.Pending);
            request.setReqType(Constants.ReqType.Fund.toString());
            request.getTrail().addTrail(Constants.Status.Pending, userAccount,Constants.TrailLevel.Level1);
            request.setRequestedFor(enterprise);
            Organization org = null;
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                if (organization instanceof InventoryManagerOrganization){
                    org = organization;
                    break;
                }
            }
            if (org!=null){
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }   
            model.setRowCount(0);
            txtarearemarks.setText("");
            productListComboBox.setSelectedIndex(0);
            quantitySpinner.setValue(0);
            order=new Order();
            
            JOptionPane.showMessageDialog(null, "Request placed Successfully", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManageEquipmentRequestJPanel panel = new ManageEquipmentRequestJPanel(userProcessContainer,userAccount,labOrganization,enterprise );
        userProcessContainer.add("ManageEquipmentRequestJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int row = eqipReqJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a product!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        OrderItem oi=(OrderItem)eqipReqJTable.getValueAt(row, 0);
        order.removeProduct(oi);
        populateRequestTable();
        JOptionPane.showMessageDialog(null, "Item removed successfully!!", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTable eqipReqJTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> productListComboBox;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextArea txtarearemarks;
    // End of variables declaration//GEN-END:variables
}
