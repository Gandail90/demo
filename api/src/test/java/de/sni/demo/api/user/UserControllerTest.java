package de.sni.demo.api.user;

import de.sni.demo.businesslogic.user.User;
import de.sni.demo.businesslogic.user.UserService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest
{
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private UserDTOConverter converter;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp(final WebApplicationContext webApplicationContext,
                      final RestDocumentationContextProvider restDocumentation)
    {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .apply(documentationConfiguration(restDocumentation))
                .alwaysDo(document("{method-name}",
                                   preprocessRequest(prettyPrint()),
                                   preprocessResponse(prettyPrint())))
                .build();

        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void given_storedUser_when_getById_should_returnStoredUser()
    {

        final User user = mock(TestUser.class);
        when(userService.getById(anyString()))
                .thenReturn(Optional.of(user));

        //@formatter:off
        given()
                    .accept(MediaType.APPLICATION_JSON_VALUE)
                    .auth().none()
                .when()
                    .get("/user/123")
                .then()
                    .status(HttpStatus.OK)
                    .contentType(ContentType.JSON)
                    .body("name", equalTo(null))
                    .log();
        //@formatter:on
    }

    @Test
    void given_storedUser_when_getAll_should_returnStoredUser()
    {
        final User user = new TestUser("123", "Kenma", new ArrayList<>(), new ArrayList<>());
        when(userService.getAll())
                .thenReturn(List.of(user));

        //@formatter:off
        given()
                    .accept(MediaType.ALL)
                    .auth().none()
                .when()
                    .get("/user/all")
                .then()
                    .status(HttpStatus.OK)
                    .contentType(ContentType.JSON)
                    .body("name", contains("Kenma"))
                    .body("id", contains("123"))
                .and()
//                    .apply(document("getAll",
//                                    requestFields(
//                                            fieldWithPath("id").description("Id of User"),
//                                            fieldWithPath("name").description("Name of User"),
//                                            fieldWithPath("themes").description("Themes of User")),
//                                    links(linkWithRel("crud").description("The CRUD resource")),
//                                    responseFields(subsectionWithPath("_links")
//                                                           .description("Links to other resources")),
//                                    responseHeaders(headerWithName("Content-Type")
//                                                            .description("The Content-Type of the payload"))))
                    .log();
        //@formatter:on
    }

//
//    @Test
//    public void crudCreateExample() throws Exception {
//        Map<String, Object> crud = new HashMap<>();
//        crud.put("title", "Sample Model");
//        crud.put("body", "http://www.baeldung.com/");
//
//        this.mockMvc.perform(post("/crud")
//                                     .contentType(MediaTypes.HAL_JSON)
//                                     .body(this.objectMapper.writeValueAsString(crud))
//                                     .
//                .andExpect(status().isCreated())
//                .andDo(document("create-crud-example",
//                                requestFields(fieldWithPath("id").description("The id of the input"),
//                                              fieldWithPath("title").description("The title of the input"),
//                                              fieldWithPath("body").description("The body of the input"),
//                                              ))));
//    }
}