/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dto.CarroDTO;
import br.com.projeto_4.dao.CarroDAO;
import br.com.projeto_4.dao.ConexaoDAO;
import java.sql.ResultSet;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class CarroCTR {
    CarroDAO carroDAO = new CarroDAO();

    public CarroCTR() {
    }
    
    public String inserirCarro(CarroDTO carroDTO) {
        try {
     
            if (carroDAO.inserirCarro(carroDTO)) {
                return "Carro cadastrado com sucesso!!!";
            } else {
                return "Carro NÃO cadastrado!!!";
            }
        }		
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO cadastrado!!!";
        }
    }
    
    public String alterarCarro(CarroDTO carroDTO) {
        try {
            
            if (carroDAO.alterarCarro(carroDTO)) {
                return "Carro alterado com sucesso!!!";
            } else {
                return "Carro NÃO alterado!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO alterado!!!";
        }
    }
    
    public String excluirCarro(CarroDTO carroDTO) {
        try {
            
            if (carroDAO.excluirCarro(carroDTO)) {
                return "Carro excluído com sucesso!!!";
            } else {
                return "Carro NÃO excluído!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Carro NÃO excluído!!!";
        }
    }
    
    public ResultSet consultarCarro(CarroDTO carroDTO, int opcao) {
        
        ResultSet rs = null;
    
        rs = carroDAO.consultarCarro(carroDTO, opcao);
        return rs;
    }
    
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
