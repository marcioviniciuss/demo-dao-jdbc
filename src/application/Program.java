package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department obj = new Department(1,"books");
        System.out.println(obj);

        Seller seller = new Seller(21, "Carlos", "carlos@gmail.com", new Date(), 3000.00,
                obj);
        System.out.println(seller);

        SellerDao sellerDao = DaoFactory.createSellerDao();
    }
}
