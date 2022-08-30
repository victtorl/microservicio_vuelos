package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Vuelo;

@Repository
public class VuelosDaoImpl implements VuelosDao {
	@Autowired
	VuelosJpaSpring vuelos;
	@Override
	public List<Vuelo> devolverVuelos() {		
		return vuelos.findAll();
	}
	
	public void guardarVueloDAO(Vuelo vuelo) {
		 vuelos.save(vuelo);
	}
	
	public Vuelo obtenerVueloporIdDAO(Integer id) {
		return vuelos.findById(id).get();
	}
	
}
