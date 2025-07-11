
package misInterfaces;

import java.util.ArrayList;


public interface CRUD <T>{
    public void insertar(T p);
    public void eliminar(String valor);
    public void actualizar(T p);
    public T listarUno(String valor);
    public ArrayList<T> listarTodos();
}
