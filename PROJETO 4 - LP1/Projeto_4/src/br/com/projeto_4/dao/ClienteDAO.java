/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.dao;

import java.sql.*;
import br.com.projeto_4.dto.ClienteDTO;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class ClienteDAO {
    public ClienteDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO cliente (nome, cpf, rua, numero, "
                    + "bairro, cidade, estado) VALUES ("
                    + "'" + clienteDTO.getNome() + "', "
                    + "'" + clienteDTO.getCpf() + "', "
                    + "'" + clienteDTO.getRua() + "', "
                    + "" + clienteDTO.getNumero() + ", "
                    + "'" + clienteDTO.getBairro() + "', "
                    + "'" + clienteDTO.getCidade() + "', "
                    + "'" + clienteDTO.getEstado() + "') ";
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

    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE cliente SET "
                    + "nome = '" + clienteDTO.getNome() + "', "
                    + "cpf = '" + clienteDTO.getCpf() + "', "
                    + "rua = '" + clienteDTO.getRua() + "', "
                    + "numero = " + clienteDTO.getNumero() + ", "
                    + "bairro = '" + clienteDTO.getBairro() + "', "
                    + "cidade = '" + clienteDTO.getCidade() + "', "
                    + "estado = '" + clienteDTO.getEstado() + "' "
                    + "WHERE id_cliente = " + clienteDTO.getId_cliente();
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

    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM cliente WHERE id_cliente = " + clienteDTO.getId_cliente();
            stmt.execute(comando);
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

    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT c.* "
                            + "FROM cliente c "
                            + "WHERE nome LIKE '" + clienteDTO.getNome() + "%' "
                            + "ORDER BY c.nome";
                    break;
                case 2:
                    comando = "SELECT c.* "
                            + "FROM cliente c "
                            + "WHERE c.id_cliente = " + clienteDTO.getId_cliente();
                    break;
                case 3:
                    comando = "SELECT c.id_cliente, c.nome "
                            + "FROM cliente c ";
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}
