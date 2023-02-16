package mx.edu.utez.markeplace.controller.subcategory;

import mx.edu.utez.markeplace.controller.category.dtos.CategoryDto;
import mx.edu.utez.markeplace.controller.subcategory.dtos.SubcategoryDto;
import mx.edu.utez.markeplace.models.category.Category;
import mx.edu.utez.markeplace.models.subcategory.SubCategory;
import mx.edu.utez.markeplace.services.subcategory.SubcategoryService;
import mx.edu.utez.markeplace.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-market/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    private SubcategoryService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<SubCategory>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<SubCategory>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<SubCategory>> insert(@RequestBody SubcategoryDto subcategoryDto) {//castea de datos a un obj categoria
        return new ResponseEntity<>(
                this.service.insert(subcategoryDto.getSubCategory()), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Category>> delete(
            @PathVariable("id") Long id
    ) {
        this.service.delete(id);
        return new ResponseEntity<>(
                null, HttpStatus.OK

        );
    }

}
