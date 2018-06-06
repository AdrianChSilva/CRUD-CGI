package com.adrichs.paginaWeb;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class MainController {

  @Autowired
  private Servicio servicio;


  private String message = "Hello World";


  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    return "index";
  }

  @RequestMapping("/videojuegos") // method = RequestMethod.GET)
  public String videojuegos(Map<String, Object> model) {
    List<DTOVideojuegos> tabla = servicio.obtenerTabla();
    model.put("tabla", tabla);
    return "videojuegos";
  }

  @RequestMapping("/altaVideojuego")
  public String altaVideojuego(Map<String, Object> model, Integer codigo,
      @RequestParam("Titulo") String titulo, @RequestParam("Plataforma") String plataforma,
      @RequestParam("Desarrolladora") String desarrolladora,
      @RequestParam("Publisher") String publisher, @RequestParam("Precio") float precio,
      @RequestParam("Stock") int stock) {
    DTOVideojuegos vj = new DTOVideojuegos();
    vj.setCodVideojuegos(codigo);
    vj.setTitulo(titulo);
    vj.setPlataforma(plataforma);
    vj.setDesarrolladora(desarrolladora);
    vj.setPublisher(publisher);
    vj.setPrecio(precio);
    vj.setStock(stock);
    servicio.insertVideojuegos(vj);
    List<DTOVideojuegos> tabla = servicio.obtenerTabla();
    model.put("tabla", tabla);
    return "videojuegos";
  }

  @RequestMapping("/archivoVideojuego")
  public String archivoVideojuego(Map<String, Object> model,
      @RequestParam("csv") MultipartFile file) {

    try {

      List<String> lineas = new ArrayList<>();
      BufferedReader br;

      String line;
      InputStream is = file.getInputStream();
      br = new BufferedReader(new InputStreamReader(is));
      while ((line = br.readLine()) != null) {
        lineas.add(line);
      }

      List<DTOVideojuegos> videojuegos = new ArrayList<>();
      for (String linea : lineas) {
        String[] word = linea.split(",");
        DTOVideojuegos videojuego = new DTOVideojuegos();
        videojuego.setTitulo(word[0]);
        videojuego.setPlataforma(word[1]);
        videojuego.setDesarrolladora(word[2]);
        videojuego.setPublisher(word[3]);
        videojuego.setPrecio(Float.parseFloat(word[4]));
        videojuego.setStock(Integer.parseInt(word[5]));
        videojuegos.add(videojuego);
      }

      for (DTOVideojuegos videojuego : videojuegos) {
        if (servicio.compruebaDatos(videojuego)) {
          servicio.actualizarDatosDesdeFichero(videojuego);
        } else {
          servicio.insertVideojuegos(videojuego);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    return "videojuegos";

  }

  @RequestMapping("/borraVideojuego")
  public String borraVideojuego(Map<String, Object> model,
      @RequestParam("CodVideojuegos") Integer codigo) {
    servicio.deleteVideojuegos(codigo);
    List<DTOVideojuegos> tabla = servicio.obtenerTabla();
    model.put("tabla", tabla);
    return "videojuegos";
  }

  @RequestMapping("/buscaVideojuegos")
  public String buscaVideojuegos(Map<String, Object> model, @RequestParam("b") String b) {
    List<DTOVideojuegos> buscaVi = servicio.busquedaVideojuego(b);
    model.put("buscaVi", buscaVi);

    return "videojuegos";
  }

  @RequestMapping("/editaVideojuego")
  public String editaVideojuego(Map<String, Object> model,
      @RequestParam("CodVideojuegos") Integer codigo) {
    DTOVideojuegos videojuego = servicio.cogeVideojuego(codigo);
    model.put("videojuego", videojuego);

    return "editaVideojuego";
  }

  @RequestMapping("/editaVideojuegoModificado")
  public String editaVideojuegoModificado(Map<String, Object> model,
      @RequestParam("Titulo") String titulo, @RequestParam("Plataforma") String plataforma,
      @RequestParam("Desarrolladora") String desarrolladora,
      @RequestParam("Publisher") String publisher, @RequestParam("Precio") float precio,
      @RequestParam("Stock") int stock, @RequestParam("CodVideojuegos") Integer codigo) {
    DTOVideojuegos vj = new DTOVideojuegos();
    vj.setTitulo(titulo);
    vj.setPlataforma(plataforma);
    vj.setDesarrolladora(desarrolladora);
    vj.setPublisher(publisher);
    vj.setPrecio(precio);
    vj.setStock(stock);
    vj.setCodVideojuegos(codigo);// posiblemente sobre este
    servicio.actualizarVj(vj);
    List<DTOVideojuegos> tabla = servicio.obtenerTabla();
    model.put("tabla", tabla);

    return "videojuegos";
  }

  @RequestMapping("/editaSocio")
  public String editaSocio(Map<String, Object> model, @RequestParam("CodSocios") Integer codigo) {
    DTOSocios socio = servicio.cogeSocio(codigo);
    model.put("socio", socio);

    return "editaSocio";

  }

  @RequestMapping("/editaSocioModificado")
  public String editaSocioModificado(Map<String, Object> model, @RequestParam("DNI") String dni,
      @RequestParam("Nombre") String nombre, @RequestParam("Apellidos") String apellidos,
      @RequestParam("Telefono") String telefono, @RequestParam("Email") String email,
      @RequestParam("Genero") String genero, @RequestParam("Direccion") String direccion,
      @RequestParam("Asociado") String asociado, @RequestParam("CodSocios") Integer codigo) {
    DTOSocios socios = new DTOSocios();
    socios.setDni(dni);
    socios.setNombre(nombre);
    socios.setApellidos(apellidos);
    socios.setTelefono(telefono);
    socios.setEmail(email);
    socios.setGenero(genero);
    socios.setDireccion(direccion);
    socios.setAsociado(asociado);
    socios.setCodSocios(codigo);
    servicio.actualizarSocio(socios);
    List<DTOSocios> tablaSo = servicio.tablaSocios();
    model.put("tablaSo", tablaSo);
    return "socios";
  }

  @RequestMapping("/socios")
  public String socios(Map<String, Object> model) {
    List<DTOSocios> tablaSo = servicio.tablaSocios();
    model.put("tablaSo", tablaSo);
    return "socios";
  }

  @RequestMapping("/altaSocio")
  public String altaSocios(Map<String, Object> model, @RequestParam("DNI") String dni,
      @RequestParam("Nombre") String nombre, @RequestParam("Apellidos") String apellidos,
      @RequestParam("Telefono") String telefono, @RequestParam("Email") String email,
      @RequestParam("Genero") String genero, @RequestParam("Direccion") String direccion,
      @RequestParam("Asociado") String asociado) {
    DTOSocios socios = new DTOSocios();
    socios.setDni(dni);
    socios.setNombre(nombre);
    socios.setApellidos(apellidos);
    socios.setTelefono(telefono);
    socios.setEmail(email);
    socios.setGenero(genero);
    socios.setDireccion(direccion);
    socios.setAsociado(asociado);
    servicio.insertsSocios(socios);
    List<DTOSocios> tablaSo = servicio.tablaSocios();
    model.put("tablaSo", tablaSo);
    return "socios";
  }

  @RequestMapping("/borraSocio")
  public String borraSocio(Map<String, Object> model, @RequestParam("CodSocios") Integer codigo) {
    servicio.deleteSocios(codigo);
    List<DTOSocios> tablaSo = servicio.tablaSocios();
    model.put("tablaSo", tablaSo);
    return "socios";
  }

  @RequestMapping("/buscaSocio")
  public String buscaSocio(Map<String, Object> model, @RequestParam("b") String b) {
    List<DTOSocios> buscaSo = servicio.busquedaSocio(b);
    model.put("buscaSo", buscaSo);
    return "socios";
  }

  @RequestMapping("/facturas")
  public String facturas(Map<String, Object> model) {
    List<DTOFacturas> tablaFa = servicio.tablaFacturas();
    model.put("tablaFa", tablaFa);
    return "facturas";
  }

  @RequestMapping("/altaFacturas")
  public String altaSocios(Map<String, Object> model,
      // @RequestParam("CodDetFact") Integer codDetFact,
      @RequestParam("CodVideojuegos") Integer codVideojuegos,
      @RequestParam("Cantidad") Integer cantidad, @RequestParam("Precio") Integer precio,
      @RequestParam("Factura_idFactura") Integer facturaIdFactura) {
    DTOFacturas factura = new DTOFacturas();
    factura.setCodVideojuegos(codVideojuegos);
    factura.setCantidad(cantidad);
    factura.setPrecio(precio);
    factura.setFacturaIdFactura(facturaIdFactura);
    servicio.insertsFacturas(factura);
    List<DTOFacturas> tablaFa = servicio.tablaFacturas();
    model.put("tablaFa", tablaFa);
    return "facturas";
  }

  @RequestMapping("/borraFacturas")
  public String borraFactura(Map<String, Object> model,
      @RequestParam("CodDetFact") Integer codigo) {
    servicio.deleteFacturas(codigo);
    List<DTOFacturas> tablaFa = servicio.tablaFacturas();
    model.put("tablaFa", tablaFa);
    return "facturas";
  }

  @RequestMapping("/buscaFacturas")
  public String buscaFacturas(Map<String, Object> model, @RequestParam("b") String b) {
    List<DTOFacturas> buscaFa = servicio.busquedaFactura(b);
    model.put("buscaFa", buscaFa);
    return "facturas";
  }
}
