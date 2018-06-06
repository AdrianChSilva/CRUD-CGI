package com.adrichs.paginaWeb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "DTOFacturas")
@Table(name = "tableFacturas")
public class DTOFacturas implements Serializable {
  private Integer codDetFact;
  private Integer codVideojuegos;
  private String titulo;
  private int cantidad;
  private int precio;
  private Integer facturaIdFactura;


  public DTOFacturas() {

  }

  public Integer getCodDetFact() {
    return codDetFact;
  }

  public void setCodDetFact(Integer codDetFact) {
    this.codDetFact = codDetFact;
  }

  public Integer getCodVideojuegos() {
    return codVideojuegos;
  }

  public void setCodVideojuegos(Integer codVideojuegos) {
    this.codVideojuegos = codVideojuegos;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Integer getFacturaIdFactura() {
    return facturaIdFactura;
  }

  public void setFacturaIdFactura(Integer facturaIdFactura) {
    this.facturaIdFactura = facturaIdFactura;
  }



}
