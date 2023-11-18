package schach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class ControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    @DisplayName("Beim Aufrufen von / wird ein Spielfeld erstellt und Startseite zurückgegeben")
    void test01() throws Exception{
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Startseite"));
    }

    @Test
    @DisplayName("Bei gültiger Eingabe wird eine Spielfigur bewegt und die Startseite erneut angezeigt")
    void test02() throws Exception{
        mvc.perform(post("/").param("eingabe", "8 16"))
                .andExpect(status().isOk())
                .andExpect(view().name("Startseite"));

    }

    @Test
    @DisplayName("Bei ungültiger Eingabe wird Ungültige Eingabe ausgegeben")
    void test03() throws Exception{

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalerOutput = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            mvc.perform(post("/").param("eingabe", "SchachIstEinfach"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("Startseite"));
        } finally {
            System.setOut(originalerOutput);
        }

        assertTrue(outputStream.toString().contains("Ungültige Eingabe"));
    }
}
