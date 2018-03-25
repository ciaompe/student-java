/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.Views;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import student.Controllers.GradeController;
import student.Controllers.StudentController;
import student.Models.Course;
import student.Models.Student;
import student.Models.StudentGrade;

/**
 *
 * @author mpe20
 */
public class ViewGrade extends javax.swing.JFrame {
    
    private final StudentController studentController;
    private final GradeController gradeController;
    private Integer studentId = 0;
    Component panel = null;

    /**
     * Creates new form ViewGrade
     */
    public ViewGrade() {
        this.studentController = new StudentController();
        this.gradeController = new GradeController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_stdid1 = new javax.swing.JLabel();
        txt_std = new javax.swing.JTextField();
        btn_selectStu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_grades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_stdid1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl_stdid1.setText("Student ID :");

        btn_selectStu.setText("Select Student");
        btn_selectStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selectStuActionPerformed(evt);
            }
        });

        tbl_grades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course", "Subject", "Grade"
            }
        ));
        jScrollPane1.setViewportView(tbl_grades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_stdid1)
                    .addComponent(txt_std, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_selectStu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txt_std, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_selectStu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_stdid1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_selectStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selectStuActionPerformed
        String stdid = txt_std.getText();
        
        if(stdid == null || stdid.length() == 0) {
            javax.swing.JOptionPane.showMessageDialog(panel, "Student id is requied", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            
            Student stu = studentController.searchById(Integer.parseInt(stdid));
        
            if(stu != null) {
                studentId = stu.id;
                javax.swing.JOptionPane.showMessageDialog(panel, "Student Selected", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                 
                
                DefaultTableModel amodel = (DefaultTableModel)tbl_courses.getModel();
                amodel.setRowCount(0);

                String colHeads[] = {"ID", "Name", "Description"};
                amodel.setColumnIdentifiers(colHeads);

                ArrayList<StudentGrade> list = gradeController.gradeByStu(studentId);
                int gradeCount = gradeController.gradeByStu(studentId).size();

                Object rowData[] =  new Object[3];

                for (int i = 0; i < gradeCount; i++) {
                   rowData[0] =  list.get(i).course;
                   rowData[1] =  list.get(i).subject;
                   rowData[2] =  list.get(i).grade;

                   amodel.addRow(rowData);
                }
                 
            } else {
                javax.swing.JOptionPane.showMessageDialog(panel, "Student Not Found In the Database", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
               
            }
        }
    }//GEN-LAST:event_btn_selectStuActionPerformed

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
            java.util.logging.Logger.getLogger(ViewGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGrade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGrade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selectStu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_stdid1;
    private javax.swing.JTable tbl_grades;
    private javax.swing.JTextField txt_std;
    // End of variables declaration//GEN-END:variables
}