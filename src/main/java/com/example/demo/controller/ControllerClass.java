package com.example.demo.controller;

import com.example.demo.pojo.Product;
import com.example.demo.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerClass {

    @Autowired
    ServiceClass serviceClass;

    @GetMapping("/hellocheck")
    public String checkcall(){
        String res="";
        res=serviceClass.checkfun();
        return res;
    }

    @PostMapping("/addproducts/{sellerid}")
    public String addproducts(@PathVariable String sellerid, @RequestBody List<Product> products){

            String response=serviceClass.addproducts(sellerid,products);

        return response;
    }

    @GetMapping("/viewbyseller/{sellerid}")
    public List<Product> getProductsForSeller(@PathVariable String sellerid){
        List<Product> list=serviceClass.findallproductsbyseller(sellerid);
        return list;

    }

    @DeleteMapping("/delete")
    public String deleteProduct(@Param("sellerid") String sellerid, @Param("productid") String productid){
        String res=serviceClass.deleteproduct(sellerid,productid);
        return res;
    }

    @GetMapping("/search/{key}")
    public Iterable<Product> getProducts(@PathVariable String key){
        return serviceClass.search(key);
    }
}
