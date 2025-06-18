
package sesion2.reto1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {
        System.out.println("Simulación de misión espacial iniciada...");
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        Future<String> navegacion = executor.submit(new SistemaNavegacion());
        Future<String> soporte = executor.submit(new SistemaSoporteVital());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
       
        try {
            System.out.println(comunicaciones.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(navegacion.get());
            System.out.println("Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error en la misión: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
