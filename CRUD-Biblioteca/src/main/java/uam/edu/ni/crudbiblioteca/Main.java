package uam.edu.ni.crudbiblioteca;

import uam.edu.ni.crudbiblioteca.entity.Autor;
import uam.edu.ni.crudbiblioteca.services.dao.MyDao;
import uam.edu.ni.crudbiblioteca.services.interfaces.ICRUD;

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
}
