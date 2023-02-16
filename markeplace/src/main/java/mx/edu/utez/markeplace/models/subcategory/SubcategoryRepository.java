package mx.edu.utez.markeplace.models.subcategory;

import mx.edu.utez.markeplace.models.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findById(Long id);
    Optional<SubCategory> findByName(String name);

    @Query(value = "UPDATE subcategories SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);

}
