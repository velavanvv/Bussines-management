package com.business.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.business.entities.Product;
import com.business.repositories.ProductRepository;
@Component
public class ProductServices 
{
	@Autowired
	private ProductRepository productRepository;

	//add Product
	public void addProduct(String name,double price,String desc,MultipartFile file) throws IOException 
	{

Product entity=new Product(name,price,desc);
		String uplodeDir="src/main/resources/static/images";
		String uniqueFileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		Path uploadPath=Path.of(uplodeDir);
		Path filePath=uploadPath.resolve(uniqueFileName);
		if(!Files.exists(uploadPath)){
			Files.createDirectories(uploadPath);
		}
		Files.copy(file.getInputStream(),filePath,StandardCopyOption.REPLACE_EXISTING);
		entity.setPimage(uniqueFileName);

		this.productRepository.save(entity);
	}


	//getAll products
	public List<Product> getAllProducts()
	{
		List<Product> products=(List<Product>)this.productRepository.findAll();

		return products;
	}

	//get Single Product
	public Product getProduct(int id)
	{
		Product product = this.productRepository.findById(id);
		
		return product;
	}

	//update Product
	public void updateproduct(int id,String name,double price,String desc,MultipartFile file) throws IOException 
	{
		
		Product entity = this.productRepository.findById(id);
		if(!file.isEmpty()){
			String uplodeDir="src/main/resources/static/images";
		String uniqueFileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		Path uploadPath=Path.of(uplodeDir);
		Path filePath=uploadPath.resolve(uniqueFileName);
		if(!Files.exists(uploadPath)){
			Files.createDirectories(uploadPath);
		}
		Files.copy(file.getInputStream(),filePath,StandardCopyOption.REPLACE_EXISTING);
		Path imagePath=Path.of(uplodeDir,entity.getPimage());
		if(Files.exists(imagePath)){
			Files.delete(imagePath);
		}
		entity.setPimage(uniqueFileName);
		}
		entity.setPname(name);
		entity.setPdescription(desc);
		entity.setPprice(price);

		
			this.productRepository.save(entity);				
		
	}
	//delete product
	public void deleteProduct(int id) throws IOException
	{
		Product entity = this.productRepository.findById(id);
		String uplodeDir="src/main/resources/static/images";
		Path imagePath=Path.of(uplodeDir,entity.getPimage());
		if(Files.exists(imagePath)){
			Files.delete(imagePath);
		}
		this.productRepository.deleteById(id);
	}

	//Get Product By Name
	public Product getProductByName(String name)
	{
		
		Product product= this.productRepository.findByPname(name);
		if(product!=null)
		{
			return product;
		}
		return null;
	
	}
}