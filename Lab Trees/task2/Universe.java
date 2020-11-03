import org.junit.Assert;

public class Universe {
    private static Universe Instance;

    public Universe() {
    }

    public static Universe getInstance() {
        return Instance;
    }

}
