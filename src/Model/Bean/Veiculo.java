/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author lucas
 */
public class Veiculo {
    private int idVeiculo;
    private String placaVeiculo;
    private int idClienteVeiculo;

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public int getIdClienteVeiculo() {
        return idClienteVeiculo;
    }

    public void setIdClienteVeiculo(int idClienteVeiculo) {
        this.idClienteVeiculo = idClienteVeiculo;
    }

    public Veiculo(int idVeiculo, String placaVeiculo, int idClienteVeiculo) {
        this.idVeiculo = idVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.idClienteVeiculo = idClienteVeiculo;
    }

    public Veiculo() {
    }
    
    
    
}
