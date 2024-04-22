package com.basic.apirest.apirest.Repositories.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.apirest.apirest.Entities.Product;

// PRIMER PARAMETRO ES EL TIPO DE ENTIDAD Y EL SEGUNDO EL TIPO DE DATO DE LA LLAVE PRIMARIA 

public interface IProductRepository extends JpaRepository<Product, Long>{

}
