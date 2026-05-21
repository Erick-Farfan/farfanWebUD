package asp.bean;
// Autor: Erick Mauricio Farfán Díaz

import java.io.Serializable;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.ProgAcad;
import asp.service.AspiranteService;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("asp")
@SessionScoped
public class AspiranteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Aspirante dto = new Aspirante();
    private String mensajeExito;

    private AspiranteService service = new AspiranteService();

    // Las listas se obtienen siempre desde el servicio
    private ArrayList<Aspirante> listaAs;
    private ArrayList<ProgAcad>  listaPa;

    public AspiranteBean() {
        listaPa = service.obtenerProgramas();
        listaAs = service.obtenerTodos();
    }

    // ─── Getters / Setters ───────────────────────────────────────────────────

    public Aspirante getDto()                        { return dto; }
    public void setDto(Aspirante dto)                { this.dto = dto; }

    public ArrayList<Aspirante> getListaAs()         { return listaAs; }
    public void setListaAs(ArrayList<Aspirante> l)   { this.listaAs = l; }

    public ArrayList<ProgAcad> getListaPa()          { return listaPa; }
    public void setListaPa(ArrayList<ProgAcad> l)    { this.listaPa = l; }

    public String getMensajeExito()                  { return mensajeExito; }
    public void setMensajeExito(String m)            { this.mensajeExito = m; }

    // ─── Acción ──────────────────────────────────────────────────────────────

    public void registrar() {
        boolean ok = service.registrar(dto, listaPa);

        if (ok) {
            mensajeExito = "✔ Aspirante " + dto.getNombres() + " " + dto.getApellidos()
                         + " registrado exitosamente.";
            listaAs = service.obtenerTodos();
            dto = new Aspirante();
        } else {
            mensajeExito = null;
        }
    }
}
