package com.example.EvidencijaPolaznika.repository;

import com.example.EvidencijaPolaznika.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
