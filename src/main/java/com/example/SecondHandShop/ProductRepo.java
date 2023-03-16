package com.example.SecondHandShop;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo extends CrudRepository <Product, Long>{



}
