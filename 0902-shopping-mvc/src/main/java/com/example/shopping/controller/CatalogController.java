package com.example.shopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.shopping.entity.Product;
import com.example.shopping.service.CatalogService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/display-list")
    public String displayList(Model model) {
        List<Product> productList = catalogService.findAll();
        model.addAttribute("productList", productList);
        return "catalog/productList";
    }
    
    @GetMapping("/display-details")
    public String displayDetails(@RequestParam("productId") String id, Model model) {
    	Product product = catalogService.findById(id);
    	model.addAttribute("product", product);
    	return "catalog/product";
    }

}
