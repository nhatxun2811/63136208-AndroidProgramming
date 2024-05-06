package xuanntn.edu.example_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void LoginChange(View v){
        Intent iManHinhLogin = new Intent(this, Login_Activity.class);
        startActivity(iManHinhLogin);
    }

}