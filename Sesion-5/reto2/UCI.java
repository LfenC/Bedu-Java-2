
package sesion5.reto2;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class UCI {
        
//generar pacientes
    private static Flux<String> generaPaciente(int numero){
       return Flux.interval(Duration.ofMillis(300))
               .onBackpressureBuffer()
               .map(tick -> {
                    int fC = ThreadLocalRandom.current().nextInt(40,141);
                    int presion1 = ThreadLocalRandom.current().nextInt(80,161);
                    int presion2 = ThreadLocalRandom.current().nextInt(50,101);
                    int spO2 = ThreadLocalRandom.current().nextInt(85,100);


                 //evento criticos
                 // frecuencia cardiaca <50 o >120 bpm
                    if(fC < 50 || fC > 120) {
                        return "Paciente " + numero + " - FC crítica: " + fC + " bpm";
                    //presión arterial < 90/60 mmHg o > 140/90 mmHg
                    } else if (presion1 < 90 || presion1 > 140 || presion2 < 60 || presion2 > 90 ){
                        return "Paciente " + numero + " - PA crítica: " + presion1 + "/" + presion2 + " mmHg";
                    //oxígeno en sangre <90%
                    } else if (spO2 < 90) {
                        return "Paciente " + numero + " - SpO2 baja: " + spO2 + "%";
                    }
                    return "";           
                })
               .filter(alert -> !alert.isEmpty());
    }
        
    public static void main(String[] args) throws InterruptedException {
        //generar pacientes
        Flux<String> paciente1 = generaPaciente(1);
        Flux<String> paciente2 = generaPaciente(2);
        Flux<String> paciente3 = generaPaciente(3);
        
        //merge
        Flux.merge(paciente1, paciente2, paciente3)
        //aplicar cambio debido a la gran cantidad de eventos y saturación
                .flatMap(alert -> Mono.just(alert).delayElement(Duration.ofSeconds(1)),3)
                .subscribe(System.out::println);
        
        Thread.sleep(30000);
     
    }
    
}
