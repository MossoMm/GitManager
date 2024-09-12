package com.example.androidappbuilder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataActivity extends AppCompatActivity {
    private static String owner, repo, branch,titles, base, head, body;


    public static String getTitles() {
        return titles;
    }

    public static void setTitles(String title) {
        DataActivity.titles = title;
    }

    public static String getOwner() {
        return owner;
    }

    public static void setOwner(String owner) {
        DataActivity.owner = owner;
    }

    public static String getRepo() {
        return repo;
    }

    public static void setRepo(String repo) {
        DataActivity.repo = repo;
    }

    public static String getBranch() {
        return branch;
    }

    public static void setBranch(String branch) {
        DataActivity.branch = branch;
    }




    public static String getBase() {
        return base;
    }

    public static void setBase(String base) {
        DataActivity.base = base;
    }

    public static String getHead() {
        return head;
    }

    public static void setHead(String head) {
        DataActivity.head = head;
    }

    public static String getBody() {
        return body;
    }

    public static void setBody(String body) {
        DataActivity.body = body;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserInterface service = retrofit.create(UserInterface.class);

        Button button = (Button)findViewById(R.id.button);
        Button backbutton = (Button)findViewById(R.id.button2);
        Button comButton = (Button)findViewById(R.id.button3);
        comButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.requestCommit(owner,repo, branch).enqueue(new Callback<BranchCommit>() {
                    @Override
                    public void onResponse(Call<BranchCommit> call, Response<BranchCommit> response) {
                        textview.setText("Branch name: " + response.body().name + "\n" + "Branch commit url: " + response.body().commit.url + "\n" + "Commit comments: " + response.body().commit.comment_count +
                                "\n" + "Commit message: " + response.body().commit.message);
                    }

                    @Override
                    public void onFailure(Call<BranchCommit> call, Throwable t) {
                        textview.setText(t.getMessage());
                    }

                });
            }
        });
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                service.postPull(new RequestPost(owner,titles, repo,body, base, head) ).enqueue(new Callback<ResponsePost>() {
                    @Override
                    public void onResponse(Call<ResponsePost> call, Response<ResponsePost> response) {
                        textview.setText("A pull was created!");

                    }

                    @Override
                    public void onFailure(Call<ResponsePost> call, Throwable t) {
                        textview.setText("Error! A pull was not created(");
                    }

                });
                textview.setText(owner);
            }
        });
    }
}
