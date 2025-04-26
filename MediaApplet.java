import java.applet.Applet;
import java.awt.*;
import java.net.URL;

/*
<applet code="MediaApplet" width="400" height="300">
<param name="imageURL" value="your_image.jpg">
<param name="audioURL" value="your_audio.wav">
<param name="videoURL" value="your_video.mp4">
</applet>
*/

public class MediaApplet extends Applet {

    private Image image;
    private AudioClip audioClip;
    private URL videoURL;

    @Override
    public void init() {
        try {
            // Load Image
            String imagePath = getParameter("imageURL");
            if (imagePath != null && !imagePath.isEmpty()) {
                URL imageURL = new URL(getDocumentBase(), imagePath);
                image = getImage(imageURL);
            }

            // Load Audio
            String audioPath = getParameter("audioURL");
            if (audioPath != null && !audioPath.isEmpty()) {
                URL audioURL = new URL(getDocumentBase(), audioPath);
                audioClip = getAudioClip(audioURL);
            }

            // Load Video URL (Applets have limited built-in video support)
            String videoPath = getParameter("videoURL");
            if (videoPath != null && !videoPath.isEmpty()) {
                videoURL = new URL(getDocumentBase(), videoPath);
                // For actual video playback in a modern web environment,
                // you'd typically use HTML5 <video> tag or external libraries.
                System.out.println("Video URL loaded: " + videoURL);
                // Displaying video directly in a simple Applet is complex.
                // We'll just load the URL for demonstration.
            }

        } catch (Exception e) {
            System.err.println("Error loading media: " + e.getMessage());
        }
    }

    @Override
    public void paint(Graphics g) {
        // Display Image
        if (image != null) {
            g.drawImage(image, 10, 10, this);
        } else {
            g.drawString("Image not loaded.", 10, 30);
        }

        // Provide a button to play audio
        if (audioClip != null) {
            Button playButton = new Button("Play Audio");
            playButton.setBounds(10, 50 + (image != null ? image.getHeight(this) : 0), 100, 30);
            add(playButton);
            playButton.addActionListener(e -> audioClip.play());
        } else {
            g.drawString("Audio not loaded.", 10, 80 + (image != null ? image.getHeight(this) : 0));
        }

        // Indicate video URL (actual playback requires more complex handling)
        if (videoURL != null) {
            g.drawString("Video URL loaded. Playback requires external handling.", 10, 110 + (image != null ? image.getHeight(this) : 0));
        } else {
            g.drawString("Video not loaded.", 10, 140 + (image != null ? image.getHeight(this) : 0));
        }
    }
}