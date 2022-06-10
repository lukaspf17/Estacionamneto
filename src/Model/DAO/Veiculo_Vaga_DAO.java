/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.Vaga;
import Model.Bean.Veiculo_Vaga;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Veiculo_Vaga_DAO {
    
    public void create(Veiculo_Vaga veiculo_vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = conn.prepareStatement("insert into tb_veiculo_vaga (dt_entrada, dt_saida, vl_locacao, cd_veiculo, cd_vaga) values(?, ?, ?, ?, ?);");
            stmt.setString(1, veiculo_vaga.getEntradaLocacao());
            stmt.setString(2, veiculo_vaga.getSaidaLocacao());
            stmt.setFloat(3, veiculo_vaga.getValorLocacao());
            stmt.setInt(4, veiculo_vaga.getIdVeiculoLocacao());
            stmt.setInt(5, veiculo_vaga.getIdVagaLocacao());
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            System.out.println("Log: Locação realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public List<Veiculo_Vaga> read(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Veiculo_Vaga> veiculo_vaga_List = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from tb_veiculo_vaga;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Veiculo_Vaga veiculos_vagas = new Veiculo_Vaga();
                
                veiculos_vagas.setIdLocacao(rs.getInt("cd_locacao"));
                veiculos_vagas.setEntradaLocacao(rs.getString("dt_entrada"));
                veiculos_vagas.setSaidaLocacao(rs.getString("dt_saida"));
                veiculos_vagas.setValorLocacao(rs.getFloat("vl_locacao"));
                veiculos_vagas.setIdVeiculoLocacao(rs.getInt("cd_veiculo"));
                veiculos_vagas.setIdVagaLocacao(rs.getInt("cd_vaga"));
                
                veiculo_vaga_List.add(veiculos_vagas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as vagas!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return veiculo_vaga_List;
    }
    
    public void update(Veiculo_Vaga veiculo_vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = conn.prepareStatement("update tb_veiculo_vaga set dt_entrada = ?, dt_saida = ?, vl_locacao = ?, cd_veiculo = ?, cd_vaga = ? where cd_locacao = ?;");
            stmt.setString(1, veiculo_vaga.getEntradaLocacao());
            stmt.setString(2, veiculo_vaga.getSaidaLocacao());
            stmt.setFloat(3, veiculo_vaga.getValorLocacao());
            stmt.setInt(4, veiculo_vaga.getIdVeiculoLocacao());
            stmt.setInt(5, veiculo_vaga.getIdVagaLocacao());
            stmt.setInt(6, veiculo_vaga.getIdLocacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(Veiculo_Vaga veiculo_vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("delete from tb_veiculo_vaga where cd_locacao = ?;");
            stmt.setInt(1, veiculo_vaga.getIdLocacao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public String readGetHourById(int cdLocacao){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String dtIn = "";
        
        try {
            stmt = conn.prepareStatement("select dt_entrada from tb_veiculo_vaga where cd_locacao = ?;");
            stmt.setInt(1, cdLocacao);
            rs = stmt.executeQuery();
            
            if(rs.next()){                
                dtIn = rs.getString("dt_entrada");                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as vagas!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return dtIn;
    }
    
    public void updateEncerrarLocacao(String dtSaida, float valorLocacao, int cdLocacao){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = conn.prepareStatement("update tb_veiculo_vaga set dt_saida = ?, vl_locacao = ? where cd_locacao = ?;");
            stmt.setString(1, dtSaida);
            stmt.setFloat(2, valorLocacao);
            stmt.setInt(3, cdLocacao);
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            System.out.println("Log: Locação encerrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
}
