package com.example.catalogueservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.catalogueservice.model.Product;
import com.example.catalogueservice.repository.ProductRepository;

@Controller
public class MainController {

	@Autowired
    private ProductRepository productRepository;

    @RequestMapping("/products")
    public String index(Model model){
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products",products);

        return "products";
    }

    @RequestMapping(value = "add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "addProduct";
    }
}
