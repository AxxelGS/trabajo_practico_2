package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	
	public static void main(String[] args) {
		//Garfield
		FelinoDomestico felino01 = new FelinoDomestico("Garfiel",(byte)12, 34);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felino02 = converter.convert(felino01);
		converter.mostrarObjeto(felino02);
		
		//Mufasa
		FelinoSalvaje felino03 = new FelinoSalvaje("Mufasa",(byte)20, 54);
		Converter<FelinoSalvaje, FelinoDomestico> converterNuevo = x -> new FelinoDomestico(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoDomestico felino04 = converterNuevo.convert(felino03);
		converterNuevo.mostrarObjeto(felino04);
		
	}
	
	
}