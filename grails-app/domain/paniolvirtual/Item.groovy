package paniolvirtual

class Item {
    
    Long id
    String nombre
    User duenio
    String ubicacion
    Long cantidad
    
    static constraints = {
    }
    
    def String toString() {
        duenio?.getNombre() + " " + duenio?.getApellido()
    }
}
