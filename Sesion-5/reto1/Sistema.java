
package sesion5.reto1;
import java.util.Random;
import reactor.core.publisher.Flux;
import java.time.Duration;


public class Sistema {
    
    //random generador
    static Random random = new Random();
    
    public static void main(String[] args) throws InterruptedException {
        //trafic 0-100 cada 500 ms
        Flux.interval(Duration.ofMillis(500))
            .map(n -> random.nextInt(101))
            .filter(valor -> valor > 70)
            .subscribe(valor -> System.out.println("Alerta: Congestión del " + valor + "%"+ " en Avenida Solar"));

        //contaminacion PM2.5 cada 600 ms
        Flux.interval(Duration.ofMillis(600))
            .map(n -> random.nextInt(101))
            .filter(pm -> pm > 50)
            .subscribe(pm -> System.out.println("Alerta: Contaminación alta (PM2.5:  " + pm + " ug/m3)"));

        //accidentes Baja, media,alta cada 800 ms
        String[] prioridad = {"Baja", "Media", "Alta"};
        Flux.interval(Duration.ofMillis(800))
            .map(n -> prioridad[random.nextInt(prioridad.length)])
            .filter(p -> p.equals("Alta"))
            .subscribe(p -> System.out.println("Emergencia vial: Accidente con prioridad " + p));

        //trenes retraso (0-10 min) cada 700 ms
        Flux.interval(Duration.ofMillis(700))
            .onBackpressureBuffer()
            .map(n -> random.nextInt(11))
            .filter(minutos -> minutos > 5)
            .subscribe(minutos -> System.out.println("Tren maglev con retraso crítico:  " +  minutos + " minutos"));

        //semáforos Verde, amarillo,rojo cada 400 ms
        String[] estado = {"Verde", "Amarillo", "Rojo"};   
        Flux.interval(Duration.ofMillis(400))
            .map(n -> estado[random.nextInt(estado.length)])
            .buffer(3,1)
            .filter(l -> l.stream().allMatch(e -> e.equals("Rojo")))
            .subscribe(l-> System.out.println("Semáforo en rojo detectado 3 veces seguidas en cruce norte "));

        Thread.sleep(15000);
    }
    
}
