package fichero_objetos;

import java.io.Serializable;

//recordad el seriealizable
public class Dado implements Serializable {
    public static final int Caras = 6;
    private int tirada;
    /*
    Funcionamiento es guardar un objeto en un fichero binario y despues descifrarlo y leerlo de nuevo
    //tener en cuenta que al principio de cada archivo hay una cabecera indicando como leer ese archivo en binario tener en cuenta evitar
    hay que evitar que la cabecera no se repita despues de crear objetos dentro del archivo
    //serializable enviar un objeto de una actividad a otra
    //Object readObject lee un objeto SERIELADIZADO
   //sii serializo un objeto el modelo de datos no se puede cambiar ni una variable se queda en modo lectura
    //WriteObject





     */

    public Dado(int tirada){
        this.tirada = tirada;
    }

    public int getTirada() {
        return tirada;
    }

    public void setTirada(int tirada) {
        this.tirada = tirada;
    }
}
