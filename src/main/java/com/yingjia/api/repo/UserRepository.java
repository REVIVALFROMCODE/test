package com.yingjia.api.repo;
import com.yingjia.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends  CrudRepository<User,Integer>{

}
