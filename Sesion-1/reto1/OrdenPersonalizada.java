
package sesion1.reto1;

public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;
    
    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;
    }
    
    @Override
    public void mostrarResumen(){
        System.out.println("OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + "- Cliente: " + cliente);
    }
    
    public void aplicaCosto(int costo){
        System.out.println("Orden " + codigo + " ajustada con costo adicional de $" + costo);
    }
}
