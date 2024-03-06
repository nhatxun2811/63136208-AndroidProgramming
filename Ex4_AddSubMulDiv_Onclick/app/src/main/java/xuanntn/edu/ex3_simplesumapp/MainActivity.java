package xuanntn.edu.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    public void XuLyCong(View view){
//        EditText edtsoA = findViewById(R.id.txtA);
//        EditText edtsoB = findViewById(R.id.txtB);
//        EditText edtKQ = findViewById(R.id.txtKQ);
//
//        String strA = edtsoA.getText().toString();
//        String strB = edtsoB.getText().toString();
//
//        double soA = Double.parseDouble(strA);
//        double soB = Double.parseDouble(strB);
//
//        double tong = soA + soB;
//        String strTong = String.valueOf(tong);
//
//        edtKQ.setText(strTong);
//    }
}