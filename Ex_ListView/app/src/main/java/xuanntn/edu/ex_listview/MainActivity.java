package xuanntn.edu.ex_listview;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText edInput;
    ListView LVName;
    ArrayList<String> listName;

    void getControls(){
        edInput = (EditText)findViewById(R.id.edInputName);
        LVName = (ListView)findViewById(R.id.LVName);
    }
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

        getControls();
        listName = new ArrayList<>();
        listName.add("Thiên");
        listName.add("Thành");
        listName.add("Vũ");
        listName.add("Khoa");
        listName.add("Tài");
        listName.add("Quân");
        // Tạo Adapter và gắn vào nguồn dữ liệu
        ArrayAdapter<String> source = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , listName);
        // Cắm bộ nguồn vào ListView
        LVName.setAdapter(source);

        LVName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edInput.setText(listName.get(position));
            }
        });
    }

    public void ThemPhanTu(View view){
        EditText edtInput = (EditText) findViewById(R.id.edInputName);
        String name = edtInput.getText().toString();
        listName.add(name);
        ArrayAdapter<String> dsTen = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , listName);
        LVName.setAdapter(dsTen);
        dsTen.notifyDataSetChanged();
        edtInput.setText("");
    }
}