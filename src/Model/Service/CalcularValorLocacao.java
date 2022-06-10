/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author lucas
 */
public class CalcularValorLocacao {

    public int calcularHorasLocacao(String dtIn, String dtOut){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
        LocalDateTime dt1 = LocalDateTime.parse(dtIn, formatter);
        LocalDateTime dt2 = LocalDateTime.parse(dtOut, formatter);
        int numeroHoras = (int) ChronoUnit.HOURS.between(dt1, dt2);
        return numeroHoras;
    }
    
    public float calcularValorLocacao(int horasLocacao){
        if(horasLocacao == 0){
            return 5;
        }
        float valorLocacao = horasLocacao * 5;
        return  valorLocacao;
    }
}
