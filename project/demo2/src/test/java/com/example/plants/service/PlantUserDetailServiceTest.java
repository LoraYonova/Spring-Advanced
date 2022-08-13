package com.example.plants.service;

import com.example.plants.model.entity.UserEntity;
import com.example.plants.model.entity.UserRoleEntity;
import com.example.plants.model.entity.enums.UserRoleEnum;
import com.example.plants.model.user.PlantUserDetail;
import com.example.plants.repository.UserRepository;
import com.example.plants.service.impl.PlantUserDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlantUserDetailServiceTest {

    @Mock
    private UserRepository mockUserRepo;

    private PlantUserDetailService toTest;

    @BeforeEach
    void setUp() {
        toTest = new PlantUserDetailService(
                mockUserRepo
        );
    }

    @Test
    void testLoadUserByUsername_UserExists() {

        UserEntity testUserEntity =
                new UserEntity().
                        setUsername("lora")
                        .setEmail("lora@example.com")
                        .setPassword("123456")
                        .setFirstName("Lora")
                        .setLastName("Yonova")
                        .setRoles(
                                Set.of(
                                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN),
                                        new UserRoleEntity().setRole(UserRoleEnum.USER)
                                )
                        );

        when(mockUserRepo.findByUsername(testUserEntity.getUsername())).
                thenReturn(Optional.of(testUserEntity));

        PlantUserDetail userDetails = (PlantUserDetail)
                toTest.loadUserByUsername(testUserEntity.getUsername());

        Assertions.assertEquals(testUserEntity.getEmail(), userDetails.getEmail());
        Assertions.assertEquals(testUserEntity.getFirstName(), userDetails.getFirstName());
        Assertions.assertEquals(testUserEntity.getLastName(), userDetails.getLastName());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());


        var authorities = userDetails.getAuthorities();

        Assertions.assertEquals(2, authorities.size());

        var authoritiesIter = authorities.iterator();

//        Assertions.assertEquals("ROLE_" + UserRoleEnum.ADMIN.name(),
//                authoritiesIter.next().getAuthority());
        Assertions.assertEquals("ROLE_" + UserRoleEnum.USER.name(),
                authoritiesIter.next().getAuthority());
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {

        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("non-lora")
        );
    }

}
