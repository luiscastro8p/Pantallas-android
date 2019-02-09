package com.example.login;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import java.util.ArrayList;

public class salas extends AppCompatActivity {

    FloatingActionButton fab;

    static ArrayList<clase_salas> listaConferencistas = new ArrayList<clase_salas>();

    RecyclerView rv;
    adapter_rv_cardview adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salas);



        listaConferencistas.clear();
        listaConferencistas.add(new clase_salas("PANCHITO"));
        listaConferencistas.add(new clase_salas("jose"));
        listaConferencistas.add(new clase_salas("pedro"));
        listaConferencistas.add(new clase_salas("josechuy"));
        listaConferencistas.add(new clase_salas("niña"));
        listaConferencistas.add(new clase_salas("perro"));
        listaConferencistas.add(new clase_salas("gato"));
        listaConferencistas.add(new clase_salas("ivan"));
        listaConferencistas.add(new clase_salas("extra"));
        rv = findViewById(R.id.rv_salas);

        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_slide_from_bottom);


        rv.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new adapter_rv_cardview(listaConferencistas, getApplicationContext(), rv);
        rv.setAdapter(adapter);

        rv.setLayoutAnimation(layoutAnimationController);
        rv.getAdapter().notifyDataSetChanged();
        rv.scheduleLayoutAnimation();


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Picaste: " + listaConferencistas.get(rv.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        fab =  findViewById(R.id.fab);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.botonflotante);          fab.setAnimation(myanim);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(),  "hola putita", Toast.LENGTH_SHORT).show();

                } catch
                (Exception e) { Toast.makeText(salas.this, "Ocurrió un error intentelo de nuevo", Toast.LENGTH_SHORT).show(); }
            }
        });
    }
}
