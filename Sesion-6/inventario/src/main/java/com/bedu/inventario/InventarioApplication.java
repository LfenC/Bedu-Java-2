package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
            SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {
            // Guardar algunos productos
            repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
            repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
            repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
            repository.save(new Producto("Audifonos", "Cancelación de sonido", 1600.00));
            /*
            // Mostrar todos los productos
            System.out.println("Productos disponibles:");
            repository.findAll().forEach(System.out::println);
            */
            //Imprime todos los productos con precio mayor a 500
            System.out.println("\nProductos con precio mayor a 500:");
            repository
                    .findByPrecioGreaterThan(500)
                    .forEach(System.out::println);
            
            // Buscar por nombre parcial
            System.out.println("\nProductos que contienen 'Lap':");
            repository
                    .findByNombreContaining("Lap")
                    .forEach(System.out::println);
            
            //Imprime productos con precio entre 400 y 1000
            System.out.println("\nProductos con precio entre 400 y 1000:");
            repository
                    .findByPrecioBetween(400,1000)
                    .forEach(System.out::println);
 
            //Imprime productos cuyo nombre comience con "m" o "M"
            System.out.println("\nProductos cuyo nombre empieza con 'm':");
            repository
                    .findByNombreStartingWithIgnoreCase("m")
                    .forEach(System.out::println);          
        };
    }
}
