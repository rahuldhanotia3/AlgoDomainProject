package com.example.demo.dao;

import com.example.demo.pojo.Product;
import com.example.demo.pojo.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Integer> {
    @Query(value="select * from seller where sellerid=?1",nativeQuery = true)
    Seller findbysellerid(String sellerid);
}
