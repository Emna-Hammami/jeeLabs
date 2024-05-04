package com.tn.jeeLabs.lab1;

import java.util.List;

import com.tn.jeeLabs.lab3.Categorie;

public interface ProduitService {
	
	Produit saveProduit(Produit p);
	
	Produit updateProduit(Produit p);
	
	void deleteProduit(Produit p);
	
	void deleteProduitById(Long id);
	
	Produit getProduit(Long id);
	
	List<Produit> getAllProduits();
	
	List<Produit> findByNomProduit(String nom);
	
	List<Produit> findByNomPrix (String nom, Double prix);
	
	List<Produit> findByCategorie (Categorie categorie);
	
	List<Produit> findByCategorieIdCat(Long id);

}
