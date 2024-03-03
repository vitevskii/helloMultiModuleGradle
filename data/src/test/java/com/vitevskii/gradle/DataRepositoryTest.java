package com.vitevskii.gradle;

import org.junit.Test;
import static org.junit.Assert.*;

public class DataRepositoryTest {
    @Test
    public void appHasAGreeting() {
        DataRepository repository = new DataRepository();
        assertNotNull("app should have a greeting", repository.getGreeting("Bill"));
    }
}
