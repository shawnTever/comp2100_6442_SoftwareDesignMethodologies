import org.junit.Assert;
import org.junit.Test;

public class test {
    Universe universe = new Universe();
    @Test
    public void test() {
        Assert.assertEquals(Universe.getInstance(), Universe.getInstance());
        Assert.assertSame(Universe.getInstance(), Universe.getInstance());
    }
}
