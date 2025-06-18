
package sesion2.reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        RecursoMedico recursoMedico = new RecursoMedico("Sala de cirugía");
        
        Runnable draSanchez = () -> recursoMedico.usar("Dra. Sánchez");
        Runnable drGomez = () -> recursoMedico.usar("Dr. Gómez");
        Runnable enfermeraLopez = () -> recursoMedico.usar("Enfermera López");
        Runnable drRamirez = () -> recursoMedico.usar("Dr. Ramírez");
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        System.out.println("Iniciando acceso a la sala de cirugía...");
        System.out.println();
        
        executor.execute(draSanchez);
        executor.execute(drGomez);
        executor.execute(enfermeraLopez);
        executor.execute(drRamirez);
        
        executor.shutdown();

    }
}
