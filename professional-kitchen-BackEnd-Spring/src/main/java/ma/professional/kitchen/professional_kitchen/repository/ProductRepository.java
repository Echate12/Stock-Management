package ma.professional.kitchen.professional_kitchen.repository;

import ma.professional.kitchen.professional_kitchen.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
