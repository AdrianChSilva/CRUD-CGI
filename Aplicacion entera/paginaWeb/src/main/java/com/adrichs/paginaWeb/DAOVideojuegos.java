package com.adrichs.paginaWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DAOVideojuegos {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<DTOVideojuegos> verTabla() {
    List<DTOVideojuegos> lista = new ArrayList<DTOVideojuegos>();
    lista = jdbcTemplate.query("select * from videojuegos",
        new BeanPropertyRowMapper<>(DTOVideojuegos.class));

    return lista;
  }

  public List<DTOVideojuegos> busqueda(String b) {
    List<DTOVideojuegos> lista = new ArrayList<DTOVideojuegos>();
    if (b.equals("")) {
      lista = jdbcTemplate.query("select * from videojuegos",
          new BeanPropertyRowMapper<>(DTOVideojuegos.class));
    } else {
      lista = jdbcTemplate.query("select * from videojuegos where CodVideojuegos like '" + b
          + "' or titulo like '" + b + "' or plataforma like '" + b + "' or desarrolladora like '"
          + b + "' or publisher like '" + b + "' or precio like '" + b + "' or stock like '" + b
          + "'", new BeanPropertyRowMapper<>(DTOVideojuegos.class));

    }
    return lista;
  }

  /**
   * Obtiene el una clave primaria no existente en base de datos. Es como si hiciera un auto
   * increment
   * 
   * @return Clave primaria
   */
  private Integer codVideojuego() {

    Integer codMayor =
        jdbcTemplate.queryForObject("Select MAX(CodVideojuegos) from videojuegos", Integer.class)
            + 1;
    return codMayor;
  }

  /**
   * Con este metodo insertaremos datos con el DTO y usamos la funcion codVideojuego()
   * 
   */

  public void insertarDatos(DTOVideojuegos videojuego) {
    jdbcTemplate.update("insert into videojuegos values " + "(?, ?, ?, ?, ?, ?, ?)",
        codVideojuego(), videojuego.getTitulo(), videojuego.getPlataforma(),
        videojuego.getDesarrolladora(), videojuego.getPublisher(), videojuego.getPrecio(),
        videojuego.getStock());
  }

  public void borraVideojuego(Integer codigo) {
    jdbcTemplate.update("delete from videojuegos where CodVideojuegos = " + codigo);
  }

  public void actualizarVj(DTOVideojuegos vjAct) {
    jdbcTemplate.update(
        "update videojuegos set titulo = ?, plataforma = ?, desarrolladora = ?, publisher = ?, precio = ?, stock = ? where CodVideojuegos = ?",
        vjAct.getTitulo(), vjAct.getPlataforma(), vjAct.getDesarrolladora(), vjAct.getPublisher(),
        vjAct.getPrecio(), vjAct.getStock(), vjAct.getCodVideojuegos());
  }

  public void actualizarDatosDesdeFichero(DTOVideojuegos vjAct) {
    jdbcTemplate.update(
        "update videojuegos set desarrolladora = ?, precio = ?, stock = ? where titulo = ? AND"
            + " plataforma = ? AND publisher = ?",
        vjAct.getDesarrolladora(), vjAct.getPrecio(), vjAct.getStock(), vjAct.getTitulo(),
        vjAct.getPlataforma(), vjAct.getPublisher());
  }

  public boolean comprobarDatos(DTOVideojuegos juego) {
    String sql = "SELECT * FROM videojuegos WHERE titulo= ? AND publisher= ? AND plataforma = ?";
    List<Map<String, Object>> lista = jdbcTemplate.queryForList(sql, juego.getTitulo(),
        juego.getPublisher(), juego.getPlataforma());
    if (lista != null && lista.size() >= 1) {
      return true;
    } else {
      return false;
    }
  }

  public DTOVideojuegos cogeVideojuego(Integer codigo) {
    return jdbcTemplate.queryForObject("select * from videojuegos where CodVideojuegos = " + codigo,
        new BeanPropertyRowMapper<>(DTOVideojuegos.class));
  }


}

