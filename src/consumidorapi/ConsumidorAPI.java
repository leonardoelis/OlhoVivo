package consumidorapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class ConsumidorAPI {
    private static String URLBase = "http://api.olhovivo.sptrans.com.br/v2.1/";
    private static String token = "e981f7515d268b79b6d1c8caa4c5124039b610c80ec7f4f27ac309cead50cea4";
    
    private static ConsumidorAPI instance;
    
    private CloseableHttpClient clientHTTP;
    
    private ConsumidorAPI(){
        this.clientHTTP = HttpClients.createDefault();
    }
    
    public static ConsumidorAPI getInstance(){
        if (instance == null) {
            instance = new ConsumidorAPI();
        }
        
        return instance;
    }
    
    public void doLogin() {
        try{
            String url = URLBase + "Login/Autenticar?token=" + token;
            HttpPost httpPost = new HttpPost(url);
            
            // Criando um handler ou manipulador de resposta customizado
            // pois queremos recuperar o conteúdo da resposta e não apenas o código http de resposta
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: "+status);
                    }
                }
            };
            String responseBody = this.clientHTTP.execute(httpPost, responseHandler);
            //System.out.println("---------------------------------------");
            //System.out.println(responseBody);
        } catch(IOException ex){
            Logger.getLogger(ConsumidorAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // método para fazer requisições para a API
    // lembrando que primeiro deve ser executado o método doLogin para realizar a autenticação
    // este método recebe parte da URL que será executada, pois a URL Base já é um atributo estático dessa classe
    public String doRequest(String path){
        String responseBody = null;
        try{
            HttpGet httpGet = new HttpGet(ConsumidorAPI.URLBase + path);
            
            // Criando um handler ou manipulador de resposta customizado
            // pois queremos recuperar o conteúdo da resposta e não apenas o código http de resposta
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: "+status);
                    }
                }
            };
            responseBody = this.clientHTTP.execute(httpGet, responseHandler);
            System.out.println("---------------------------------------");
//            System.out.println(responseBody);
        } catch(IOException ex){
            Logger.getLogger(ConsumidorAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return responseBody;
    }
}
