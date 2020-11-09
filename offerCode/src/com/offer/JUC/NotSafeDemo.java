package com.offer.JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 题目:请举例说明集合类是不安全的
 *
 * 1 故障现象 java.util.ConcurrentModificationException
 * 2 导致原因
 *    多个线程同时读，同时写
 * 3 解决方案
 *  3.1 Vector 方法
 *  3.2 Collections.synchronizedList
 *  3.3 CopyOnWriteArrayList<>()
 *   写时复制：CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy
 *             复制出一个新的容器Object[] newElements, 然后新的容器object[] newElements里添加元素，添加完元素之后，
 *             再将原容器的引用指向新的容器setArray(newElements); 这样做的好处是可以对CopyOnWrite容器进行并发的读，
 *             而不需要加锁，因为当前容器不会添加任何元素。 所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器
 *   public boolean add(E e) {
 *         synchronized (lock) {
 *             Object[] es = getArray();
 *             int len = es.length;
 *             es = Arrays.copyOf(es, len + 1);
 *             es[len] = e;
 *             setArray(es);
 *             return true;
 *         }
 *     }
 *
 * 4 优化建议(同样的错误，不出现第2次)
 */
public class NotSafeDemo {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();// Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <=30 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
