package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	// Constructing a URI
    @Test
    public void constructURI() {
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("www.jobyme88.com")
                .path("/junit-5")
                .build();

        assertEquals("http://www.jobyme88.com/junit-5", uriComponents.toUriString());
    }


    // Constructing an Encoded URI
    @Test
    public void constructURIEncoded() {
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("www.jobyme88.com")
                .path("/junit 5")
                .build()
                .encode();

        assertEquals("http://www.jobyme88.com/junit%205", uriComponents.toUriString());
    }


    // Constructing a URI from a Template
    @Test
    public void constructURIFromTemplate() {
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("www.jobyme88.com")
                .path("/{article-name}")
                .buildAndExpand("junit-5"); // fill the path template

        assertEquals("http://www.jobyme88.com/junit-5", uriComponents.toUriString());
    }

    // Constructing a URI With Query Parameters
    @Test
    public void constructUriWithQueryParameter() {
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("www.google.com")
                .path("/")
                .query("q={keyword}")
                .buildAndExpand("jobyme88.com");

        assertEquals("http://www.google.com/?q=jobyme88.com", uriComponents.toUriString());
    }


    // Expanding a URI With Regular Expressions
    @Test
    public void expandWithRegexVar() {
        String template = "/myurl/{name:[a-z]{1,5}}/show";
        UriComponents uriComponents = UriComponentsBuilder
                .fromUriString(template)
                .build();
        uriComponents = uriComponents.expand(Collections.singletonMap("name", "test"));

        assertEquals("/myurl/test/show", uriComponents.getPath());
    }

}
