package com.bedu.ejemplo2;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejemplo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo2Application.class, args);
	}
        
        
        @Bean
        public CommandLineRunner demo(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, MarcaRepository marcaRepo) {
            return (args) -> {
                //categorias
                Categoria tecnologia = new Categoria("Tecnología");
                categoriaRepo.save(tecnologia);

                //marcas
                Marca lenovo = new Marca("Lenovo");
                Marca asus = new Marca("ASUS");
                Marca msi = new Marca("MSI");
                marcaRepo.saveAll(List.of(lenovo,asus, msi));

                //productos
                productoRepo.save(new Producto("Laptop ASUS ROG Strix SCAR 18", "Intel Core i9, RTX 5090", 90000.00, tecnologia, asus));
                productoRepo.save(new Producto("Laptop MSI Titan 18 HX", "Intel Core i9, RTX 4090", 140000.00, tecnologia,msi));
                productoRepo.save(new Producto("Tablet Lenovo", "Pantalla 10 pulgadas", 7800.00, tecnologia, lenovo));
                productoRepo.save(new Producto("Teclado ASUS", "Teclado rosa", 1200.00, tecnologia, asus));

                /*
                System.out.println("Productos registrados:");
                productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getCategoria().getNombre()));
                */
                System.out.println("Productos por marca:");
                    marcaRepo.findAll().forEach(marca -> {
                       System.out.println(" - " + marca.getNombre() + ":");
                       productoRepo.findAll().stream()
                          .filter(p -> p.getMarca().getId().equals(marca.getId()))
                          .forEach(p -> System.out.println("   - " + p.getNombre()));
                });
            
            };
        }
}
