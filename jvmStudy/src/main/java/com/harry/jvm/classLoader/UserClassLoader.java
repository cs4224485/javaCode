package com.harry.jvm.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserClassLoader extends ClassLoader{
    private String rootDir;

    public UserClassLoader(ClassLoader parent, String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节码数组

        byte[] classData = new byte[0];
        try {
            classData = getClassDate(name);
            if (classData == null) {
                throw new ClassNotFoundException();
            } else {
                //直接生成class对象
                return defineClass(name, classData, 0, classData.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }
    private byte[] getClassDate(String className) throws IOException {
        // 读取类文件的字节
        String path = classNameToPath(className);
        FileInputStream ins = new FileInputStream(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 读取类文件的字节码
        while ((len = ins.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        return baos.toByteArray();

    }

    /**
     * 类文件的完全路径
     */
    private String classNameToPath(String className) {
        return rootDir + "\\" + className.replace('.', '\\') + ".class";
    }

}
