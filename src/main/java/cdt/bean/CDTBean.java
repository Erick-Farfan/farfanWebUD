package cdt.bean;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;
import java.util.ArrayList;
import cdt.modelo.CDT;
import cdt.service.CDTService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("cdtBean")
@ViewScoped
public class CDTBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private CDT dto = new CDT();
    private ArrayList<CDT> listaCdt;
    private CDTService service = new CDTService();

    public CDTBean() {}

    public String registrar() {
        service.registrar(dto);
        listaCdt = service.obtenerTodos();
        dto = new CDT();
        return "/CDT/cdtAdmin?faces-redirect=true";
        // Ajusta la ruta al nombre real de tu vista admin
    }

    public void cargarLista() {
        listaCdt = service.obtenerTodos();
    }

    public CDT getDto()                        { return dto; }
    public void setDto(CDT dto)                { this.dto = dto; }

    public ArrayList<CDT> getListaCdt()        { return listaCdt; }
    public void setListaCdt(ArrayList<CDT> l)  { this.listaCdt = l; }
}