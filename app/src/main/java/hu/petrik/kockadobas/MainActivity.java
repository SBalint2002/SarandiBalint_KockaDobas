package hu.petrik.kockadobas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView elsoKocka;
    private ImageView masodikKocka;
    private Button egyKocka;
    private Button kettoKocka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        elsoKocka = findViewById(R.id.elsoKocka);
        masodikKocka = findViewById(R.id.masodikKocka);
        egyKocka = findViewById(R.id.egyKocka);
        kettoKocka = findViewById(R.id.kettoKocka);
    }
}