package com.example.apptiempo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import Modelos_clases.Municipio;

public class Busqueda extends AppCompatActivity {
    private SearchView buscador;
    private RecyclerView recView;
    private Query query;
    private FirebaseFirestore myStore;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);
        buscador = findViewById(R.id.busquedaMunicipio);

        myStore = FirebaseFirestore.getInstance();
        recView = findViewById(R.id.recView_municipios);

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                textSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textSearch(newText);
                return false;
            }
        });

    }

    private void textSearch(String entrada) {
        //Query
        Query query = myStore.collection("municipiosEspaña")
                .orderBy("name").startAt(entrada).endAt(entrada + "~");

        //RecyclerOptions
        FirestoreRecyclerOptions<Municipio> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Municipio>()
                        .setQuery(query, Municipio.class).build();


        recView.setHasFixedSize(true);
        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(adapter);
    }

    private class MunicipioViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre_municipio;
        private TextView codigo_municipio;

        public MunicipioViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre_municipio = itemView.findViewById(R.id.lista_nombre);
            codigo_municipio = itemView.findViewById(R.id.lista_codigo);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}