package com.business.controllers;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.business.entities.Product;
import com.business.services.ProductServices;

@Controller
public class ProductController 
{
	@Autowired
	private ProductServices productServices;

	//	AddProduct
	@PostMapping("/addingProduct")
	public String addProduct(@RequestParam("pname") String name,@RequestParam("pprice")double price,@RequestParam("pdescription")String desc,@RequestParam("file")MultipartFile file) throws IOException
	{

		this.productServices.addProduct(name,price,desc,file);
		return "redirect:/admin/services";
	}

	//	UpdateProduct
	@PostMapping("/updatingProduct/{productId}")
	public String updateProduct(@PathVariable("productId") int id,@RequestParam("pname") String name,@RequestParam("pprice")double price,@RequestParam("pdescription")String desc,@RequestParam("file")MultipartFile file) throws IOException
	{

		this.productServices.updateproduct(id,name,price,desc,file);
		return "redirect:/admin/services";
	}
	//DeleteProduct
	@GetMapping("/deleteProduct/{productId}")
	public String delete(@PathVariable("productId") int id) throws IOException
	{
		this.productServices.deleteProduct(id);
		return "redirect:/admin/services";
	}
	
}
