/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion.dao;

import com.mycompany.sistemagestion.models.Cliente;
import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAICOL
 */
public class ClienteDao {
    
    public Connection conectar() {
        String baseDeDatos = "java_curso";
        String usuario = "root";
        String password = "Ww/47A.5@nrj5FI/";
        String host = "localhost";
        String puerto = "3306";
        //String driver = "com.mysql.jdbc.driver";        
        String conexionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
        
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(conexionUrl, usuario, password);
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
    
    public void agregar(Cliente cliente) {
                
        try {
            Connection conexion = conectar();

            String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `email`, `telefono`, `direccion`) VALUES (NULL, '" 
                    + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" 
                    + cliente.getEmail() + "', '" + cliente.getTelefono() + "','" + cliente.getDireccion() + "' );";  
            Statement statement = conexion.createStatement();  
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar(Cliente cliente) {
                
        try {
            Connection conexion = conectar();

            String sql = "UPDATE `clientes` SET `nombre` = '" + cliente.getNombre() 
                    + "',`apellido` = '" + cliente.getApellido() 
                    + "', `email` = '" + cliente.getEmail() 
                    + "', `telefono` = '" + cliente.getTelefono() 
                    + "', `direccion` = '" + cliente.getDireccion() 
                    + "' WHERE `clientes`.`id` = "+ cliente.getId() +";";  
            Statement statement = conexion.createStatement();  
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> listar() {
        List<Cliente> listado = new ArrayList<>();
        
        try {            
            Connection conexion = conectar();
            
            String sql = "SELECT * FROM `clientes`;";  
            
            Statement statement = conexion.createStatement();  
            ResultSet resultado = statement.executeQuery(sql);
            
            while (resultado.next()) {
                Cliente cliente = new Cliente();               
                cliente.setId(resultado.getString("id"));   
                cliente.setNombre(resultado.getString("nombre"));                
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefono(resultado.getString("telefono"));                
                cliente.setDireccion(resultado.getString("direccion"));

                listado.add(cliente);

            }
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listado;
      }
    
    
    public void eliminar(String id) {
        
        try {            
            Connection conexion = conectar();

            String sql = "DELETE FROM `clientes` WHERE `clientes`.`id` = " + id ;  
            Statement statement = conexion.createStatement();  
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardar(Cliente cliente) {
        if (StringUtils.isEmptyOrWhitespaceOnly(cliente.getId())) {
            agregar(cliente);
        } else {
            actualizar(cliente);
        }
    }
    
    /*public void crearTablaUsuario(String conexionUrl, String usuario, String password) {
        String crearTablaSQL = "CREATE TABLE IF NOT EXISTS usuario ("
            + "id INT AUTO_INCREMENT PRIMARY KEY,"
            + "nombre VARCHAR(50) NOT NULL,"
            + "apellido VARCHAR(50) NOT NULL,"
            + "email VARCHAR(100) UNIQUE NOT NULL"
            + ")";

        try (
                Connection conexion = DriverManager.getConnection(conexionUrl, usuario, password);
            Statement statement = conexion.createStatement()) {

            statement.execute(crearTablaSQL);
            System.out.println("Tabla usuario creada correctamente.");

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
