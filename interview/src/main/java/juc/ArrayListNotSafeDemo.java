package juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList( new ArrayList<>());

        for (int i = 0; i <300 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
