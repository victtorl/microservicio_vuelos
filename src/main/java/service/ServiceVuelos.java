package service;

import java.util.List;

import model.Vuelo;

public interface ServiceVuelos {
	
	public List<Vuelo> devolverVuelosDisponibles ();
	
	public void guardarVuelo(Vuelo vuelo);
	
	public  Vuelo obtenerVueloxID(Integer id);

}
