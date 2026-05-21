package cdt.modelo;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;

public class ClienteCDT implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private String correo;

    public ClienteCDT() {}

    public ClienteCDT(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre()              { return nombre; }
    public void setNombre(String nombre)   { this.nombre = nombre; }

    public String getCorreo()              { return correo; }
    public void setCorreo(String correo)   { this.correo = correo; }

    @Override
    public String toString() {
        return "ClienteCDT [nombre=" + nombre + ", correo=" + correo + "]";
    }
}