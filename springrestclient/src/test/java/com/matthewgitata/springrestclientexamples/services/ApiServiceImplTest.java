package com.matthewgitata.springrestclientexamples.services;

import com.matthewgitata.api.domain.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiServiceImplTest {

    @Autowired
    ApiService apiService;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.Test
    void testGetUsers() throws Exception {
        List<User> users = apiService.getUsers(3);

        assertEquals(4, users.size());
    }
}