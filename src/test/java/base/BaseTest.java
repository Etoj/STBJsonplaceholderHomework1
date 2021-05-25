package base;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static String BASE_URL = "https://jsonplaceholder.typicode.com";
    protected static String ALBUMS ="albums";
    protected static String USERS ="users";

    protected static Faker faker;

    public static int fakeUserId;
    public static String fakeTitle;
    public static int fakeId;

    @BeforeAll
    public static void beforeAll() {
        faker = new Faker();
    }
}
