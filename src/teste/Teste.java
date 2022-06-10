/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teste;

import Model.Bean.Cliente;
import Model.Bean.Funcionario;
import Model.Bean.LocacaoDTO;
import Model.Bean.Vaga;
import Model.Bean.Veiculo;
import Model.Bean.Veiculo_Vaga;
import Model.DAO.ClienteDAO;
import Model.DAO.DbConnection;
import Model.DAO.FuncionarioDAO;
import Model.DAO.Queries;
import Model.DAO.VagaDAO;
import Model.DAO.VeiculoDAO;
import Model.DAO.Veiculo_Vaga_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    // Para inserir no banco -----------------------------------
        
//        Vaga v = new Vaga();
//        VagaDAO dao = new VagaDAO();
//        
//        v.setTipoVaga("Carro");
//        v.setEstadoVaga(true);
//        
//        dao.create(v);
        
    // Para recuperar do banco ----------------------------------
//        VagaDAO dao = new VagaDAO();
//        for(Vaga v : dao.read()){
//            System.out.println(v.getIdVaga() + " " + v.getTipoVaga() + " " + v.getEstadoVaga());
//        }
//        
    // Para atualizar o banco ----------------------------------
//        Vaga v = new Vaga();
//        VagaDAO dao = new VagaDAO();
//        
//        v.setTipoVaga("Carro");
//        v.setEstadoVaga(false);
//        v.setIdVaga(41);
//        
//        dao.update(v);

    // Para recuperar do banco ----------------------------------
//        Vaga v = new Vaga();
//        VagaDAO dao = new VagaDAO();
//        
//        v.setIdVaga(41);
//        
//        dao.delete(v);



//  - - - - - - - - - - - - - - - - - - - - - - - - - CLIENTE - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

// Para inserir no banco -----------------------------------
        
//        Cliente c = new Cliente();
//        ClienteDAO dao = new ClienteDAO();
//        
//        c.setNomeCliente("Joseth Joestar");
//        c.setCpfCliente("12345678906");
//        c.setTelefoneCliente("11912345678");
//        
//        dao.create(c);

// Para recuperar do banco ----------------------------------
//        ClienteDAO dao = new ClienteDAO();
//        for(Cliente c : dao.read()){
//            System.out.println(c.getIdCliente() + " " + c.getNomeCliente() + " " + c.getCpfCliente() + " " + c.getTelefoneCliente());
//        }
      
    // Para atualizar o banco ----------------------------------
//        Cliente c = new Cliente();
//        ClienteDAO dao = new ClienteDAO();
//        
//        c.setNomeCliente("Jonathan Joestar");
//        c.setCpfCliente("12345678906");
//        c.setTelefoneCliente("11912345678");
//        c.setIdCliente(1);
//        
//        dao.update(c);

    // Para apagar do banco ----------------------------------
//        Cliente c = new Cliente();
//        ClienteDAO dao = new ClienteDAO();
//        
//        c.setIdCliente(1);
//        
//        dao.delete(c);

// Para recuperar ultimo registro do banco ----------------------------------
//        ClienteDAO dao = new ClienteDAO();
//        System.out.println(dao.lastInserted());

//  - - - - - - - - - - - - - - - - - - - - - - - - - FUNCIONARIO - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    // Para inserir no banco -----------------------------------
        
//        Funcionario f = new Funcionario();
//        FuncionarioDAO dao = new FuncionarioDAO();
//        
//        f.setNomeFunc("Funcionario Teste2");
//        f.setTurnoFunc("Noturno");
//        f.setIsAdmFunc(true);
//        f.setUserNameFunc("funcionario_teste2");
//        f.setPasswordFunc("func123");
//        
//        dao.create(f);

    // Para recuperar do banco ----------------------------------
//        FuncionarioDAO dao = new FuncionarioDAO();
//        for(Funcionario f : dao.read()){
//            System.out.println(f.getIdFunc() + " " + f.getNomeFunc() + " " + f.getTurnoFunc() + " " + f.getIsAdmFunc() + " " + f.getUserNameFunc() + " " +f.getPasswordFunc());
//        }

    // Para atualizar o banco ----------------------------------
//        Funcionario f = new Funcionario();
//        FuncionarioDAO dao = new FuncionarioDAO();
//        
//        f.setNomeFunc("Funcionario Teste2");
//        f.setTurnoFunc("Noturno");
//        f.setIsAdmFunc(false);
//        f.setUserNameFunc("funcionarioTeste2");
//        f.setPasswordFunc("func123");
//        f.setIdFunc(3);
//        
//        dao.update(f);

    // Para apagar do banco ----------------------------------
//        Funcionario f = new Funcionario();
//        FuncionarioDAO dao = new FuncionarioDAO();
//        
//        f.setIdFunc(3);
//        
//        dao.delete(f);

    // funcionarioLogin() ----------------------------------
//        String user = "funcTeste";
//        String pass = "123";
//        FuncionarioDAO dao = new FuncionarioDAO();
//
//        System.out.println(dao.funcionarioLogin(user, pass));

