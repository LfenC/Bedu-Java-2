package sesion4.reto2;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;



public class AeropuertoControl {
    
    private CompletableFuture<Boolean> simular(String servicio){
         return CompletableFuture.supplyAsync(()-> {
             try {
                 simularLatencia();
                 if(Math.random() < 0.1)
                     throw new RuntimeException("Error al verificar " + servicio);
                 return Math.random() < 0.9;
             } catch (Exception e) {
                 throw new RuntimeException("Excepción en verificar " + servicio + " " + e.getMessage());
             }
         });
    }
    public CompletableFuture<Boolean> verificarPista(){
        return simular("pista");
    }
    
    
    public CompletableFuture<Boolean> verificarClima(){
        return simular("clima");
    }
        
    public CompletableFuture<Boolean> verificarTraficoAereo(){
        return simular("tráfico aéreo");
    }
    
    
    public CompletableFuture<Boolean> verificarPersonalTierra(){
        return simular("personal en tierra");
    }
    
    ///simular latencia
    private void simularLatencia(){
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2,4));
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    
    public void autorizarAterrizaje(){
        System.out.println("Verificando condiciones para aterrizaje...\n");
        
        CompletableFuture<Boolean> pista = verificarPista().exceptionally(ex ->{
            System.out.println("Pista disponible: Error\n");
            return false;
        });
        
        CompletableFuture<Boolean> clima = verificarClima().exceptionally(ex ->{
            System.out.println("Clima favorable: Error\n");
            return false;
        });
        
        CompletableFuture<Boolean> traficoAereo = verificarTraficoAereo().exceptionally(ex ->{
            System.out.println("Tráfico aéreo despejado: Error\n");
            return false;
        });
        
        CompletableFuture<Boolean> personalTierra = verificarPersonalTierra().exceptionally(ex ->{
            System.out.println("Personal disponible: Error\n");
            return false;
        });
        
        //tareas
        
        CompletableFuture.allOf(pista, clima, traficoAereo, personalTierra)
            .thenRun(() -> {
                try {
                    boolean pistaB = pista.get();
                    boolean climaB = clima.get();
                    boolean traficoAereoB = traficoAereo.get();
                    boolean personalTierraB = personalTierra.get();

                    System.out.println("Pista disponible: " + pistaB);
                    System.out.println("Clima favorable: " + climaB);
                    System.out.println("Tráfico aéreo despejado: " + traficoAereoB);
                    System.out.println("Personal disponible: " + personalTierraB);
                    System.out.println();
                    
                    if (pistaB && climaB && traficoAereoB && personalTierraB){
                        System.out.println("Aterrizaje autorizado: todas las condiciones óptimas\n");
                    } else {
                        System.out.println("Aterrizaje denegado: condiciones no óptimas\n");
                    }
                } catch (Exception e) {
                    System.out.println("Aterrizaje denegado: error inesperado en las verificaciones\n");
                }
            });
    }        
    public static void main(String[] args) throws InterruptedException {
        AeropuertoControl aeropuertoControl = new AeropuertoControl();
        aeropuertoControl.autorizarAterrizaje();

        Thread.sleep(6000);
    }
}
