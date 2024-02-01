package DAO;

/**
 * @author: Davidson Teixeira Filho
 * @date: 03/01/2023
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    public Connection getConnection() throws Exception {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/church_sys", "root", "");
        }catch (SQLException ex){
            System.out.println(ex);        
        } return null;
    }
}
