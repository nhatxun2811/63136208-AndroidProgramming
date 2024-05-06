package xuanntn.edu.example2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InputData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void EnterData(View view){
        EditText edHT = findViewById(R.id.edt1);
        EditText edNS = findViewById(R.id.edt2);

        String hoten = edHT.getText().toString();
        int namsinh = Integer.parseInt(edNS.getText().toString());

        Intent Result = new Intent();

        Result.putExtra("HT", hoten);
        Result.putExtra("NS", namsinh);

        setResult(RESULT_OK, Result);
        finish();
    }
}