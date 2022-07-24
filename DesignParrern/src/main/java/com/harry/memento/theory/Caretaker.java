package com.harry.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    // 在 List 集合中会有很多的备忘录对象
    private java.util.List<Memento> mementoList = new ArrayList<Memento>();
    public void add(Memento memento) {
        mementoList.add(memento);
    }
    //获取到第 index 个 Originator 的 备忘录对象(即保存状态)
    public Memento get(int index) {
        return mementoList.get(index);
    }
}
