/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Bean;

/**
 *
 * @author lucas
 */
public class Vaga {
    private int idVaga;
    private String tipoVaga;
    private Boolean estadoVaga;

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

    public Boolean getEstadoVaga() {
        return estadoVaga;
    }

    public void setEstadoVaga(Boolean estadoVaga) {
        this.estadoVaga = estadoVaga;
    }
    
}
