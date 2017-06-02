package paniolvirtual

class Deposito {
    String nombre
    String direccion
    int capacidad
    boolean activo

    static constraints = {
    }
    
    String toString(){
        return nombre;
    }
}
