
package sesion1.reto1;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<OrdenMasa> ordenList = List.of(
            new OrdenMasa("A123",500),
            new OrdenMasa("A124",750)
        );
        
        List<OrdenPersonalizada> personalizada = new ArrayList<>(List.of(
            new OrdenPersonalizada("P456",100, "ClienteX"),
            new OrdenPersonalizada("P789",150, "ClienteY")
        ));   
        
        List<OrdenPrototipo> prototipo = List.of(
            new OrdenPrototipo("T789",10, "Diseño"),
            new OrdenPrototipo("T790",5,"Pruebas")
        );
        
        //mostrar
        Ordenes.mostrarOrdenes(ordenList);
        System.out.println();
        
        Ordenes.mostrarOrdenes(personalizada);
        System.out.println();
        
        Ordenes.mostrarOrdenes(prototipo);
        System.out.println();

        Ordenes.procesarPersonalizadas(personalizada, 200);
        
        System.out.println();
        System.out.println("Resumen total de órdenes:");
        System.out.println("Producción en masa: " + ordenList.size());
        System.out.println("Personalizadas: " + personalizada.size());
        System.out.println("Prototipos: " + prototipo.size());
    }
}
