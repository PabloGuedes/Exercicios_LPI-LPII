/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dao.ConexaoDAO;
import br.com.projeto_4.dao.VendaDAO;
import br.com.projeto_4.dto.VendaDTO;
import br.com.projeto_4.dto.ClienteDTO;
import javax.swing.JTable;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class VendaCTR {
    VendaDAO vendaDAO = new VendaDAO();
    
    public VendaCTR(){
        
    }
    
    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable carros){
        try{
            if(vendaDAO.inserirVenda(vendaDTO, clienteDTO, carros)){
                return "Venda cadastrada com sucesso!!!";
            }
            else{
                System.out.println("1");
                return "Venda não cadastrada!!!";
            }
        }
        catch(Exception e){
            System.out.println("2");
            System.out.println(e.getMessage());
            return "Venda não cadastrada!!!";
        }
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
}
