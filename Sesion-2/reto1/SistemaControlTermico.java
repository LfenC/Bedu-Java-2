
package sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String>{
    @Override
    public String call() throws Exception{
        Thread.sleep(1200);
        return "Control térmico: ttemperatura estable (22 °C).";
    }
}
