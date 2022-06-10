/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.ClienteVeiculoDTO;
import Model.Bean.Funcionario;
import Model.Bean.LocacaoDTO;
import Model.Bean.HistoricoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Queries {
    
    public List<LocacaoDTO> locacaoQuery(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<LocacaoDTO> locacaoList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select tb_veiculo_vaga.cd_locacao, tb_vaga.cd_vaga, tb_veiculo.cd_placa, tb_vaga.nm_tipo, tb_cliente.nm_cliente, tb_veiculo_vaga.dt_entrada from tb_cliente " +
                                            "inner join tb_veiculo on tb_cliente.cd_cliente = tb_veiculo.cd_cliente " +
                                            "inner join tb_veiculo_vaga on tb_veiculo.cd_veiculo = tb_veiculo_vaga.cd_veiculo " +
                                            "inner join tb_vaga on tb_veiculo_vaga.cd_vaga = tb_vaga.cd_vaga " +
                                            "where tb_vaga.nm_estado = false;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                LocacaoDTO locacaoes = new LocacaoDTO();
                
                locacaoes.setIdLocacao(rs.getInt("cd_locacao"));
                locacaoes.setIdVaga(rs.getInt("cd_vaga"));
                locacaoes.setPlacaVeiculo(rs.getString("cd_placa"));
                locacaoes.setTipoVaga(rs.getString("nm_tipo"));
                locacaoes.setNomeCliente(rs.getString("nm_cliente"));
                locacaoes.setEntradaLocacao(rs.getString("dt_entrada"));
                
                locacaoList.add(locacaoes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as locações!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return locacaoList;
    }
    
    public List<HistoricoDTO> historicoQuery(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<HistoricoDTO> historicoList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select tb_veiculo_vaga.cd_locacao, tb_vaga.cd_vaga, tb_veiculo.cd_placa, tb_vaga.nm_tipo, tb_cliente.nm_cliente, " +
                                            "tb_veiculo_vaga.vl_locacao, tb_veiculo_vaga.dt_entrada, tb_veiculo_vaga.dt_saida from tb_cliente " +
                                                "inner join tb_veiculo on tb_cliente.cd_cliente = tb_veiculo.cd_cliente " +
                                                "inner join tb_veiculo_vaga on tb_veiculo.cd_veiculo = tb_veiculo_vaga.cd_veiculo " +
                                                "inner join tb_vaga on tb_veiculo_vaga.cd_vaga = tb_vaga.cd_vaga " +
                                                "where tb_veiculo_vaga.dt_entrada is not null and tb_veiculo_vaga.dt_saida is not null;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                HistoricoDTO historicos = new HistoricoDTO();
                
                historicos.setIdLocacao(rs.getInt("cd_locacao"));
                historicos.setIdVaga(rs.getInt("cd_vaga"));
                historicos.setPlacaVeiculo(rs.getString("cd_placa"));
                historicos.setTipoVaga(rs.getString("nm_tipo"));
                historicos.setNomeCliente(rs.getString("nm_cliente"));
                historicos.setValorLocacao(rs.getFloat("vl_locacao"));
                historicos.setEntradaLocacao(rs.getString("dt_entrada"));
                historicos.setSaidaLocacao(rs.getString("dt_saida"));
                
                historicoList.add(historicos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as locações!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return historicoList;
    }
    
    public boolean placaQuery(String placa){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String placaDb = "";
        try {
            stmt = conn.prepareStatement("select cd_placa from tb_veiculo where cd_placa = ?;");
            stmt.setString(1, placa);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){              
                placaDb = rs.getString("cd_placa");                
            }
            
            if(!placa.equals(placaDb)){
                JOptionPane.showMessageDialog(null, "Erro: Esta placa não consta nos registros! Verfique a digitação ou se o cliente está cadastrado.");
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as locações!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }       
        return false;
    }
    
    public boolean vagaQuery(int iDvaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean vagaDb = false;
        try {
            stmt = conn.prepareStatement("select nm_estado from tb_vaga where cd_vaga = ?;");
            stmt.setInt(1, iDvaga);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){              
                vagaDb = rs.getBoolean("nm_estado");                
            }
            
            if(true != vagaDb){
                JOptionPane.showMessageDialog(null, "Erro: Esta vaga atualmente já está oculpada! Verifique se selecionou a vaga corretamente.");
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as locações!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }       
        return false;
    }
    
    public ClienteVeiculoDTO clienteQuery(String stCpf){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ClienteVeiculoDTO clienteVeiculo = new ClienteVeiculoDTO();
        
        try {
            stmt = conn.prepareStatement("select tb_cliente.cd_cliente, nm_cliente, cd_cpf, cd_telefone, cd_placa from tb_cliente "
                                            + "inner join tb_veiculo on tb_cliente.cd_cliente = tb_veiculo.cd_cliente where cd_cpf = ?;");
            stmt.setString(1, stCpf);
            
            rs = stmt.executeQuery();
            
            while(rs.next()){    
                clienteVeiculo.setIdCliente(rs.getInt("cd_cliente"));
                clienteVeiculo.setNomeCliente(rs.getString("nm_cliente"));
                clienteVeiculo.setCpfCliente(rs.getString("cd_cpf"));
                clienteVeiculo.setTelefoneCliente(rs.getString("cd_telefone"));
                clienteVeiculo.setPlacaVeiculo(rs.getString("cd_placa"));
            }
                        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as locações!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }       
        return clienteVeiculo;
    }
}
