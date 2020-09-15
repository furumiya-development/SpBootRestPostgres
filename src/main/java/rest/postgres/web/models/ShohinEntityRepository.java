package rest.postgres.web.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShohinEntityRepository extends JpaRepository<ShohinEntity, Integer> {
	List<ShohinEntity> findBy_ShohinCode(Short find);
	//Interface CrudRepository<T,ID>参照
}