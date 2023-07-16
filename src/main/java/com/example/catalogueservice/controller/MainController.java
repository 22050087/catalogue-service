package com.example.catalogueservice.controller;

import com.example.catalogueservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.catalogueservice.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

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
      
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") Integer id){
        Optional<Product> optional = productRepository.findById(id);
        optional.ifPresent(product ->{
          productRepository.delete(product);
        });
        
        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){

        Optional<Product> optional = productRepository.findById(id);
        optional.ifPresent(product ->{
          model.addAttribute("product", product);
        });

        return "editProduct";
    }
}
