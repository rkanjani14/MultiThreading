
class A 
{
    void Display() 
    {
        System.out.println("Display Function Called..");
        try 
        {
            Thread.sleep(1000);
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}

class B implements Runnable 
{
    A et;
    B(A et) 
    {
        this.et = et;
    }

    @Override
    public void run() 
    {
        System.out.println("Started Runnable Interface..");
        et.Display();
        System.out.println("Executed Runnable Interface..");
    }
}

class C extends Thread 
{
    A a;
    C(A et) 
    {
        this.a = et;
    }
    public void run() 
    {
        System.out.println("Started Thread Class..");
        a.Display();
        System.out.println("Executed Thread Class..");
    }
}

class question1 
{
    public static void main(String[] args) 
    {
        A a = new A();
        B b = new B(a);
        Thread t = new Thread(b);
        C c = new C(a);
        C c1 = new C(a);
        C c2 = new C(a);
        t.start();
        c.start();
        try 
        {
            c.join();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        c1.start();
        c2.start();
        System.out.println(Thread.activeCount());
    }
}







