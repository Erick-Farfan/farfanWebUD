package cdt.bean;
// Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;
import java.util.ArrayList;
import cdt.modelo.CDT;
import cdt.modelo.CDTDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("cdtBean")
@SessionScoped
public class CDTBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private CDT dto = new CDT();
    private ArrayList<CDT> listaCdt = CDTDAO.lista_C;

    public CDTBean() {}

    public void registrar() {
        dto.setId(CDTDAO.lista_C.size() + 1L);
        dto.calcular();
        CDTDAO.lista_C.add(dto);
        System.out.println("CDT registrado: " + dto.toString());
        dto = new CDT(); // Limpiar formulario
    }

    public CDT getDto()                          { return dto; }
    public void setDto(CDT dto)                  { this.dto = dto; }

    public ArrayList<CDT> getListaCdt()          { return listaCdt; }
    public void setListaCdt(ArrayList<CDT> l)    { this.listaCdt = l; }
}