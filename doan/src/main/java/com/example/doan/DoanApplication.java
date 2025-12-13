package com.example.doan;

import com.example.doan.dao.app.AppDAO;
import com.example.doan.models.Category;
import com.example.doan.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoanApplication.class, args);
	}

//	@Bean
//    public CommandLineRunner cammandLineRunner(AppDAO appDAO){
//        return runner->{
//            createCategoryWithProduct(appDAO);
//        };
//    }
//
//    private void createCategoryWithProduct(AppDAO appDAO) {
//        Category tempCategory = new Category("SanPhamMoi","abc.png",1);
//        Product tempProduct = new Product("abc","abc.png",100,"abc","day la cuon sach cua toi",tempCategory,1);
//        tempCategory.add(tempProduct);
//        appDAO.save(tempCategory);
//        System.out.println("Da xong");
//    }
}
