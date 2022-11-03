package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.UsuariosAdapter;
import com.example.myapplication.models.Usuario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    public RecyclerView usuariosRecycleView;
    public List<Usuario> usuarios;
    private TextView idDetail;
    private TextView namesDetail;
    private TextView userDetail;
    private TextView rolDetail;
    private TextView creadoDetail;
    private TextView actuaDetail;
    private Button regresarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle infoU = this.getIntent().getExtras();

        this.idDetail = findViewById(R.id.idDetail);
        this.namesDetail = findViewById(R.id.namesDetail);
        this.userDetail = findViewById(R.id.userDetail);
        this.rolDetail = findViewById(R.id.rolDetail);
        this.creadoDetail = findViewById(R.id.creadoDetail);
        this.actuaDetail = findViewById(R.id.actuaDetail);
        this.regresarBtn = findViewById(R.id.regresarDetail);

        this.idDetail.setText(infoU.getString("id"));
        this.namesDetail.setText(infoU.getString("nombre"));
        this.userDetail.setText(infoU.getString("usuario"));
        this.rolDetail.setText(infoU.getString("rol"));
        this.creadoDetail.setText(infoU.getString("creado"));
        this.actuaDetail.setText(infoU.getString("actualizado"));

        this.regresarBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListadoActivity.class);
            startActivity(intent);
            finish();
        });








    }
    public void initData(){
        this.usuariosRecycleView.setHasFixedSize(true);
        this.usuariosRecycleView.setLayoutManager(new LinearLayoutManager(this));
        UsuariosAdapter adapter = new UsuariosAdapter(this.usuarios, this);
        this.usuariosRecycleView.setAdapter(adapter);
    }
}
