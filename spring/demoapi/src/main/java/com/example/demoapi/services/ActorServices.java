package com.example.demoapi.services;

import com.example.demoapi.model.Actor;
import com.example.demoapi.model.Film;
import com.example.demoapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServices {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Actor> search(String name){
        Query query = new Query();
//        query.addCriteria(Criteria.where("_id").is("Id"));
        query.addCriteria(Criteria.where("name").is(name));
//{name:"123"} ,{name:"456"}

//        query.addCriteria(Criteria.where("address").regex("Hà Nội"));
        List<Actor> lstActor = mongoTemplate.find(query,Actor.class);
        return lstActor;
    }

    public Actor saveActor(Actor actor){
        Actor newActor = actorRepository.save(actor);
        return newActor;
    }
    public List<Actor> getAllActor(int page,int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        List<Actor> lstActor = actorRepository.findAll(pageable).getContent();
        return lstActor;
    }

    public Actor findActorById(String id) throws Exception {
        Optional<Actor> optActor = actorRepository.findById(id);
//        Actor a = actorRepository.findById(id).get();
//        a.getAddress();
        if(optActor.isPresent()){
            return optActor.get();
        }else{
            throw new Exception("Actor not found");
        }
    }
    public void deleteActor(String id) throws Exception {
        Optional<Actor> optActor = actorRepository.findById(id);
        if(optActor.isPresent()){
            actorRepository.delete(optActor.get());
        }else{
            throw new Exception("Actor not found");
        }
    }

    public Actor addFilmToActor(String id, Film film) throws Exception {
        Optional<Actor> optActor = actorRepository.findById(id);
        if(optActor.isPresent()){
            Actor actor = optActor.get();
            //lấy danh sách phim của diễn viên
            List<Film> filmList = actor.getListFilm();
            //kiểm tra danh sách phim có tồn tại
            if(filmList == null){
                filmList = new ArrayList<>();
            }
            //thêm phim vào danh sách
            filmList.add(film);
            //đặt lại danh sách phim cho diễn viên
            actor.setListFilm(filmList);
            //lưu vào DB
            return actorRepository.save(actor);
        }else{
            throw new Exception("Actor not found");
        }
    }

    public Actor deleteFilm(String id, String filmId) throws Exception {
        Optional<Actor> otpActor = actorRepository.findById(id);
        if(otpActor.isPresent()){
            Actor exitsActor = otpActor.get();
            List<Film> listFilm = exitsActor.getListFilm();
            if(listFilm == null){
                throw new Exception("List film trống");
            }
            Film filmDelete = null;
            for(Film f : listFilm){
                if(f.getId().equals(filmId)){
                    filmDelete = f;
                }
            }
            if(filmDelete != null){
                listFilm.remove(filmDelete);
            }
            exitsActor.setListFilm(listFilm);
            return actorRepository.save(exitsActor);
        }else{
            throw new Exception("Actor không tồn tại");
        }
    }
}
