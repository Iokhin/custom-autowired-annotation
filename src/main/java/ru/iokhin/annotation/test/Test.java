package ru.iokhin.annotation.test;

import org.springframework.stereotype.Component;
import ru.iokhin.annotation.Inset;
import ru.iokhin.annotation.test.Cat;

@Component
public class Test {

    Cat cat;

    @Inset
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void test() {
        System.out.println(cat);
    }
}
