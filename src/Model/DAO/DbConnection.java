/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class DbConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_estacionamento";
    private static final String USER = "root";
    private static final String PASSWORD = "sql123";
    
    //Método responsavel por estabelecer a conexão com o banco de dados
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            Connection connector = DriverManager.getConnection(URL, USER, PASSWORD);
            return connector;
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException("Erro na conexão: ", e);
            //return null;
        }
    }
    
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pst){
        closeConnection(conn);
        if(pst != null){
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pst, ResultSet rs){
        closeConnection(conn, pst);
        if(pst != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
