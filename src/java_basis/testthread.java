package java_basis;

public class testthread {
    public static void main(String[] args) {
        threaddemo td1 = new threaddemo("窗口一");
        threaddemo td2 = new threaddemo("窗口二");
        threaddemo td3 = new threaddemo("窗口三");
        threaddemo td4 = new threaddemo("窗口四");
        td1.start();
        td2.start();
        td3.start();
        td4.start();
    }
}
