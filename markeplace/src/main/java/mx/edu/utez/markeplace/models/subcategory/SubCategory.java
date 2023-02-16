package mx.edu.utez.markeplace.models.subcategory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.markeplace.models.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class    SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true,length = 150)
    private String name;


    @Column(nullable = false, unique = true, columnDefinition = "INT DEFAULT 0")
    private int poder;

    @Column(nullable = false, unique = true, columnDefinition = "INT DEFAULT 0")
    private int salud;

    @Column(nullable = false, unique = true, columnDefinition = "INT DEFAULT 0")
    private int ataque;
    @Column(nullable = false, unique = true, columnDefinition = "INT DEFAULT 0")
    private int defensa;








    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Category entrenador;
}
