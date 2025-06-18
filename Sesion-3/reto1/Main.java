
package sesion3.reto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        List <Pedido> pedidos = new ArrayList<>();
        pedidos.add (new Pedido("Carlos", "domicilio", "555-1234")); 
        pedidos.add (new Pedido("Ana", "local", "555-9999")); 
        pedidos.add (new Pedido("Luis", "domicilio", null)); 
        pedidos.add (new Pedido("Sofia", "domicilio", "6685-5678"));    
    
        pedidos.stream()
                .filter(p -> p.getTipoentrega().equalsIgnoreCase("domicilio"))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(telefono -> "Confirmación enviada al número: " + telefono)
                .forEach(System.out::println);
    }
    
    
}
