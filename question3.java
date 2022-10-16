class question3
{
    private static Integer i1 = 0;
    private static Integer i2 = 0;
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    private static void increment() throws InterruptedException 
    {
        System.out.println(Thread.currentThread().getName() + " ++");
        Thread.sleep(1000);
        synchronized (lock1) 
        {
            i1++;
        }
        System.out.println(Thread.currentThread().getName() + " ++");
    }

    private static void decrement() throws InterruptedException 
    {
        System.out.println(Thread.currentThread().getName() + " --");
        Thread.sleep(1000);
        synchronized (lock2) 
        {
            i2--;
        }
        System.out.println(Thread.currentThread().getName() + " --");
    }

    public static void main(String[] args) throws InterruptedException 
    {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) 
            {
                try 
                {
                    increment();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }, "Increment1");
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) 
            {
                try 
                {
                    decrement();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }, "Decrement1");
        
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) 
            {
                try 
                {
                    decrement();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }, "Decrement2");
        
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 20000; i++) 
            {
                try 
                {
                    increment();
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
            }
        }, "Increment2");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        System.out.println("Value of Integer: " + i1);
        System.out.println("Value of Integer: " + i2);
    }
}
