package cdt.service;

//Autor: Erick Mauricio Farfán Díaz
import java.io.Serializable;
import java.util.ArrayList;
import cdt.modelo.CDT;
import cdt.modelo.CDTDAO;

public class CDTService implements Serializable {
 private static final long serialVersionUID = 1L;

 public void registrar(CDT cdt) {
     cdt.setId(CDTDAO.lista_C.size() + 1L);
     cdt.calcular();
     CDTDAO.lista_C.add(cdt);
 }

 public ArrayList<CDT> obtenerTodos() {
     return CDTDAO.lista_C;
 }
}