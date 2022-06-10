/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author lucas
 */
public class ClienteVeiculoDTO {
    private int idCliente;
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;
    private String placaVeiculo;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public ClienteVeiculoDTO(String nomeCliente, String cpfCliente, String telefoneCliente, String placaVeiculo) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.placaVeiculo = placaVeiculo;
    }

    public ClienteVeiculoDTO(int idCliente, String nomeCliente, String cpfCliente, String telefoneCliente, String placaVeiculo) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.placaVeiculo = placaVeiculo;
    }
        
    public ClienteVeiculoDTO() {
    }  
    
}
