/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_4.dao;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import br.com.projeto_4.dto.FuncionarioDTO;
/**
 *
 * @author Pablo Guedes Bacca
 */
public class FuncionarioDAO {
    
    public FuncionarioDAO() {
    
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO funcionario (nome_fun, cpf_fun, "
                    + "login_fun, senha_fun, tipo_fun) VALUES ( "
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getCpf_fun() + "', "
                    + "'" + funcionarioDTO.getLogin_fun() + "', "
                    + "'" + criptografar(funcionarioDTO.getSenha_fun()) + "', "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase() + "') ";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            comando = "UPDATE funcionario SET "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = '" + funcionarioDTO.getLogin_fun() + "', ";
            if (funcionarioDTO.getSenha_fun() != null){
                comando += "senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + ", ";
            }

            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun().toUpperCase() + "' "
                    + "WHERE id_fun = " + funcionarioDTO.getId_fun();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM funcionario WHERE id_fun = "
                    + funcionarioDTO.getId_fun();
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch(opcao){
                case 1:
                    comando = "SELECT f.* " +
                            "FROM funcionario f " +
                            "WHERE nome_fun ILIKE '" + funcionarioDTO.getNome_fun() + "%' " +
                            "ORDER BY f.nome_fun";
                break;
                case 2:
                    comando = "SELECT f.* " +
                            "FROM funcionario f " +
                            "WHERE f.id_fun = " + funcionarioDTO.getId_fun();
                break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public String logarFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT f.tipo_fun " +
                    "FROM funcionario f " +
                    "WHERE f.login_fun = '" + funcionarioDTO.getLogin_fun() + "'" +
                    "AND f.senha_fun = '" + criptografar(funcionarioDTO.getSenha_fun()) + "'";
            rs = null;
            rs = stmt.executeQuery(comando);
            if(rs.next()){
                return rs.getString("tipo_fun");
            }
            else {
                return "";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    private static MessageDigest md = null;
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    
    private static char[] hexCodes(byte[] text){
        char[] hexOutput = new char[text.length * 3];
        String hexString;
        
        for (int i = 0; i < text.length; i++){
            hexString = "00" + Integer.toHexString(i);
            hexString.toUpperCase().getChars(hexString.length() - 3,
                    hexString.length(), hexOutput, i * 3);
        }
        return hexOutput;
    }
    
    public static String criptografar (String pwd){
        if (md != null){
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
}
