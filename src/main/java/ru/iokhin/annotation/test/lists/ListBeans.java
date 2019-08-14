package ru.iokhin.annotation.test.lists;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListBeans {

    @Bean
    public List<String> getStringList() {
        List<String> strings = new ArrayList<>(3);
        strings.add("asd");
        strings.add("asd");
        strings.add("asd");
        return strings;
    }

    @Bean
    public List<Integer> getIntegerList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        return integers;
    }

}
