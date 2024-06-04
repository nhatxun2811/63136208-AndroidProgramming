package xuanntn.edu.thi_nguyenthinhatxuan63136208_dethi1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FamousCityFragment extends Fragment {
    public FamousCityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_famous_city, container, false);

        // Create a list of cities
        List<City> cities = new ArrayList<>();
        cities.add(new City("Paris", "France", R.drawable.paris));
        cities.add(new City("New York", "USA", R.drawable.new_york));
        cities.add(new City("Tokyo", "Japan", R.drawable.tokyo));
        // Thêm các thành phố khác nếu cần

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CityAdapter adapter = new CityAdapter(cities);
        recyclerView.setAdapter(adapter);

        return view;
    }
}