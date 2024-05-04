package com.tn.jeeLabs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tn.jeeLabs.lab1.ProduitRepository;
import com.tn.jeeLabs.lab1.Produit;
import com.tn.jeeLabs.lab3.Categorie;
import java.util.Date;
import java.util.List;

@SpringBootTest
class JeeLabsApplicationTests {
	@Autowired
	private ProduitRepository pR;

	@Test
	public void testCreateProduit() {
		Produit produit = new Produit("PC Dell", 2200.500, new Date());
		pR.save(produit);
	}
	
	@Test
	public void testFindProduit() {
		Produit produit = pR.findById(1L).get();
		System.out.println(produit);
	}
	
	@Test
	public void testUpdateProduit() {
		Produit produit = pR.findById(1L).get();
		produit.setPrixProduit(1000.0);
		pR.save(produit);
	}

	@Test
	public void testDeleteProduit() {
		pR.deleteById(1L);
	}
	
	@Test
	public void testListerTousProduits() {
		List<Produit> produits = pR.findAll();
		for (Produit p : produits) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByNomProduit()
	{
		List<Produit> produits = pR.findByNomProduit("Imprimante");
		for (Produit p : produits){
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByNomPrix()
	{
		List<Produit> produits = pR.findByNomPrix("Imprimante",500.0);
		for (Produit p : produits){
			System.out.println(p);
		}
	}
	
	@Test
	public void testfindByCategorie()
	{
		Categorie categorie = new Categorie();
		categorie.setIdCat(1L);
		List<Produit> produits = pR.findByCategorie(categorie);
		for (Produit p : produits)
		{
			System.out.println(p);
		}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
		List<Produit> produits = pR.findByCategorieIdCat(1L);
		for (Produit p : produits)
		{
			System.out.println(p);
		}
	}
}
