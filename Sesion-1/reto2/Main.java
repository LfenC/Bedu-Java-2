
package sesion1.reto2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = Arrays.asList(
            new Video("Introducción a Java", "Mario", 15),
            new Video("POO en Java", "Carlos", 20),
            new Articulo("Historia de Java","Ana",1200),
            new Articulo("Tipos de datos", "Luis", 800),
            new Ejercicio("Variables y tipos", "Luis"),
            new Ejercicio("Condicionales", "Mario")       
        );
        
        Genericos.mostrarMateriales(materiales);
        
        //filtro
        
        List<Video> videos = new ArrayList<>();
        for(MaterialCurso materialC : materiales){
            if(materialC instanceof Video){
                videos.add((Video) materialC);
            }
        }
        
        System.out.println();
        Genericos.contarDuracionVideos(videos);
        
        System.out.println();
        Genericos.marcarEjerciciosRevisados(materiales);
        
        System.out.println();
        System.out.println("Filtrando por autor:");
        Genericos.filtrarPorAutor(materiales, m -> m.getAutor().equals("Mario"));
    }
}
