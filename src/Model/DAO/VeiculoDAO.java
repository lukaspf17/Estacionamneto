/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.Veiculo;
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
public class VeiculoDAO {
    
    public void create(Veiculo veiculo){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("insert into tb_veiculo( cd_placa, cd_cliente) values(?, ?);");
            stmt.setString(1, veiculo.getPlacaVeiculo());
            stmt.setInt(2, veiculo.getIdClienteVeiculo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Veiculo salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public List<Veiculo> read(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Veiculo> veiculoList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from tb_veiculo;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Veiculo veiculos = new Veiculo();
                
                veiculos.setIdVeiculo(rs.getInt("cd_veiculo"));
                veiculos.setPlacaVeiculo(rs.getString("cd_placa"));
                veiculos.setIdClienteVeiculo(rs.getInt("cd_cliente"));
                
                veiculoList.add(veiculos);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os veiculos!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return veiculoList;
    }
    
    public void update(Veiculo veiculo){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_veiculo set cd_placa = ?, cd_cliente = ? where cd_veiculo = ?;");
            stmt.setString(1, veiculo.getPlacaVeiculo());
            stmt.setInt(2, veiculo.getIdClienteVeiculo());
            stmt.setInt(3, veiculo.getIdVeiculo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(Veiculo veiculo){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("delete from tb_veiculo where cd_veiculo = ?;");
            stmt.setInt(1, veiculo.getIdVeiculo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public int readByPlate(String placa){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int idVeiculo = 0;
        
        try {
            stmt = conn.prepareStatement("select cd_veiculo from tb_veiculo where cd_placa = ?;");
            stmt.setString(1, placa);
            rs = stmt.executeQuery();
            
            if(rs.next()){                
                idVeiculo = rs.getInt("cd_veiculo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os veiculos!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return idVeiculo;
    }
}
