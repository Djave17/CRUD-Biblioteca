

import entity.Autor;
import entity.Libro;
import services.dao.MyDao;
import services.interfaces.ICRUD;

import java.util.List;

public class Main {
    public static final ICRUD crud = new MyDao();

    public static void main(String[] args) {

        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();

    }


    public static void insertarAutor(){
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicano");
        crud.insert(a);

        Autor b = new Autor();
        b.setNombre("Rubén Darío");
        b.setNacionalidad("Nicaraguense");
        crud.insert(b);

    }

    public static void listarAutores(){
        Autor a = new Autor();
        List<Autor> autores = crud.getAll("autores.All", Autor.class);
        autores.forEach(autor -> {          ;
            System.out.println("ID: " + autor.getId());
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Nacionalidad: " + autor.getNacionalidad());
            System.out.println("-----------------------");
        });
    }

    public static void editarAutor(){
        Autor a = new Autor();
        a = crud.findById(1, Autor.class);
        a.setNacionalidad("Colombiano");
        crud.update(a);
    }

    public static void eliminarAutor(){
        Autor a = new Autor();
        a = crud.findById(2, Autor.class);
        crud.delete(a);
    }


    public static void crearLibro(){
        Libro a = new Libro();
        a = crud.findById(1, Libro.class);
        a.setTitulo("El hobbit");
        a.setAnioPublicacion("1937");
        crud.update(a);

    }

    public static void listarLibros(){
        Libro a = new Libro();
        List<Libro> libros = crud.getAll("libros.All", Libro.class);
        libros.forEach(libro -> {          ;
            System.out.println("ID: " + libro.getId());
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Anio Publicacion: " + libro.getAnioPublicacion());
            System.out.println("-----------------------");
        });
    }

    public static void eliminarLibro(){
        Libro a = new Libro();
        a = crud.findById(1, Libro.class);
        crud.delete(a);
    }

    public static void editarLibro(){
        Libro a = new Libro();
        a = crud.findById(1, Libro.class);
        a.setTitulo("El hobbit 2");
        crud.update(a);
    }

    public static void insertarCategoria(){
        
    }

}
