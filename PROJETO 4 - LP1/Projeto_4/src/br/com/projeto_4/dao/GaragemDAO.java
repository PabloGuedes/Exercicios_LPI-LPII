/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.dao;

import java.sql.*;
import br.com.projeto_4.dto.GaragemDTO;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class GaragemDAO {
    public GaragemDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirGaragem(GaragemDTO garagemDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO garagem (nome, cnpj, "
                    + "telefone, estoque) VALUES ("
                    + "'" + garagemDTO.getNome() + "', "
                    + garagemDTO.getCnpj() + ", "
                    + garagemDTO.getTelefone() + ", "
                    + "'" + garagemDTO.getEstoque() + "') ";
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

    public boolean alterarGaragem(GaragemDTO garagemDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "UPDATE garagem SET "
                    + "nome = '" + garagemDTO.getNome() + "', "
                    + "cnpj = " + garagemDTO.getCnpj() + ", "
                    + "telefone = " + garagemDTO.getTelefone() + ", "
                    + "estoque = '" + garagemDTO.getEstoque() + "' "
                    + "WHERE id_garagem = " + garagemDTO.getId_garagem();
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

    public boolean excluirGaragem(GaragemDTO garagemDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM garagem WHERE id_garagem = " + garagemDTO.getId_garagem();
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

    public ResultSet consultarGaragem(GaragemDTO garagemDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT c.* "
                            + "FROM garagem c "
                            + "WHERE nome LIKE '" + garagemDTO.getNome() + "%' "
                            + "ORDER BY c.nome";
                    break;
                case 2:
                    comando = "SELECT c.* "
                            + "FROM garagem c "
                            + "WHERE c.id_garagem = " + garagemDTO.getId_garagem();
                    break;
                case 3:
                    comando = "SELECT c.id_garagem, c.nome "
                            + "FROM garagem c ";
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
