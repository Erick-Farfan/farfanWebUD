package cdt.modelo;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;

public class CDT extends ClienteCDT implements Serializable {
    private static final long serialVersionUID = 1L;

    private Inversion inversion;   // composición

    private double gananciaBruta;
    private double impuesto;
    private double gananciaNeta;
    private double valorFuturo;

    private static final double ANIO = 360.0;

    public CDT() {
        super();
        this.inversion = new Inversion();
    }

    public CDT(String nombre, String correo, Inversion inversion) {
        super(nombre, correo);
        this.inversion = inversion;
    }

    public void calcular() {
        gananciaBruta = inversion.getInversion()
                      * (inversion.getInteres() * (inversion.getPlazo() / ANIO));
        impuesto      = gananciaBruta * 0.04;
        gananciaNeta  = gananciaBruta - impuesto;
        valorFuturo   = inversion.getInversion() + gananciaNeta;
    }

    // --- Delegados a Inversion (para el formulario JSF) ---
    public long getId()                      { return inversion.getId(); }
    public void setId(long id)               { inversion.setId(id); }

    public double getMontoInversion()        { return inversion.getInversion(); }
    public void setMontoInversion(double v)  { inversion.setInversion(v); }

    public double getInteres()               { return inversion.getInteres(); }
    public void setInteres(double i)         { inversion.setInteres(i); }

    public double getPlazo()                 { return inversion.getPlazo(); }
    public void setPlazo(double p)           { inversion.setPlazo(p); }

    // --- Resultados del cálculo ---
    public double getGananciaBruta()         { return gananciaBruta; }
    public void setGananciaBruta(double g)   { this.gananciaBruta = g; }

    public double getImpuesto()              { return impuesto; }
    public void setImpuesto(double i)        { this.impuesto = i; }

    public double getGananciaNeta()          { return gananciaNeta; }
    public void setGananciaNeta(double g)    { this.gananciaNeta = g; }

    public double getValorFuturo()           { return valorFuturo; }
    public void setValorFuturo(double v)     { this.valorFuturo = v; }

    public Inversion getInversionObj()       { return inversion; }
    public void setInversionObj(Inversion i) { this.inversion = i; }

    @Override
    public String toString() {
        return super.toString() + " | " + inversion.toString()
             + " | CDT [gananciaBruta=" + gananciaBruta
             + ", impuesto=" + impuesto
             + ", gananciaNeta=" + gananciaNeta
             + ", valorFuturo=" + valorFuturo + "]";
    }
}