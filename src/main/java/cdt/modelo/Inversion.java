package cdt.modelo;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;

public class Inversion implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private double inversion;
    private double interes;
    private double plazo;

    public Inversion() {}

    public Inversion(long id, double inversion, double interes, double plazo) {
        this.id = id;
        this.inversion = inversion;
        this.interes = interes;
        this.plazo = plazo;
    }

    public long getId()             { return id; }
    public void setId(long id)      { this.id = id; }

    public double getInversion()            { return inversion; }
    public void setInversion(double inv)    { this.inversion = inv; }

    public double getInteres()              { return interes; }
    public void setInteres(double interes)  { this.interes = interes; }

    public double getPlazo()                { return plazo; }
    public void setPlazo(double plazo)      { this.plazo = plazo; }

    @Override
    public String toString() {
        return "Inversion [id=" + id + ", inversion=" + inversion
             + ", interes=" + interes + ", plazo=" + plazo + "]";
    }
}