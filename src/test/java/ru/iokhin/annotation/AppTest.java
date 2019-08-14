package ru.iokhin.annotation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.iokhin.annotation.reflection.api.Dog;

public class AppTest {
    @Test
    public void test() {
        Dog dog = Dog.create();
        dog.bark();
        dog.bark();
        dog.run();
        dog.sleep();
    }

    @Test
    public void intern() {
        "asd".intern();
    }
}
