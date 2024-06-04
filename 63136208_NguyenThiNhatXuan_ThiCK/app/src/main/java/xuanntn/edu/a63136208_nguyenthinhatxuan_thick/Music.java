package xuanntn.edu.a63136208_nguyenthinhatxuan_thick;

public class Music {

        int  MusicID;
        String MusicName;
        String Singer;
        // Tạo các getter. setter, contrtructor
        public Music() {

        }
        public Music(int musicID, String musicName, String singer) {
            MusicID = musicID;
            MusicName = musicName;
            Singer = singer;
        }

        public int getMusicID() {
            return MusicID;
        }

    public void setMusicID(int musicID) {
        MusicID = musicID;
    }

        public String getMusicName() {
            return MusicName;
        }

        public void setMusicName(String musicName) {
            MusicName = musicName;
        }

        public String getSinger() {
            return Singer;
        }

        public void setSinger(int singer) {
            Singer = String.valueOf(singer);
        }


}
