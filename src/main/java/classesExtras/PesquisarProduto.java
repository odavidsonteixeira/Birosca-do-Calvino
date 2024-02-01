package classesExtras;

/**
 * @author : Davidson Teixeira Filho
 * @date : 26/01/2023
 */

import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.telasInt.TelaVenda;

public class PesquisarProduto {
    
    public String nome;
    public double valor;
    
    public void pesquisar(javax.swing.JTextField pesq, javax.swing.JComboBox prod) {
        prod.removeAllItems();
        prod.addItem("------");

        String pesquisa;

        pesquisa = (pesq.getText());

        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome, quantidade, valor from produto where nome like '%" + pesquisa + "%'";

            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next()) {
                prod.addItem(rs.getString("nome"));
                this.nome= rs.getString("nome");
                this.valor= rs.getDouble("valor");
            }

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao carregar o ComboBox");
        } catch (Exception ex) {
            Logger.getLogger(TelaVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
