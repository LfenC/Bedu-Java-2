
package sesion1.reto2;

import java.util.List;
import java.util.function.Predicate;

public class Genericos {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("Materiales del curso:");
        for(MaterialCurso material : lista){
            material.mostrarDetalle();
        }          
    }
    
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracionMin();
        }
        System.out.println("Duración total de videos: " + total + " minutos");
    }
    
    
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        for(Object obj : lista) {
            if(obj instanceof Ejercicio ejercicio) {
                ejercicio.mostrarRevisado();
            }
        }
    }
    
    public static void filtrarPorAutor(List<? extends MaterialCurso> materiales, Predicate<MaterialCurso> filtrar){
        materiales.stream()
                .filter(filtrar)
                .forEach(MaterialCurso::mostrarDetalle);
    }   
    
}
