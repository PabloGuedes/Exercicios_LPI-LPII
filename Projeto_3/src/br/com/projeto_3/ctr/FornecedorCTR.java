/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.FornecedorDTO;
import br.com.projeto_3.dao.FornecedorDAO;
import br.com.projeto_3.dao.ConexaoDAO;
/**
 *
 * @author Aluno
 */
public class FornecedorCTR {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor cadastrado com sucesso.";
            } 
            else{
                return "Fornecedor não cadastrado.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor não cadastrado.";
        }
    }
    
    public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor alterado com sucesso!";
            }
            else{
                return "Fornecedor NÃO alterado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado!";
        }
    }
    
    public String excluirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor excluído com sucesso!";
            }
            else{
                return "Fornecedor NÃO excluído!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO excluído!";
        }
    }
    
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
        ResultSet rs = null;
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
