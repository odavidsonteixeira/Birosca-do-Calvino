package DAO;

/**
 * @author : Davidson Teixeira Filho
 * @date : 26/01/2023
 */

import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException, Exception{
        try{
            try (Connection connection = new Conexao().getConnection()) {
                System.out.println("Conexão aberta!!!");
            }
            System.out.println("Conexão fechada!!!");
        }catch (SQLException ex){
            System.err.println("Deu erro!");
        }
    }
}