package com.example.demoapi.controller;

import com.example.demoapi.services.StoreFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    @Autowired
    StoreFileService storeFileService;

    @PostMapping("/upload")
    @ResponseBody
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
//        name image
        String fileName = "";
//        link url (Nếu thay đổi port thì phải thay đổi cải cái này nữa)
        String fileLink = "http://localhost:8083/link/";
        try{
            if(file.isEmpty()) {
                throw new Exception();
            }
//            get file name
            fileName = storeFileService.store(file);
//            cộng với url
            fileLink += fileName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileLink;
    }
}
