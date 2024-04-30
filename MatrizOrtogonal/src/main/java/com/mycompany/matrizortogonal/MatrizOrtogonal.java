
package com.mycompany.MatrizOrtogonal;
import com.mycompany.matrizortogonal.NodoColumna;



class MatrizOrtogonal {
    
    NodoFila primeraFila;
    NodoColumna primeraColumna;

    public MatrizOrtogonal() {
        this.primeraFila = null;
        this.primeraColumna = null;
    }

    public void insertarVehiculo(String placa, String color, String linea, String modelo, String propietario, int fila, int columna) {
        NodoVehiculo nuevoVehiculo = new NodoVehiculo(placa, color, linea, modelo, propietario);
        NodoFila filaActual = obtenerFila(fila);
        NodoColumna columnaActual = obtenerColumna(columna);

        if (filaActual == null) {
            filaActual = new NodoFila(fila);
            filaActual.siguienteFila = primeraFila;
            primeraFila = filaActual;
        }
        if (columnaActual == null) {
            columnaActual = new NodoColumna(columna);
            columnaActual.siguienteColumna = primeraColumna;
            primeraColumna = columnaActual;
        }

      
        nuevoVehiculo.siguienteFila = filaActual.siguienteFila;
        nuevoVehiculo.siguienteColumna = columnaActual.siguienteColumna;
        filaActual.siguienteFila = nuevoVehiculo;
        columnaActual.siguienteColumna = nuevoVehiculo;
    }

    public NodoVehiculo buscarVehiculo(String valorABuscar) 
            
    {
        NodoFila tempFila = primeraFila;
        while (tempFila != null) {
            NodoVehiculo tempVehiculo = tempFila.siguienteFila;
            while (tempVehiculo != null) {
                if (tempVehiculo.placa.equals(valorABuscar) || tempVehiculo.color.equals(valorABuscar)
                        || tempVehiculo.linea.equals(valorABuscar) || tempVehiculo.modelo.equals(valorABuscar)
                        || tempVehiculo.propietario.equals(valorABuscar)) {
                    return tempVehiculo;
                }
                tempVehiculo = tempVehiculo.siguienteFila;
            }
            tempFila = tempFila.siguienteFila;
        }
        
        return null; 
    }

    public void eliminarVehiculo(String valorABuscar) {
        
        NodoFila tempFila = primeraFila;
        while (tempFila != null) {
            NodoVehiculo anterior = null;
            NodoVehiculo actual = tempFila.siguienteFila;
            while (actual != null) {
                if (actual.placa.equals(valorABuscar) || actual.color.equals(valorABuscar)
                        || actual.linea.equals(valorABuscar) || actual.modelo.equals(valorABuscar)
                        || actual.propietario.equals(valorABuscar)) {
                    if (anterior == null) {
                        tempFila.siguienteFila = actual.siguienteFila;
                    } else {
                        anterior.siguienteFila = actual.siguienteFila;
                    }
                    actual = null; 
                    return;
                }
                anterior = actual;
                actual = actual.siguienteFila;
            }
            tempFila = tempFila.siguienteFila;
        }
    }
    
    
    private NodoFila obtenerFila(int fila) {
        
        NodoFila temp = primeraFila;
        while (temp != null) {
            if (temp.fila == fila) {
                return temp;
            }
            temp = temp.siguienteFila;
        }
        return null;
    }

    
    private NodoColumna obtenerColumna(int columna) {
        
        NodoColumna temp = primeraColumna;
        while (temp != null) {
            if (temp.columna == columna) {
                return temp;
            }
            temp = temp.siguienteColumna;
        }
        return null;
    }

    
    public static void main(String[] args) {
      
        MatrizOrtogonal matriz = new MatrizOrtogonal();

      
        matriz.insertarVehiculo("ABC123", "Rojo", "Totoya xd", "Corolla", "Juan", 1, 1);
        matriz.insertarVehiculo("DEF456", "Azul", "Honda", "Civic", "Maria", 2, 2);
        matriz.insertarVehiculo("GHI789", "Verde", "Ford", "Fiesta", "Pedro", 3, 3);

       
        NodoVehiculo vehiculoBuscado = matriz.buscarVehiculo("DEF456");
        if (vehiculoBuscado != null) {
            
            System.out.println("Vehículo encontrado: " + vehiculoBuscado.placa);
        } else {
            
            System.out.println("Vehículo no encontrado");
        }

        // Eliminar
        matriz.eliminarVehiculo("ABC123");

   
        vehiculoBuscado = matriz.buscarVehiculo("ABC123");
        if (vehiculoBuscado != null) {
            System.out.println("Vehículo encontrado después de eliminarlo: " + vehiculoBuscado.placa);
        } else {
            System.out.println("Vehículo no encontrado después de eliminarlo");
        }
    }

    

    public SourceVersion getSupportedSourceVersion() 
    {
        return SourceVersion.latest();
    }
    
}