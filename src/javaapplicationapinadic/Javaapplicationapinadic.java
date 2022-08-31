package javaapplicationapinadic;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;


public class JavaApplicationAPINadic {

    public static void main(String[] args) {
        //http://nadic.ifrn.edu.br/api/dou/2022-02-08/?usuario=dev_nadic
        
        try{
            URL url = new URL("http://nadic.ifrn.edu.br/api/dou/2022-02-08/?usuario=dev_nadic");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            int responseCode = conn.getResponseCode();
            if(responseCode != 200){
                throw new RuntimeException("ocorreu um erro"+responseCode);
            }else{
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                
                while(scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }
                
                scanner.close();  
                
              JSONArray jsonArray = new JSONArray(informationString.toString());
              JSONObject jsonObject = jsonArray.getJSONObject(1);

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
