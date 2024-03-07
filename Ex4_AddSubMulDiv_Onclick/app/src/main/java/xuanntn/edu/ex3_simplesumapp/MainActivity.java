package xuanntn.edu.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtso1;
    EditText edtso2;
    EditText edtKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

    void TimDieuKhien(){
        edtso1 = findViewById(R.id.edt1);
        edtso2 = findViewById(R.id.edt2);
        edtKQ = findViewById(R.id.edtKQ);
        nutCong = findViewById(R.id.btnC);
        nutTru = findViewById(R.id.btnT);
        nutNhan = findViewById(R.id.btnN);
        nutChia = findViewById(R.id.btnCh);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void XuLyCong(View view){

        String strA = edtso1.getText().toString();
        String strB = edtso2.getText().toString();

        double so1 = Double.parseDouble(strA);
        double so2 = Double.parseDouble(strB);

        double tong = so1 + so2;
        String strTong = String.valueOf(tong);

        edtKQ.setText(strTong);
    }
    public void XuLyTru(View view){

        String strA = edtso1.getText().toString();
        String strB = edtso2.getText().toString();

        double so1 = Double.parseDouble(strA);
        double so2 = Double.parseDouble(strB);

        double hieu = so1 - so2;
        String strHieu = String.valueOf(hieu);

        edtKQ.setText(strHieu);
    }
    public void XuLyNhan(View view){

        String strA = edtso1.getText().toString();
        String strB = edtso2.getText().toString();

        double so1 = Double.parseDouble(strA);
        double so2 = Double.parseDouble(strB);

        double tich = so1 * so2;
        String strTich = String.valueOf(tich);

        edtKQ.setText(strTich);
    }
    public void XuLyChia(View view){

        String strA = edtso1.getText().toString();
        String strB = edtso2.getText().toString();

        double so1 = Double.parseDouble(strA);
        double so2 = Double.parseDouble(strB);

        double thuong = so1 / so2;
        String strThuong = String.valueOf(thuong);

        edtKQ.setText(strThuong);
    }
}