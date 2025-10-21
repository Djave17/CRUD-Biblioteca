package entity;


import jakarta.persistence.*;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter@Setter
@NamedQueries(
        @NamedQuery(
                name = "autores.All",
                query = "SELECT a FROM Autor a"
        )
)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_categoria", length = 100, nullable = false)
    private String nombre;

    @Column(name = "nacionalidad", length = 100, nullable = false)
    private String nacionalidad;

    private LocalDate fechaNacimiento;


}
