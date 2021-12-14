package com.example.td6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListeRepos extends AppCompatActivity {
    RecyclerView recyclerViewReposList;
    Button btnSearch;
    EditText userName;
    GithubService githubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lister_repos);

        recyclerViewReposList = findViewById(R.id.rvReposList);
        btnSearch = findViewById(R.id.btn_search);
        userName = findViewById(R.id.nom_utilisateur);

        githubService = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);


        btnSearch.setOnClickListener(v -> getListRepos());

    }

    public void getListRepos(){
        githubService.listRepos(userName.getText().toString()).enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                if(response.body()!= null) {
                    Adapter adapter = new Adapter(response.body());
                    recyclerViewReposList.setAdapter(adapter);
                    recyclerViewReposList.setLayoutManager(new LinearLayoutManager(ListeRepos.this));
                }else {
                    Toast.makeText(ListeRepos.this,
                            "Aucun résultat! :(",
                            Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Toast.makeText(ListeRepos.this,
                        "Erreur :(",
                        Toast.LENGTH_LONG).show();
            }
        });
    }



}
