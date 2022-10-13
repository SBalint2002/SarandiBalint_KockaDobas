package hu.petrik.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Kockapoker extends AppCompatActivity{

    private Random r = new Random();
    private int elso, masodik, harmadik, negyedik;
    private ImageButton kocka1, kocka2, kocka3, kocka4;
    private Button vissza, ujradobas, dobas;
    private TextView robotpont, gyoztes, enyempont, kivalasztott;
    private int[] kepek = {R.drawable.kocka1, R.drawable.kocka2, R.drawable.kocka3, R.drawable.kocka4, R.drawable.kocka5, R.drawable.kocka6};
    private boolean iselso = false;
    private boolean ismasodik = false;
    private boolean isharmadik = false;
    private boolean isnegyedik = false;
    private static int randomSzam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kockapoker);
        init();

        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Kockapoker.this,MainActivity.class);
                startActivity(back);
                finish();
            }
        });
        dobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kocka1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                kocka1.setImageResource(kepek[randomIndex()]);
                elso = randomSzam+1;
                kocka1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                kocka2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                kocka2.setImageResource(kepek[randomIndex()]);
                masodik = randomSzam+1;
                kocka2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                kocka3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                kocka3.setImageResource(kepek[randomIndex()]);
                harmadik = randomSzam+1;
                kocka3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));

                kocka4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
                kocka4.setImageResource(kepek[randomIndex()]);
                negyedik = randomSzam+1;
                kocka4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
                kocka1.setEnabled(true);
                kocka2.setEnabled(true);
                kocka3.setEnabled(true);
                kocka4.setEnabled(true);
                ujradobas.setEnabled(true);
            }
        });
        ujradobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iselso){
                    sorselso();
                }
                if(ismasodik){
                    sorsmasodik();
                }
                if(isharmadik){
                    sorsharmadik();
                }
                if(isnegyedik){
                    sorsnegyedik();
                }
                ujradobas.setEnabled(false);
                osszesit();
            }
        });
        kocka1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iselso = true;
                String input = kivalasztott.getText().toString();
                kivalasztott.setText(input + " 1");
                kocka1.setEnabled(false);
            }
        });
        kocka2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ismasodik = true;
                String input = kivalasztott.getText().toString();
                kivalasztott.setText(input + " 2");
                kocka2.setEnabled(false);
            }
        });
        kocka3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isharmadik = true;
                String input = kivalasztott.getText().toString();
                kivalasztott.setText(input + " 3");
                kocka3.setEnabled(false);
            }
        });
        kocka4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isnegyedik = true;
                String input = kivalasztott.getText().toString();
                kivalasztott.setText(input + " 4");
                kocka4.setEnabled(false);
            }
        });
    }

    private void sorselso(){
        //Első kocka
        kocka1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
        kocka1.setImageResource(kepek[randomIndex()]);
        elso = randomSzam+1;
        kocka1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
    }

    private void sorsmasodik(){
        //Második kocka
        kocka2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
        kocka2.setImageResource(kepek[randomIndex()]);
        masodik = randomSzam+1;
        kocka2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
    }

    private void sorsharmadik(){
        //Harmadik kocka
        kocka3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
        kocka3.setImageResource(kepek[randomIndex()]);
        harmadik = randomSzam+1;
        kocka3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
    }

    private void sorsnegyedik(){
        //Negyedik kocka
        kocka4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out_fade_out));
        kocka4.setImageResource(kepek[randomIndex()]);
        negyedik = randomSzam+1;
        kocka4.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in_fade_in));
    }

    private int randomIndex(){
        randomSzam = r.nextInt(6);
        return randomSzam;
    }

    private void osszesit(){
        //Pontok bekérése és összesítése
        int robotpontok = (r.nextInt(5)+1)+(r.nextInt(5)+1)+(r.nextInt(5)+1)+(r.nextInt(5)+1);
        int enyem = elso+masodik+harmadik+negyedik;
        robotpont.setText("Robot: " + robotpontok);
        enyempont.setText("Te pontod: " + enyem);
        //Győztes eldöntése
        if (robotpontok > enyem){
            gyoztes.setText("Győztes: Robot");
        }else if(robotpontok < enyem){
            gyoztes.setText("Győztes: Te");
        }else gyoztes.setText("Győztes: Döntetlen!");
    }

    private void init(){
        kivalasztott = findViewById(R.id.kivalasztott);
        kocka1 = findViewById(R.id.kocka1);
        kocka2 = findViewById(R.id.kocka2);
        kocka3 = findViewById(R.id.kocka3);
        kocka4 = findViewById(R.id.kocka4);
        kocka1.setEnabled(false);
        kocka2.setEnabled(false);
        kocka3.setEnabled(false);
        kocka4.setEnabled(false);
        vissza = findViewById(R.id.vissza);
        robotpont = findViewById(R.id.robotpont);
        enyempont = findViewById(R.id.enyempont);
        gyoztes = findViewById(R.id.gyoztes);
        dobas = findViewById(R.id.dobas);
        ujradobas = findViewById(R.id.ujradobas);
        ujradobas.setEnabled(false);
    }
}
