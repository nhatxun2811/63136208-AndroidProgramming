package xuanntn.edu.thi_nguyenthinhatxuan63136208_dethi1;

public class Notes {

        int  Id;
        String Title;
        String Description;
        // Tạo các getter. setter, contrtructor
        public Notes() {

        }
        public Notes(int id, String title, String description) {
            Id = id;
            Title = title;
            Description = description;
        }

        public int getId() {
            return Id;
        }

    public void setId(int id) {
        Id = id;
    }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(int description) {
            Description = String.valueOf(description);
        }


}
