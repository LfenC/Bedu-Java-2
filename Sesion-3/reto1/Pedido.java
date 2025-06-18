
package sesion3.reto1;

import java.util.Optional;


public class Pedido {
    private String cliente;
    //puede ser domicilio o local
    private String tipoEntrega;
    //puede ser null
    private String telefono;

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }
    
    //get telefono que devuelve Optional<String>
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
    
    public String getTipoentrega(){
        return tipoEntrega;
    }
}
