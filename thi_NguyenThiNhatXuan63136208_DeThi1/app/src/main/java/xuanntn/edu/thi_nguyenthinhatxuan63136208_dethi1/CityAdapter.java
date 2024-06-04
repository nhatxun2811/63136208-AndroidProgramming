package xuanntn.edu.thi_nguyenthinhatxuan63136208_dethi1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    private List<City> cities;

    public CityAdapter(List<City> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.famouscity, parent, false);
        return new CityViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cities.get(position);
        holder.cityNameTextView.setText(city.getName());
        holder.countryNameTextView.setText(city.getCountry());
        holder.imageView.setImageResource(city.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {
        public TextView cityNameTextView;
        public TextView countryNameTextView;
        public ImageView imageView;

        public CityViewHolder(View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.cityNameTextView);
            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
