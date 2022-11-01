package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Usuario;

import java.util.List;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ViewHolder> {

    private List<Usuario> usuarios;
    private LayoutInflater layoutInflater;

    public ContactosAdapter(List<Usuario> contactos, Context context) {
        this.usuarios = contactos;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ContactosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = this.layoutInflater.inflate(R.layout.item_usuario_template, null);
        return new ContactosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosAdapter.ViewHolder viewHolder, int position) {
        Usuario usuario = this.usuarios.get(position);
        viewHolder.bindData(usuario);

    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView namesLb;
        private TextView rolLB;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.namesLb = itemView.findViewById(R.id.namesLb);
            this.rolLB = itemView.findViewById(R.id.rolLB);

        }

        public void bindData(final Usuario usuario){
            this.namesLb.setText(usuario.getNames());
            this.rolLB.setText(usuario.getRol());

        }

    }

}

