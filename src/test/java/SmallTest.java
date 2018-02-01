import org.graphwalker.java.annotation.Edge;
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;

@Model(file = "src/resources/com.mentProject.gmail/SmallTest.graphml")
public interface SmallTest {

    @Edge()
    void e_SomeAction();

    @Vertex()
    void v_VerifySomeOtherAction();

    @Edge()
    void e_FirstAction();

    @Vertex()
    void v_VerifySomeAction();

    @Edge()
    void e_AnotherAction();

    @Edge()
    void e_SomeOtherAction();
}