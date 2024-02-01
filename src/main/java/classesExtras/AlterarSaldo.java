package classesExtras;

/**
 * @author : Davidson Teixeira Filho
 * @date : 26/01/2023
 */

import DAO.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlterarSaldo {
    
    public double total;
    public double novoTotal;
    public String pesquisa;

    public void alterarSaldo(javax.swing.JComboBox acamp, javax.swing.JLabel jl, double valor) {
        
        pesquisa = (acamp.getSelectedItem().toString());

        try {
            //  busca e atualização de saldo na tabela ACAMPANTE
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select saldo from acampante where nome='" + pesquisa + "'";

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            total = rs.getDouble("saldo");

            if (total < valor) {
            } else {

                novoTotal = total - valor;

                String update = "update acampante set saldo = " + novoTotal + " where nome='" + pesquisa + "'";
                PreparedStatement stmt = con.prepareStatement(update);
                int res = stmt.executeUpdate(update);

                
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
