
package sesion1.reto1;

import java.util.List;

public class Ordenes {
    
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("Órdenes registradas:");
        for(OrdenProduccion orden : lista){
            orden.mostrarResumen();
        }               
    }
    
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("Procesando órdenes personalizadas...");
        for(Object obj : lista) {
            if(obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).aplicaCosto(costoAdicional);
            }
        }
    }
}
