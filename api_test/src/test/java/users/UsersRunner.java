package users;

import io.karatelabs.core.Runner;
import io.karatelabs.core.SuiteResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsersRunner {

    @Test
    void testAll() {
        SuiteResult result = Runner.path("classpath:features/users")
                .outputHtmlReport(true)
                .parallel(1);

        assertTrue(result.isPassed());
    }
}