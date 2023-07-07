package com.gamedoora.backend.userservices.repository;

import com.gamedoora.backend.userservices.config.PropertiesConfig;
import com.gamedoora.model.dao.Users;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@EnableConfigurationProperties(PropertiesConfig.class)
@TestPropertySource("classpath:test.properties")
class UsersRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UsersRepository usersRepository;


    @Test
    public void sampleTest(){
        Users users = new Users();
        users.setId(1);

        usersRepository.save(users);

        Optional<Users> dummy = usersRepository.findById(1L);

        assertNotNull(dummy);
    }
}