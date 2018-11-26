import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * @author Josiah Laivins
 * @version 1.0
 * @since 3/1/8/2017
 *
 * <p>
 *     <code>ImageBuilder</code> takes in a 3 dimensional integer matrix
 *     and generates an image from that matrix. The first 2 dimensions
 *     are for the x and y coordinates. The third dimension should be
 *     of size 3, one for each RGB color.
 * </p>
 *
 */
public class ImageBuilder {

    public BufferedImage bufferedImage;
    public int[][][] newImage;

    /**
     * Constructs an <code>ImageBuilder</code> object that
     * stores a 3 dimensional matrix that is zoomed to
     * a certain size.
     *
     * @param image    3 dimensional matrix to be turned into a usable image
     * @param zoom     the size of the pixels of the image for
     *                 improved readability
     */
    public ImageBuilder(int[][][] image, int zoom) {

        int indexX = 0;
        int indexY = 0;

        this.newImage = new int[image.length*zoom]
                [image[0].length*zoom][3];

        for (int i = 0; i < newImage.length-zoom+1; i += zoom) {
            for (int j = 0; j < newImage[i].length-zoom+1; j += zoom) {

                for (int k = 0; k < zoom && (k+i) < newImage.length; k++) {
                    for (int l = 0; l < zoom && (l+j) < newImage[0].length; l++) {

                        newImage[i+k][j+l][0] = image[indexX][indexY][0];
                        newImage[i+k][j+l][1] = image[indexX][indexY][1];
                        newImage[i+k][j+l][2] = image[indexX][indexY][2];
                    }
                }
                indexY += 1;
            }
            indexX += 1;
            indexY = 0;
            System.out.println("Loading Row " + i + "...");
        }

        this.bufferedImage = new BufferedImage(newImage.length,
                newImage[0].length, TYPE_INT_RGB);

        for (int i = 0; i < newImage.length; i++) {
            for (int j = 0; j < newImage[0].length; j++) {
                bufferedImage.setRGB(i, j, new Color(newImage[i][j][0],
                        newImage[i][j][1], newImage[i][j][2]).getRGB());
            }
        }
    }

    /**
     * Displays the image as a <code>JFrame</code>.
     * Allows a scrollable behavior.
     */
    public void show() {

        JFrame frame = new JFrame();
        int frameY = (int)(newImage[0].length*1.5) > 500 ? 500:(int)(newImage[0].length*1.5);
        int frameX = (int)(newImage.length*1.5) > 500 ? 500:(int)(newImage.length*1.5);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameX, frameY);

        ImageIcon icon = new ImageIcon(bufferedImage);

        JLabel imageLabel = new JLabel(icon);

        JPanel jPanel = new JPanel();
        jPanel.add(imageLabel);

        JScrollPane scrollPane = new JScrollPane(jPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, frameX, frameY);

        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
