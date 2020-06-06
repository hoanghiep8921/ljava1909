package com.example.demoapi.controller;

import com.example.demoapi.model.BaseResponse;
import com.example.demoapi.model.ProductCart;
import com.example.demoapi.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartServices cartServices;

    //lấy số lượng loại sản phẩm trong giỏ hàng
    //theo id người dùng (user)
    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public BaseResponse getProductsInCart(
            @PathVariable("id") String userId){
        BaseResponse response = new BaseResponse();
        try {
            List<ProductCart> lstProduct =
                    cartServices.getListProductInCart(userId);
            response.setMessage("Lấy danh sách sản phẩm trong giỏ hàng thành công");
            response.setCode("00");
            response.setData(lstProduct);
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //Thêm sản phẩm vào giỏ hàng theo user
    @RequestMapping(value = "/add/{id}/{idProduct}",
            method = RequestMethod.POST)
    public BaseResponse addToCart(@PathVariable("id")String userId,
                                  @PathVariable("idProduct")String idProduct){
        BaseResponse response = new BaseResponse();
        try{
            List<ProductCart> lstProduct =
                    cartServices.addProductToCart(userId,idProduct);
            response.setMessage("Thêm sản phẩm vào giỏ hàng thành công");
            response.setCode("00");
            response.setData(lstProduct);
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }
    //Remove sản phẩm ra giỏ hàng theo user
    @RequestMapping(value = "/delete/{id}/{idProduct}",method = RequestMethod.DELETE)
    public BaseResponse deleteToCart(@PathVariable("id")String userId,
                                  @PathVariable("idProduct")String idProduct){
        BaseResponse response = new BaseResponse();
        try{
            List<ProductCart> lstProduct =
                    cartServices.removeProductToCart(userId,idProduct);
            response.setMessage("Xóa sản phẩm khỏi giỏ hàng thành công");
            response.setCode("00");
            response.setData(lstProduct);
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    //Đặt hàng 
    @RequestMapping(value = "/order/{id}",method = RequestMethod.POST)
    public BaseResponse orderCart(@PathVariable("id")String userId,
                                  @RequestParam("address")String address,
                                  @RequestParam("phone")String phone){
        BaseResponse response = new BaseResponse();
        try{
            cartServices.orderProduct(userId,address,phone);
            response.setMessage("Đăt hóa đơn thành công");
            response.setCode("00");
            response.setData(null);
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
