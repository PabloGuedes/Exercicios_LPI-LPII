/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controledejogadores.dto;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class JogadorDTO {
    private String nome_jog, tipocon_jog, clube_jog;
    private Date datanasc_jog, dataini_jog, datater_jog, datapub_jog;
    private int id_jog, numcon_jog;

    public String getNome_jog() {
        return nome_jog;
    }

    public void setNome_jog(String nome_jog) {
        this.nome_jog = nome_jog;
    }

    public String getTipocon_jog() {
        return tipocon_jog;
    }

    public void setTipocon_jog(String tipocon_jog) {
        this.tipocon_jog = tipocon_jog;
    }

    public String getClube_jog() {
        return clube_jog;
    }

    public void setClube_jog(String clube_jog) {
        this.clube_jog = clube_jog;
    }

    public Date getDatanasc_jog() {
        return datanasc_jog;
    }

    public void setDatanasc_jog(Date datanasc_jog) {
        this.datanasc_jog = datanasc_jog;
    }

    public Date getDataini_jog() {
        return dataini_jog;
    }

    public void setDataini_jog(Date dataini_jog) {
        this.dataini_jog = dataini_jog;
    }

    public Date getDatater_jog() {
        return datater_jog;
    }

    public void setDatater_jog(Date datater_jog) {
        this.datater_jog = datater_jog;
    }

    public Date getDatapub_jog() {
        return datapub_jog;
    }

    public void setDatapub_jog(Date datapub_jog) {
        this.datapub_jog = datapub_jog;
    }

    public int getId_jog() {
        return id_jog;
    }

    public void setId_jog(int id_jog) {
        this.id_jog = id_jog;
    }
    
    public int getNumcon_jog() {
        return numcon_jog;
    }

    public void setNumcon_jog(int numcon_jog) {
        this.numcon_jog = numcon_jog;
    }
    
    
}
