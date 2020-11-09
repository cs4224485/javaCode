package com.harry.dao;


import com.harry.bean.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectIf(Student student);
    List<Student> selectChoose(Student student);
    List<Student> selectForeachArray(int[] ids);
    List<Student> selectForeachList(List<Integer> list);
    List<Student> selectForeachListStudent(List<Student> list);
}
