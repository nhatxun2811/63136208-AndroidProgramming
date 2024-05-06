package xuanntn.edu.example2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OpenData(View view){
        Intent input = new Intent(this, InputData.class);
        startActivityForResult(input, 8000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 8000)
            if(resultCode == RESULT_OK){
                String hotenNhanDuoc = data.getStringExtra("HT");
                int namsinhNhanDuoc = data.getIntExtra("NS", 2020);
                TextView tvHT = findViewById(R.id.txt1);
                TextView tvNS = findViewById(R.id.txt2);
                tvHT.setText(hotenNhanDuoc);
                tvNS.setText(namsinhNhanDuoc);
            }
        else
                Toast.makeText(this, "Trả về thất bại!", Toast.LENGTH_LONG);
        else
            super.onActivityResult(requestCode, resultCode, data);
    }
}