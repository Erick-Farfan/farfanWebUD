package cdt.modelo;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;

public class CDT extends Inversion implements Serializable {
    private static final long serialVersionUID = 1L;

    private double ganancia;
    private double valorFuturo;
    private double impuesto;

    private static final double ANIO = 360.0;

    public CDT() { super(); }

    public CDT(long id, double inversion, double interes, double plazo) {
        super(id, inversion, interes, plazo);
    }

    public void calcular() {
        ganancia    = getInversion() * (getInteres() * (getPlazo() / ANIO));
        valorFuturo = getInversion() + ganancia;
        impuesto    = ganancia * 0.04;
    }

    public double getGanancia()              { return ganancia; }
    public void setGanancia(double g)        { this.ganancia = g; }

    public double getValorFuturo()           { return valorFuturo; }
    public void setValorFuturo(double vf)    { this.valorFuturo = vf; }

    public double getImpuesto()              { return impuesto; }
    public void setImpuesto(double imp)      { this.impuesto = imp; }

    @Override
    public String toString() {
        return "CDT [" + super.toString()
             + ", ganancia=" + ganancia
             + ", valorFuturo=" + valorFuturo
             + ", impuesto=" + impuesto + "]";
    }
}