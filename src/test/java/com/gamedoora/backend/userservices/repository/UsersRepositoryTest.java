package com.gamedoora.backend.userservices.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration
@ExtendWith(SpringExtension.class)
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    void injectedComponentsAreNotNull(){
        assertThat(usersRepository).isNotNull();
    }

}