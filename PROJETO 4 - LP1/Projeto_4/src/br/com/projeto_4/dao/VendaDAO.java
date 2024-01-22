/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.dao;

import br.com.projeto_4.dto.ClienteDTO;
import br.com.projeto_4.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class VendaDAO {
   
    public VendaDAO(){
        
    }
    
    private ResultSet rs = null;
    Statement stmt = null;
    Statement stmt1 = null;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable carros){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "INSERT INTO venda (valor_venda, data_venda, "
                    + "id_cliente) VALUES ( "
                    + vendaDTO.getValor_venda() + ", "
                    + "to_date ('" + date.format(vendaDTO.getData_venda()) + "', 'dd/MM/yyyy'), "
                    + clienteDTO.getId_cliente() + ") ";
            
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for(int cont=0; cont < carros.getRowCount(); cont++){
                String comando2 = "INSERT INTO carro_venda (id_venda, id_carro, "
                        + "total_venda, total_carros) VALUES ("
                        + rs.getInt("id_venda") + ", "
                        + carros.getValueAt(cont, 0) + ", "
                        + carros.getValueAt(cont, 2) + ", "
                        + carros.getValueAt(cont, 3) + "); ";
                stmt1.execute(comando2);
            }
            ConexaoDAO.con.commit();
            stmt.close();
            stmt1.close();
            rs.close();
            return true;
        }    
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
}
