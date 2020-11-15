package com.mauroPignatta.config;

import sun.security.krb5.Config;

import java.io.*;
import java.util.Properties;

public class Configuration {

    public static int SIZE = 400;
    public static int WIDTH = SIZE;
    public static int HEIGHT = SIZE;
    public static int UPS = 1000;
    public static int RES_WIDTH = 800;
    public static int RES_HEIGHT = 600;

    private static Properties props;

    public static void init(){
        props = new Properties();
        File configFile = new File("config.ini");
        if(configFile.exists()){
            loadConfig(configFile);
        } else {
            create(configFile);
        }
    }

    private static void create(File config) {
        try{
            config.createNewFile();
            props.setProperty("Array_Size","" + SIZE);
            props.setProperty("Iterations_Per_Second","" + UPS);
            props.setProperty("Resolution_Width","" + RES_WIDTH);
            props.setProperty("Resolution_Height","" + RES_HEIGHT);
            props.store(new FileOutputStream(config), null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadConfig(File config) {
        try{
            props.load(new FileInputStream(config));

            String size = props.getProperty("Array_Size");
            String ups = props.getProperty("Iterations_Per_Second");
            String res_width = props.getProperty("Resolution_Width");
            String res_height = props.getProperty("Resolution_Height");

            SIZE = toInt(size, SIZE);
            WIDTH = toInt(size, SIZE);
            HEIGHT = toInt(size, SIZE);
            UPS = toInt(ups, UPS);
            RES_WIDTH = toInt(res_width, RES_WIDTH);
            RES_HEIGHT = toInt(res_height, RES_HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int toInt(String value, int defaultValue){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

}
