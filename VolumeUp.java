public class VolumeUp implements Command {
    private MusicPlayer musicPlayer;

    public VolumeUp(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String execute() {
        return musicPlayer.addVolume();
    }
}