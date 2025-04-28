package cn.mcff.takecolor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class FrameMain {
    /*主界面*/
    private int uiWinSizeX = 300, uiWinSizeY = 150;
    private static JPanelMax uiJPanelMax;


    /*界面显示的东西*/
    public static JLabel uiImageColor = new JLabel();//颜色的显示区
    public static JLabel uiTextHtml;//html的颜色
    public static JLabel uiTextRgb;//Rgb颜色值
    public static JLabel uiMouseX, uiMouseY;//鼠标的位置
    public static JLabel uiCutOffImage = new JLabel();//鼠标位置的图片

    public FrameMain() {//系统设置
        /*界面*/
        uiJPanelMax = new JPanelMax(uiWinSizeX, uiWinSizeY);

        uiImageColor.setOpaque(true);
        setJLabelBorder(uiImageColor, 10, 40, 170, 20, 200, 200, 200);


        /*html的颜色*/
        uiTextHtml = new JLabel("#FFFFFF", JLabel.LEFT);
        setJLabelFont(uiTextHtml, 10, 65, 85, 20, 15);

        /*Rgb颜色值*/
        uiTextRgb = new JLabel("255,255,255", JLabel.RIGHT);
        setJLabelFont(uiTextRgb, 95, 65, 85, 20, 15);

        /*鼠标的X位置*/
        uiMouseX = new JLabel("0", JLabel.CENTER);
        setJLabelFont(uiMouseX, 40, 100, 50, 20, 20);

        /*鼠标的Y位置*/
        uiMouseY = new JLabel("0", JLabel.CENTER);
        setJLabelFont(uiMouseY, 90, 100, 50, 20, 20);


        /*图片上面的 横竖红线*/
        setJLabelBorder(new JLabel(), 191, 91, 98, 1, 255, 0, 0);
        setJLabelBorder(new JLabel(), 240, 41, 1, 98, 255, 0, 0);

        /*现实的图片*/
        setJLabelBorder(uiCutOffImage, 190, 40, 100, 100, 200, 200, 200);

        /*显示界面*/
        uiJPanelMax.ShowUI(true);
    }

    /*同一的设置显示的字体跟背景颜色*/
    private void setJLabelFont(JLabel label, int x, int y, int width, int height, int fontSize) {
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Dialog", 0, fontSize));
        label.setForeground(new Color(0, 0, 0));
        uiJPanelMax.add(label);
    }

    private void setJLabelBorder(JLabel label, int x, int y, int width, int height, int r, int g, int b) {
        label.setBounds(x, y, width, height);
        label.setBorder(BorderFactory.createLineBorder(new Color(r, g, b)));
        uiJPanelMax.add(label);
    }
}
