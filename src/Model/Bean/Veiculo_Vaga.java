/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

import java.sql.Date;

/**
 *
 * @author lucas
 */
public class Veiculo_Vaga {
    private int idLocacao;
    private String entradaLocacao;
    private String saidaLocacao;
    private float valorLocacao;
    private int idVeiculoLocacao;
    private int idVagaLocacao;

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public String getEntradaLocacao() {
        return entradaLocacao;
    }

    public void setEntradaLocacao(String entradaLocacao) {
        this.entradaLocacao = entradaLocacao;
    }

    public String getSaidaLocacao() {
        return saidaLocacao;
    }

    public void setSaidaLocacao(String saidaLocacao) {
        this.saidaLocacao = saidaLocacao;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public int getIdVeiculoLocacao() {
        return idVeiculoLocacao;
    }

    public void setIdVeiculoLocacao(int idVeiculoLocacao) {
        this.idVeiculoLocacao = idVeiculoLocacao;
    }

    public int getIdVagaLocacao() {
        return idVagaLocacao;
    }

    public void setIdVagaLocacao(int idVagaLocacao) {
        this.idVagaLocacao = idVagaLocacao;
    }   
    
}
