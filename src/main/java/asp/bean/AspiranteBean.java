package asp.bean;

// Autor: Erick Mauricio Farfán Díaz

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.AspiranteDAO;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("asp")
@SessionScoped   // ← CAMBIO: SessionScoped para que la lista persista entre peticiones AJAX
public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Aspirante dto = new Aspirante();
    private String mensajeExito;

    // Referencias directas a las listas estáticas
    private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
    private ArrayList<ProgAcad>  listaPa = ProgAcadDAO.lista_P;

    public AspiranteBean() {
        ProgAcadDAO.cargaDatos();
    }

    // ─── Getters / Setters ───────────────────────────────────────────────────

    public Aspirante getDto() { return dto; }
    public void setDto(Aspirante dto) { this.dto = dto; }

    public ArrayList<Aspirante> getListaAs() { return listaAs; }
    public void setListaAs(ArrayList<Aspirante> listaAs) { this.listaAs = listaAs; }

    public ArrayList<ProgAcad> getListaPa() { return listaPa; }
    public void setListaPa(ArrayList<ProgAcad> listaPa) { this.listaPa = listaPa; }

    public String getMensajeExito() { return mensajeExito; }
    public void setMensajeExito(String mensajeExito) { this.mensajeExito = mensajeExito; }

    // ─── Acciones ────────────────────────────────────────────────────────────

    public void registrar() {
        // Verificar que el código del programa sea válido
        int codProg = dto.getPro_acad().getCod();
        if (codProg >= 0 && codProg < listaPa.size()) {
            dto.setPro_acad(listaPa.get(codProg));
        } else {
            dto.setPro_acad(null);
            mensajeExito = null;
            return;
        }

        dto.setFecha_reg(LocalDate.now());

        // Agregar a la lista estática global
        AspiranteDAO.lista_A.add(dto);
        System.out.println("Registrado: " + dto.toString());

        mensajeExito = "✔ Aspirante " + dto.getNombres() + " " + dto.getApellidos()
                       + " registrado exitosamente.";

        // Reiniciar formulario
        dto = new Aspirante();
    }
}
