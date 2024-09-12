package com.example.androidappbuilder;

import static com.example.androidappbuilder.databinding.ActivityMainBinding.inflate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidappbuilder.databinding.ActivityMainBinding;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private static String LOG_TAG = "MainActivity";
    public static final String baseUrl = "http://api.github.com";
    private TextView urltext;
    private String answerHTTP;

    public ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        urltext = (TextView) findViewById(R.id.usertext);
       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
        UserInterface service = retrofit.create(UserInterface.class);

        Button button= (Button)findViewById(R.id.gotoURL);
        EditText owner = (EditText)findViewById(R.id.usertext);
        EditText base = (EditText)findViewById(R.id.userbase);
        EditText body = (EditText)findViewById(R.id.userbody);
        EditText branch = (EditText)findViewById(R.id.userbranch);
        EditText head = (EditText)findViewById(R.id.userhead);
        EditText repo = (EditText)findViewById(R.id.userrepo);
        EditText titles = (EditText)findViewById(R.id.usertitle);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                DataActivity.setOwner(String.valueOf(owner.getText()));
                DataActivity.setBase(String.valueOf(base.getText()));
                DataActivity.setBody(String.valueOf(body.getText()));
                DataActivity.setBranch(String.valueOf(branch.getText()));
                DataActivity.setHead(String.valueOf(head.getText()));
                DataActivity.setRepo(String.valueOf(repo.getText()));
                DataActivity.setTitles(String.valueOf(titles.getText()));
                Intent myIntent = new Intent(MainActivity.this, DataActivity.class);
                startActivity(myIntent);


            }
        });


        }
    }
