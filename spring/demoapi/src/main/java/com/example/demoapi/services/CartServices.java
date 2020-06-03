package com.example.demoapi.services;

import com.example.demoapi.model.Order;
import com.example.demoapi.model.ProductCart;
import com.example.demoapi.model.ProductModal;
import com.example.demoapi.model.User;
import com.example.demoapi.repository.OrderRepository;
import com.example.demoapi.repository.ProductRepository;
import com.example.demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    public List<ProductCart> getListProductInCart(String userId)
            throws Exception {
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()){
            throw new Exception("User not exits");
        }
        User exitsUser = optUser.get();
        List<ProductCart> lstProduct = exitsUser.getCart();
        return lstProduct;
    }

    public List<ProductCart> addProductToCart(String userId,
                                              String productId) throws Exception {
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()){
            throw new Exception("User not exits");
        }
        User exitsUser = optUser.get();
        List<ProductCart> lstProduct = exitsUser.getCart();

        Optional<ProductModal> optProduct =
                productRepository.findById(productId);
        if(!optProduct.isPresent()){
            throw new Exception("Product not found");
        }
        //ProductModal là đối tượng product trong DB
        ProductModal productModal = optProduct.get();

        //cờ để cehck sản phẩm trong giỏ hàng
        boolean isExitsInCart = false;

        //duyệt danh sách sản phẩm trong giỏ hàng
        for(int i = 0;i < lstProduct.size();i++){
            //productCart là đói tượng product trong giỏ hàng
            ProductCart productCart = lstProduct.get(i);
            //check sản phẩm muốn thêm có trong giỏ hàng chưa ?
            if(productCart.getIdProduct().equals(productModal.getId())){
                //nếu có tăng thêm 1
                productCart.setNumbers(productCart.getNumbers() + 1);
                lstProduct.set(i,productCart);
                isExitsInCart = true;
            }
        }

        if(!isExitsInCart){
            //Nếu sản phẩm mới không có trong giỏ hàng
            //thực hiện thêm mới product
            ProductCart newProductCart = new ProductCart();
            newProductCart.setNumbers(1);
            newProductCart.setIdProduct(productId);
            newProductCart.setImageProduct(productModal.getImage());
            newProductCart.setPrice(
                    Double.parseDouble(productModal.getPrice()));
            newProductCart.setNameProduct(productModal.getName());
            lstProduct.add(newProductCart);
        }
        //lưu lại giỏ hàng vào user
        exitsUser.setCart(lstProduct);
        //lưu lại user vào DB
        userRepository.save(exitsUser);
        return lstProduct;
    }

    public List<ProductCart> removeProductToCart(String userId,
                                              String productId) throws Exception {
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()){
            throw new Exception("User not exits");
        }
        User exitsUser = optUser.get();
        List<ProductCart> lstProduct = exitsUser.getCart();

        Optional<ProductModal> optProduct =
                productRepository.findById(productId);
        if(!optProduct.isPresent()){
            throw new Exception("Product not found");
        }
        //ProductModal là đối tượng product trong DB
        ProductModal productModal = optProduct.get();

        //cờ để check sản phẩm trong giỏ hàng
        boolean isExitsInCart = false;

        //duyệt danh sách sản phẩm trong giỏ hàng
        for(int i = 0;i < lstProduct.size();i++){
            //productCart là đói tượng product trong giỏ hàng
            ProductCart productCart = lstProduct.get(i);
            //check sản phẩm muốn thêm có trong giỏ hàng chưa ?
            if(productCart.getIdProduct().equals(productModal.getId())){
                //nếu có giảm số lượng
                if(productCart.getNumbers() - 1 <= 0){
                    lstProduct.remove(i);
                }else{
                    productCart.setNumbers(productCart.getNumbers() - 1);
                    lstProduct.set(i,productCart);
                }
                isExitsInCart = true;
            }
        }

        if(!isExitsInCart){
            //Nếu sản phẩm mới không có trong giỏ hàng
            //trả ra lỗi
            throw new Exception("Sản phẩm không có trong giỏ hàng");
        }
        //lưu lại giỏ hàng vào user
        exitsUser.setCart(lstProduct);
        //lưu lại user vào DB
        userRepository.save(exitsUser);
        return lstProduct;
    }

    //thanh toán
    public void orderProduct(String userId,
                             String address,
                             String phone) throws Exception {
        //lấy thông tin dùng
        Optional<User> optUser = userRepository.findById(userId);
        if(!optUser.isPresent()){
            throw new Exception("User not exits");
        }
        User exitsUser = optUser.get();
        //lấy danh sách sản phẩm trong giỏ hàng của user
        List<ProductCart> lstProduct = exitsUser.getCart();
        if(lstProduct == null){
            lstProduct = new ArrayList<>();
        }
        //Tạo hóa đơn
        Order order = new Order();
        order.setBuyerId(userId);
        order.setBuyerName(exitsUser.getUsername());
        //order.setAddress(exitsUser.getAddress);
        order.setAddress(address);
        order.setPhone(phone);
        order.setStatus(1);
        order.setCreatedAt(new Date());
        order.setCart(lstProduct);
        orderRepository.save(order);

        exitsUser.setCart(new ArrayList<>());
        userRepository.save(exitsUser);
    }
}
