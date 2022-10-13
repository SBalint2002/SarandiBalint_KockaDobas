package hu.petrik.kockadobas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView elsoKocka;
    private ImageView masodikKocka;
    private Button egyKocka;
    private Button kettoKocka;
    private TextView eredmeny;
    private Button dobas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        egyKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.GONE);
            }
        });

        kettoKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.VISIBLE);
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
    }
}