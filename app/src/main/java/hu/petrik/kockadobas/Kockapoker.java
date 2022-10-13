package hu.petrik.kockadobas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Kockapoker extends AppCompatActivity {

    private Button vissza;

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
    }

    private void init(){
        vissza = findViewById(R.id.vissza);
    }
}
