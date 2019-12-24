package marcopolo.web;


import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import marcopolo.Spitter;
import marcopolo.data.SpitterRepository;



/**
 * @author luopeng
 * @date 2019/10/1 21:20
 */
public class SpitterCnotrollerTest {

    @Test
    public void shouldShowRegisteration() throws Exception {
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        //构建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spitter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "jack", "bauer","223232@qq.com");
        Spitter saved = new Spitter(24L,"jbauer", "24hours", "jack", "bauer","223232@qq.com");

        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("firstName", "jack")
                .param("lastName", "bauer")
                .param("username", "jbauer")
                .param("password","24hours")
                .param("email", "223232@qq.com"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/jbauer"));
        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);


    }

}
