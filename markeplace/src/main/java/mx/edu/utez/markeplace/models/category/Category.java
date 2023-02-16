package mx.edu.utez.markeplace.models.category;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.markeplace.models.subcategory.SubCategory;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "entrenadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 150)
    private String name;
    @Column(nullable = false, unique = true,length = 150)
    private String equipo;

    @Column(name = "status", nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean status;

    @OneToMany(mappedBy = "entrenador")
    @JsonIgnore
    private List<SubCategory> pokemons;
}
