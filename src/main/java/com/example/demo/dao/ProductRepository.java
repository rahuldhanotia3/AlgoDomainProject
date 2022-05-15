package com.example.demo.dao;

import com.example.demo.pojo.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    @Query(value="select * from products where sellerid=?1",nativeQuery = true )
    List<Product> findallproductsbyseller(String sellerid);

    @Query(value="select * from products where sellerid=?1 && productid=?2",nativeQuery = true )
    Product findproductbyproductidselerid(String sellerid, String productid);
    @Modifying
    @Transactional
    @Query(value="delete from products where productid=:productid",nativeQuery = true )
    void deleteByproductId(@Param("productid") String productid);

    @Query(value ="select * from products where productname =?1 or producttype =?1 or productcategory =?1", nativeQuery=true)
    List<Product> findProductByNameOrTypeOrCategory(String value);
}
