package xuanntn.edu.example_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {

    // Khai báo tên đăng nhập và mật khẩu đúng
    private static final String CORRECT_USERNAME = "NhatXuan";
    private static final String CORRECT_PASSWORD = "2811";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void ConfirmLogin(View v){
        EditText edtUsername = findViewById(R.id.editTextUsername);
        EditText edtPassword = findViewById(R.id.editTextPassword);

        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            Intent iXacNhan = new Intent(this, Home_Activity.class);
            startActivity(iXacNhan);
        } else {
            Toast.makeText(this, "Tên đăng nhập hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
        }
    }
}
