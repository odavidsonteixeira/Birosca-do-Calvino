package telas.telasInt;

/**
 * @author : Davidson Teixeira Filho
 * @date : 26/01/2023
 */

import DAO.Conexao;
import classesExtras.ListarLideres;
import classesExtras.PesquisarAcampante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DepositoAcampante extends javax.swing.JFrame {

    public DepositoAcampante() {
        setTitle("Depósito de valores do acampante");
        initComponents();
        ListarLideres ll = new ListarLideres();
        ll.pesquisar(jCBLider);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLAcampante = new javax.swing.JLabel();
        jCBAcampantes = new javax.swing.JComboBox();
        jBPesquisar = new javax.swing.JButton();
        jTFPesquisa = new javax.swing.JTextField();
        jBDepositar = new javax.swing.JButton();
        jLDeposito = new javax.swing.JLabel();
        jTFDeposito = new javax.swing.JTextField();
        jLSaldo = new javax.swing.JLabel();
        jTFSaldo = new javax.swing.JTextField();
        jBAtualizar = new javax.swing.JButton();
        jLExib = new javax.swing.JLabel();
        jBVoltar = new javax.swing.JButton();
        jLLider = new javax.swing.JLabel();
        jCBLider = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLAcampante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLAcampante.setText("Acampante");

        jCBAcampantes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------" }));
        jCBAcampantes.setToolTipText("");

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

        jBDepositar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBDepositar.setText("Efetuar o depósito");
        jBDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDepositarActionPerformed(evt);
            }
        });

        jLDeposito.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLDeposito.setText("Valor do Depósito (separe as casas decimais com '.')");

        jTFDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFDepositoActionPerformed(evt);
            }
        });

        jLSaldo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLSaldo.setText("Saldo atual do acampante");

        jTFSaldo.setEditable(false);
        jTFSaldo.setFocusable(false);

        jBAtualizar.setText("Atualizar saldo");
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

        jLLider.setText("Quem recebeu (caixa)?");

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
                            .addComponent(jCBAcampantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFSaldo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLSaldo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTFPesquisa, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLAcampante)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLDeposito)
                                .addGap(115, 115, 115)
                                .addComponent(jLExib, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLLider)
                            .addComponent(jCBLider, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jBDepositar)
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar))
                .addGap(6, 6, 6)
                .addComponent(jLAcampante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBAcampantes, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLSaldo)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAtualizar))
                        .addGap(10, 10, 10)
                        .addComponent(jLDeposito))
                    .addComponent(jLExib, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLLider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCBLider, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //  BOTÃO QUE FAZ PESQUISA DE NOME DO ACAMPANTE NO BD
    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        PesquisarAcampante pesq = new PesquisarAcampante();
        
        pesq.pesquisar(jTFPesquisa, jCBAcampantes);
    }//GEN-LAST:event_jBPesquisarActionPerformed

    //  FAZ A PESQUISA DE NOME DO ACAMPANTE POR ENTER
    private void jTFPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPesquisaActionPerformed
        jBPesquisarActionPerformed(evt);
    }//GEN-LAST:event_jTFPesquisaActionPerformed

    //  BOTÃO QUE EFETUA O DEPÓSITO NO NOME DO ACAMPANTE
    private void jBDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDepositarActionPerformed
        String acamp, lider;

        double valor, total, novoTotal;

        acamp = (jCBAcampantes.getSelectedItem().toString());
        lider = (jCBLider.getSelectedItem().toString());

        valor = Double.parseDouble(jTFDeposito.getText());

        try {

            //  busca e atualização de saldo na tabela ACAMPANTE
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select saldo from acampante where nome='" + acamp + "'";

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            total = rs.getDouble("saldo");

            novoTotal = total + valor;

            String update = "update acampante set saldo = " + novoTotal + " where nome='" + acamp + "'";

            PreparedStatement stmt = con.prepareStatement(update);
            int res = stmt.executeUpdate(update);

            //  registro de depósito na tabela DEPOSITO
            Statement state = con.createStatement();

            String sel = "select id from acampante where nome='" + acamp + "'";

            ResultSet r = state.executeQuery(sel);
            r.next();
            int id = r.getInt("id");
            System.out.println(id);

            String insert = "insert into deposito(valor, id_acamp, lider_caixa, saldo_inicial, saldo_final) values (?,?,?,?,?)";
            System.out.println("Connection established!");

            PreparedStatement input = con.prepareStatement(insert);

            input.setDouble(1, valor);
            input.setInt(2, id);
            input.setString(3, lider);
            input.setDouble(4, total);
            input.setDouble(5, novoTotal);

            input.executeUpdate();

            input.close();
            System.out.println("Connection closed!");
            
            dispose();
            DepositoAcampante obj = new DepositoAcampante();
            obj.setVisible(true);
            
            System.out.printf("O novo total é de R$%.2f\n", novoTotal);
            JOptionPane.showMessageDialog(jLExib, String.format("Depósito efetuado com sucesso! O novo saldo é de R$%.2f", novoTotal));

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);;
        }
    }//GEN-LAST:event_jBDepositarActionPerformed

    //  EFETUA O DEPÓSITO NO NOME DO ACAMPANTE POR ENTER
    private void jTFDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFDepositoActionPerformed
        jBDepositarActionPerformed(evt);
    }//GEN-LAST:event_jTFDepositoActionPerformed

    //  BOTÃO QUE ATUALIZA O SALDO DO ACAMPANTE
    private void jBAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAtualizarActionPerformed
        String acamp = (jCBAcampantes.getSelectedItem().toString());

        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select saldo from acampante where nome='" + acamp + "'";
            //System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                double total = rs.getDouble("saldo");

                String inter = String.valueOf(total);
                jTFSaldo.setText(inter);
            }
        } catch (SQLException ex) {
            System.err.println(ex);

        } catch (Exception ex) {
            Logger.getLogger(DepositoAcampante.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAtualizarActionPerformed

    //  BOTÃO QUE REDIRECIONA PARA A TELA PRINCIPAL
    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        dispose();
        TelaPrincipal set = new TelaPrincipal();
        set.setVisible(true);
    }//GEN-LAST:event_jBVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(DepositoAcampante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepositoAcampante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepositoAcampante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepositoAcampante.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DepositoAcampante().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAtualizar;
    private javax.swing.JButton jBDepositar;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox jCBAcampantes;
    private javax.swing.JComboBox jCBLider;
    private javax.swing.JLabel jLAcampante;
    private javax.swing.JLabel jLDeposito;
    private javax.swing.JLabel jLExib;
    private javax.swing.JLabel jLLider;
    private javax.swing.JLabel jLSaldo;
    private javax.swing.JTextField jTFDeposito;
    private javax.swing.JTextField jTFPesquisa;
    private javax.swing.JTextField jTFSaldo;
    // End of variables declaration//GEN-END:variables
}
