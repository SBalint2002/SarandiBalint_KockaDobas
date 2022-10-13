package hu.petrik.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView elsoKocka;
    private ImageView masodikKocka;
    private Button egyKocka;
    private Button kettoKocka;
    private TextView eredmeny;
    private Button dobas;
    private static boolean egykockae = false;
    private int[] kepek = {R.drawable.kocka1,R.drawable.kocka2,R.drawable.kocka3, R.drawable.kocka4, R.drawable.kocka5, R.drawable.kocka6};
    private Button reset;
    private AlertDialog.Builder resetGomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        egyKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.GONE);
                egykockae = true;
            }
        });

        kettoKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.VISIBLE);
                egykockae = false;
            }
        });

        /*reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGomb = new AlertDialog.Builder(MainActivity.this);
                resetGomb.setTitle("Helyes megfejtés!");
                resetGomb.setMessage("Szeretnél még egyet játszani?");
                resetGomb.setCancelable(false);
                resetGomb.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                resetGomb.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                resetGomb.create().show();
            }
        });*/

        dobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int elso = r.nextInt(6);
                elsoKocka.setImageResource(kepek[elso]);
                if (!egykockae){
                    int masodik = r.nextInt(6);
                    masodikKocka.setImageResource(kepek[masodik]);
                    eredmeny.append((elso+1) + " + " + (masodik+1) + "\n");
                    Toast.makeText(MainActivity.this, (elso+1) + " + " + (masodik+1), Toast.LENGTH_SHORT).show();
                }else{
                    eredmeny.append((elso+1) + "\n");
                    Toast.makeText(MainActivity.this, ""+(elso+1), Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void init(){
        elsoKocka = findViewById(R.id.elsoKocka);
        masodikKocka = findViewById(R.id.masodikKocka);
        egyKocka = findViewById(R.id.egyKocka);
        kettoKocka = findViewById(R.id.kettoKocka);
        eredmeny = findViewById(R.id.eredmeny);
        dobas = findViewById(R.id.dobas);
        reset = findViewById(R.id.reset);
    }
}