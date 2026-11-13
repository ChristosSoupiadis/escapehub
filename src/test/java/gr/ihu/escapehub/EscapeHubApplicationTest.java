package gr.ihu.escapehub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class EscapeHubApplicationTest {

    @Test
    void contextLoads() {
        // Αποτυγχάνει αν το Spring context δεν μπορεί να ξεκινήσει.
    }
}
