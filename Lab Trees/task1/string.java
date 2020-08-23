import org.junit.Assert;
import org.junit.Test;

public class string {
    @Test
    public void Test() {
        String s = "www";
        String s2 = new String("www");
        String s3 = "aaa";

        Assert.assertSame(s, s2);

    }
    @Test
    public void Test1() {
        String s = "www";
        String s2 = new String("www");
        String s3 = "aaa";

        Assert.assertSame(s, s2);



    }
    @Test
    public void Test2() {
        String s = "www";
        String s2 = new String("www");
        String s3 = "aaa";


        Assert.assertEquals(s, s2);


    }
    @Test
    public void Test3() {
        String s = "www";
        String s2 = new String("www");
        String s3 = "aaa";

        Assert.assertFalse(s == s2);

    }
    @Test
    public void Test4() {
        String s = "www";
        String s2 = new String("www");
        String s3 = "aaa";


        Assert.assertNotEquals(s3, s);
        Assert.assertEquals(s, s2);
        Assert.assertFalse(s == s2);

    }
}
