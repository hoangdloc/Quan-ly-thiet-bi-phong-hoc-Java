/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.IOFile;
import Model.BangQLThietBi;
import Model.PhongHoc;
import Model.ThietBi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoang Loc
 */
public class FormQLTB extends javax.swing.JPanel {

    /**
     * Creates new form FormQLTB
     */
    private DefaultTableModel tm;
    private String file = "src/Controller/QLTB.txt";
    private boolean them = false;
    
    public FormQLTB() {
        initComponents();
        String[] col = {"Ma phong hoc", "Ten phong hoc", "Ten thiet bi", "Ma thiet bi", "So luong", "Tinh trang"};
        tm = new DefaultTableModel(col, 0);
        jTable1.setModel(tm);
        btTrue();
        loadData();
    }
    
    private void btTrue() {
        btThem.setEnabled(true);
        btBoQua.setEnabled(false);
        btCapNhat.setEnabled(false);
    }
    
    private void btFalse() {
        btThem.setEnabled(false);
        btBoQua.setEnabled(true);
        btCapNhat.setEnabled(true);
    }
    
    private void loadData() {
        List<ThietBi> tb = IOFile.docFile("src/Controller/TB.txt");
        for(ThietBi i : tb) {
            jComboBox1.addItem(i.getMaTB() + "");
        }
        List<PhongHoc> ph = IOFile.docFile("src/Controller/PH.txt");
        for(PhongHoc i : ph) {
            jComboBox2.addItem(i.getMaPH() + "");
        }
    }
    
    private PhongHoc getPhongHocByMa(int ma) {
        List<PhongHoc> list = IOFile.docFile("src/Controller/PH.txt");
        for(PhongHoc i : list)
            if(i.getMaPH() == ma)
                return i;
            return null;
    }
    
    private ThietBi getThietBiByMa(int ma) {
        List<ThietBi> list = IOFile.docFile("src/Controller/TB.txt");
        for(ThietBi i : list)
            if(i.getMaTB() == ma)
                return i;
            return null;
    }
    
    private boolean checkExist(int matb,int maph){
        List<BangQLThietBi> list=getAll();
        for(BangQLThietBi i:list)
            if(i.getThiet_bi().getMaTB() == matb && i.getPhong_hoc().getMaPH() == maph)
                return true;
        return false;
    }
    
