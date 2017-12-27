package fr.textma.repository;


import fr.textma.model.TsModePaiement;
import org.springframework.data.repository.CrudRepository;


public interface ModePaiementDao extends CrudRepository<TsModePaiement, Integer> {
}
