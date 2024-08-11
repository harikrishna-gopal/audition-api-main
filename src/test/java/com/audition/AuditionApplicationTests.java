package com.audition;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

/**
 * @author Hari
 */
@SpringBootTest
@AutoConfigureMockMvc
class AuditionApplicationTests {

    // TODO implement unit test. Note that an applicant should create additional unit tests as required.

    @Autowired

    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetPosts() throws Exception {
        // Arrange
        int userId = 1;

        // Act
        ResultActions result = mockMvc.perform(get("/posts")
                .param("userId", String.valueOf(userId)));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                        "        \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"qui est esse\",\n" +
                        "        \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 3,\n" +
                        "        \"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
                        "        \"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 4,\n" +
                        "        \"title\": \"eum et est occaecati\",\n" +
                        "        \"body\": \"ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 5,\n" +
                        "        \"title\": \"nesciunt quas odio\",\n" +
                        "        \"body\": \"repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 6,\n" +
                        "        \"title\": \"dolorem eum magni eos aperiam quia\",\n" +
                        "        \"body\": \"ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 7,\n" +
                        "        \"title\": \"magnam facilis autem\",\n" +
                        "        \"body\": \"dolore placeat quibusdam ea quo vitae\\nmagni quis enim qui quis quo nemo aut saepe\\nquidem repellat excepturi ut quia\\nsunt ut sequi eos ea sed quas\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 8,\n" +
                        "        \"title\": \"dolorem dolore est ipsam\",\n" +
                        "        \"body\": \"dignissimos aperiam dolorem qui eum\\nfacilis quibusdam animi sint suscipit qui sint possimus cum\\nquaerat magni maiores excepturi\\nipsam ut commodi dolor voluptatum modi aut vitae\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 9,\n" +
                        "        \"title\": \"nesciunt iure omnis dolorem tempora et accusantium\",\n" +
                        "        \"body\": \"consectetur animi nesciunt iure dolore\\nenim quia ad\\nveniam autem ut quam aut nobis\\net est aut quod aut provident voluptas autem voluptas\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"userId\": 1,\n" +
                        "        \"id\": 10,\n" +
                        "        \"title\": \"optio molestias id quia eum\",\n" +
                        "        \"body\": \"quo et expedita modi cum officia vel magni\\ndoloribus qui repudiandae\\nvero nisi sit\\nquos veniam quod sed accusamus veritatis error\"\n" +
                        "    }\n" +
                        "]"))
                .andReturn();
          }

    @Test
    public void testPosts() throws Exception {
        // Arrange
        int id = 1;

        // Act
        ResultActions result = mockMvc.perform(get("/posts/{id}", id));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(content().json("\n" +
                        "{\n" +
                        "  \"userId\": 1,\n" +
                        "  \"id\": 1,\n" +
                        "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                        "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                        "}")).andReturn() ;
    }

    @Test
    public void testGetCommentsForIndividualPost() throws Exception {
        // Arrange
        int postId = 1;

        // Act
        ResultActions result = mockMvc.perform(get("/posts/{postId}/comments", postId));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(content().json("\n" +
                        "[\n" +
                        "  {\n" +
                        "    \"postId\": 1,\n" +
                        "    \"id\": 1,\n" +
                        "    \"name\": \"id labore ex et quam laborum\",\n" +
                        "    \"email\": \"Eliseo@gardner.biz\",\n" +
                        "    \"body\": \"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 1,\n" +
                        "    \"id\": 2,\n" +
                        "    \"name\": \"quo vero reiciendis velit similique earum\",\n" +
                        "    \"email\": \"Jayne_Kuhic@sydney.com\",\n" +
                        "    \"body\": \"est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\nvoluptatem error expedita pariatur\\nnihil sint nostrum voluptatem reiciendis et\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 1,\n" +
                        "    \"id\": 3,\n" +
                        "    \"name\": \"odio adipisci rerum aut animi\",\n" +
                        "    \"email\": \"Nikita@garfield.biz\",\n" +
                        "    \"body\": \"quia molestiae reprehenderit quasi aspernatur\\naut expedita occaecati aliquam eveniet laudantium\\nomnis quibusdam delectus saepe quia accusamus maiores nam est\\ncum et ducimus et vero voluptates excepturi deleniti ratione\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 1,\n" +
                        "    \"id\": 4,\n" +
                        "    \"name\": \"alias odio sit\",\n" +
                        "    \"email\": \"Lew@alysha.tv\",\n" +
                        "    \"body\": \"non et atque\\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\\nquia voluptas consequuntur itaque dolor\\net qui rerum deleniti ut occaecati\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 1,\n" +
                        "    \"id\": 5,\n" +
                        "    \"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                        "    \"email\": \"Hayden@althea.biz\",\n" +
                        "    \"body\": \"harum non quasi et ratione\\ntempore iure ex voluptates in ratione\\nharum architecto fugit inventore cupiditate\\nvoluptates magni quo et\"\n" +
                        "  }\n" +
                        "]")).andReturn() ;
    }



    @Test
    public void testGetCommentsForPost() throws Exception {
        // Arrange
        int postId = 7;

        // Act
        ResultActions result = mockMvc.perform(get("/comments")
                .param("postId", String.valueOf(postId)));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(content().json("\n" +
                        "[\n" +
                        "  {\n" +
                        "    \"postId\": 7,\n" +
                        "    \"id\": 31,\n" +
                        "    \"name\": \"ex velit ut cum eius odio ad placeat\",\n" +
                        "    \"email\": \"Buford@shaylee.biz\",\n" +
                        "    \"body\": \"quia incidunt ut\\naliquid est ut rerum deleniti iure est\\nipsum quia ea sint et\\nvoluptatem quaerat eaque repudiandae eveniet aut\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 7,\n" +
                        "    \"id\": 32,\n" +
                        "    \"name\": \"dolorem architecto ut pariatur quae qui suscipit\",\n" +
                        "    \"email\": \"Maria@laurel.name\",\n" +
                        "    \"body\": \"nihil ea itaque libero illo\\nofficiis quo quo dicta inventore consequatur voluptas voluptatem\\ncorporis sed necessitatibus velit tempore\\nrerum velit et temporibus\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 7,\n" +
                        "    \"id\": 33,\n" +
                        "    \"name\": \"voluptatum totam vel voluptate omnis\",\n" +
                        "    \"email\": \"Jaeden.Towne@arlene.tv\",\n" +
                        "    \"body\": \"fugit harum quae vero\\nlibero unde tempore\\nsoluta eaque culpa sequi quibusdam nulla id\\net et necessitatibus\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 7,\n" +
                        "    \"id\": 34,\n" +
                        "    \"name\": \"omnis nemo sunt ab autem\",\n" +
                        "    \"email\": \"Ethelyn.Schneider@emelia.co.uk\",\n" +
                        "    \"body\": \"omnis temporibus quasi ab omnis\\nfacilis et omnis illum quae quasi aut\\nminus iure ex rem ut reprehenderit\\nin non fugit\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"postId\": 7,\n" +
                        "    \"id\": 35,\n" +
                        "    \"name\": \"repellendus sapiente omnis praesentium aliquam ipsum id molestiae omnis\",\n" +
                        "    \"email\": \"Georgianna@florence.io\",\n" +
                        "    \"body\": \"dolor mollitia quidem facere et\\nvel est ut\\nut repudiandae est quidem dolorem sed atque\\nrem quia aut adipisci sunt\"\n" +
                        "  }\n" +
                        "]")).andReturn() ;
    }




}
