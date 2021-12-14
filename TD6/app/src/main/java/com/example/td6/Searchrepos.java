package com.example.td6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Searchrepos extends AppCompatActivity {
    RecyclerView rvSearchRepos;
    Button search;
    EditText userName;
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_repos);

        rvSearchRepos = findViewById(R.id.rvSearchRepos);
        search = findViewById(R.id.btn_search);
        userName = findViewById(R.id.nom_utilisateur);

        githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);


        search.setOnClickListener(v -> getListRepos());

    }

    public void getListRepos(){
        githubService.searchRepos(userName.getText().toString()).enqueue(new Callback<Repos>() {
            @Override
            public void onResponse(Call<Repos> call, Response<Repos> response) {

                if(response.body()!= null) {
                    Adapter adapter = new Adapter(response.body().getItems());
                    rvSearchRepos.setAdapter(adapter);
                    rvSearchRepos.setLayoutManager(new LinearLayoutManager(Searchrepos.this));
                }else {
                    Toast.makeText(Searchrepos.this,"Aucune repo trouvée", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<Repos> call, Throwable t) {
                Toast.makeText(Searchrepos.this,"Une erreur s'est produite", Toast.LENGTH_LONG).show();
            }
        });
    }



}