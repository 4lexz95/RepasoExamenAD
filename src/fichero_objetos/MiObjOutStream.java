package fichero_objetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjOutStream  extends ObjectOutputStream {
    public MiObjOutStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjOutStream() throws IOException, SecurityException {
    }
    //en la excepcion constructor vacio seleccionar 2 parametro de la excep
    //Importante: tengo que reescribir la funcion writeStreamHeader() es la funcion
    // que llama el OOS cada vez que va a empezar a escribir en un fichero le da igual sea
    // nuevo o no (Sele quita el super) y asi no escribira la cabecera pero esto con un IF hay que controlarlo para se creee un fichero nuevo


    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
