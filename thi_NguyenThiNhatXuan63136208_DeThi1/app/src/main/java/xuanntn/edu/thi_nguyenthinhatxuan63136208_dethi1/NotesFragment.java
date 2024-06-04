package xuanntn.edu.thi_nguyenthinhatxuan63136208_dethi1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NotesFragment extends Fragment {

    ListView lvNotes;
    ArrayAdapter<String> bo_nguon;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        SQLiteDatabase db = getActivity().openOrCreateDatabase("Notes.db", // tên file = tên DB
                android.content.Context.MODE_PRIVATE,  // giới hạn truy cập
                null          // con trỏ bản ghi
        );
        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS NOTES;";

        String sqlTaoBang = "CREATE TABLE NOTES( Id integer PRIMARY KEY, " +
                "Title text, " +
                "Description text)";
        // thực hiện lệnh sql
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);
        // Thêm một số dòng dữ liệu vào bảng
        String sqlThem1 = "INSERT INTO NOTES VALUES(1, 'Thứ 2', 'Đi học');";
        String sqlThem2 = "INSERT INTO NOTES VALUES(2, 'Thứ 3', 'Đi làm cả ngày');";
        String sqlThem3 = "INSERT INTO NOTES VALUES(3, 'Thứ 4', 'Ôn thi');";
        String sqlThem4 = "INSERT INTO NOTES VALUES(4, 'Thứ 5', 'Thi IoT');";
        String sqlThem5 = "INSERT INTO NOTES VALUES(5, 'Thứ 6', 'Thi Lập trình thiết bị di động');";
        String sqlThem6 = "INSERT INTO NOTES VALUES(6, 'Thứ 7', 'Thi Công nghệ phần mềm');";
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);
        db.execSQL(sqlThem6);

        String sqlSelect = "Select * from NOTES;";
        Cursor cs = db.rawQuery(sqlSelect, null);
        cs.moveToFirst();
        ArrayList<Notes> dsNote = new ArrayList<>();

        while (!cs.isAfterLast()) {

            int idNote = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String chude = cs.getString(1);
            String ghichu = cs.getString(2);
            Notes b = new Notes(idNote, chude, ghichu);
            dsNote.add(b);
            cs.moveToNext();
        }
        cs.close();
        // B4, Hiện lên listview, recylerview,..
        ArrayList<String> dsNotes = new ArrayList<>();
        for (Notes notes : dsNote) {
            dsNotes.add(notes.getTitle());
        }

        lvNotes = view.findViewById(R.id.lvNotes);
        bo_nguon = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dsNotes);
        lvNotes.setAdapter(bo_nguon);

        db.close();

        return view;
    }
}