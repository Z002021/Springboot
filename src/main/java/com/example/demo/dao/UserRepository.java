//在该接口中使用JPA进行数据库的增删改查
package com.example.demo.dao;

import com.example.demo.entities.VueUserEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.services.BaseService;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<VueUserEntity,Integer> {
    @Query("select u from VueUserEntity u where u.id=?1")
    Optional<VueUserEntity> findById(Integer id);


}
    //@Query表示CRUD操作的注解，nativeQuery参数表示开启原生SQL语句语法规则
    //Pageable 表示分页对象，指定起始和最终数据
//   @Query(value = "select * from username where id = ?1", nativeQuery = true)
//   List<VueUserEntity> getUsername(Integer id, Pageable pageable);


