package mx.edu.utez.markeplace.services.subcategory;
import mx.edu.utez.markeplace.models.category.Category;
import mx.edu.utez.markeplace.models.subcategory.SubCategory;
import mx.edu.utez.markeplace.models.subcategory.SubcategoryRepository;
import mx.edu.utez.markeplace.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubcategoryService {
    @Autowired //instanciar nuestro repositorio
    private SubcategoryRepository repository;

    @Transactional(readOnly = true)
    public Response<List<SubCategory>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Tabn Pokemon"
        );
    }

    @Transactional(readOnly= true)
    public Response<SubCategory> getOne(Long id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "ok"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro la categoria"
        );

    }



    @Transactional(rollbackFor = {SQLException.class})
    public Response<SubCategory> insert(SubCategory subCategory){
        Optional<SubCategory> exist = this.repository.findByName(subCategory.getName());
        if (exist.isPresent())
            return new Response<>(
                    null, true, 400,"La categoria ya fue registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(subCategory), false,200,"Categoria registrada correctamente"
        );
    }


    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}
