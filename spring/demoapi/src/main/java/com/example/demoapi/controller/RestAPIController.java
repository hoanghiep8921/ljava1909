package com.example.demoapi.controller;

import com.example.demoapi.model.BaseResponse;
import com.example.demoapi.model.User;
import com.example.demoapi.repository.UserRepository;
import com.example.demoapi.services.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestAPIController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenAuthenticationService tokenAuthenticationService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponse login(@RequestParam("username")String username,
                              @RequestParam("password")String password){
        BaseResponse response = new BaseResponse();
        try{
            if(username.isEmpty() || password.isEmpty()){
                throw new Exception("Data invalid");
            }
            Optional<User> optUser = userRepository.
                    findByUsernameAndPassword(username,password);
            if(!optUser.isPresent()){
                throw new Exception("Username or password incorrect");
            }
            User user = optUser.get();
            String token = tokenAuthenticationService.
                    generateJWT(user.getUsername());
            response.setMessage("Login thành công");
            response.setData(token);
            response.setCode("00");
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping("/getInfo")
    public BaseResponse getInfoUser(@RequestHeader("Authen")String token){
        BaseResponse response = new BaseResponse();
        try{
            if(!validToken(token)){
                throw new Exception("Invalid token");
            }
            response.setCode("00");
            response.setData("Đây là thông tin user");
            response.setMessage("Lấy user info thành công");
        }catch (Exception e){
            response.setCode("99");
            response.setMessage(e.getMessage());
        }

        return response;
    }
    public boolean validToken(String token){
        String username = tokenAuthenticationService.readJWT(token);
        if(username == null || username.isEmpty()){
            return false;
        }
        Optional<User> optUser = userRepository.findByUsername(username);
        if(optUser.isPresent()){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/api/example",method = RequestMethod.GET)
    //@GetMapping("/api/example");
    public int example(){
        return 100;
    }
}
