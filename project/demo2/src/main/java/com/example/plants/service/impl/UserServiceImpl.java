package com.example.plants.service.impl;

import com.example.plants.model.DTO.UserRegisterDTO;
import com.example.plants.model.entity.UserEntity;
import com.example.plants.model.entity.UserRoleEntity;
import com.example.plants.model.entity.enums.UserRoleEnum;
import com.example.plants.repository.UserRepository;
import com.example.plants.repository.UserRoleRepository;
import com.example.plants.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

        private final UserRepository userRepository;
        private final UserRoleRepository userRoleRepository;
        private final PasswordEncoder passwordEncoder;
        private final UserDetailsService plantUserDetailService;
        private final ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder,
                           UserDetailsService plantUserDetailService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.plantUserDetailService = plantUserDetailService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeAdmin() {
        if(userRepository.count() == 0) {
            UserRoleEntity adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.USER);
            UserEntity admin = new UserEntity();

            admin.setUsername("admin")
                    .setFirstName("Lora")
                    .setLastName("Yonova")
                    .setEmail("lor4eto111@gmail.com")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setRoles(Set.of(adminRole,userRole));
            userRepository.save(admin);

            UserEntity user = new UserEntity();
            user.setUsername("user")
                    .setFirstName("Adelina")
                    .setLastName("Boycheva")
                    .setEmail("adelina@gmail.com")
                    .setPassword(passwordEncoder.encode("123456"))
                    .setRoles(Set.of(userRole));
            userRepository.save(user);

        }
    }

    @Override
    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity userEntity = new UserEntity()

                .setUsername(userRegisterDTO.getUsername())
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setEmail(userRegisterDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()))
                        .setRoles(Set.of(userRoleRepository.findByRole(UserRoleEnum.USER)));

        userRepository.save(userEntity);

        UserDetails userDetails = plantUserDetailService.loadUserByUsername(userEntity.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public UserEntity findById(Long id) {

      return userRepository.findById(id).orElseThrow();
    }

    @Override
    public UserEntity findByEmail(String email) {
       return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserEntity findByUsername(String username) {

      return userRepository.findByUsername(username).orElse(null);
    }


}
