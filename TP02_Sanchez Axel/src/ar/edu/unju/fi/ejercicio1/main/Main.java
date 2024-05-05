package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Origenes;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categorias;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean valido = false;
        
        while (option != 4) {
            do {
                valido = false;
                System.out.println("\n*** MENU ***");
                System.out.println("1) Crear Producto");
                System.out.println("2) Mostrar productos");
                System.out.println("3) Modificar producto");
                System.out.println("4) Salir");
                try {
                    System.out.print("Opcion: ");
                    option = Integer.parseInt(sc.next());
                    if (option < 1 || option > 4) {
                        System.out.println("\nOpcion no valida");
                    } else {
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nERROR: Ingrese un numero valido");
                }
            } while (!valido);
            
            switch (option) {
                case 1:
                    crearProducto(productos, sc, valido);
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(productos, sc, valido);
                    break;
            }
        }
        sc.close();
    }

    private static void crearProducto(List<Producto> productos, Scanner sc, boolean valido) {
        Producto producto = new Producto();
        int opcion = 0;
        String codigo = "", descripcion;
        float precio = 0;
        valido = false;
        
        while (!valido) {
            valido = true;
            System.out.print("Ingrese el codigo del Producto: ");
            codigo = sc.next();
            Iterator<Producto> productoExistente = productos.iterator();
            while (productoExistente.hasNext()) {
                if (productoExistente.next().getCodigo().equals(codigo)) {
                    valido = false;
                }
            }
            if (!valido) {
                System.out.println("Codigo ya existente. Ingrese uno nuevo\n");
            }
        }
        System.out.print("Ingrese la descripcion: ");
        sc.nextLine();
        descripcion = sc.nextLine();
        valido = false;
        
        while (!valido) {
            System.out.print("Ingrese el precio del Producto: ");
            try {
                precio = Float.parseFloat(sc.next());
                if (precio < 0) {
                    System.out.println("Precio no valido");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
            }
        }
        producto.setCodigo(codigo);
        producto.setDescripcion(descripcion);
        producto.setPrecioUnitario(precio);
        valido = false;
        
        do {
            System.out.println("\n---Origen de Fabricacion---");
            System.out.println("1) Argentina");
            System.out.println("2) China");
            System.out.println("3) Brasil");
            System.out.println("4) Uruguay");
            try {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(sc.next());
                if (opcion < 1 || opcion > 4) {
                    System.out.println("\nOpcion no valida\n");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: Ingrese un numero valido\n");
            }
        } while (!valido);
        
        switch (opcion) {
            case 1:
                producto.setOrigenFabricacion(Origenes.ARGENTINA);
                break;
            case 2:
                producto.setOrigenFabricacion(Origenes.CHINA);
                break;
            case 3:
                producto.setOrigenFabricacion(Origenes.BRASIL);
                break;
            case 4:
                producto.setOrigenFabricacion(Origenes.URUGUAY);
                break;
        }
        valido = false;
        
        do {
            System.out.println("\n---Categoria---");
            System.out.println("1) Telefonia");
            System.out.println("2) Informatica");
            System.out.println("3) Electro Hogar");
            System.out.println("4) Herramientas");
            try {
                System.out.print("Opcion: ");
                opcion = Integer.parseInt(sc.next());
                if (opcion < 1 || opcion > 4) {
                    System.out.println("\nOpcion no valida\n");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nERROR: Ingrese un numero valido\n");
            }
        } while (!valido);
        
        switch (opcion) {
            case 1:
                producto.setCategoria(Categorias.TELEFONIA);
                break;
            case 2:
                producto.setCategoria(Categorias.INFORMATICA);
                break;
            case 3:
                producto.setCategoria(Categorias.ELECTRO_HOGAR);
                break;
            case 4:
                producto.setCategoria(Categorias.HERRAMIENTAS);
                break;
        }
        productos.add(producto);
    }

    private static void mostrarProductos(List<Producto> productos) {
        System.out.println("\n**Productos**\n");
        for (Producto producto : productos) {
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Precio Unitario: " + producto.getPrecioUnitario() + "$");
            System.out.println("Origen de Fabricacion: " + producto.getOrigenFabricacion());
            System.out.println("Categoria: " + producto.getCategoria() + "\n");
        }
    }

    private static void modificarProducto(List<Producto> productos, Scanner sc, boolean valido) {
        String codigo, descripcion;
        float precio = 0;
        int opcion = 0;
        System.out.print("\nIngrese el codigo del Producto a modificar: ");
        codigo = sc.next();
        valido = false;
        
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                valido = true;
                System.out.print("\nProducto Encontrado\n");
                System.out.print("Ingrese la descripcion: ");
                sc.nextLine();
                descripcion = sc.nextLine();
                valido = false;
                
                while (!valido) {
                    System.out.print("Ingrese el precio del Producto: ");
                    try {
                        precio = Float.parseFloat(sc.next());
                        if (precio < 0) {
                            System.out.println("Precio no valido");
                        } else {
                            valido = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese un numero valido");
                    }
                }
                producto.setDescripcion(descripcion);
                producto.setPrecioUnitario(precio);
                valido = false;
                
                do {
                    System.out.println("\n---Origen de Fabricacion---");
                    System.out.println("1) Argentina");
                    System.out.println("2) China");
                    System.out.println("3) Brasil");
                    System.out.println("4) Uruguay");
                    try {
                        System.out.print("Opcion: ");
                        opcion = Integer.parseInt(sc.next());
                        if (opcion < 1 || opcion > 4) {
                            System.out.println("\nOpcion no valida\n");
                        } else {
                            valido = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nERROR: Ingrese un numero valido\n");
                    }
                } while (!valido);
                
                switch (opcion) {
                    case 1:
                        producto.setOrigenFabricacion(Origenes.ARGENTINA);
                        break;
                    case 2:
                        producto.setOrigenFabricacion(Origenes.CHINA);
                        break;
                    case 3:
                        producto.setOrigenFabricacion(Origenes.BRASIL);
                        break;
                    case 4:
                        producto.setOrigenFabricacion(Origenes.URUGUAY);
                        break;
                }
                valido = false;
                
                do {
                    System.out.println("\n*** Categoria ***");
                    System.out.println("1) Telefonia");
                    System.out.println("2) Informatica");
                    System.out.println("3) Electro Hogar");
                    System.out.println("4) Herramientas");
                    try {
                        System.out.print("Opcion: ");
                        opcion = Integer.parseInt(sc.next());
                        if (opcion < 1 || opcion > 4) {
                            System.out.println("\nOpcion no valida\n");
                        } else {
                            valido = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\nERROR: Ingrese un numero valido\n");
                    }
                } while (!valido);
                
                switch (opcion) {
                    case 1:
                        producto.setCategoria(Categorias.TELEFONIA);
                        break;
                    case 2:
                        producto.setCategoria(Categorias.INFORMATICA);
                        break;
                    case 3:
                        producto.setCategoria(Categorias.ELECTRO_HOGAR);
                        break;
                    case 4:
                        producto.setCategoria(Categorias.HERRAMIENTAS);
                        break;
                }
            }
        }
    if (!valido) {
        System.out.print("\nProducto no encontrado\n");
    } else {
        System.out.print("\nProducto Modificado\n");
    }
}
}