package com.adrichs.paginaWeb;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAOFacturas {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<DTOFacturas> verTabla() {
    List<DTOFacturas> lista = new ArrayList<DTOFacturas>();
    lista = jdbcTemplate.query(
        "select * from det_factura inner join videojuegos on det_factura.CodVideojuegos = videojuegos.CodVideojuegos",
        new BeanPropertyRowMapper<>(DTOFacturas.class));

    return lista;
  }
  
  public void insertarDatos(DTOFacturas facturas) {
    jdbcTemplate.update("insert into det_factura (CodVideojuegos, Cantidad, Precio, Factura_idFactura) values (?,?,?,?)",
        facturas.getCodVideojuegos(), facturas.getCantidad(),
        facturas.getPrecio(), facturas.getFacturaIdFactura());
  }

  public void borraFactura(Integer codigo) {
    jdbcTemplate.update("delete from det_factura where CodDetFact = " + codigo);
  }

  public List<DTOFacturas> busqueda(String b) {
    List<DTOFacturas> lista = new ArrayList<DTOFacturas>();
    if (b.equals("")) {
      lista = jdbcTemplate.query(
          "select * from det_factura inner join videojuegos on det_factura.CodVideojuegos = videojuegos.CodVideojuegos",
          new BeanPropertyRowMapper<>(DTOFacturas.class));
    } else {
      lista = jdbcTemplate.query(
          "select * from det_factura inner join videojuegos on det_factura.CodVideojuegos = videojuegos.CodVideojuegos where det_factura.CodDetFact like '"
              + b + "' or det_factura.CodVideojuegos like '" + b + "' or videojuegos.titulo like '"
              + b + "' or det_factura.Cantidad like '" + b + "' or det_factura.Precio like '" + b
              + "' or det_factura.Factura_idFactura like '" + b + "'",
          new BeanPropertyRowMapper<>(DTOFacturas.class));

    }
    return lista;
  }
  

}

