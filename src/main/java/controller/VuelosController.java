package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import model.Vuelo;
import service.ServiceVuelos;

@CrossOrigin(origins="*")
@RestController
public class VuelosController {

	@Autowired
	ServiceVuelos service;
	
	@GetMapping (value ="/api/vuelos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> devolverVuelos () {
		return service.devolverVuelosDisponibles();
	}
	
	@PostMapping("/api/vuelo")
	public void guardarVueloDAO(@RequestBody Vuelo vuelo) {
		 service.guardarVuelo(vuelo);
	}
	
	@GetMapping("/api/vuelo/{id}")
	public ResponseEntity<Vuelo> ObtenerVueloxid(@PathVariable Integer id){
		
			try {
				Vuelo vuelo=service.obtenerVueloxID(id);
				return  new ResponseEntity<Vuelo>(vuelo,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Vuelo>(HttpStatus.NOT_FOUND);
			}
	}
	
	@PutMapping("/api/vuelo/{id}")
	public ResponseEntity<?> actualizarDisponiblidad(@RequestBody Vuelo vuelo,@PathVariable Integer id){
		try {
			Vuelo vueloexistente=service.obtenerVueloxID(id);
			
			vueloexistente.setCategoria(vuelo.getCategoria());
			vueloexistente.setDisponible(vuelo.getDisponible());
			vueloexistente.setOrigen(vuelo.getOrigen());
			vueloexistente.setDestino(vuelo.getDestino());
			vueloexistente.setPrecio(vuelo.getPrecio());
			
			service.guardarVuelo(vueloexistente);
			
			return  new ResponseEntity<Vuelo>(vueloexistente,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Vuelo>(HttpStatus.NOT_FOUND);
		}
	}
}
