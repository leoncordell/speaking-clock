
import com.clocks.speakingclock.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class MainAppTest {

    @Test
    public void soTestMainApp(){
        Main main = new Main();

        main.main(new String[2]);
        System.setIn(new ByteArrayInputStream("Q".getBytes()));
    }
}