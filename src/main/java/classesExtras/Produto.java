/*
 * The MIT License
 *
 * Copyright 2024 Davidson Teixeira Filho.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package classesExtras;

import DAO.Conexao;
import com.mycompany.biroscadocalvino.CadastroProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.telasInt.DepositoAcampante;

/**
 *
 * @author: Davidson Teixeira Filho
 * @modified on: 29/01/2024
 */
public class Produto {

    public void cadastrar(javax.swing.JLabel jLExib, String nome, double valor, int quantidade) {
        try {
            String insert = "insert into produto(nome, valor, quantidade) values (?, ?, ?)";
            Connection con = new Conexao().getConnection();
            System.out.println("Connection established!");

            PreparedStatement stmt = con.prepareStatement(insert);

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setInt(3, quantidade);

            stmt.executeUpdate();

            stmt.close();
            System.out.println("Connection closed!");

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alterar(String pesquisa, String nome,double novoValor, String lider) throws Exception {

        int id = getID(pesquisa);
        
        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select valor from produto where nome='" + pesquisa + "'";

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            double valor = rs.getDouble("valor");

            String update = "update produto set nome = '"+ nome +"', valor = " + novoValor + " where id =" + id + "";
            PreparedStatement stmt = con.prepareStatement(update);
            int res = stmt.executeUpdate(update);
            
            if (valor!=novoValor) {
                inputAlteracoesValores(id, valor, novoValor, lider);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void inputAlteracoesValores(int id, double valor, double novoValor, String lider) {
        try {
            //  busca e atualização de valor na tabela Produto
            Connection con = new Conexao().getConnection();

            //  registro de depósito na tabela COMPRA
            Statement state = con.createStatement();

            String insert = "insert into alteracoesProduto(valor_inicial, valor_final, id_prod, lider_caixa) values (?,?,?,?)";
            System.out.println("Connection established!");

            PreparedStatement input = con.prepareStatement(insert);

            input.setDouble(1, valor);
            input.setDouble(2, novoValor);
            input.setInt(3, id);
            input.setString(4, lider);

            input.executeUpdate();

            input.close();
            System.out.println("Connection closed!");

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public int getID(String nome) throws Exception {
        int id = 0;
        try {
            Connection con = new Conexao().getConnection();

            String sql = "select id from produto where nome='" + nome + "';";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                id = rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return id;
    }
    
    public void getProduto(javax.swing.JComboBox prod, javax.swing.JTextField nome,
            javax.swing.JTextField valorAtual, javax.swing.JTextField valorNovo) throws Exception {

        String name = "";
        double valorAt = 0.00, valorNov = 0.00;
        
        String pesquisa;

        pesquisa = (prod.getSelectedItem().toString());
        int id = getID(pesquisa);

        try {
            
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome, valor from produto where id ="+id+";";
            //System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("nome");
                valorAt = rs.getDouble("valor");
            }

            nome.setText(name);
            valorAtual.setText(String.valueOf(valorAt));

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public void pesquisar(String pesquisa, javax.swing.JComboBox prod) throws Exception {
        prod.removeAllItems();
        prod.addItem("------");
        
        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome from produto where nome like '%" + pesquisa + "%'";

            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next()) {
                prod.addItem(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao carregar o ComboBox");
        }
    }
    
    public void listar (javax.swing.JComboBox prod) throws Exception {
        prod.removeAllItems();
        prod.addItem("------");
        
        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome from produto";

            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next()) {
                prod.addItem(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao carregar o ComboBox");
        }
    }
}
