package com.silent.jvm.reflection;

import java.io.*;

public class MyClassloader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyClassloader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    public Class findClass(String name) {

        byte[] b = loadClassData(name);

        return defineClass(name, b, 0, b.length);

    }


    private byte[] loadClassData(String name) {
        name = path + name + ".calss";
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));

            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
                assert out != null;
                out.close();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return out.toByteArray();
    }

}
