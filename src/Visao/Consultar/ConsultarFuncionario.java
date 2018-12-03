/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Consultar;

import DAO.Conexao;
import DAO.FuncionarioDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Funcionario;

/**
 *
 * @author aluno
 */
public class ConsultarFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarFuncionario
     */
    public ConsultarFuncionario() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Cadastro de Alunos");
        setResizable(false);
        AtualizaTable();
    }
    
    
    
    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        FuncionarioDAO bd = new FuncionarioDAO(con);
        List<Funcionario> lista = new ArrayList<>();
        lista = bd.ListarFuncionario();
        DefaultTableModel tbm = 
                (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {            
            tbm.removeRow(0);
        }
        
        int i = 0;
        
        for (Funcionario tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getIdFuncionario(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getLogin(), i, 2);
            jTable.setValueAt(tab.getSenha(), i, 3);
            i++;
        }
        
        Conexao.FecharConexao(con);
    }
    
    
    
    private void PesquisaNome() {
        
        String nome = nomeFu.getText();
        
        Connection con = Conexao.AbrirConexao();
        FuncionarioDAO bd = new FuncionarioDAO(con);
        List<Funcionario> lista = new ArrayList<>();
        lista = bd.Pesquisar_Nome_Funcionario(nome);
        DefaultTableModel tbm = 
                (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {            
            tbm.removeRow(0);
        }
        
        int i = 0;
        
        for (Funcionario tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getIdFuncionario(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getLogin(), i, 2);
            jTable.setValueAt(tab.getSenha(), i, 3);
            i++;
        }
        
        Conexao.FecharConexao(con);
    }
    
    
    
    private void PesquisaCod() {
        
        String codigo = codFu.getText();
        int cod = Integer.parseInt(codigo);
        
        Connection con = Conexao.AbrirConexao();
        FuncionarioDAO bd = new FuncionarioDAO(con);
        List<Funcionario> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_Funcionario(cod);
        DefaultTableModel tbm = 
                (DefaultTableModel) jTable.getModel();
        
        while (tbm.getRowCount() > 0) {            
            tbm.removeRow(0);
        }
        
        int i = 0;
        
        for (Funcionario tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getIdFuncionario(), i, 0);
            jTable.setValueAt(tab.getNome(), i, 1);
            jTable.setValueAt(tab.getLogin(), i, 2);
            jTable.setValueAt(tab.getSenha(), i, 3);
            i++;
        }
        
        Conexao.FecharConexao(con);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        nomeFu = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        codFu = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Login", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Pesquisa por nome:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisa por código:");

        jButton2.setText("TODOS");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(917, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeFu, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29)
                            .addComponent(codFu, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(222, 222, 222))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(codFu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomeFu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PesquisaNome();
        codFu.setText("");
        nomeFu.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AtualizaTable();
        codFu.setText("");
        nomeFu.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        PesquisaCod();
        codFu.setText("");
        nomeFu.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codFu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField nomeFu;
    // End of variables declaration//GEN-END:variables
}