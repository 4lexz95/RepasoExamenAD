package fichero_objetos;

import java.io.*;
import java.util.ArrayList;

public class Main {


private static ArrayList<Dado> dados;
private static File dadosFichero;
static{
    dados = new ArrayList<>();
    dadosFichero = new File("dados.dat");
}
public static void main(String[] args) {
    crearTiradas();
    escribirTiradas();
    leerTiradas();


    }

    private static void leerTiradas() {
// Abrir el fichero coger los objetos y ver por consola el valor de la tirada
    FileInputStream fis;

        try {

            fis = new FileInputStream(dadosFichero);
            //esa herramienta que tiene la posibilidad de leer sobre un fichero pero byte a byte lo que va a hacer es encapsularla
            // en otro que es capaz de leer objeto a objeto
            ObjectInputStream ois = new ObjectInputStream(fis);
            // creo un bucle necesito leer hasta que explote porque ha encontrado el fin del fichero
            while (true){
                // primero cuando leo , y luego decido que hago con ellos en este caso donde los voy a guardar
                Dado dado =(Dado) ois.readObject();
                System.out.printf("La tirada es: %d%n",dado.getTirada());

            }
/*
add cacth
Antes del imputException debo agregar la excepcion del EOFExcetion End of File para que ese bucle while termine y ahora fuerzo
que el objeto que esta leyendo se castee a lo que corresponde
 */

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }catch (EOFException exception){

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void escribirTiradas() {
    //Encapsular el objeto, escribir el objeto en el archivo binario lo metjo en un bucle el arraylist de objetos y los va escribiendo
        //en binario
        // true en fos:
        /*
        al darle el valor true eso implica que la proxima vez que ejecute el fichero sino existe se creara pero si existe se añadiran
        y al añadirse agregara otra cabecera en el fichero y explotara
1º creo el fichero, meto la cabecera de como es el serialicer y meto datos vuelvo a escribir el fichero entero
PROBLEMA: Que se añada la cabecera otra vez El OOS se la suda y explota porque la la nueva cabecera creada en el fichero y
explota porque no lee un objeto dado que es lo que debe de leer en el archivo
SOLUCION: Controlar al OOS para que no añada la cabecera nueva para eso se crea un propio OOS basado en el generico

         */
        try {
            //fos = new FileOutputStream(dadosFichero, true);// añadido despues a proposito

            // el OOS antes de definirlo hay que decir si va aser generico o el propio OOS

            //El padre siempre generaliza mas que el hijo cuando defina la variable que va a escribir el OOS es el
            // padre que el que se la define y luego ya le digo si quiero que lo ejecute el padre o el hijo
            ObjectOutputStream ous;
            //comprueba si existe  y dependiendo una el propio o el generico
            if (dadosFichero.exists())
            ous = new MiObjOutStream(new FileOutputStream(dadosFichero, true));
            else {
                System.out.println("No existe");
                ous = new ObjectOutputStream(new FileOutputStream(dadosFichero, true));
            }
            for (Dado dado : dados
                 ) {
                ous.writeObject(dado);
            }
            ous.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void crearTiradas() {
        for (int i = 0; i < 100; i++) {
            dados.add(new Dado((int)Math.random() * Dado.Caras +1));

        }



    }
}