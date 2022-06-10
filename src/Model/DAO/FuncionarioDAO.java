/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.Funcionario;
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
public class FuncionarioDAO {
    
    public void create(Funcionario funcionario){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("insert into tb_funcionario( nm_funcionario, nm_turno, nm_adm, nm_usuario, cd_senha) values(?, ?, ?, ?, ?);");
            stmt.setString(1, funcionario.getNomeFunc());
            stmt.setString(2, funcionario.getTurnoFunc());
            stmt.setBoolean(3, funcionario.getIsAdmFunc());
            stmt.setString(4, funcionario.getUserNameFunc());
            stmt.setString(5, funcionario.getPasswordFunc());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public List<Funcionario> read(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarioList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from tb_funcionario;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario funcionarios = new Funcionario();
                
                funcionarios.setIdFunc(rs.getInt("cd_funcionario"));
                funcionarios.setNomeFunc(rs.getString("nm_funcionario"));
                funcionarios.setTurnoFunc(rs.getString("nm_turno"));
                funcionarios.setIsAdmFunc(rs.getBoolean("nm_adm"));
                funcionarios.setUserNameFunc(rs.getString("nm_usuario"));
                funcionarios.setPasswordFunc(rs.getString("cd_senha"));

                funcionarioList.add(funcionarios);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as vagas!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return funcionarioList;
    }
    
    public void update(Funcionario funcionario){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_funcionario set nm_funcionario = ?, nm_turno = ?, nm_adm = ?, nm_usuario = ?, cd_senha = ? where cd_funcionario = ?;");
            stmt.setString(1, funcionario.getNomeFunc());
            stmt.setString(2, funcionario.getTurnoFunc());
            stmt.setBoolean(3, funcionario.getIsAdmFunc());
            stmt.setString(4, funcionario.getUserNameFunc());
            stmt.setString(5, funcionario.getPasswordFunc());
            stmt.setInt(6, funcionario.getIdFunc());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(Funcionario funcionario){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("delete from tb_funcionario where cd_funcionario = ?;");
            stmt.setInt(1, funcionario.getIdFunc());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public boolean funcionarioLogin(String userName, String password){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean auth = false;
        
        try {
            stmt = conn.prepareStatement("select * from tb_funcionario where nm_usuario = ? and cd_senha = ?;");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                auth = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao logar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return auth;
    }
}
