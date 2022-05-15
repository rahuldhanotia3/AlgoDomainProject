package com.example.demo.service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.SellerRepository;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClass {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;
    public String checkfun(){
        return "Service Called successfully";
    }

    public String addproducts(String sellerid, List<Product> products) {
        String res="";
        try {
            Seller seller=sellerRepository.findbysellerid(sellerid);
            if(seller!=null){
                products.stream().forEach(e->e.setSellerid(sellerid));
            productRepository.saveAll(products);
            res="products added";}
            else {
                res="not have enough privilleges.";
            }
        }
        catch(Exception e){
            res="exception occurred";
        }
        return res;
    }

    public List<Product> findallproductsbyseller(String sellerid) {
        Seller seller=sellerRepository.findbysellerid(sellerid);
        if(seller!=null) {
            return productRepository.findallproductsbyseller(sellerid);
        }
        return null;
    }

    public String deleteproduct(String sellerid, String productid) {

        String res="";
        Product product=productRepository.findproductbyproductidselerid(sellerid,productid);
        if(product!=null)
        {
            productRepository.deleteByproductId(productid);
            res="deleted";
            return res;
        }
        res="data not found";
        return res;
    }

    public List<Product> search(String key) {

        List<Product> res =productRepository.findProductByNameOrTypeOrCategory(key);

        return res;
    }
}
