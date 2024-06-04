package xuanntn.edu.thi_nguyenthinhatxuan63136208_dethi1;

public class City {
    private String name;
    private String country;
    private int imageResourceId;

    public City(String name, String country, int imageResourceId) {
        this.name = name;
        this.country = country;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
