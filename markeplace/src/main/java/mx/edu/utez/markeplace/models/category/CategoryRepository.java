package mx.edu.utez.markeplace.models.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findById(Long id); // optional para ver si estaba vacia
    List<Category> findAllByStatus(Boolean status);
    Optional<Category> findByName(String name);

    @Query(value = "UPDATE categories SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);
}
