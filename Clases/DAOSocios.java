package com.adrichs.paginaWeb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAOSocios {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<DTOSocios> verTabla() {
    List<DTOSocios> lista = new ArrayList<DTOSocios>();
    lista =
        jdbcTemplate.query("select * from socios", new BeanPropertyRowMapper<>(DTOSocios.class));

    return lista;
  }

  public List<DTOSocios> busqueda(String b) {
    List<DTOSocios> lista = new ArrayList<DTOSocios>();
    if (b.equals("")) {
      lista =
          jdbcTemplate.query("select * from socios", new BeanPropertyRowMapper<>(DTOSocios.class));
    } else {
      lista = jdbcTemplate.query(
          "select * from socios where DNI like '" + b + "' or nombre like '" + b
              + "' or apellidos like '" + b + "' or telefono like '" + b + "' or email like '" + b
              + "' or direccion like '" + b + "' or asociado like '" + b + "'",
          new BeanPropertyRowMapper<>(DTOSocios.class));

    }
    return lista;
  }

  public void insertarDatos(DTOSocios socios) {
    jdbcTemplate.update(
        "insert into socios (DNI, nombre, apellidos, telefono, email, genero, direccion, asociado) values (?, ?, ?, ?, ?, ?, ?, ?)",
        socios.getDni(), socios.getNombre(), socios.getApellidos(), socios.getTelefono(),
        socios.getEmail(), socios.getGenero(), socios.getDireccion(), socios.getAsociado());
  }


  public void borraSocio(Integer codigo) {
    jdbcTemplate.update("delete from socios where CodSocios = " + codigo);
  }

  public DTOSocios cogeSocio(Integer codigo) {
    return jdbcTemplate.queryForObject("select * from socios where CodSocios = " + codigo,
        new BeanPropertyRowMapper<>(DTOSocios.class));
  }

  public void actualizaSocio(DTOSocios sAct) {
    jdbcTemplate.update(
        "update socios set DNI = ?, nombre= ?, apellidos = ?, telefono = ?, email = ?, genero = ?, direccion = ?, asociado = ? where CodSocios = ?",
        sAct.getDni(), sAct.getNombre(), sAct.getApellidos(), sAct.getTelefono(), sAct.getEmail(),
        sAct.getGenero(), sAct.getDireccion(), sAct.getAsociado(), sAct.getCodSocios());
  }
}
