/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemagestion.models;

/**
 *
 * @author MAICOL
 */
public class Cliente {
    
    private String nombre   ; 
    private String apellido;
    private String email;
    private String telefono;
    
    public String getNombre () {
        return nombre;
    }
    
    public void setNombre (String valor) {
        nombre = valor;
    }
    
    public String getApellido () {
        return apellido;
    }

    public void setApellido (String valor) {
        apellido = valor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getNombreCompleto () {
        return nombre + " " + apellido;
    }
}
