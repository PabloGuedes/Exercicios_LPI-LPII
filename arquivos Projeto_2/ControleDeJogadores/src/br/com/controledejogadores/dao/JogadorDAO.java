/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controledejogadores.dao;

import java.sql.*;
import br.com.controledejogadores.dto.JogadorDTO;
import java.text.SimpleDateFormat;

/**
 *
 * @author Aluno
 */
public class JogadorDAO {

    public JogadorDAO() {
    }

    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean inserirJogador(JogadorDTO jogadorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into jogador (nome_jog, datanasc_jog, numcon_jog, tipocon_jog, "
                    + "dataini_jog, datater_jog, datapub_jog, clube_jog) values ("
                    + "'" + jogadorDTO.getNome_jog() + "', "
                    + "to_date('" + data_format.format(jogadorDTO.getDatanasc_jog()) + "', 'dd/mm/yyyy'), "
                    + jogadorDTO.getNumcon_jog() + ", "
                    + "'" + jogadorDTO.getTipocon_jog() + "', "
                    + "to_date('" + data_format.format(jogadorDTO.getDataini_jog()) + "', 'dd/mm/yyyy'), "
                    + "to_date('" + data_format.format(jogadorDTO.getDatater_jog()) + "', 'dd/mm/yyyy'), "
                    + "to_date('" + data_format.format(jogadorDTO.getDatapub_jog()) + "', 'dd/mm/yyyy'), "
                    + "'" + jogadorDTO.getClube_jog() + "')";
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

    public boolean alterarJogador(JogadorDTO jogadorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update jogador set "
                    + "nome_jog = '" + jogadorDTO.getNome_jog() + "', "
                    + "datanasc_jog = to_date('" + data_format.format(jogadorDTO.getDatanasc_jog()) + "','dd/mm/yyyy'), "
                    + "numcon_jog = '" + jogadorDTO.getNumcon_jog() + "', "
                    + "tipocon_jog = '" + jogadorDTO.getTipocon_jog() + "', "
                    + "dataini_jog = to_date('" + data_format.format(jogadorDTO.getDataini_jog()) + "','dd/mm/yyyy'), "
                    + "datater_jog = to_date('" + data_format.format(jogadorDTO.getDatater_jog()) + "','dd/mm/yyyy'), "
                    + "datapub_jog = to_date('" + data_format.format(jogadorDTO.getDatapub_jog()) + "','dd/mm/yyyy'), "
                    + "clube_jog = '" + jogadorDTO.getClube_jog() + "' "
                    + "where id_jog = " + jogadorDTO.getId_jog();
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

    public boolean excluirJogador(JogadorDTO jogadorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from jogador where id_jog = " + jogadorDTO.getId_jog();
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

    public ResultSet consultarJogador(JogadorDTO jogadorDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select c.id_jog, c.nome_jog "
                            + "from jogador c "
                            + "where c.nome_jog ilike '" + jogadorDTO.getNome_jog() + "%' "
                            + "order by c.nome_jog";
                    break;

                case 2:
                    comando = "Select c.id_jog, c.nome_jog, to_char(c.datanasc_jog, 'dd/mm/yyyy') as datanasc_jog, "
                            + "c.numcon_jog, c.tipocon_jog, to_char(c.dataini_jog, 'dd/mm/yyyy') as dataini_jog,"
                            + "to_char(c.datater_jog, 'dd/mm/yyyy') as datater_jog, to_char(c.datapub_jog, 'dd/mm/yyyy') as datapub_jog, "
                            + "c.clube_jog from jogador c "
                            + "where c.id_jog = " + jogadorDTO.getId_jog();
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
