package com.otus;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BaseSpringTest {
    @LocalServerPort
    protected int port;

    protected String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
