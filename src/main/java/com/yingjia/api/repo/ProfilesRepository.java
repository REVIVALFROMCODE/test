package com.yingjia.api.repo;

import com.yingjia.api.entity.Profiles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProfilesRepository extends CrudRepository<Profiles,String> {
}
