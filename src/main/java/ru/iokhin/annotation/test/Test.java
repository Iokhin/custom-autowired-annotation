package ru.iokhin.annotation.test;

import org.springframework.stereotype.Component;
import ru.iokhin.annotation.Inset;

@Component
public class Test {

    Cat cat;

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat() {
        return cat;
    }

    @Inset
    public Test(Cat cat) {
        this.cat = cat;
    }

    public void test() {
        System.out.println(cat);
    }
}
