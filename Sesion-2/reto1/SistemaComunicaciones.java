
package sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(900);
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}
