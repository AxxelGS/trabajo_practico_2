package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio7.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Producto> productos = new ArrayList<Producto>();
		
		Producto p01 = new Producto("p01","p01",100,true);
		Producto p02 = new Producto("p02","p02",40,false);
		Producto p03 = new Producto("p03","p03",50,true);
		Producto p04 = new Producto("p04","p04",30,false);
		
		productos = Arrays.asList(p01,p02,p03,p04);
		
		//Mostrar productos con Consumer
		Consumer<Producto> mostrar = p -> {if (p.isEstado()) 
	        System.out.println(p);
	    };
		productos.forEach(mostrar);
				
		//System.out.println(mostrarDisponibles(productos));
		//System.out.println(aumentarPrecio(productos));
		System.out.println(ordenarPorPrecio(productos));
		
	}

	public static List<Producto> mostrarDisponibles(List<Producto> productos) {
		//Predicate y Filter
        Predicate<Producto> condicion = p -> p.isEstado();
		return productos.stream()
                .filter(condicion)
                .collect(Collectors.toList());
    }
	
	public static List<Producto> aumentarPrecio(List<Producto> productos) {		
		Function<Producto,Producto> nuevoPrecio = p -> {
			p.setPrecio(p.getPrecio()*1.20f);
			return p;
			};
		        
        return productos.stream()
        		.map(nuevoPrecio)
        		.collect(Collectors.toList());
    }
	
	public static List<Producto> ordenarPorPrecio(List<Producto> productos) {		
		Comparator<Producto> c = Comparator.comparing(Producto :: getPrecio).reversed();
		        
		productos.sort(c);
		
		return productos;
    }
	
}