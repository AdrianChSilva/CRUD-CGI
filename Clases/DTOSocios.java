package com.adrichs.paginaWeb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "DTOSocios")
@Table(name = "tableSocios")
public class DTOSocios implements Serializable {
  private Integer codSocios;
  private String dni;
  private String nombre;
  private String apellidos;
  private String telefono;
  private String email;
  private String genero;
  private String direccion;
  private String asociado;

  public DTOSocios() {

  }

  public Integer getCodSocios() {
    return codSocios;
  }

  public void setCodSocios(Integer codSocios) {
    this.codSocios = codSocios;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getAsociado() {
    return asociado;
  }

  public void setAsociado(String asociado) {
    this.asociado = asociado;
  }

  @Override
  public String toString() {
    return "DTOSocios [codSocios=" + codSocios + ", dni=" + dni + ", nombre=" + nombre
        + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email + ", genero="
        + genero + ", direccion=" + direccion + ", asociado=" + asociado + "]";
  }

}
