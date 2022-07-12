package services;

import com.google.gson.Gson;
import java.io.IOException;
import model.TarjetaCredito;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//import org.json.JSONObject;
//import org.json.JSONException;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

public class TarjetaCreditoS {

    public static JSONObject obtenerJSonTarjeta(TarjetaCredito modelo) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"Inputs\": {\r\n    \"input1\": [\r\n      {\r\n        \"PassengerId\":" + modelo.getDEUDA() + ",\r\n"
                + "\"Survived\":" + modelo.getANIOS_EMPLEO() + ",\r\n"
                + "\"Pclass\":" + modelo.getCODIGO_POSTAL() + ",\r\n"
                + "\"Name\": \"Braund, Mr. Owen Harris\",\r\n"
                + "\"Sex\": \"male\",\r\n"
                + "\"Age\":" + modelo.getEDAD() + ",\r\n"
                + "\"SibSp\": 0,\r\n        \"Parch\": 0,\r\n        \"Ticket\": \"\",\r\n        \"Fare\": 0,\r\n        \"Cabin\": \"\",\r\n        \"Embarked\": \"\"\r\n      }\r\n    ]\r\n  },\r\n  \"GlobalParameters\": {}\r\n}\r\n");
        Request request = new Request.Builder()
                .url("https://ussouthcentral.services.azureml.net/workspaces/6b32e2f918884ee1aa9106acf3965558/services/8a9e015a8f5a458f9493d15cb2678888/execute?api-version=2.0&format=swagger")
                .method("POST", body)
                .addHeader("Authorization", "Bearer 41YASIvz9sIdk3y8uZFDU2p/X/9s63SQ3Yirr7CXrAdI6KlVtS0cJOZ9rARiBxJKVoDzebCraMOI5l/PCfkPdA==")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        Gson gson = new Gson();
        // Convierte la cadena body en un objeto jsonObject
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject cadenaJson = jsonObject.getJSONObject("Results").getJSONArray("output1").getJSONObject(0);
        return cadenaJson;
    }

    public static JSONObject obtenerJSonTarjeta3() throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"Inputs\": {\r\n    \"input1\": {\r\n      \"ColumnNames\": [\r\n        \"PassengerId\",\r\n        \"Survived\",\r\n        \"Pclass\",\r\n        \"Name\",\r\n        \"Sex\",\r\n        \"Age\",\r\n        \"SibSp\",\r\n        \"Parch\",\r\n        \"Ticket\",\r\n        \"Fare\",\r\n        \"Cabin\",\r\n        \"Embarked\"\r\n      ],\r\n      \"Values\": [\r\n        [\r\n          \"0\",\r\n          \"0\",\r\n          \"0\",\r\n          \"value\",\r\n          \"value\",\r\n          \"0\",\r\n          \"0\",\r\n          \"0\",\r\n          \"value\",\r\n          \"0\",\r\n          \"value\",\r\n          \"value\"\r\n        ],\r\n        [\r\n          \"0\",\r\n          \"0\",\r\n          \"0\",\r\n          \"value\",\r\n          \"value\",\r\n          \"0\",\r\n          \"0\",\r\n          \"0\",\r\n          \"value\",\r\n          \"0\",\r\n          \"value\",\r\n          \"value\"\r\n        ]\r\n      ]\r\n    }\r\n  },\r\n  \"GlobalParameters\": {}\r\n}\r\n");
        Request request = new Request.Builder()
                .url("https://ussouthcentral.services.azureml.net/workspaces/6b32e2f918884ee1aa9106acf3965558/services/8a9e015a8f5a458f9493d15cb2678888/execute?api-version=2.0&details=true")
                .method("POST", body)
                .addHeader("Authorization", "Bearer 41YASIvz9sIdk3y8uZFDU2p/X/9s63SQ3Yirr7CXrAdI6KlVtS0cJOZ9rARiBxJKVoDzebCraMOI5l/PCfkPdA==")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        Gson gson = new Gson();
        // Convierte la cadena body en un objeto jsonObject
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject cadenaJson = jsonObject.getJSONObject("Results").getJSONArray("output1").getJSONObject(0);
        return cadenaJson;
    }

    public static void main(String[] args) throws IOException {
        try {
//            Titanic titanic = new Titanic();
//            titanic.setID(1);
//            titanic.setSOBREVIVENCIA(0);
//            titanic.setCLASE(3);
//            titanic.setEDAD(22);
//            System.out.println("Lista = " + TarjetaCreditoS.obtenerJSonTarjeta(titanic));
//            JSONObject cadenaJson = TarjetaCreditoS.obtenerJSonTarjeta(titanic);
//            System.out.println("Scored = " + cadenaJson.getInt("Scored Labels"));
//            System.out.println("Scored Probabilities for Class 0 = " + cadenaJson.getDouble("Scored Probabilities for Class \"0\""));
//            System.out.println("Scored Probabilities for Class 1 = " + cadenaJson.getDouble("Scored Probabilities for Class \"1\""));

//            FUNCIONA SIN MODELO
            System.out.println("Lista " + TarjetaCreditoS.obtenerJSonTarjeta3());
            JSONObject cadenaJson = TarjetaCreditoS.obtenerJSonTarjeta3();
            System.out.println("Scored = " + cadenaJson.getInt("Scored Labels"));
            System.out.println("Scored Probabilities for Class 0 = " + cadenaJson.getDouble("Scored Probabilities for Class \"0\""));
            System.out.println("Scored Probabilities for Class 1 = " + cadenaJson.getDouble("Scored Probabilities for Class \"1\""));
        } catch (Exception e) {
            System.out.println("error en Servicio main" + e.getMessage());
            e.printStackTrace();
        }
    }

}
