/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dto.ClienteDTO;
import br.com.projeto_4.dao.ClienteDAO;
import br.com.projeto_4.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCTR() {
    }
    
    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
     
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente cadastrado com sucesso!!!";
            } else {
                return "Cliente NÃO cadastrado!!!";
            }
        }		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrado!!!";
        }
    }
    
    public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente alterado com sucesso!!!";
            } else {
                return "Cliente NÃO alterado!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado!!!";
        }
    }
    
    public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente excluído com sucesso!!!";
            } else {
                return "Cliente NÃO excluído!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO excluído!!!";
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        
        ResultSet rs = null;
    
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