//  - - - - - - - - - - - - - - - - - - - - - - - - - VEICULO - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    // Para inserir no banco -----------------------------------
        
//        Veiculo v = new Veiculo();
//        VeiculoDAO dao = new VeiculoDAO();
//        
//        v.setPlacaVeiculo("ABC1234");
//        v.setIdClienteVeiculo(2);
//        
//        dao.create(v);

    // Para recuperar do banco ----------------------------------
//        VeiculoDAO dao = new VeiculoDAO();
//        for(Veiculo v : dao.read()){
//            System.out.println(v.getIdVeiculo() + " " + v.getPlacaVeiculo() + " " + v.getIdClienteVeiculo());
//        }

    // Para atualizar o banco ----------------------------------
//        Veiculo v = new Veiculo();
//        VeiculoDAO dao = new VeiculoDAO();
//        
//        v.setPlacaVeiculo("ABC4321");
//        v.setIdClienteVeiculo(2);
//        v.setIdVeiculo(1);
//        
//        dao.update(v);

    // Para apagar do banco ----------------------------------
//        Veiculo v = new Veiculo();
//        VeiculoDAO dao = new VeiculoDAO();
//        
//        v.setIdVeiculo(1);
//        
//        dao.delete(v);

//  - - - - - - - - - - - - - - - - - - - - - - - - - VEICULO_VAGA - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

    // Para inserir no banco -----------------------------------
        
//        Veiculo_Vaga vv = new Veiculo_Vaga();
//        Veiculo_Vaga_DAO dao = new Veiculo_Vaga_DAO();
//        
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(dt);
//        
//        vv.setEntradaLocacao(currentTime);
//        vv.setSaidaLocacao(null);
//        vv.setValorLocacao(0);
//        vv.setIdVeiculoLocacao(2);
//        vv.setIdVagaLocacao(1);
//        
//        dao.create(vv);

    // Para recuperar do banco ----------------------------------
//        Veiculo_Vaga_DAO dao = new Veiculo_Vaga_DAO();
//        for(Veiculo_Vaga vv : dao.read()){
//            System.out.println(vv.getIdLocacao() + " " + vv.getEntradaLocacao() + " " + vv.getSaidaLocacao() + " " + vv.getValorLocacao() + " " + vv.getIdVeiculoLocacao() + " " + vv.getIdVagaLocacao());
//        } 
     
    // Para atualizar o banco ----------------------------------
//        Veiculo_Vaga vv = new Veiculo_Vaga();
//        Veiculo_Vaga_DAO dao = new Veiculo_Vaga_DAO();
//        
//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(dt);
//        
//        //vv.setEntradaLocacao(currentTime);
//        vv.setSaidaLocacao(currentTime);
//        vv.setValorLocacao(0);
//        vv.setIdVeiculoLocacao(2);
//        vv.setIdVagaLocacao(1);
//        vv.setIdLocacao(3);
//        
//        dao.update(vv);

    // Para apagar do banco ----------------------------------
//        Veiculo_Vaga vv = new Veiculo_Vaga();
//        Veiculo_Vaga_DAO dao = new Veiculo_Vaga_DAO();
//        
//        vv.setIdLocacao(1);
//        
//        dao.delete(vv);

//  - - - - - - - - - - - - - - - - - - - - - - - - - QUERIES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
// Para recuperar do banco ----------------------------------
//        Queries query = new Queries();
//        for(LocacaoDTO locDTO : query.locacaoQuery()){
//            System.out.println(locDTO.getIdLocacao() + " " + locDTO.getIdVaga() + " " + locDTO.getTipoVaga() + " " + locDTO.getPlacaVeiculo() + " " + locDTO.getNomeCliente() + " " + locDTO.getEntradaLocacao());
//        } 

//  - - - - - - - - - - - - - - - - - - - - - - - - - OUTROS TESTES - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
// Validação de CPF ----------------------------------
//    String myStr = "123.456.789-45";
//    System.out.println(myStr.replace(".", "").replace("-", "").trim());

// Capturar Hora Atual Java ----------------------------------        
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    //System.out.println("yyyy/MM/dd hh:mm:ss-> "+dtf.format(LocalDateTime.now()));

// Subtrair datas/horas Java  ----------------------------------     
//      LocalDateTime d1 = LocalDateTime.now();
//              
//       String str = "2022-04-20 18:17"; 
//       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
//       LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//     
//      System.out.println(ChronoUnit.HOURS.between(dateTime, d1));     

// Verificando se a Placa existe no banco ----------------------------------
//    Queries q = new Queries();
//    System.out.println(q.placaQuery("QWE7897"));

//Verificando se a Vaga está livre ----------------------------------
//    Queries q = new Queries();
//    System.out.println(q.vagaQuery(2));

//Buscando Cliente por CPF ----------------------------------
//    Queries q = new Queries();
//    System.out.println(q.clienteQuery("46216836806").getIdCliente());

    }   
}
