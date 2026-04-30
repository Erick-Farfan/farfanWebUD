package asp.modelo;

// Autor: Erick Mauricio Farfán Díaz

import java.util.ArrayList;

public class ProgAcadDAO {

    public static ArrayList<ProgAcad> lista_P = new ArrayList<>();

    public static void cargaDatos() {
        if (lista_P.isEmpty()) {
            // Códigos únicos y correlativos para cada programa
            lista_P.add(new ProgAcad(0, "Ingeniería de Sistemas"));
            lista_P.add(new ProgAcad(1, "Ingeniería Industrial"));
            lista_P.add(new ProgAcad(2, "Ingeniería de Telemática"));
            lista_P.add(new ProgAcad(3, "Administración de Empresas"));
            lista_P.add(new ProgAcad(4, "Derecho"));
            lista_P.add(new ProgAcad(5, "Matemáticas"));
        }
    }
}