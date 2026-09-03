public class MusicPlayer {
    private int volume = 50;

    public String addVolume() {
        volume += 10;
        return "Music player volume increased to " + volume;
    }
    public String minusVolume() {
        volume -= 10;
        return "Music player volume decreased to " + volume;
    }
}