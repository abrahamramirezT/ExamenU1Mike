package mx.edu.utez.markeplace.controller.subcategory.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.markeplace.models.category.Category;
import mx.edu.utez.markeplace.models.subcategory.SubCategory;

import javax.persistence.criteria.CriteriaBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class SubcategoryDto {

    private Long id;

    private String name;

    private Integer poder;

    private Integer salud;
    private Integer ataque;
    private Integer defensa;

    private Category entrenador;




    public SubCategory getSubCategory(){
    return new SubCategory(getId(),getName(),getPoder(),getSalud(),getAtaque(),getDefensa(), getEntrenador());
    }





}
