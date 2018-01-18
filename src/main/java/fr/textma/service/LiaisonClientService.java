package fr.textma.service;


import fr.textma.model.LiaisonClient;

public interface LiaisonClientService {
	void save(LiaisonClient liaison);
	void delete(Integer idMere, Integer idFils);
}
