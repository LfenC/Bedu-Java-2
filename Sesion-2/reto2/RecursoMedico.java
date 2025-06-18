
package sesion2.reto2;

import java.util.concurrent.locks.ReentrantLock;


public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock reentrantlock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println(profesional + " intentando acceder a " + nombre + "...");
        reentrantlock.lock();
        try {
            System.out.println(profesional + " ha ingresado " + nombre);
            Thread.sleep(1000);
            System.out.println(profesional + " ha salido de " + nombre);
        } catch (InterruptedException e){
            System.out.println(profesional + " fue interrumpido.");
        } finally {
            reentrantlock.unlock();
        }
        
    }
}
