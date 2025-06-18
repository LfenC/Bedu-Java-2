
package sesion3.reto2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Encuesta> encuestaCentro = new ArrayList<>();
        encuestaCentro.add(new Encuesta("Juan", "El tiempo de espera fue largo",2));    
        encuestaCentro.add(new Encuesta("Marta", null,3));    
        encuestaCentro.add(new Encuesta("Luis", "Todo bien",5));    
       
        List<Encuesta> encuestaNorte = new ArrayList<>();
        encuestaCentro.add(new Encuesta("Ana", "La atención fue buena, pero la limpieza puede mejorar",3));    
        encuestaCentro.add(new Encuesta("Carlos", null,2));    
        encuestaCentro.add(new Encuesta("Elena", "Excelente",5));    
        
        List<Sucursal> sucursales = new ArrayList<>();
        sucursales.add(new Sucursal("Centro", encuestaCentro));    
        sucursales.add(new Sucursal("Norte", encuestaNorte));  
        
        
        sucursales.stream()
                .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .flatMap(encuesta -> encuesta.getComentario()
                    .map(comentario -> Stream.of("Sucursal " + sucursal.getNombre()
                        + ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                    .orElseGet(Stream::empty)
                    )
                )
                .forEach(System.out::println);
    }
}
