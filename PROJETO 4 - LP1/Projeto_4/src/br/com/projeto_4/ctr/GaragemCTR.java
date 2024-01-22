/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dto.GaragemDTO;
import br.com.projeto_4.dao.GaragemDAO;
import br.com.projeto_4.dao.ConexaoDAO;
import java.sql.ResultSet;

/**
 *
 * @author Pablo Guedes Bacca
 */
public class GaragemCTR {

    GaragemDAO garagemDAO = new GaragemDAO();

    public GaragemCTR() {
    }

    public String inserirGaragem(GaragemDTO garagemDTO) {
        try {

            if (garagemDAO.inserirGaragem(garagemDTO)) {
                return "Garagem cadastrada com sucesso!!!";
            } else {
                return "Garagem NÃO cadastrada!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Garagem NÃO cadastrada!!!";
        }
    }

    public String alterarGaragem(GaragemDTO garagemDTO) {
        try {

            if (garagemDAO.alterarGaragem(garagemDTO)) {
                return "Garagem alterada com sucesso!!!";
            } else {
                return "Garagem NÃO alterada!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Garagem NÃO alterada!!!";
        }
    }

    public String excluirGaragem(GaragemDTO garagemDTO) {
        try {

            if (garagemDAO.excluirGaragem(garagemDTO)) {
                return "Garagem excluída com sucesso!!!";
            } else {
                return "Garagem NÃO excluída!!!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Garagem NÃO excluída!!!";
        }
    }

    public ResultSet consultarGaragem(GaragemDTO garagemDTO, int opcao) {

        ResultSet rs = null;

        rs = garagemDAO.consultarGaragem(garagemDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
