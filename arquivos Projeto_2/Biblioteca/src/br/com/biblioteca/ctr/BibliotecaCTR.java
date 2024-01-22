package br.com.biblioteca.ctr;

import java.sql.ResultSet;
import br.com.biblioteca.dto.BibliotecaDTO;
import br.com.biblioteca.dao.BibliotecaDAO;
import br.com.biblioteca.dao.ConexaoDAO;

public class BibliotecaCTR {
    
    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    
    public String inserirLivro(BibliotecaDTO bibliotecaDTO){
        try{
            if(bibliotecaDAO.inserirLivro(bibliotecaDTO)){
                return "Livro cadastrado com sucesso.";
            } 
            else{
                return "Livro NÃO cadastrado.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Livro NÃO cadastrado.";
        }
    }
    
    public ResultSet consultarLivro(BibliotecaDTO bibliotecaDTO, int opcao){
        ResultSet rs = null;
        rs = bibliotecaDAO.consultarLivro(bibliotecaDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String alterarLivro(BibliotecaDTO bibliotecaDTO){
        try{
            if(bibliotecaDAO.alterarLivro(bibliotecaDTO)){
                return "Livro alterado com sucesso!";
            }
            else{
                return "Livro NÃO alterado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Livro NÃO alterado!";
        }
    }
    
    public String excluirLivro(BibliotecaDTO bibliotecaDTO){
        try{
            if(bibliotecaDAO.excluirLivro(bibliotecaDTO)){
                return "Livro excluído com sucesso!";
            }
            else{
                return "Livro NÃO excluído!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Livro NÃO excluído!";
        }
    }
}

