package com.example.demoapi.controller;

import com.example.demoapi.model.BaseResponse;
import com.example.demoapi.model.Product;
import com.example.demoapi.model.ProductEditModal;
import com.example.demoapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductAPIController {

    private List<Product> lstProduct = new ArrayList<>();
    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void initData(){
        for(int i = 0 ;i< 10;i++){
            Product p = new Product();
            p.setId("CODE"+i);
            p.setCreateAt(new Date());
            p.setName("Name Product " + i);
            p.setPrice((float)i * 1000);

            lstProduct.add(p);
        }
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public BaseResponse getAllProduct(){
        BaseResponse response = new BaseResponse();
        response.setData(productRepository.findAll());
        response.setCode("00");
        response.setMessage("Lấy danh sách sản phẩm");
        return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponse getListProduct(@RequestParam("page") int page,
                                       @RequestParam("pageSize") int pageSize){
        BaseResponse response = new BaseResponse();
        response.setCode("00");
        response.setMessage("Lấy dữ liệu thành công");
        List<Product> pageProduct = new ArrayList<>();
        int start = page*pageSize; //100
        if(start > lstProduct.size()){
            response.setCode("99");
            response.setMessage("page not exits");
            response.setData(null);
            return response;
        }
        int end = start + pageSize; // 20
        if(end > lstProduct.size()){
            end = lstProduct.size();
        }
        for(int i = start; i < end;i++){
            Product p = lstProduct.get(i);
            pageProduct.add(p);
        }
        //sort
        //List<Product> sortProduct = new ArrayList<>();
        //Collections.sort(pageProduct);
        response.setData(pageProduct);
        return response;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public BaseResponse createProduct(@RequestBody Product product){
        BaseResponse response = new BaseResponse();
        response.setCode("00");
        response.setMessage("Thành công");
        response.setData(product);
        if(product.getName().isEmpty()){
            response.setCode("99");
            response.setMessage("Thiếu tên sản phẩm");
            response.setData(null);
            return response;
        }
        lstProduct.add(product);
        return response;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public BaseResponse update(@PathVariable("id") String id,
                               @RequestBody ProductEditModal product){
        BaseResponse response = new BaseResponse();
        Product exitsProduct = null;
        int index = 0;
        if(id.contains("CODE")){
            id = id.replace("CODE","");
        }
        for(int i=0;i < lstProduct.size();i++){
            if(lstProduct.get(i).getId().equals("CODE"+id)){
                exitsProduct = lstProduct.get(i);
                index=i;
            }
        }
        exitsProduct.setName(product.getName());
        exitsProduct.setPrice(Float.parseFloat(product.getPrice()));
        lstProduct.set(index,exitsProduct);
        response.setData(exitsProduct);
        response.setCode("00");
        response.setMessage("Sửa thành công");
        return response;
    }
    
    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteProduct(@PathVariable("id") String id){
        BaseResponse response = new BaseResponse();
        Product exits = null;
        for(Product p : lstProduct ){
            if(id.contains("CODE")){
                id = id.replace("CODE","");
            }
            if(p.getId().equals("CODE"+id)){
                exits = p;
            }
        }
        if(exits == null){
            response.setCode("99");
            response.setData(null);
            response.setMessage("Mã sản phẩm không tồn tại");
        }else{
            lstProduct.remove(exits);
            response.setCode("00");
            response.setData(null);
            response.setMessage("Đã xóa thành công");
        }
        return response;
    }

    @GetMapping("/detail/{id}")
    public BaseResponse getDetail(@PathVariable("id")String id){
        BaseResponse response = new BaseResponse();
        Product exits = null;
        for(Product p : lstProduct){
            if(p.getId().equals("CODE"+id)){
                exits = p;
            }
        }
        if(exits == null){
            response.setCode("99");
            response.setData(null);
            response.setMessage("Mã sản phẩm không tồn tại");
        }else{
            response.setCode("00");
            response.setData(exits);
            response.setMessage("Thành công");
        }
        return response;
    }
}
