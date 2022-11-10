package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.PutActivity;
import com.example.myapplication.R;
import com.example.myapplication.interfaces.ItemDelete;
import com.example.myapplication.models.Usuario;
import com.example.myapplication.services.InfoServices;
import com.example.myapplication.services.dataResponse.InfoResponse;
import com.example.myapplication.services.dataResponse.InfoResponseAll;

import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.ViewHolder > {

    private List<Usuario> usuarios;
    private LayoutInflater layoutInflater;

    private Context context;
    private ItemDelete itemDelete;

    public UsuariosAdapter(List<Usuario> contactos, Context context,ItemDelete itemDelete) {
        this.usuarios = contactos;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.itemDelete = itemDelete;
    }

    @NonNull
    @Override
    public UsuariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.item_usuario_template, null);
        return new UsuariosAdapter.ViewHolder(view,this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosAdapter.ViewHolder viewHolder, int position) {
        Usuario usuario = this.usuarios.get(position);
        viewHolder.bindData(usuario,position);

    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView namesLb;
        private TextView rolLB;
        private ImageButton delBtn;
        private ImageButton modBtn;
        private ImageButton detailBtn;
        private Context context;

        public ViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.context = context;
            this.namesLb = itemView.findViewById(R.id.namesLb);
            this.rolLB = itemView.findViewById(R.id.rolLB);
            this.delBtn = itemView.findViewById(R.id.delBtn);
            this.modBtn = itemView.findViewById(R.id.modBtn);
            this.detailBtn = itemView.findViewById(R.id.detailBtn);

        }

        public void bindData(final Usuario usuario ,int position){
            this.namesLb.setText(usuario.getNames());
            this.rolLB.setText(usuario.getRol());
            this.delBtn.setOnClickListener(view -> {
                Call<InfoResponseAll> respInfo = (new InfoServices().deleteInfoService(String.valueOf(usuario.getId())));
                respInfo.enqueue(new Callback<InfoResponseAll>() {
                    @Override
                    public void onResponse(Call<InfoResponseAll> call, Response<InfoResponseAll> response) {

                        System.out.println("Info"+ "Conexión establecida");
                        System.out.println("Info"+ "Usuario eliminado");
                        itemDelete.deleteItem(position);
                    }

                    @Override
                    public void onFailure(Call<InfoResponseAll> call, Throwable t) {

                        System.out.println("Info" +"Conexión denegada");
                        System.out.println("Info" + t.getCause().getMessage());
                    }
                });
            });
            /*this.modBtn.setId(usuario.getId());*/
            this.modBtn.setOnClickListener(view -> {
                System.out.println(usuario.getId());
                Intent intent = new Intent(this.context, PutActivity.class);
                Bundle infoUs = new Bundle();
                infoUs.putInt("id",usuario.getId());
                infoUs.putString("nombre",usuario.getNames());
                infoUs.putString("usuario",usuario.getUsername());
                infoUs.putString("rol",usuario.getRol());
                infoUs.putString("pass",usuario.getPassword());
                System.out.println(usuario.getPassword());
                infoUs.putString("actualizado",usuario.getUpdated_at());
                intent.putExtras(infoUs);
                this.context.startActivity(intent);
            });
            this.detailBtn.setOnClickListener(view -> {
                System.out.println(usuario.getId());
                Intent intent = new Intent(this.context, DetailActivity.class);
                Bundle infoU = new Bundle();
                infoU.putString("id",String.valueOf(usuario.getId()));
                infoU.putString("nombre",usuario.getNames());
                infoU.putString("usuario",usuario.getUsername());
                infoU.putString("rol",usuario.getRol());
                infoU.putString("creado",usuario.getCreated_at());
                infoU.putString("actualizado",usuario.getUpdated_at());
                intent.putExtras(infoU);
                this.context.startActivity(intent);
            });
        }

    }

}

