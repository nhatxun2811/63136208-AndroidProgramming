package xuanntn.edu.a63136208_nguyenthinhatxuan_thick;

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

public class Test4Fragment extends Fragment {
    ListView lvMusic;
    ArrayAdapter<String> bo_nguon;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test4, container, false);

        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLNhac.db", // tên file = tên DB
                android.content.Context.MODE_PRIVATE,  // giới hạn truy cập
                null          // con trỏ bản ghi
        );
        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Musics;";

        String sqlTaoBang = "CREATE TABLE Musics( MusicID integer PRIMARY KEY, " +
                "MusicName text, " +
                "Singer text)";
        // thực hiện lệnh sql
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);
        // Thêm một số dòng dữ liệu vào bảng
        String sqlThem1 = "INSERT INTO Musics VALUES(1, 'Foreigner ', 'LEDGER');";
        String sqlThem2 = "INSERT INTO Musics VALUES(2, 'The Resistance', 'Skillet');";
        String sqlThem3 = "INSERT INTO Musics VALUES(3, 'POP/STARS', 'K/DA');";
        String sqlThem4 = "INSERT INTO Musics VALUES(4, 'Bring Me To Life', 'Evanescence');";
        String sqlThem5 = "INSERT INTO Musics VALUES(5, 'Wonderful U', 'AGA 江海迦');";
        String sqlThem6 = "INSERT INTO Musics VALUES(6, 'Me and My Broken Heart', 'Rixton');";
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);
        db.execSQL(sqlThem6);

        String sqlSelect = "Select * from Musics;";
        Cursor cs = db.rawQuery(sqlSelect, null);
        cs.moveToFirst();
        ArrayList<Music> dsNhac = new ArrayList<>();

        while (!cs.isAfterLast()) {

            int idNhac = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenNhac = cs.getString(1);
            String casi = cs.getString(2);
            Music b = new Music(idNhac, tenNhac, casi);
            dsNhac.add(b);
            cs.moveToNext();
        }
        cs.close();
        // B4, Hiện lên listview, recylerview,..
        ArrayList<String> dsTenSach = new ArrayList<>();
        for (Music book : dsNhac) {
            dsTenSach.add(book.getMusicName());
        }

        lvMusic = view.findViewById(R.id.lvMusic);
        bo_nguon = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dsTenSach);
        lvMusic.setAdapter(bo_nguon);

        db.close();

        return view;
    }
}