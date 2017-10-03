import org.testng.annotations.Test;

public class FailedTest {
    @Test
    public void failedTest(){
        throw new NullPointerException();
    }

}
