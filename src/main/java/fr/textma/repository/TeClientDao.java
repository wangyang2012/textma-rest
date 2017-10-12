package fr.textma.repository;


import fr.textma.model.TeClient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeClientDao extends JpaRepository<TeClient, Integer> {

//    TeClient findById(Integer id);

//    Page<TeClient> findByName(String name, Pageable pageable);
//
//
//    @Query("select tc from TeClient teClient where teClient.name like concat('%', :name, '%')")
//    List<TeClient> findAllByLikeName(@Param("name") String name, Pageable pageable);
}

