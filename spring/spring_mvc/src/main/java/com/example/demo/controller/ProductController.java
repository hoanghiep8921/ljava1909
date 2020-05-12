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
    public String index(Model model,
                        @RequestParam(value = "status"
                                ,required = false) Integer status){
        model.addAttribute("products",lstProduct);
        if(status != null){
            if(status == 0){
                model.addAttribute("success","Đã xóa thành công");
            }
            if(status == 99){
                model.addAttribute("error","Xóa bị lỗi");
            }
            if(status == 98){
                model.addAttribute("error","Sửa bị lỗi");
            }
            if(status == 1){
                model.addAttribute("success","Sửa thành công");
            }
        }

        return "product_index";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String create(@RequestParam("name") String name,
                         @RequestParam("actor") String actor,
                         @RequestParam("id") int id,
                         Model model){

        model.addAttribute("products",lstProduct);
        if(name.length() > 50 || id < 0){
            model.addAttribute("error","Data invalid");
        }else{
            Product newProduct = new Product(""+id,name,"",actor,2020);
            lstProduct.add(newProduct);
            model.addAttribute("success","Create new film success");
        }
        return "product_index";
    }

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id,
                         Model model){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //THực hiện xóa
        //trả về trạng thái thành công hay thất bại cho view
        int index = -1;
        Product product = null;
        for(Product p : lstProduct){
            if(Integer.parseInt(p.getId()) == id){
                index = lstProduct.indexOf(p);
                //product = p;
                break;
            }
        }
        if(index != -1){
            lstProduct.remove(index);
        }
        //lstProduct.remove(product);
        return "redirect:/product/index?status=0";
    }

    @RequestMapping(value = "/update/{id}",
            method = RequestMethod.GET)
    public String update(@PathVariable("id") int id,
                         @RequestParam("name")String name,
                         @RequestParam("actor") String actor){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //Thực hiện update lại các trường name, actor
        //Lưu lại vào list product
        //trả về trạng thái thành công hay thất bại cho view
        int status = 0;
        if(name.length() > 50 || id < 0 ){
            status = 98;
        }else{
            Product exitsProduct = null;
            int index = -1;
            for(Product p : lstProduct){
                if(Integer.parseInt(p.getId()) == id){
                    exitsProduct = p;
                    index = lstProduct.indexOf(exitsProduct);
                    break;
                }
            }
            if(exitsProduct != null){
                exitsProduct.setName(name);
                exitsProduct.setActor(actor);
                lstProduct.set(index,exitsProduct);
                status = 1;
            }else{
                status = 97;
            }
        }
        return "redirect:/product/index?status=" + status;
    }

    @RequestMapping(value = "/product/{id}",method = RequestMethod.POST)
    public String getDetail(Model model){
        //Duyệt danh sách product
        //tìm vị trí sản phẩm
        //
        Product exitsProduct = lstProduct.get(0);
        model.addAttribute("productDetail",exitsProduct);
        return "product_detail";
    }
}
