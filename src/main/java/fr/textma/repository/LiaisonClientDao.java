package fr.textma.repository;


import fr.textma.model.LiaisonClient;
import org.springframework.data.repository.CrudRepository;


public interface LiaisonClientDao extends CrudRepository<LiaisonClient, Integer> {
    void deleteByMereIdAndFilsId(Integer mereId, Integer filsId);
}
