package com.techhitter.service.user;

import com.techhitter.dtos.UserInfoDto;
import com.techhitter.model.UserInfo;
import com.techhitter.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public String addUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfo.builder()
                .name(userInfoDto.getName())
                .email(userInfoDto.getEmail())
                .password(encoder.encode(userInfoDto.getPassword()))
                .role(userInfoDto.getRole()).build();
        repository.save(userInfo);
        return "User Added Successfully";
    }
}
