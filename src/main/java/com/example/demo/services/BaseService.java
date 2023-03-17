package com.example.demo.services;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.VueUserEntity;
import jdk.tools.jlink.internal.Platform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BaseService {
    @Autowired
    private UserRepository userRepository;

    public BaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //search
    @GetMapping//映射注入方法
    public List<VueUserEntity> getUsername() {
        return userRepository.findAll();
    }

    //add
    public void addNewUser(VueUserEntity vueUserEntity) throws IllegalAccessException {
        //sout
        Optional<VueUserEntity> vueUserEntityOptional = userRepository.findById(vueUserEntity.getId());
        //如果增加的用户数据库中已经存在则报错
        if (vueUserEntityOptional.isPresent()) {
            throw new IllegalAccessException(("用户名已存在"));
        }//otherwise
        userRepository.save(vueUserEntity);
    }
        //delete
        public void deleteUser(Integer id) throws IllegalAccessException {
            Boolean exists = userRepository.existsById(id);
            //假设删除学生id不存在报错
            if(!exists){
                throw new IllegalAccessException(("用户不存在"));
            }//otherwise
            userRepository.deleteById(id);
        }

        //change
        public void UpdateUser(Integer id, String username, String password){
        VueUserEntity vueUserEntity = userRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException(("id已经存在无法修改")));
        if (username!=null&& username.length()>0&&!Objects.equals(vueUserEntity,id)){
            vueUserEntity.setUsername(username);
        }
        Optional<VueUserEntity> vueUserEntityOptional=userRepository.findByUsername(username);


        }
    }




//    public void deleteUser(Integer id) {
//    }

//    public VueUserEntity login(){
//        VueUserEntity vueUserEntity = new VueUserEntity();
//        //删
//        vueUserEntity.setId(1);
//
//        userRepository.delete(vueUserEntity);
//
//        System.out.println(vueUserEntity.getId());
//        return vueUserEntity;

//        //增
//        vueUserEntity.setUsername("00");
//        vueUserEntity.setPassword("123456");
//        vueUserEntity = userRepository.save(vueUserEntity);
//        System.out.println(vueUserEntity.getId());
//        return vueUserEntity;
//        //改
//        vueUserEntity.setId(1);
//        vueUserEntity.setUsername("001");
//        vueUserEntity.setPassword("654321");
//        vueUserEntity = userRepository.save(vueUserEntity);
//        System.out.println(vueUserEntity.getId());
//        return vueUserEntity;
//    }


