package Visao.Consultar;

import DAO.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import principal.Menu;

/**
 * @author aluno
**/
public class ConsultarNotas extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarNotas
     */
    public ConsultarNotas() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Cadastro de Alunos");
        setResizable(false);
        AtualizaCombo();
        AtualizaComboDisciplina();
    }
    
    
    private void AtualizaCombo() {
        Connection con = Conexao.AbrirConexao();
        AlunoDAO sql = new AlunoDAO(con);
        List<Aluno> lista = new ArrayList<>();
        lista = sql.ListarComboAluno();
        
        for (Aluno b : lista) {
            comboAl.addItem(b.getNome());
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    
    private void AtualizaComboDisciplina() {
        Connection con = Conexao.AbrirConexao();
        DisciplinaDAO sql = new DisciplinaDAO(con);
        List<Disciplina> lista = new ArrayList<>();
        lista = sql.ListarComboDisciplina();
        
        for (Disciplina b : lista) {
            comboDis.addItem(b.getDisciplina());
        }
        
        Conexao.FecharConexao(con);
    }
    
    
    
    private void PesquisaCod() {
        
        int comboa = comboAl.getSelectedIndex();
        int combod = comboDis.getSelectedIndex();
        
        Connection con = Conexao.AbrirConexao();
        DisciplinaDAO bd = new DisciplinaDAO(con);
        
        if (comboa == 0 || combod == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode está vazio",
                "Cadastro de Alunos", JOptionPane.WARNING_MESSAGE);
            
            codDis.setText("");
            codAl.setText("");
            
        } else {
         
            String codigo = codAl.getText();
            int cod = Integer.parseInt(codigo);

            String co = codDis.getText();
            int c = Integer.parseInt(co);
            
            List<Nota> lista = new ArrayList<>();
            lista = bd.Procura_Notas(cod, c);
            
            
            int i = 0;

            for (Nota tab : lista) {
                notaMat1.setText(""+ tab.getNotaAl());
                i++;
            }
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

        comboAl = new javax.swing.JComboBox<>();
        codAl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboDis = new javax.swing.JComboBox<>();
        codDis = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nomeMat = new javax.swing.JLabel();
        notaMat1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        comboAl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione um item..." }));
        comboAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAlActionPerformed(evt);
            }
        });

        codAl.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel1.setText("CONSULTAR NOTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pesquisar.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 26, 0));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setText("X");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboDis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selecione um item..." }));
        comboDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDisActionPerformed(evt);
            }
        });

        codDis.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Disciplina:");

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        nomeMat.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N

        jButton3.setText("ALTERAR");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(nomeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(notaMat1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nomeMat, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(notaMat1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(codDis, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboDis, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(codAl, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboAl, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboAl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(codAl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDis, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(codDis, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAlActionPerformed
        Connection con = Conexao.AbrirConexao();
        AlunoDAO sql = new AlunoDAO(con);
        List<Aluno> lista = new ArrayList<>();
        String nome = comboAl.getSelectedItem().toString();

        lista = sql.ConsultarCodigoAluno(nome);

        for (Aluno b : lista) {
            int a = b.getIdaluno();
            codAl.setText("" + a);
        }

        Conexao.FecharConexao(con);
    }//GEN-LAST:event_comboAlActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PesquisaCod();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDisActionPerformed
        Connection con = Conexao.AbrirConexao();
        DisciplinaDAO sql = new DisciplinaDAO(con);
        List<Disciplina> lista = new ArrayList<>();
        String nome = comboDis.getSelectedItem().toString();
        
        int comboa = comboAl.getSelectedIndex();
        int combod = comboDis.getSelectedIndex();
        
        
        if (comboa == 0 && combod != 0) {
            JOptionPane.showMessageDialog(null, "Selecione o campo acima primeira",
                "Cadastro de Alunos", JOptionPane.WARNING_MESSAGE);
            
            codDis.setText("");
            codAl.setText("");
            
            comboDis.setSelectedIndex(0);
        } else {
        
            lista = sql.ConsultarCodigoDisciplina(nome);

            for (Disciplina b : lista) {

                int a = b.getIdDi();                
                codDis.setText("" + a);
                nomeMat.setText(""+nome);
                notaMat1.setText("");
            }
        }
        

        Conexao.FecharConexao(con);
    }//GEN-LAST:event_comboDisActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String no = notaMat1.getText();
        String idA = codAl.getText();
        String idD = codDis.getText();
        
        
        if (no.equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio",
                    "Cadastro de Alunos", JOptionPane.WARNING_MESSAGE);
        } else {
            Connection con = Conexao.AbrirConexao();
            DisciplinaDAO sql = new DisciplinaDAO(con);
            int codA = Integer.parseInt(idA);
            int codD = Integer.parseInt(idD);
            Double not = Double.parseDouble(no);
            Nota a = new Nota();
            
            a.setIdAl(codA);
            a.setIdDis(codD);
            a.setNotaAl(not);
            
            sql.Alterar_Nota(a);
            Conexao.FecharConexao(con);
            
            codAl.setText("");
            codDis.setText("");
            notaMat1.setText("");
            nomeMat.setText("");
            comboAl.setSelectedIndex(0);
            comboDis.setSelectedIndex(0);
            
            JOptionPane.showMessageDialog(null, "Informações atualizadas",
                    "Cadastro de Alunos", JOptionPane.INFORMATION_MESSAGE);
       
        }
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
            java.util.logging.Logger.getLogger(ConsultarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codAl;
    private javax.swing.JTextField codDis;
    private javax.swing.JComboBox<String> comboAl;
    private javax.swing.JComboBox<String> comboDis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nomeMat;
    private javax.swing.JTextField notaMat1;
    // End of variables declaration//GEN-END:variables
}