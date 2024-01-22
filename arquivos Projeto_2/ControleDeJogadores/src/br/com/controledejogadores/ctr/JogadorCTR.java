/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controledejogadores.ctr;

import java.sql.ResultSet;
import br.com.controledejogadores.dto.JogadorDTO;
import br.com.controledejogadores.dao.JogadorDAO;
import br.com.controledejogadores.dao.ConexaoDAO;

public class JogadorCTR {
    
    JogadorDAO jogadorDAO = new JogadorDAO();
    
    public String inserirJogador(JogadorDTO jogadorDTO){
        try{
            if(jogadorDAO.inserirJogador(jogadorDTO)){
                return "Jogador cadastrado com sucesso.";
            } 
            else{
                return "Jogador não cadastrado.";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Jogador não cadastrado.";
        }
    }
    
    public ResultSet consultarJogador(JogadorDTO jogadorDTO, int opcao){
        ResultSet rs = null;
        rs = jogadorDAO.consultarJogador(jogadorDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
    public String alterarJogador(JogadorDTO jogadorDTO){
        try{
            if(jogadorDAO.alterarJogador(jogadorDTO)){
                return "Jogador alterado com sucesso!";
            }
            else{
                return "Jogador NÃO alterado!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Jogador NÃO alterado!";
        }
    }
    
    public String excluirJogador(JogadorDTO jogadorDTO){
        try{
            if(jogadorDAO.excluirJogador(jogadorDTO)){
                return "Jogador excluído com sucesso!";
            }
            else{
                return "Jogador NÃO excluído!";
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return "Jogador NÃO excluído!";
        }
    }
}
