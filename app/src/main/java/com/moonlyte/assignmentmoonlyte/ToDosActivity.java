package com.moonlyte.assignmentmoonlyte;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moonlyte.assignmentmoonlyte.adapter.ToDosAdapter;
import com.moonlyte.assignmentmoonlyte.api.API;
import com.moonlyte.assignmentmoonlyte.model.Todos;
import com.moonlyte.assignmentmoonlyte.network.ApiClient;
import com.moonlyte.assignmentmoonlyte.progressHUD.ProgressHUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToDosActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView todosRV;
    private API api;
    private ToDosAdapter toDosAdapter;
    private ProgressHUD progressHUD;
    private Toolbar toolbar;
    private ImageView backIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_dos);
        Integer userId = getIntent().getIntExtra("UserId", 0);
        this.api = ApiClient.getApiClient().create(API.class);
        initComponents();
        getUserTodos(userId);
    }

    private void initComponents() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        backIV = (ImageView) toolbar.findViewById(R.id.backIV);
        TextView toolbarTitleTv = (TextView) findViewById(R.id.toolbarTitleTv);
        toolbarTitleTv.setText("To-dos");
        backIV.setOnClickListener(this);

        todosRV = findViewById(R.id.todosRV);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        todosRV.setLayoutManager(mLayoutManager);
    }

    private void loadToDos(List<Todos> todosCall) {
        toDosAdapter = new ToDosAdapter(todosCall);
        todosRV.setAdapter(toDosAdapter);
        toDosAdapter.notifyDataSetChanged();
    }

    private void getUserTodos(Integer userId) {
        progressHUD = ProgressHUD.show(ToDosActivity.this, true, false, null);
        Call<List<Todos>> todosCall = this.api.getUserTodos(userId);
        todosCall.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                if (!response.body().isEmpty()) {
                    loadToDos(response.body());
                }
                hideDialog();
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                Toast.makeText(ToDosActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                hideDialog();
            }
        });
    }

    private void hideDialog() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backIV:
                onBackPressed();
                break;
        }
    }

}
