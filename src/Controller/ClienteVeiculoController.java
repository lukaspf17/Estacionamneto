/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bean.Cliente;
import Model.Bean.ClienteVeiculoDTO;
import Model.Bean.Vaga;
import Model.Bean.Veiculo;
import Model.DAO.ClienteDAO;
import Model.DAO.Queries;
import Model.DAO.VeiculoDAO;

/**
 *
 * @author lucas
 */
public class ClienteVeiculoController {
    
    public void CadastrarClienteVeiculo(ClienteVeiculoDTO clienteVeiculoDto){
        Cliente c = new Cliente();
        ClienteDAO daoC = new ClienteDAO();
        
        c.setNomeCliente(clienteVeiculoDto.getNomeCliente());
        c.setCpfCliente(clienteVeiculoDto.getCpfCliente().replace(".", "").replace("-", "").trim());
        c.setTelefoneCliente(clienteVeiculoDto.getTelefoneCliente().replace("(", "").replace(")", "").replace("-", "").trim());
                
        daoC.create(c);
        
        Veiculo v = new Veiculo();
        VeiculoDAO daoV = new VeiculoDAO();
        
        v.setPlacaVeiculo(clienteVeiculoDto.getPlacaVeiculo());
        v.setIdClienteVeiculo(daoC.lastInserted());
        
        daoV.create(v);
    }
    
    public ClienteVeiculoDTO bucarCliente(String stCpf){
        Queries q = new Queries();
        return q.clienteQuery(stCpf.replace(".", "").replace("-", "").trim());
    }
    
    public void updateClienteVeiculo(ClienteVeiculoDTO cv){
        ClienteDAO clienteDao = new ClienteDAO();
        VeiculoDAO veiculoDao = new VeiculoDAO();
        String cpf = cv.getCpfCliente().replace(".", "").replace("-", "").trim();
        String telefone = cv.getTelefoneCliente().replace(".", "").replace("-", "").trim();
        Cliente cliente = new Cliente(cv.getIdCliente(), cv.getNomeCliente(), cpf, telefone);
        clienteDao.update(cliente);
        int idVeiculo = veiculoDao.readByPlate(cv.getPlacaVeiculo());
        Veiculo veiculo = new Veiculo(idVeiculo, cv.getPlacaVeiculo(), cv.getIdCliente());
        veiculoDao.update(veiculo);
    }
}
