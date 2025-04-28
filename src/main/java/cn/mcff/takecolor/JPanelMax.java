package cn.mcff.takecolor;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;


public class JPanelMax extends JPanel {
    /*移动窗体的方位*/
    private int OriginX = 0, OriginY = 0;
    /*界面*/
    private JFrame uiJframe = new JFrame();

    /**
     * 创建界面
     *
     * @param sizeX 界面的宽
     * @param sizeY 界面的高
     */
    public JPanelMax(int sizeX, int sizeY) {
        uiJframe.setSize(sizeX, sizeY);
        uiJframe.setLayout(null);//清除布局
        uiJframe.setUndecorated(true);//隐藏标题栏
        uiJframe.setLocationRelativeTo(null);//设置屏幕居中

        this.setBounds(0, 0, sizeX, sizeY);
        this.setLayout(null);//清除布局
        this.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        this.setBackground(Color.white);
        uiJframe.add(this);

        JLabel ui_x = new JLabel("", JLabel.CENTER);
        ui_x.setBounds(sizeX - 30, 1, 29, 29);
        ui_x.setBackground(new Color(255, 0, 0));
        ui_x.setOpaque(false);//设置JLabel背景透明
        this.add(ui_x);
        ui_x.setIcon(ImageBaseConfig.setImage(ImageBaseConfig.circle, 10, 10, 16));

        ui_x.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {//移开
                ui_x.setOpaque(false);
                ui_x.setIcon(ImageBaseConfig.setImage(ImageBaseConfig.circle, 10, 10, 16));
            }

            public void mouseEntered(MouseEvent e) {//移上
                ui_x.setOpaque(true);
                ui_x.setIcon(ImageBaseConfig.setImage(ImageBaseConfig.off, 20, 20, 16));
            }

            public void mouseClicked(MouseEvent e) {//点击
                System.exit(3);
            }
        });

        Point origin = new Point();//窗体移动获取
        uiJframe.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                origin.x = e.getX();
                origin.y = e.getY();
            }
        });
        uiJframe.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = uiJframe.getLocation();
                uiJframe.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
                OriginX = p.x + e.getX() - origin.x;
                OriginY = p.y + e.getY() - origin.y;
            }
        });
        OriginX = uiJframe.getX();
        OriginY = uiJframe.getY();
    }

    /**
     * 显示界面
     *
     * @param b
     */
    public void ShowUI(boolean b) {
        uiJframe.setVisible(b);
    }

}
