package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("** PART 1 Departments **\n");

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("### Test 1 findByID ###");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n### Test 2 findByDepartment ###");
        Department department = new Department(2, null);
        List<Seller> sellersByDepartment = sellerDao.findByDepartment(department);

        for (Seller obj : sellersByDepartment) {
            System.out.println(obj);
        }

        System.out.println("\n### Test 3 findAll ###");
        List<Seller> allSellers= sellerDao.findAll();

        for (Seller obj : allSellers) {
            System.out.println(obj);
        }

        System.out.println("\n### Test 4 insert ###");
        Seller newSeller = new Seller(null, "Iago Teixeira", "iagoseller@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("New seller inserted. Id = " + newSeller.getId());


        System.out.println("\n### Test 5 update ###");
        seller = sellerDao.findById(7);
        seller.setName("Flavia Mendes");
        seller.setEmail("flaviamendes@gmail.com");
        seller.setBirthDate(new Date());
        sellerDao.update(seller);
        System.out.println("User updated.");

        System.out.println("\n### Test 6 delete ###");
        System.out.println("Enter Id for delete test: ");
        int id = Integer.parseInt(sc.next());
        sellerDao.deleteById(id);
        System.out.println("User deleted.");
        sc.close();

        System.out.println("\n==========================================================\n");

        System.out.println("** PART 2 Departments **");

        System.out.println("\n### Test 1 findById ###");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("\n### Test 2 insert ###");
        department = new Department(null, "Cosmetics");
        departmentDao.insert(department);
        System.out.println("New department inserted. Id = " + department.getId());

        System.out.println("\n### Test 3 findAll ###");

        List<Department> departmentList = departmentDao.findAll();

        for(Department dep : departmentList) {
            System.out.println(dep);
        }
    }
}
