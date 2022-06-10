/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author lucas
 */
public class HistoricoDTO {
    private int idLocacao;
    private int idVaga;
    private String tipoVaga;
    private String placaVeiculo;
    private String nomeCliente;
    private float valorLocacao;
    private String entradaLocacao;
    private String saidaLocacao;

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {
        this.idVaga = idVaga;
    }

    public String getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(String tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
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
    
    
}
