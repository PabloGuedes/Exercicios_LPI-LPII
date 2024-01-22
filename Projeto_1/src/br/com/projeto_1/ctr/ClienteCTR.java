/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.ctr;

import java.sql.ResultSet;
import br.com.projeto_1.dto.ClienteDTO;
import br.com.projeto_1.dao.ClienteDAO;
import br.com.projeto_1.dao.ConexaoDAO;

public class ClienteCTR {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public String inserirCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente cadastrado com sucesso.";
            } 
            else{
                return "Cliente não cadastrado.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente não cadastrado.";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        ResultSet rs = null;
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String alterarCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.alterarCliente(clienteDTO)){
                return "Cliente alterado com sucesso!";
            }
            else{
                return "Cliente NÃO alterado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado!";
        }
    }
    
    public String excluirCliente(ClienteDTO clienteDTO){
        try{
            if(clienteDAO.excluirCliente(clienteDTO)){
                return "Cliente excluído com sucesso!";
            }
            else{
                return "Cliente NÃO excluído!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Cliente NÃO excluído!";
        }
    }
}
