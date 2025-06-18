
package sesion4.reto1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public CompletableFuture<String> calcularRuta(){
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Calculando ruta...");
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4)); 
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            return "Centro -> Norte";
        });
    }
    public CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Estimando tarifa...");
            try {
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3)); 
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            return 75.50;
        });
    }
    

    public void ejecutarSimulacion(){
        CompletableFuture<String> rutaF = calcularRuta();
        CompletableFuture<Double> tarifaF = estimarTarifa();
        rutaF.thenCombine(tarifaF, (ruta, tarifa) -> 
            "Ruta calculada: " + ruta + "| Tarifa estimada: $" + tarifa)
            .exceptionally(ex -> "Error en la operacion: " + ex.getMessage())
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        MovilidadApp movilidadApp = new MovilidadApp();
        movilidadApp.ejecutarSimulacion();

        Thread.sleep(5000);
    }
}