package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper;

    static {
        mapper=new ObjectMapper();
    }

    //1. Method: Json Datasini Java Objesine cevirir.(De-Serialization)

    public static <T> T convertJsonToJavaObject(String json, Class<T> cls ){ //Generic Method
        T javaResult=null;
        try {
            mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;


    }



    //2. Method: Java Objesini Json Dataya cevirir.(Serialization)
}
