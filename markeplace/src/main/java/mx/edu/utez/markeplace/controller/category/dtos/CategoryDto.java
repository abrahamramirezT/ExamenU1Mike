package mx.edu.utez.markeplace.controller.category.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.markeplace.models.category.Category;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class CategoryDto {
    private Long id;
    private String name;

    private String equipo;
    private Boolean status;

    public Category getCategory(){
        return new Category(getId(),getName(),getEquipo(),getStatus(),null);
    }

}
