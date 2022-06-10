/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.Vaga;
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
public class VagaDAO {
    
    public void create(Vaga vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("insert into tb_vaga( nm_tipo, nm_estado) values(?, ?);");
            stmt.setString(1, vaga.getTipoVaga());
            stmt.setBoolean(2, vaga.getEstadoVaga());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public List<Vaga> read(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vaga> vagaList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from tb_vaga;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Vaga vagas = new Vaga();
                
                vagas.setIdVaga(rs.getInt("cd_vaga"));
                vagas.setTipoVaga(rs.getString("nm_tipo"));
                vagas.setEstadoVaga(rs.getBoolean("nm_estado"));
                
                vagaList.add(vagas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as vagas!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return vagaList;
    }
    
    public void update(Vaga vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_vaga set nm_tipo = ?, nm_estado = ? where cd_vaga = ?;");
            stmt.setString(1, vaga.getTipoVaga());
            stmt.setBoolean(2, vaga.getEstadoVaga());
            stmt.setInt(3, vaga.getIdVaga());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(Vaga vaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("delete from tb_vaga where cd_vaga = ?;");
            stmt.setInt(1, vaga.getIdVaga());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void updateSpotStatus(int cdVaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_vaga set nm_estado = 0 where cd_vaga = ?;");
            stmt.setInt(1, cdVaga);
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            System.out.println("Log: Estado da vaga atualizado como sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void updateSpotStatus2(int cdVaga){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_vaga set nm_estado = 1 where cd_vaga = ?;");
            stmt.setInt(1, cdVaga);
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            System.out.println("Log: Estado da vaga atualizado como sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
}
