/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpay.test.ottlicense;

import com.google.gson.Gson;
import java.util.Base64;
import java.util.UUID;

/**
 *
 * @author quangtt
 */
public class LicenseGenerator {
    public static void generateLicense() throws Exception{
        String keyLicense = "01fghbad5f795da6"; // use default key license from DB or generate license
        System.out.println("keyLicense: " + keyLicense);
        LicenseEntity entity = new LicenseEntity();
        entity.setBankCode("970436"); //id bang partner
        entity.setAesKey("B@nk@!#@!VCB&^%!"); //keys
        entity.setMacKey("B@nkGr%^&VCB)**)()^!(*%@(!@MAC!!!");//keys
        entity.setKeyId("56dcbcad5f795da69e7b918b3bb7d415");//keys
        entity.setUrlRoot("https://demomb.vnpay.vn:20157"); //service
        entity.setBankName("VCB"); //partner
        entity.setPinning1("sha256/u68khmo+xM48N0peRm5dmH8mHeqns8Nxi1DQJPgS2Uw="); //service
        entity.setPinning2("sha256/IQBnNBEiFuhj+8x6X8XLgh01V9Ic5/V3IRQLNFFc7v4="); //service
        entity.setPinning3("sha256/K87oWBWM9UZfyddvDfoxL+8lpNyoUB2ptGtn0fv6G2Q="); //service
        entity.setHostName("demomb.vnpay.vn"); //service
        entity.setBankToken("56dcbcad5f795da69e7b918b3bb7d415"); //partner

        entity.setUserName("service_user"); //service
        entity.setPassword("56dcbcad5f795da69e7b918b3bb7d415");//service 
        byte[] iv = AESService.generateIV();
        Gson gson = new Gson();
        String clearLicense = gson.toJson(entity);
        byte[] licenseBytes = AESService.encrypt(keyLicense, clearLicense, iv);

        byte[] allEncrypt = new byte[iv.length + licenseBytes.length];
        System.arraycopy(iv, 0, allEncrypt, 0, iv.length);
        System.arraycopy(licenseBytes, 0, allEncrypt, iv.length, licenseBytes.length);
        String license = Base64.getEncoder().encodeToString(allEncrypt);
        System.out.println("Clear key: " + clearLicense);

        System.out.println("LICENSE Agribank baoviet test: " + license);
    }
    
    // mac key, license_bank_token
    private static String generateKey(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    //key license (AES key)
    private static String generateAESKey(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }
    
    public static void main(String agrs[]) throws Exception{
        generateLicense();
        //System.out.println(generateAESKey());
    }
}
