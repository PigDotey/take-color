package cn.mcff.takecolor;

public class Main {
    public static void main(String[] args) {
        new FrameMain();
        new Thread(new CutOff()).start();
    }
}
