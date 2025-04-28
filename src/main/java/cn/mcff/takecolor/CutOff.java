package cn.mcff.takecolor;

import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CutOff implements Runnable {
    /*Robot机器人*/
    private Robot robot;
    /*鼠标信息*/
    private Point mousePos;
    /*颜色信息*/
    private Color color;//当前的颜色
    private String colorHtml, colorRgb;

    /*图片相关*/
    private Rectangle rectangle = new Rectangle();
    private BufferedImage bufferedImage;

    @Override
    public void run() {
        while (true) {
            try {
                robot = new Robot();
                mousePos = MouseInfo.getPointerInfo().getLocation();
                FrameMain.uiMouseX.setText((int) mousePos.getX() + "");
                FrameMain.uiMouseY.setText((int) mousePos.getY() + "");

                /*获取当前的颜色*/
                color = robot.getPixelColor((int) mousePos.getX(), (int) mousePos.getY());
                FrameMain.uiImageColor.setBackground(color);//设置颜色显示
                /*获取HTML颜色的格式*/
                colorHtml = String.format("#%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
                FrameMain.uiTextHtml.setText(colorHtml);//设置HTML的颜色 #000000
                /*获取RGB颜色的格式*/
                colorRgb = color.getRed() + "," + color.getGreen() + "," + color.getBlue();
                FrameMain.uiTextRgb.setText(colorRgb);
                
                /*图片相关*/
                rectangle.setBounds((int) mousePos.getX() - 15, (int) mousePos.getY() - 15, 30, 30);
                bufferedImage = robot.createScreenCapture(rectangle);
                FrameMain.uiCutOffImage.setIcon(setImageIcon(bufferedImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ImageIcon setImageIcon(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", byteArrayOutputStream); // 格式：PNG、JPEG等
        byte[] bytes = byteArrayOutputStream.toByteArray();
        ImageIcon imageIcon = new ImageIcon(ImageIO.read(new ByteArrayInputStream(bytes)));
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