    private List<BangQLThietBi> getAll() {
        List<BangQLThietBi> list = new ArrayList<>();
        for(int i = 0; i < tm.getRowCount(); i++) {
            int maph = Integer.parseInt(tm.getValueAt(i, 0).toString());
            PhongHoc ph = getPhongHocByMa(maph);
            String tenph = tm.getValueAt(i, 1).toString();
            String tentb = tm.getValueAt(i, 2).toString();
            int matb = Integer.parseInt(tm.getValueAt(i, 3).toString());
            ThietBi tb = getThietBiByMa(matb);
            int sluong = Integer.parseInt(tm.getValueAt(i, 4).toString());
            String ttrang = tm.getValueAt(i, 5).toString();
            BangQLThietBi bql = new BangQLThietBi(tb, ph, sluong, ttrang);
            list.add(bql);
        }
        return list;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonTenPH = new javax.swing.JRadioButton();
        jRadioButtonSoLuongTB = new javax.swing.JRadioButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btCapNhat = new javax.swing.JButton();
        btBoQua = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        btHienThi = new javax.swing.JButton();

        jLabel1.setText("Thiet bi: ");

        jLabel2.setText("Phong hoc: ");

        jLabel3.setText("So luong: ");

        jLabel4.setText("Tinh trang: ");

        jLabel5.setText("Sap xep theo: ");

        buttonGroup1.add(jRadioButtonTenPH);
        jRadioButtonTenPH.setText("Ten phong hoc");
        jRadioButtonTenPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTenPHActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonSoLuongTB);
        jRadioButtonSoLuongTB.setText("So luong thiet bi");
        jRadioButtonSoLuongTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSoLuongTBActionPerformed(evt);
            }
        });

        btTimKiem.setText("Tim kiem");
        btTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemActionPerformed(evt);
            }
        });

        jLabel6.setText("Nhap ten thiet bi: ");

        jLabel7.setText("Nhap ten phong hoc: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonSoLuongTB)
                                    .addComponent(jRadioButtonTenPH)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btTimKiem)))
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButtonTenPH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonSoLuongTB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btThem.setText("Them");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btCapNhat.setText("Cap nhat");
        btCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhatActionPerformed(evt);
            }
        });

        btBoQua.setText("Bo qua");
        btBoQua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBoQuaActionPerformed(evt);
            }
        });

        btLuu.setText("Luu");
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        btHienThi.setText("Hien thi");
        btHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btThem)
                .addGap(33, 33, 33)
                .addComponent(btCapNhat)
                .addGap(32, 32, 32)
                .addComponent(btBoQua)
                .addGap(39, 39, 39)
                .addComponent(btLuu)
                .addGap(40, 40, 40)
                .addComponent(btHienThi)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btCapNhat)
                    .addComponent(btBoQua)
                    .addComponent(btLuu)
                    .addComponent(btHienThi))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        btFalse();
        them = true;
        jComboBox1.requestFocus();
    }//GEN-LAST:event_btThemActionPerformed

    private void btCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhatActionPerformed
        // TODO add your handling code here:
        if(them) {
            int matb = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int maph = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            if(checkExist(matb, maph)) {
                JOptionPane.showMessageDialog(this, "Da ton tai thiet bi trong phong hoc nay!");
            }
            else  {
                PhongHoc ph = getPhongHocByMa(maph);
                ThietBi tb = getThietBiByMa(matb);                
                int sluong = Integer.parseInt(jTextField1.getText().toString());
                String ttrang = jTextField2.getText().toString();
                BangQLThietBi bql = new BangQLThietBi(tb, ph, sluong, ttrang);
                tm.addRow(bql.toObjects());
                them = false;
                btTrue();
            }
        }
    }//GEN-LAST:event_btCapNhatActionPerformed

    private void btBoQuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBoQuaActionPerformed
        // TODO add your handling code here:
        if(them) {
            them = false;
            btTrue();
        }
    }//GEN-LAST:event_btBoQuaActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
        // TODO add your handling code here:
        List<BangQLThietBi> list = getAll();
        IOFile.ghiFile(list, file);
        JOptionPane.showMessageDialog(this, "Luu thanh cong");
    }//GEN-LAST:event_btLuuActionPerformed

    private void btHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHienThiActionPerformed
        // TODO add your handling code here:
        tm.setRowCount(0);
        List<BangQLThietBi> list = IOFile.docFile(file);
        for(BangQLThietBi i : list) {
            tm.addRow(i.toObjects());
        }
    }//GEN-LAST:event_btHienThiActionPerformed

    private void jRadioButtonTenPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTenPHActionPerformed
        // TODO add your handling code here:
        List<BangQLThietBi> list = getAll();
            list.sort(new Comparator<BangQLThietBi>() {
            @Override
            public int compare(BangQLThietBi s1, BangQLThietBi s2) {
                String ten1 = s1.getPhong_hoc().getTenPH();
                String ten2 = s2.getPhong_hoc().getTenPH();
                return (ten1.substring(ten1.lastIndexOf(" ")) + ten1).compareToIgnoreCase(ten2.substring(ten2.lastIndexOf(" ")));
            }
        });
        tm.setRowCount(0);
        for (BangQLThietBi i : list) {
            tm.addRow(i.toObjects());
        }
    }//GEN-LAST:event_jRadioButtonTenPHActionPerformed

    private void jRadioButtonSoLuongTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSoLuongTBActionPerformed
        // TODO add your handling code here:
        List<BangQLThietBi> list = getAll();
            list.sort(new Comparator<BangQLThietBi>() {
            @Override
            public int compare(BangQLThietBi s1, BangQLThietBi s2) {
                return s2.getSoLuong() - s1.getSoLuong();
            }
        });
        tm.setRowCount(0);
        for (BangQLThietBi i : list) {
            tm.addRow(i.toObjects());
        }
    }//GEN-LAST:event_jRadioButtonSoLuongTBActionPerformed

    private void btTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemActionPerformed
        // TODO add your handling code here:
        List<BangQLThietBi> list = getAll();
        String nhapTenTB = jTextField3.getText();
        String nhapTenPH = jTextField4.getText();
        if(nhapTenTB.equals("") && nhapTenPH.equals("")) {
            JOptionPane.showMessageDialog(this, "Chua nhap thong tin!");
            return;
        }
        tm.setRowCount(0);
        for(BangQLThietBi i : list) {
            if(i.getThiet_bi().getTenTB().contains(nhapTenTB) && i.getPhong_hoc().getTenPH().contains(nhapTenPH))
                tm.addRow(i.toObjects());
        }
    }//GEN-LAST:event_btTimKiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBoQua;
    private javax.swing.JButton btCapNhat;
    private javax.swing.JButton btHienThi;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonSoLuongTB;
    private javax.swing.JRadioButton jRadioButtonTenPH;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
