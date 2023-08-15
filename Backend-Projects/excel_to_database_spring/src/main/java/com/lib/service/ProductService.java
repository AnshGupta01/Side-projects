package com.lib.service;

import com.lib.Entity.Product;
import com.lib.Helper.ExcelHelper;
import com.lib.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public void save(MultipartFile file) throws IOException {
        List<Product> products = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
        this.productRepo.saveAll(products);
    }
    public List<Product> getAll(){
        return this.productRepo.findAll();
    }
}
