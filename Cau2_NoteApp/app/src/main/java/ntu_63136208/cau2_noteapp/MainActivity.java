package ntu_63136208.cau2_noteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText noteInput;
    Button addButton;
    TextView noteDisplay;
    ArrayList<String> notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteInput = findViewById(R.id.note_input);
        addButton = findViewById(R.id.btnAdd);
        noteDisplay = findViewById(R.id.note_display);
        notes = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = noteInput.getText().toString();
                notes.add(note);
                displayNotes();
                noteInput.setText("");
            }
        });
    }
    private void displayNotes() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String note : notes) {
            stringBuilder.append(note).append("\n").append("-------------------");
        }
        noteDisplay.setText(stringBuilder.toString());
    }
}