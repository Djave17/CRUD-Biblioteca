

import entity.Autor;
import entity.Categoria;
import entity.Libro;
import services.dao.MyDao;
import services.interfaces.ICRUD;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static final ICRUD crud = new MyDao();

    public static void main(String[] args) {
        menu();
    }


    private static void menu() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("\n=========== MENÚ BIBLIOTECA ===========");
            System.out.println(" 1) Insertar autores (demo)");
            System.out.println(" 2) Listar autores");
            System.out.println(" 3) Editar autor (ID=1 → nacionalidad Colombiano)");
            System.out.println(" 4) Eliminar autor");
            System.out.println(" 5) Insertar categoría");
            System.out.println(" 6) Listar categorías");
            System.out.println(" 7) Editar categoría");
            System.out.println(" 8) Eliminar categoría");
            System.out.println(" 9) Crear/editar libro");
            System.out.println("10) Listar libros");
            System.out.println("11) Eliminar libro)");
            System.out.println(" 0) Salir");
            System.out.print("Seleccione opción: ");
            op = readInt(sc);

            switch (op) {
                case 1 -> insertarAutor();
                case 2 -> listarAutores();
                case 3 -> editarAutor();
                case 4 -> eliminarAutor();
                case 5 -> insertarCategoria();
                case 6 -> listarCategorias();
                case 7 -> editarCategoria();
                case 8 -> eliminarCategoria();
                case 9 -> crearLibro();
                case 10 -> listarLibros();
                case 11 -> eliminarLibro();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 0);
        sc.close();
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número: ");
            sc.next();
        }
        return sc.nextInt();
    }



    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicano");
        crud.insert(a);

        Autor b = new Autor();
        b.setNombre("Rubén Darío");
        b.setNacionalidad("Nicaraguense");
        crud.insert(b);

        System.out.println("Autores insertados.");
    }

    public static void listarAutores() {
        List<Autor> autores = crud.getAll("autores.All", Autor.class);
        if (autores == null || autores.isEmpty()) {
            System.out.println("No se encontraron autores.");
            return;
        }
        System.out.println("---- AUTORES ----");
        autores.forEach(autor -> {
            System.out.println("ID: " + autor.getId());
            System.out.println("Nombre: " + autor.getNombre());
            System.out.println("Nacionalidad: " + autor.getNacionalidad());
            System.out.println("-----------------------");
        });
    }

    public static void editarAutor() {
        Autor a = crud.findById(1, Autor.class);
        if (a == null) {
            System.out.println("Autor con ID 1 no encontrado.");
            return;
        }
        a.setNacionalidad("Colombiano");
        crud.update(a);
        System.out.println("Autor actualizado (ID 1).");
    }

    public static void eliminarAutor() {
        Autor a = crud.findById(2, Autor.class);
        if (a == null) {
            System.out.println("Autor con ID 2 no encontrado.");
            return;
        }
        crud.delete(a);
        System.out.println("Autor eliminado (ID 2).");
    }

    public static void crearLibro() {

        Libro a = crud.findById(1, Libro.class);
        if (a == null) {
            System.out.println("Libro con ID 1 no encontrado.");
            return;
        }
        a.setTitulo("El hobbit");
        a.setAnioPublicacion(1937);
        crud.update(a);
        System.out.println("Libro actualizado (ID 1).");
    }

    public static void listarLibros() {
        List<Libro> libros = crud.getAll("libros.All", Libro.class);
        if (libros == null || libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
            return;
        }
        System.out.println("---- LIBROS ----");
        libros.forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Titulo: " + libro.getTitulo());
            // Si tu entidad usa Integer anioPub, cambia por getAnioPub()
            // Si tu entidad usa Integer anioPub, cambia por getAnioPublicacion() si aplica
            System.out.println("Anio Publicacion: " + libro.getAnioPublicacion());
            System.out.println("-----------------------");
        });
    }

    public static void eliminarLibro() {
        Libro a = crud.findById(1, Libro.class);
        if (a == null) {
            System.out.println("Libro con ID 1 no encontrado.");
            return;
        }
        crud.delete(a);
        System.out.println("Libro eliminado (ID 1).");
    }

    public static void insertarCategoria() {
        Categoria a = new Categoria();
        a.setNombre("Fantasia");
        crud.insert(a);
        System.out.println("Categoría insertada.");
    }

    public static void listarCategorias() {
        List<Categoria> categorias = crud.getAll("categorias.All", Categoria.class);
        if (categorias == null || categorias.isEmpty()) {
            System.out.println("No se encontraron categorias.");
            return;
        }
        System.out.println("---- CATEGORÍAS ----");
        categorias.forEach(categoria -> {
            System.out.println("ID: " + categoria.getId());
            System.out.println("Nombre: " + categoria.getNombre());
            System.out.println("-----------------------");
        });
    }

    public static void eliminarCategoria() {
        Categoria a = crud.findById(1, Categoria.class);
        if (a == null) {
            System.out.println("Categoria con ID 1 no encontrada.");
            return;
        }
        crud.delete(a);
        System.out.println("Categoría eliminada (ID 1).");
    }

    public static void editarCategoria() {
        Categoria a = crud.findById(1, Categoria.class);
        if (a == null) {
            System.out.println("Categoria con ID 1 no encontrada.");
            return;
        }
        // DEMO: aquí podrías cambiar el nombre si tu entidad lo permite
        System.out.println("Demo editarCategoria: implementa cambios según tu modelo.");
    }
}
