package java_basis;


public class threaddemo extends Thread{
    static int ticket=100;

    public threaddemo() {
    }

    public threaddemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            synchronized (threaddemo.class){
                if(ticket<1){
                    break;
                }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName()+"正在出售第"+ticket--+"张票");

            }
        }
    }
}
