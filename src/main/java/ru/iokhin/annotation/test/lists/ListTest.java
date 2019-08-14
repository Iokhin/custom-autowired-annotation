package ru.iokhin.annotation.test.lists;

import org.springframework.stereotype.Component;
import ru.iokhin.annotation.Inset;

import java.util.List;

@Component
public class ListTest {

    @Inset
    public List<Integer> integers;

    @Inset
    public List<String> strings;
}
