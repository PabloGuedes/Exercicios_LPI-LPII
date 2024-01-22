/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controledejogadores.dao;

import java.sql.*;
/**
 *
 * @author Aluno
 */
public class ConexaoDAO {
    public static Connection con = null;
    
    public ConexaoDAO(){
        
    }
    
    public static void ConectDB(){
        try{
            String dan = "projeto_2";
            String user = "postgres";
            String senha = "postdba";
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            
            String url = "jdbc:postgresql://localhost:5432/" + dan;
            
            con = DriverManager.getConnection(url, user, senha);
            
            con.setAutoCommit(false);
            
            if(con == null){
                System.out.println("Erroao abrir o banco!");
            }
        }
        catch(Exception e){
            System.out.println("Problema ao abrir a base de dados!" + e.getMessage());
        }
    }
    
    public static void CloseDB(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Problema ao fechar a base de dados!" + e.getMessage());
        }
    }
    
}