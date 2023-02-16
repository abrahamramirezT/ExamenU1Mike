package mx.edu.utez.markeplace.controller.category;

import mx.edu.utez.markeplace.controller.category.dtos.CategoryDto;
import mx.edu.utez.markeplace.models.category.Category;
import mx.edu.utez.markeplace.services.category.CategoryService;
import mx.edu.utez.markeplace.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"})
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Category>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Category>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }


    @PostMapping("/")
    public ResponseEntity<Response<Category>> insert(@RequestBody CategoryDto category) {//castea de datos a un obj categoria
        return new ResponseEntity<>(
                this.service.insert(category.getCategory()), HttpStatus.CREATED
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
