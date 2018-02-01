import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_FirstAction")
public class SomeSmallTest extends ExecutionContext implements SmallTest {

    @Override
    public void e_FirstAction() {
        System.out.println("Running: e_FirstAction");
    }

    @Override
    public void e_AnotherAction() {
        System.out.println("Running: e_AnotherAction");
    }

    @Override
    public void e_SomeAction() {
        System.out.println("Running: e_SomeAction");
    }

    @Override
    public void e_SomeOtherAction() {
        System.out.println("Running: e_SomeOtherAction");
    }

    @Override
    public void v_VerifySomeAction() {
        System.out.println("Running: v_VerifySomeAction");
    }

    @Override
    public void v_VerifySomeOtherAction() {
        System.out.println("Running: v_VerifySomeOtherAction");
    }

    public static void main(String[] args) {
        SomeSmallTest someSmallTest = new SomeSmallTest();
        someSmallTest.e_FirstAction();
        someSmallTest.e_AnotherAction();
        someSmallTest.e_SomeAction();
    }
}