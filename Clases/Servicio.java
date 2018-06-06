package com.adrichs.paginaWeb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Servicio {
  @Autowired
  private DAOVideojuegos daoVideojuegos;
  @Autowired
  private DAOSocios daoSocios;
  @Autowired
  private DAOFacturas daoFacturas;

  public List<DTOVideojuegos> obtenerTabla() {

    return daoVideojuegos.verTabla();
  }

  public List<DTOSocios> tablaSocios() {
    return daoSocios.verTabla();
  }

  public List<DTOFacturas> tablaFacturas() {
    return daoFacturas.verTabla();
  }


  // Inserts
  public void insertVideojuegos(DTOVideojuegos x) {
    daoVideojuegos.insertarDatos(x);
  }

  public void insertsFacturas(DTOFacturas x) {
    daoFacturas.insertarDatos(x);
  }

  public void insertsSocios(DTOSocios socios) {
    daoSocios.insertarDatos(socios);
  }


  // deletes
  public void deleteVideojuegos(Integer codigo) {
    daoVideojuegos.borraVideojuego(codigo);
  }


  public void deleteSocios(Integer codigo) {
    daoSocios.borraSocio(codigo);
  }

  public void deleteFacturas(Integer codigo) {
    daoFacturas.borraFactura(codigo);
  }

  // searchs
  public List<DTOSocios> busquedaSocio(String b) {
    return daoSocios.busqueda(b);
  }

  public List<DTOFacturas> busquedaFactura(String b) {
    return daoFacturas.busqueda(b);
  }

  public List<DTOVideojuegos> busquedaVideojuego(String b) {
    return daoVideojuegos.busqueda(b);
  }

  // updates
  public void actualizarVj(DTOVideojuegos vjAct) {
    daoVideojuegos.actualizarVj(vjAct);
  }

  public void actualizarDatosDesdeFichero(DTOVideojuegos vjAct) {
    daoVideojuegos.actualizarDatosDesdeFichero(vjAct);
  }

  public void actualizarSocio(DTOSocios sAct) {
    daoSocios.actualizaSocio(sAct);
  }

  // Misc
  public DTOVideojuegos cogeVideojuego(Integer x) {
    return daoVideojuegos.cogeVideojuego(x);
  }

  public DTOSocios cogeSocio(Integer x) {
    return daoSocios.cogeSocio(x);
  }

  public boolean compruebaDatos(DTOVideojuegos x) {
    return daoVideojuegos.comprobarDatos(x);
  }
}
