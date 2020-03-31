//package main.java.Util;
//import com.google.gson.GsonBuilder;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class JsonHandler {
//
//
//    private static JsonHandler instance = new JsonHandler();
//    private final GsonBuilder gsonBuilder = new GsonBuilder();
//
//    private JsonHandler() {
//
//    }
//
//    public Boolean serialize(File dataFile, Object obj) {
//
//        try (PrintWriter printWriter = new PrintWriter(dataFile)) {
//
//            String json = gsonBuilder.create().toJson(obj);
//            printWriter.write(json);
//            printWriter.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//
//
//        return true;
//    }
//
//    public Object deSerialize(File dataFile, Class clazz ) {
//
//        try (Scanner input = new Scanner(dataFile)) {
//
//            String json = input.nextLine();
//            return gsonBuilder.create().fromJson(json, clazz);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static JsonHandler getInstance() {
//        return instance;
//    }
//
//}