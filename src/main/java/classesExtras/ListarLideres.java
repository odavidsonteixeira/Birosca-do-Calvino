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
import javax.swing.JComboBox;
import telas.telasInt.DepositoAcampante;

public class ListarLideres {
    
    public void listar (javax.swing.JComboBox lid) {
        lid.removeAllItems();
        lid.addItem("------");
        
        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome from lideranca";

            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next()) {
                lid.addItem(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao carregar o ComboBox");
        } catch (Exception ex) {
            Logger.getLogger(DepositoAcampante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pesquisar(JComboBox jCBLider) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
