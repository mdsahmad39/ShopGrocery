package com.finalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductDao;
import com.dao.StoreDao;
import com.dto.Product;
import com.dto.Store;

@RestController
public class ProductController
	{
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	StoreDao storeDao;
	
/*	@GetMapping("register_item")
	public void register() {
		List<Store> storeList = storeDao.getAllStores();
		Product item1 = new Product("Rice", "Kitchen", 10, 20, 200, "12/2/2021", "12/2/2025", storeList.get(0));
		Product item2 = new Product("Wheat", "Kitchen", 10, 20, 200, "12/2/2021", "12/2/2025", storeList.get(1));
		Product item3 = new Product("Eggs", "Kitchen", 10, 20, 200, "12/2/2021", "12/2/2025", storeList.get(0));
		
		productDao.register(item1);
		productDao.register(item2);
		productDao.register(item3);
	}
*/	
	@PostMapping("/addProduct")
	public void registerProduct(@RequestBody Product product)
	{
		productDao.register(product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	@GetMapping("/getAllproducts/{storeId}")
	public List<Product> getProductsByStore(@PathVariable("storeId") String storeId){
		return productDao.getProductsByStoreId(storeId);
	}
	

	@GetMapping("/getProductByStore/{storeId}")
	public List<Product> getProductByStore(@PathVariable("storeId") String storeId){
		return productDao.getProductsByStoreId(storeId);
	}
	
	
	@GetMapping("/getProductById/{Id}")
	public Product getProductById(@PathVariable("Id") Integer productId)
	{
		return productDao.getProductById(productId);
	}
	
	@PostMapping("updateProduct")
	public void updateProduct(@RequestBody Product product) {
		productDao.updateProduct(product);
	}
}
