/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_2.ctr;

import java.sql.ResultSet;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dto.ProdutoDTO;
import br.com.projeto_2.dao.ProdutoDAO;
import br.com.projeto_2.dao.ConexaoDAO;
import br.com.projeto_2.dao.FornecedorDAO;
/**
 *
 * @author rondon cell
 */
public class ProdutoCTR {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public ProdutoCTR(){
        
    }
    
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto cadastrado com sucesso.";
            } 
            else{
                return "Produto não cadastrado.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto não cadastrado.";
        }
    }
    
    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produto alterado com sucesso!";
            }
            else{
                return "Produto NÃO alterado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO alterado!";
        }
    }
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto excluído com sucesso!";
            }
            else{
                return "Produto NÃO excluído!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO excluído!";
        }
    }
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
