import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {

    private ArrayList<Libro> libros;
    private HashMap<String, Libro> librosPorCodigo;

    public Biblioteca() {
        libros = new ArrayList<>();
        librosPorCodigo = new HashMap<>();
    }

    public boolean agregarLibro(Libro libro) {

        if (librosPorCodigo.containsKey(libro.getCodigo())) {
            return false;
        }

        libros.add(libro);
        librosPorCodigo.put(libro.getCodigo(), libro);

        return true;
    }

    public boolean eliminarLibro(String codigo) {

        Libro libro = librosPorCodigo.get(codigo);

        if (libro != null) {
            libros.remove(libro);
            librosPorCodigo.remove(codigo);
            return true;
        }

        return false;
    }

    public ArrayList<Libro> filtrarPorAutor(String autor) {

        ArrayList<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {

            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(libro);
            }
        }

        return resultado;
    }

    public ArrayList<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }
}