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
import com.mycompany.biroscadocalvino.CadastroAcampante;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import telas.telasInt.DepositoAcampante;

/**
 *
 * @author: Davidson Teixeira Filho
 * @modified on: 29/01/2024
 */
public class Acampante {
    public void alterarAcampante(javax.swing.JComboBox acamp, javax.swing.JLabel jLExib, String nome, int idade, String contato,
            String rg, String alergia) throws Exception {
        
        String pesquisa;

        pesquisa = (acamp.getSelectedItem().toString());
        int id = getID(pesquisa);

        try {
            //  busca e atualização de saldo na tabela ACAMPANTE
            Connection con = new Conexao().getConnection();
            
            //acampante(nome, idade, contato, saldo, rg, alergia

            String update = "update acampante set nome = '" + nome + "', idade = " + idade + ", contato = '" + contato + "', rg = '" + rg + "', alergia = '" + alergia + "' where id=" + id + "";

            Statement stmt = con.prepareStatement(update);
            stmt.executeUpdate(update);
            
            JOptionPane.showMessageDialog(jLExib, "Acampante atualizado com sucesso!");
            
        } catch (Exception ex) {
            Logger.getLogger(com.mycompany.biroscadocalvino.AlterarAcampanteScreen.class
                .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(jLExib, "Deu errado!");
        }

    }
    
    public int getID(String nome) throws Exception {
        int id = 0;
        try {
            Connection con = new Conexao().getConnection();

            String sql = "select id from acampante where nome='" + nome + "';";

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
    
    public void export(JLabel jLExib){
        String caminho, nomeArquivo;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Selecione uma pasta");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        nomeArquivo = null;

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            caminho = (chooser.getSelectedFile()).toString();

            // Exibe a caixa de diálogo para a entrada de texto
            String userInput = JOptionPane.showInputDialog(jLExib,"Digite o nome do arquivo:");

            // Verifica se o usuário clicou em "Cancelar" ou fechou a caixa de diálogo
            if (userInput == null) {
                System.out.println("Operação cancelada!");

            } else {
                nomeArquivo = userInput;
            }

            try {
                Connection con = new DAO.Conexao().getConnection();

                String sql = "select distinct id, nome, idade, contato, rg, alergia from acampante order by nome";

                PreparedStatement stmt = con.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery();

                XSSFWorkbook workbook = new XSSFWorkbook();
                org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Acampantes");

                // Criar estilo para o cabeçalho
                CellStyle headerStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setColor(IndexedColors.BLACK.getIndex()); // Cor do texto no cabeçalho
                headerStyle.setFont(font);
                headerStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE1.getIndex()); // Cor de fundo do cabeçalho
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                // Criar uma linha para o cabeçalho
                Row headerRow = sheet.createRow(0);

                // Adicionar cabeçalho à linha usando o estilo
                String[] headers = {"ID BD", "Nome", "Idade", "Contato", "RG", "Alergia"};
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                    cell.setCellStyle(headerStyle);
                }

                int rowNum = 1;
                while (rs.next()) {
                    Row row = sheet.createRow(rowNum++);
                    int colNum = 0;
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        Cell cell = row.createCell(colNum++);
                        cell.setCellValue(rs.getString(i));
                    }
                }

                try ( FileOutputStream outputStream = new FileOutputStream("" + caminho + "/" + nomeArquivo + ".xlsx")) {
                    workbook.write(outputStream);
                }

                System.out.println("Exportação para o caminho:'" + caminho + "' concluída com sucesso!");
            } catch (Exception e) {
            }
        } else {
            System.out.println("Exportação falhou!");
        }
    }
    
    public void getAcampante(javax.swing.JComboBox acamp, javax.swing.JTextField nome,
            javax.swing.JTextField idade, javax.swing.JTextField alergia, javax.swing.JFormattedTextField RG,
            javax.swing.JFormattedTextField contato) throws Exception {

        String name = "", doc = "", phone = "", alergi = "";
        int age = 0;
        
        String pesquisa;

        pesquisa = (acamp.getSelectedItem().toString());
        int id = getID(pesquisa);

        try {
            
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome, idade, contato, rg, alergia from acampante where id ="+id+";";
            //System.out.println(sql);
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("nome");
                age = rs.getInt("idade");
                phone = rs.getString("contato");
                doc = rs.getString("rg");
                alergi = rs.getString("alergia");
            }

            nome.setText(name);
            idade.setText(String.valueOf(age));
            contato.setText(phone);
            RG.setText(doc);
            alergia.setText(alergi);

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
     
     public void pesquisar(String pesquisa, javax.swing.JComboBox acamp) {
        acamp.removeAllItems();
        acamp.addItem("------");
        
        try {
            Connection con = new Conexao().getConnection();
            Statement stm = con.createStatement();

            String sql = "select nome from acampante where nome like '%" + pesquisa + "%'";

            ResultSet rs = (ResultSet) stm.executeQuery(sql);

            while (rs.next()) {
                acamp.addItem(rs.getString("nome"));
            }

        } catch (SQLException ex) {
            System.err.println("Ocorreu um erro ao carregar o ComboBox");
        } catch (Exception ex) {
            Logger.getLogger(DepositoAcampante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void cadastrar(javax.swing.JLabel jLExib, String nome, int idade, String contato, String rg, String alergia) {
         try {
            String insert = "insert into acampante(nome, idade, contato, saldo, rg, alergia) values (?,?,?,?,?,?)";
            Connection con = new Conexao().getConnection();
            System.out.println("Connection established!");

            PreparedStatement stmt = con.prepareStatement(insert);

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, contato);
            stmt.setFloat(4, 0);
            stmt.setString(5, rg);
            stmt.setString(6, alergia);

            stmt.executeUpdate();

            stmt.close();
            System.out.println("Connection closed!");

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroAcampante.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
