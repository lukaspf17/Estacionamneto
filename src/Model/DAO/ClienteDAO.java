/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Bean.Cliente;
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
public class ClienteDAO {
    
    public void create(Cliente cliente){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("insert into tb_cliente ( nm_cliente, cd_cpf, cd_telefone) values(?, ?, ?);");
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getTelefoneCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public List<Cliente> read(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clienteList = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("select * from tb_cliente;");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente clientes = new Cliente();
                
                clientes.setIdCliente(rs.getInt("cd_cliente"));
                clientes.setNomeCliente(rs.getString("nm_cliente"));
                clientes.setCpfCliente(rs.getString("cd_cpf"));
                clientes.setTelefoneCliente(rs.getString("cd_telefone"));
                
                clienteList.add(clientes);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return clienteList;
    }
    
    public void update(Cliente cliente){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("update tb_cliente set nm_cliente = ?, cd_cpf = ?, cd_telefone = ? where cd_cliente = ?;");
            stmt.setString(1, cliente.getNomeCliente());
            stmt.setString(2, cliente.getCpfCliente());
            stmt.setString(3, cliente.getTelefoneCliente());
            stmt.setInt(4, cliente.getIdCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public void delete(Cliente cliente){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("delete from tb_cliente where cd_cliente = ?;");
            stmt.setInt(1, cliente.getIdCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt);
        }
    }
    
    public int lastInserted(){
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int idCliente = 0;
        
        try {
            stmt = conn.prepareStatement("select max(cd_cliente) from tb_cliente;");
            rs = stmt.executeQuery();
            
            if(rs.next()){                
                idCliente = rs.getInt("max(cd_cliente)");
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as vagas!" + ex);
            Logger.getLogger(VagaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DbConnection.closeConnection(conn, stmt, rs);
        }
        return idCliente;
    }
}
