package com.midia.fbsolucoes.testeleilaorecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.midia.fbsolucoes.testeleilaorecycler.adapter.RecyclerViewAdapter;
import com.midia.fbsolucoes.testeleilaorecycler.model.Postagem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/anderson6947/ac8b47ca9ff5fb86f35a862dd22f55e5/raw/2135cd75bb0e08f31698de2d4fd54993e3328d34/postagem.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Postagem> lstPostagem;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPostagem = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerId);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Postagem postagem = new Postagem();
                        postagem.setNome(jsonObject.getString("nome"));
                        postagem.setPreco(jsonObject.getString("preco"));
                        postagem.setCidade(jsonObject.getString("cidade"));
                        postagem.setData(jsonObject.getString("data"));
                        postagem.setTempo(jsonObject.getString("tempo"));
                        postagem.setImagem_url(jsonObject.getString("imagem_url"));
                        lstPostagem.add(postagem);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(lstPostagem);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Postagem> lstPostagem) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstPostagem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}
