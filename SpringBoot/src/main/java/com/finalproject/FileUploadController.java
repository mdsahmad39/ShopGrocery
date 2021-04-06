package com.finalproject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

	//@Value("${file.upload-dir}")
	//String FILE_DIRECTORY;
	
	@PostMapping("/uploadStoreImage")
	public void uploadImage(@RequestPart("Image") MultipartFile file) throws IOException {
		System.out.println("Upload called...");
		Path root = Paths.get("src/main/resources/uploads/storeImages");

		//Path root = Paths.get("C:/Angular/ShopGrocery/src/assets/images/storeImages/");
		//Files.createDirectory(root);
	      //System.out.println(root+" : "+file.getOriginalFilename());
	    Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
	    
		    
	}
	
	 @RequestMapping(value = "/storeImage/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	 public void getStoreImage(HttpServletResponse response,@PathVariable("imageName") String imageName) throws IOException {

	        ClassPathResource imgFile = new ClassPathResource("uploads/storeImages/"+imageName);
	        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	    }

	
	@PostMapping("/uploadProductImage")
	public void uploadProductImage(@RequestPart("Image") MultipartFile file) throws IOException {
		System.out.println("Upload called...");
		Path root = Paths.get("src/main/resources/uploads/productImages");

		//Path root = Paths.get("C:/Angular/ShopGrocery/src/assets/images/productImages/");
		//Files.createDirectory(root);
	      //System.out.println(root+" : "+file.getOriginalFilename());
	    Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
	    
	}
	
	 @RequestMapping(value = "/productImage/{imageName}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	 public void getProductImage(HttpServletResponse response,@PathVariable("imageName") String imageName) throws IOException {
		 System.out.println("entered into request mapping");
	        ClassPathResource imgFile = new ClassPathResource("uploads/productImages/"+imageName);
	        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	    }


	
	
	
	/*public ResponseEntity<String> fileUpload(@RequestParam("File") MultipartFile file, @RequestParam("newFileName") String newName) throws IOException{
		File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
		System.out.println(newName);
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		if(myFile!=null && myFile.exists() && myFile.renameTo(new File(FILE_DIRECTORY+newName)))
		{
			System.out.println("renamed successfully");
			return new ResponseEntity<String>("The File Uploaded Successfully", HttpStatus.OK);
		}
		else
		{
			System.out.println("failed");
			 return new ResponseEntity<String>("Invalid Excel file", HttpStatus.BAD_REQUEST);
		}
		
	}*/
}