package com.tn.jeeLabs.lab4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tn.jeeLabs.lab1.ProduitService;
import com.tn.jeeLabs.lab1.Produit;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRestController {
	@Autowired
	ProduitService pS;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits() {
		return pS.getAllProduits();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id) {
		return pS.getProduit(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Produit createProduit(@RequestBody Produit produit) {
		return pS.saveProduit(produit);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit produit) {
		return pS.updateProduit(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		pS.deleteProduitById(id);
	}
	
	@RequestMapping(value="/prodscat/{idCat}",method = RequestMethod.GET)
	public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return pS.findByCategorieIdCat(idCat);
	}

}
