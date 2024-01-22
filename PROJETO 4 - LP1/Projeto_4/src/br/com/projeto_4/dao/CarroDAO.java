/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.dao;

import java.sql.*;
import br.com.projeto_4.dto.CarroDTO;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class CarroDAO {

    public CarroDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirCarro(CarroDTO carroDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO carro (nome, placa, preco_carro, modelo, "
                    + "fabricante, cor, chassi, ano) VALUES ("
                    + "'" + carroDTO.getNome() + "', "
                    + "'" + carroDTO.getPlaca() + "', "
                    + "" + carroDTO.getPreco_carro() + ", "
                    + "'" + carroDTO.getModelo() + "', "
                    + "'" + carroDTO.getFabricante() + "', "
                    + "'" + carroDTO.getCor() + "', "
                    + "'" + carroDTO.getChassi() + "', "
                    + "" + carroDTO.getAno() + ") ";
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

    public boolean alterarCarro(CarroDTO carroDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE carro SET "
                    + "nome = '" + carroDTO.getNome() + "', "
                    + "placa = '" + carroDTO.getPlaca() + "', "
                    + "preco_carro = " + carroDTO.getPreco_carro() + ", "
                    + "modelo = '" + carroDTO.getModelo() + "', "
                    + "fabricante = '" + carroDTO.getFabricante() + "', "
                    + "cor = '" + carroDTO.getCor() + "', "
                    + "chassi = '" + carroDTO.getChassi() + "', "
                    + "ano = " + carroDTO.getAno() + " "
                    + "WHERE id_carro = " + carroDTO.getId_carro();
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

    public boolean excluirCarro(CarroDTO carroDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM carro WHERE id_carro = " + carroDTO.getId_carro();
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

    public ResultSet consultarCarro(CarroDTO carroDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT c.* "
                            + "FROM carro c "
                            + "WHERE nome LIKE '" + carroDTO.getNome() + "%' "
                            + "ORDER BY c.nome";
                    break;
                case 2:
                    comando = "SELECT c.* "
                            + "FROM carro c "
                            + "WHERE c.id_carro = " + carroDTO.getId_carro();
                    break;
                case 3:
                    comando = "SELECT c.id_carro, c.nome "
                            + "FROM carro c ";
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
