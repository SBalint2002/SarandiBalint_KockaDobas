package hu.petrik.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private int szamlalo = 0;
    private ImageView elsoKocka, masodikKocka;
    private Button egyKocka, kettoKocka, elsoOldalDobas, kockapoker, reset;
    private TextView eredmeny;
    private static boolean egykockae = false;
    private int[] kepek = {R.drawable.kocka1, R.drawable.kocka2, R.drawable.kocka3, R.drawable.kocka4, R.drawable.kocka5, R.drawable.kocka6};
    private AlertDialog.Builder resetGomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        egyKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                masodikKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
                masodikKocka.setVisibility(View.GONE);
                egykockae = true;
            }
        });
        kettoKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (egykockae){
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
                    masodikKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
                    masodikKocka.setVisibility(View.VISIBLE);
                    egykockae = false;
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGomb = new AlertDialog.Builder(MainActivity.this);
                resetGomb.setTitle("Reset");
                resetGomb.setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat");
                resetGomb.setCancelable(false);
                resetGomb.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                resetGomb.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eredmeny.setText("");
                    }
                });
                resetGomb.create().show();
            }
        });
        elsoOldalDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                if (!egykockae) {
                    int elso = r.nextInt(6);
                    int masodik = r.nextInt(6);
                    //Első kocka eltűnés-megváltoztatás-előhozás
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                    elsoKocka.setImageResource(kepek[elso]);
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                    //Második kocka eltűnés-megváltoztatás-előhozás
                    masodikKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                    masodikKocka.setImageResource(kepek[masodik]);
                    masodikKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                    //Eredmény
                    eredmeny.append((elso + 1) + " + " + (masodik + 1) + "\n");
                    Toast.makeText(MainActivity.this, (elso + 1) + " + " + (masodik + 1), Toast.LENGTH_SHORT).show();
                } else {
                    int elso = r.nextInt(6);
                    //Második kocka eltüntetés - Első kocka eltűnés-megváltoztatás-előhozás
                    masodikKocka.setVisibility(View.GONE);
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                    elsoKocka.setImageResource(kepek[elso]);
                    elsoKocka.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                    //Eredmény
                    eredmeny.append((elso + 1) + "\n");
                    Toast.makeText(MainActivity.this, "" + (elso + 1), Toast.LENGTH_SHORT).show();
                }
            }
        });
        kockapoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this, Kockapoker.class);
                startActivity(next);
                finish();
            }
        });
    }

    private void init() {
        elsoKocka = findViewById(R.id.elsoKocka);
        masodikKocka = findViewById(R.id.masodikKocka);
        egyKocka = findViewById(R.id.egyKocka);
        kettoKocka = findViewById(R.id.kettoKocka);
        eredmeny = findViewById(R.id.eredmeny);
        elsoOldalDobas = findViewById(R.id.elsoOldalDobas);
        reset = findViewById(R.id.reset);
        kockapoker = findViewById(R.id.kockapoker);
    }
}