package com.tn.jeeLabs.lab1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tn.jeeLabs.lab3.Categorie;

public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository pR;
	
	@Override
	public Produit saveProduit(Produit p) {
		return pR.save(p);
	}
	
	@Override
	public Produit updateProduit(Produit p) {
		return pR.save(p);
	}
	
	@Override
	public void deleteProduit(Produit p) {
		pR.delete(p);
	}
	
	@Override
	public void deleteProduitById(Long id) {
		pR.deleteById(id);
	}
	
	@Override
	public Produit getProduit(Long id) {
		return pR.findById(id).get();
	}
	
	@Override
	public List<Produit> getAllProduits(){
		return pR.findAll();
	}
	
	@Override
	public List<Produit> findByNomProduit(String nom) {
		return pR.findByNomProduit(nom);
	}
	
	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return pR.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return pR.findByCategorie(categorie);
	}
	
	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return pR.findByCategorieIdCat(id);
	}
	

}
