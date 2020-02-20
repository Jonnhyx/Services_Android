package com.example.pac_jonatan;

public class DatoAlmacenado {

    private String Nombre;
    private String Apellido;
    private String Correo;

    public DatoAlmacenado(String Nombre, String Apellido, String Correo){
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
    }

    public void setNombre(String nombre){
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellido(String Apellido){
        this.Apellido = Apellido;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setCorreo(String Correo){
        this.Correo = Correo;
    }

    public String getCorreo() {
        return Correo;
    }
}