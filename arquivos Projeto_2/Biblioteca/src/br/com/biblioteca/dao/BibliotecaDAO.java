package br.com.biblioteca.dao;

import java.sql.*;
import br.com.biblioteca.dto.BibliotecaDTO;

public class BibliotecaDAO {

    public BibliotecaDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirLivro(BibliotecaDTO bibliotecaDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into livro (isbn_livro, nome_livro, editora_livro, "
                    + "autor_livro, numpag_livro, genero_livro) values ( "
                    + bibliotecaDTO.getIsbn_livro() + ", "
                    + "'" + bibliotecaDTO.getNome_livro() + "', "
                    + "'" + bibliotecaDTO.getEditora_livro() + "', "
                    + "'" + bibliotecaDTO.getAutor_livro() + "', "
                    + bibliotecaDTO.getNumpag_livro() + ", "
                    + "'" + bibliotecaDTO.getGenero_livro() + "') ";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarLivro(BibliotecaDTO bibliotecaDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select c.* "
                            + "from livro c "
                            + "where nome_livro like '" + bibliotecaDTO.getNome_livro() + "%' "
                            + "order by c.nome_livro";
                    break;
                case 2:
                    comando = "Select c.* "
                            + "from livro c "
                            + "where c.id_livro = " + bibliotecaDTO.getId_livro();
                    break;
                case 3:
                    comando = "Select c.id_livro, c_nome_livro "
                            + "from livro c ";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarLivro(BibliotecaDTO bibliotecaDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Update livro set "
                    + "isbn_livro = '" + bibliotecaDTO.getIsbn_livro() + "', "
                    + "nome_livro = '" + bibliotecaDTO.getNome_livro() + "', "
                    + "editora_livro = '" + bibliotecaDTO.getEditora_livro() + "', "
                    + "autor_livro = '" + bibliotecaDTO.getAutor_livro() + "', "
                    + "numpag_livro = '" + bibliotecaDTO.getNumpag_livro() + "', "
                    + "genero_livro = '" + bibliotecaDTO.getGenero_livro() + "' "
                    + "where id_livro = " + bibliotecaDTO.getId_livro();
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirLivro(BibliotecaDTO bibliotecaDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from livro where id_livro = " + bibliotecaDTO.getId_livro();
            
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
}
