package config;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CoronavirusLogo {

        public static void logoPrint() {
            int width = 100;
            int height = 30;
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            g.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 12));


            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.drawString("CORONAVIRUS", 10, 20);



            for (int y = 0; y < height; y++) {
                StringBuilder sb = new StringBuilder();
                for (int x = 0; x < width; x++) {

                    sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");

                }

                if (sb.toString().trim().isEmpty()) {
                    continue;
                }

                System.out.println(sb);


            }
        }

    }
