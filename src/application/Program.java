package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerdao.finById(3);
		
		System.out.println(seller);
		
		System.out.println("/n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("/n=== TEST 3: seller findAll =====");
		list = sellerdao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("/n=== TEST 4: seller Insert =====");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("/n=== TEST 5: seller Update =====");
		seller = sellerdao.finById(1);
		seller.setName("Martha Waine");
		sellerdao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("/n=== TEST 6: seller Delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerdao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();
		
		
	}

}
