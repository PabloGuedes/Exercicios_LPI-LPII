/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_4.ctr;

import java.sql.ResultSet;
import br.com.projeto_4.dto.FuncionarioDTO;
import br.com.projeto_4.dao.FuncionarioDAO;
import br.com.projeto_4.dao.ConexaoDAO;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public FuncionarioCTR(){
        
    }
    
    public String inserirFuncionario (FuncionarioDTO funcionarioDTO){
        try{
            if(funcionarioDAO.inserirFuncionario(funcionarioDTO)){
                return "Funcionário cadastrado com sucesso!!!";
            }
            else {
                return "Funcionário NÃO cadastrado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Funcionário NÃO cadastrado!!!";
        }
    }
    
    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionario alterado com sucesso!!!";
            } else {
                return "Funcionario NÃO alterado!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO alterado!!!";
        }
    }
    
    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario excluído com sucesso!!!";
            } else {
                return "Funcionario NÃO excluído!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO excluído!!!";
        }
    }
    
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        
        ResultSet rs = null;
    
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    }
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
