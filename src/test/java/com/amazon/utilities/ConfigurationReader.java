package com.amazon.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;//Propeties classı javaya ait, javanın key valuleri tutmasını/okuyabilmesini sağlayan classtır.

    static {   //obje oluşturulmadan önce static bloğu çalışır, initialize olur.
        try {
            // what file to read
            String path = "configuration.properties"; // !!! configuration.properties file ının pathi bu. File değişirse pathinide değiştirmek zorundasın
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path); // javanın file ı okuyabilmesini sağlayan class
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

    //NOT!!! Neden bu class a ihtiyaç duyuyoruz?
    //configuration.properties deki dataların java tarafından okunabilmesi için oluşturulan
    //properties(private static Properties properties;) objesinin içerisine bu datalar yerleştiriliyor ve oradaki get metoduyla da o dataları alabiliyoruz.
    //bu yapı sayesinde datalarda bir değişiklik yapmak istediğimde sadece bir yeri değiştirmem tüm frameworkte etkili oluyor.
    //Bu da benim işimi çok kolaylaştırıyor.

}
