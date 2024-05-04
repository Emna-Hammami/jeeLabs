package com.tn.jeeLabs.lab2.controller;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tn.jeeLabs.lab1.Produit;
import com.tn.jeeLabs.lab1.ProduitService;

@Controller
public class ProduitController {
	@Autowired
	ProduitService pS;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createProduit";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") Produit produit,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	produit.setDateProduit(dateCreation);
	Produit saveProduit = pS.saveProduit(produit);
	String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}
	
	@RequestMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap)
	{
	List<Produit> prods =
	pS.getAllProduits();
	modelMap.addAttribute("produits", prods);
	return "listeProduits";
	}

}
