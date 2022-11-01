package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.UsuariosAdapter;
import com.example.myapplication.models.Usuario;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle infoU = this.getIntent().getExtras();
        this.idDetail.setText(infoU.getInt("id"));
        this.namesDetail.setText(infoU.getString("nombre"));
        this.userDetail.setText(infoU.getString("usuario"));
        this.rolDetail.setText(infoU.getString("rol"));
        this.creadoDetail.setText(infoU.getString("creado"));
        this.actuaDetail.setText(infoU.getString("actualizado"));




    }
    public void initData(){
        this.usuariosRecycleView.setHasFixedSize(true);
        this.usuariosRecycleView.setLayoutManager(new LinearLayoutManager(this));
        UsuariosAdapter adapter = new UsuariosAdapter(this.usuarios, this);
        this.usuariosRecycleView.setAdapter(adapter);
    }
}
