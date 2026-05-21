package asp.service;

//Autor: Erick Mauricio Farfán Díaz

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.AspiranteDAO;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;

public class AspiranteService implements Serializable {
 private static final long serialVersionUID = 1L;

 /**
  * Valida el programa seleccionado, asigna fecha y persiste el aspirante.
  * Retorna true si el registro fue exitoso, false si el código de programa es inválido.
  */
 public boolean registrar(Aspirante aspirante, ArrayList<ProgAcad> listaPa) {
     int codProg = aspirante.getPro_acad().getCod();

     if (codProg < 0 || codProg >= listaPa.size()) {
         return false;
     }

     aspirante.setPro_acad(listaPa.get(codProg));
     aspirante.setFecha_reg(LocalDate.now());

     AspiranteDAO.lista_A.add(aspirante);
     System.out.println("Registrado: " + aspirante.toString());

     return true;
 }

 public ArrayList<Aspirante> obtenerTodos() {
     return AspiranteDAO.lista_A;
 }

 public ArrayList<ProgAcad> obtenerProgramas() {
     ProgAcadDAO.cargaDatos();
     return ProgAcadDAO.lista_P;
 }
}