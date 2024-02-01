package telas.telasInt;

/**
 * @author : Davidson Teixeira Filho
 * @date : 26/01/2023
 */

import com.mycompany.biroscadocalvino.TelaPrincipal;
import DAO.Conexao;
import classesExtras.AlterarValor;
import classesExtras.ListarLideres;
import classesExtras.PesquisarProduto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaAlterarProduto extends javax.swing.JFrame {

    public TelaAlterarProduto() {
        setTitle("Tela de alteração do produto");
        initComponents();
        ListarLideres ll = new ListarLideres();
        ll.pesquisar(jCBLider);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLItem = new javax.swing.JLabel();
        jCBItens = new javax.swing.JComboBox();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisa = new javax.swing.JTextField();
        jBAlterar = new javax.swing.JButton();
        jLValor = new javax.swing.JLabel();
        jTFValNovo = new javax.swing.JTextField();
        jLSaldo = new javax.swing.JLabel();
        jTFValAtual = new javax.swing.JTextField();
        jBAtualizar = new javax.swing.JButton();
        jLExib = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jLLider = new javax.swing.JLabel();
        jCBLider = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLItem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLItem.setText("Produto");

        jCBItens.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------" }));
        jCBItens.setToolTipText("");

        jBPesquisar.setText("Pesquisar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jTFPesquisa.setToolTipText("Pesquisar em acampantes");
        jTFPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPesquisaActionPerformed(evt);
            }
        });

        jBAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBAlterar.setText("Efetuar a alteração");
        jBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAlterarActionPerformed(evt);
            }
        });

        jLValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLValor.setText("Novo valor (separe as casas decimais com '.')");

        jTFValNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFValNovoActionPerformed(evt);
            }
        });

        jLSaldo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLSaldo.setText("Valor atual do produto");

        jTFValAtual.setEditable(false);
        jTFValAtual.setFocusable(false);

        jBAtualizar.setText("Atualizar valor");
        jBAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAtualizarActionPerformed(evt);
            }
        });

        jBVoltar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBVoltar.setText("Voltar para a tela principal");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jLLider.setText("Quem alterou?");

        jCBLider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------", "Davidson", "Layla", "Mariana" }));
        jCBLider.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLItem)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFValNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLLider))
                                .addGap(41, 41, 41)
                                .addComponent(jLExib, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(227, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCBLider, javax.swing.GroupLayout.Alignment.LEADING, 0, 328, Short.MAX_VALUE)
                            .addComponent(jLSaldo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLValor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBItens, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFPesquisa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFValAtual, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAtualizar)
                            .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAlterar)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar))
                .addGap(6, 6, 6)
                .addComponent(jLItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBItens, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFValAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAtualizar))
                        .addGap(11, 11, 11)
                        .addComponent(jLValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFValNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLExib, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLLider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBLider, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  BOTÃO QUE FAZ PESQUISA DOS NOMES DE ACAMPANTES NO BD
    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        PesquisarProduto pesq = new PesquisarProduto();

        pesq.pesquisar(jTFPesquisa, jCBItens);
    }//GEN-LAST:event_jBPesquisarActionPerformed

    //  PESQUISA DOS NOMES DE ACAMPANTES NO BD POR ENTER
    private void jTFPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPesquisaActionPerformed
        jBPesquisarActionPerformed(evt);
    }//GEN-LAST:event_jTFPesquisaActionPerformed

    //  BOTÃO QUE EFETUA A COMPRA
    private void jBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAlterarActionPerformed
        String pesquisa, lider, descricao;

        double valor;

        pesquisa = (jCBItens.getSelectedItem().toString());
        lider = (jCBLider.getSelectedItem().toString());
        valor = Double.parseDouble(jTFValNovo.getText());

        AlterarValor atualizar = new AlterarValor();
        atualizar.alterarValor(jCBItens, jLExib, valor);

        try {

            
            
            dispose();
            TelaAlterarProduto obj = new TelaAlterarProduto();
            obj.setVisible(true);
            
            JOptionPane.showMessageDialog(jLExib, "Produto alterado com sucesso!");

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);;
        }
    }//GEN-LAST:event_jBAlterarActionPerformed

    //  BOTÃO QUE ATUALIZA O SALDO DO ACAMPANTE
    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        String produto = (jCBItens.getSelectedItem().toString());

        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select valor from produto where nome='" + produto + "'";
            //System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                double value = rs.getDouble("valor");

                String inter = String.valueOf(value);
                jTFValAtual.setText(inter);
            }
        } catch (SQLException ex) {
            System.err.println(ex);

        } catch (Exception ex) {
            Logger.getLogger(TelaAlterarProduto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    //  BOTÃO QUE VOLTA PARA A TELA INICIAL
    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
        TelaPrincipal set = new TelaPrincipal();
        set.setVisible(true);
    }//GEN-LAST:event_jBVoltarActionPerformed

    //  EFETUA A COMPRA ATRAVÉS DO ENTER
    private void jTFValNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFValNovoActionPerformed
        jBAlterarActionPerformed(evt);
    }//GEN-LAST:event_jTFValNovoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAlterarProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarProduto.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaAlterarProduto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlterar;
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox jCBItens;
    private javax.swing.JComboBox jCBLider;
    private javax.swing.JLabel jLExib;
    private javax.swing.JLabel jLItem;
    private javax.swing.JLabel jLLider;
    private javax.swing.JLabel jLSaldo;
    private javax.swing.JLabel jLValor;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTextField jTFValAtual;
    private javax.swing.JTextField jTFValNovo;
    // End of variables declaration//GEN-END:variables
}
