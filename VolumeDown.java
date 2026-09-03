public class VolumeDown implements Command {
    private MusicPlayer musicPlayer;

    public VolumeDown(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String execute() {
        return musicPlayer.minusVolume();
    }
}