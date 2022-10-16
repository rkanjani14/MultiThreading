import java.util.concurrent.*;

class A implements Runnable {
    public void run() 
    {
        System.out.println("Runnable...");
    }
}

class B implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable...");
        return 1;
    }
}

class question4 
{
    static ExecutorService ex = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws ExecutionException, InterruptedException 
    {
        A t1 = new A();
        Thread t = new Thread(t1);
        B c1 = new B();   

        //Future<Integer> num = ex.submit(c1);
        //System.out.println(num.get());

        t.start();
        
        ex.submit(t);
        
    }
}