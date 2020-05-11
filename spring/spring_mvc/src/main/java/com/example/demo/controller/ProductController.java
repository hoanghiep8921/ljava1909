package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private List<Product> lstProduct = new ArrayList<>();

    @PostConstruct
    public void initData(){
        for(int i=0; i< 10 ;i++){
            Product product = new Product(""+i,"Name product " +i,"https://aphoto.vn/wp-content/uploads/2018/02/anh-dep-chup-dien-thoai-768x576.jpg",
                    "Hiệp ĐH",2000 + i);
            lstProduct.add(product);
        }
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("products",lstProduct);
        return "product_index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@RequestParam("name") String name,
                         @RequestParam("actor") String actor,
                         @RequestParam("id") int id,
                         Model model){
        if(name.length() > 50 || id < 0){
            model.addAttribute("error","Data invalid");
            return "product_index";
        }
        Product newProduct = new Product(""+id,name,"",actor,2020);
        lstProduct.add(newProduct);
        model.addAttribute("products",lstProduct);
        model.addAttribute("success","Create new film success");
        return "product_index";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String create(@PathVariable("id") int id){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //THực hiện xóa
        //trả về trạng thái thành công hay thất bại cho view
        return "product_index";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(@PathVariable("id") int id,
                         @RequestParam("name")String name,
                         @RequestParam("actor") String actor){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //Thực hiện update lại các trường name, actor
        //Lưu lại vào list product
        //trả về trạng thái thành công hay thất bại cho view
        return "product_index";
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.POST)
    public String getDetail(){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //
        return "product_index";
    }
}
