package com.example.demoapi.controller;

import com.example.demoapi.model.Actor;
import com.example.demoapi.model.BaseResponse;
import com.example.demoapi.model.Film;
import com.example.demoapi.services.ActorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorAPIController {
    @Autowired
    ActorServices actorServices;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResponse addNewActor(@RequestBody Actor actor){
        BaseResponse response = new BaseResponse();
        response.setData(actorServices.saveActor(actor));
        response.setCode("00");
        response.setMessage("Thêm diễn viên thành công");
        return response;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BaseResponse getAllActor(@RequestParam("page") int page,
                                    @RequestParam("pageSize")int pageSize){
        BaseResponse response = new BaseResponse();
        List<Actor> lstActor = actorServices.getAllActor(page,pageSize);
        response.setData(lstActor);
        response.setCode("00");
        response.setMessage("Lấy danh sách diễn viên thành công");
        return response;
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT)
    public BaseResponse updateActor(@PathVariable("id") String id,
                                    @RequestBody Actor actor){
        BaseResponse response = new BaseResponse();
        try {
            Actor exitsActor = actorServices.findActorById(id);
            exitsActor.setName(actor.getName());
            exitsActor.setAge(actor.getAge());

            response.setCode("00");
            response.setMessage("Update actor success");
            response.setData(actorServices.saveActor(exitsActor));
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public BaseResponse deleteActor(@PathVariable("id")String id){
        BaseResponse response = new BaseResponse();
        try {
            actorServices.deleteActor(id);
            response.setCode("00");
            response.setMessage("Xóa diễn viên thành công");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/addFilm/{id}",method = RequestMethod.POST)
    public BaseResponse addFilmToActor(@PathVariable("id")String id,
                                       @RequestBody Film film){
        BaseResponse response = new BaseResponse();
        try {
            response.setData(actorServices.addFilmToActor(id,film));
            response.setCode("00");
            response.setMessage("Thêm phim cho diễn viên thành công");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/deleteFilm/{id}/{idFilm}",method = RequestMethod.DELETE)
    public BaseResponse deleteFilm(@PathVariable("id") String id,
                                   @PathVariable("idFilm")String filmId){
        BaseResponse response = new BaseResponse();
        try {
            response.setCode("00");
            response.setData(actorServices.deleteFilm(id,filmId));
            response.setMessage("Xóa phim thành công");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode("99");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
