/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bean.Vaga;
import Model.Bean.Veiculo_Vaga;
import Model.DAO.Queries;
import Model.DAO.VagaDAO;
import Model.DAO.VeiculoDAO;
import Model.DAO.Veiculo_Vaga_DAO;
import Model.Service.CalcularValorLocacao;
import java.time.LocalDateTime;

/**
 *
 * @author lucas
 */
public class LocacaoController {
    
    public void newParking(String placa, int vaga){
        Veiculo_Vaga vv = new Veiculo_Vaga();
        Veiculo_Vaga_DAO dao = new Veiculo_Vaga_DAO();
        
        //Request do codigo do veiculo através da placa
        VeiculoDAO veiculoDao = new VeiculoDAO();
        int cdVeiculo = veiculoDao.readByPlate(placa);
        
        //Capturar e formatar a data atual        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        
        //Configurar objeto veiculoVagaDao
        vv.setEntradaLocacao(currentTime);
        vv.setSaidaLocacao(null);
        vv.setValorLocacao(0);
        vv.setIdVeiculoLocacao(cdVeiculo);
        vv.setIdVagaLocacao(vaga);
        
        //Inserir novo registro em tb_veiculo_vaga
        dao.create(vv);
        
        //Atualizar estado da vaga para ocupado(false)
        VagaDAO vagaDao = new VagaDAO();
        vagaDao.updateSpotStatus(vaga);
    }
    
    public void offParking(int idLocacao, int idVaga){
        //Recuperar do banco a data de entrada de acordo com o  cd_locacao
        Veiculo_Vaga_DAO veiculoVagaDao = new Veiculo_Vaga_DAO();
        String dtEntrada = veiculoVagaDao.readGetHourById(idLocacao);
        
        //Capturar data atual, a qual será a dtSaida
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        
        //Calcular a qtd de horas de locacao
        CalcularValorLocacao calculoValorLocacao = new CalcularValorLocacao();
        int horasLocacao = calculoValorLocacao.calcularHorasLocacao(dtEntrada, currentTime);
        
        //Calcular o valor a ser cobrado pela locação
        float custoLocacao = calculoValorLocacao.calcularValorLocacao(horasLocacao);
        
        //Atualizar registro de Veiculo_Vaga para encerra a locação
        veiculoVagaDao.updateEncerrarLocacao(currentTime, custoLocacao, idLocacao);
        
        //Atualizar estado da vaga para livre(true)
        VagaDAO vagaDao = new VagaDAO();
        vagaDao.updateSpotStatus2(idVaga);
        
    }
    
    public boolean placaValidation(String placa){
        Queries q = new Queries();
        return q.placaQuery(placa);
    }
    
    public boolean vagaValidation(int cdVaga){
        Queries q = new Queries();
        return q.vagaQuery(cdVaga);
    }
    
}
