package blu.macaw.tasatisfeito;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adriano on 09/02/2015.
 */
public class Funcoes {
    //Variáveis
    private static Onibus listaOnibus = new Onibus();
    private static String nToken = "f1cb555c9153b74146a3ca26583211c265c0be2779893e0e1cc9da2287c0a30";
    //Efetua a autenticação no servidor da SPTrans
    public static void autenticarToken(final String ntoken) throws URISyntaxException {
        new Thread() {
            public void run() {
                try {
                    InputStream is = null;
                    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
                    nameValuePair.add(new BasicNameValuePair("token", ntoken));

                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=" + ntoken);
                    httppost.setHeader("Content-Type", "text/plain; charset=utf-8");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    is.close();
                } catch (Exception e) {
                    Log.e("log_tag", "Error na conexão http" + e.toString());
                }
            }

        }.start();
    }

    public static Onibus getOnibus(final String nLinhaOnibus) {
        new Thread() {
            public void run() {
                String is = "";
                try {
                    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
                    nameValuePair.add(new BasicNameValuePair("token", nToken));
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://api.olhovivo.sptrans.com.br/v0/Login/Autenticar?token=" + nToken);
                    httppost.setHeader("Accept", "application/json");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();

                    HttpGet httpget = new HttpGet("http://api.olhovivo.sptrans.com.br/v0/Linha/Buscar?termosBusca=5010");
//                    HttpGet httpget = new HttpGet("http://api.olhovivo.sptrans.com.br/v0/Linha/Buscar?termosBusca=" + nLinhaOnibus);
                    httpget.setHeader("Accept", "application/json");
                    HttpResponse responseG = httpclient.execute(httpget);
                    HttpEntity entityG = responseG.getEntity();
                    is = EntityUtils.toString(entityG);
                } catch (Exception e) {
                    Log.e("log_tag", "Error na conexão http" + e.toString());
                }
                //Lê o resultado do buffer e joga na variável JSON
                try {
                    JSONArray ja = new JSONArray(is);
                    JSONObject jObj = new JSONObject();
                    for (int i = 0; i < ja.length(); i++) {
                        jObj = ja.getJSONObject(i);
                        listaOnibus.setCodigoLinha(jObj.getString("Letreiro"));
                        listaOnibus.setLetreiroIda(jObj.getString("DenominacaoTPTS"));
                        listaOnibus.setLetreiroVolta(jObj.getString("DenominacaoTSTP"));
                        listaOnibus.setPrefixoLinha(jObj.getInt("CodigoLinha"));
                        listaOnibus.setTipo(jObj.getInt("Tipo"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return listaOnibus;
    }
}
