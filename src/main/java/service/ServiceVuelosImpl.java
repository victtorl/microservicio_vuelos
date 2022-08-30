package service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.VuelosDao;
import model.Vuelo;

@Service
public class ServiceVuelosImpl implements ServiceVuelos {

	@Autowired
	VuelosDao dao;
	@Override
	public List<Vuelo> devolverVuelosDisponibles() {
		List <Vuelo> vuelos = dao.devolverVuelos();
		return vuelos.stream().filter(t->t.getDisponible()==1).collect(Collectors.toList());
	}
	
	public void guardarVuelo(Vuelo vuelo) {
	     dao.guardarVueloDAO(vuelo);
	}
	
	public Vuelo  obtenerVueloxID(Integer id) {
		return dao.obtenerVueloporIdDAO(id);
	}
	
	
}
