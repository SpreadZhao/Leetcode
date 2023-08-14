package exercise;

public class MyThread extends Thread {
    private static int order = 0;
    private final int num;

    public MyThread(int _num){
        this.num = _num;
    }

    @Override
    public void run() {
        while(order < 26){
            if(num == order % 3){
                System.out.print(num + 1);
                System.out.print((char)('A' + order));
                order++;
            }
        }
    }
}
