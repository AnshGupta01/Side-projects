package com.lib.Controller;

import com.lib.Entity.Product;
import com.lib.Helper.ExcelHelper;
import com.lib.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductCtrl {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {

        if(ExcelHelper.checkExcelFormat(file)){

            //true
            this.productService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and saved to database"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return this.productService.getAll();
    }
}
