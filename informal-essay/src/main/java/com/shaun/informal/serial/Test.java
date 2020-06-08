package com.shaun.informal.serial;

import java.io.*;

public class Test {

    public static void main(String[] args) {

        File file = new File("D:" + File.separator + "learning_materials" + File.separator + "serial"+ File.separator +"s.txt");
        try(
                OutputStream os = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(os);
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is)){

            oos.writeObject(new SerializableObject("str0", "str1"));
            oos.close();
            SerializableObject so = (SerializableObject)ois.readObject();
            System.out.println("str0 = " + so.getStr0());
            System.out.println("str1 = " + so.getStr1());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
