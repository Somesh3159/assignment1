package gc;
import java.io.IOException;
class A{
	int a=100;
	A()
	{
		System.out.println("HI"+a);
	}
	public void finalize()
	{
		System.out.println("obj removed....");
	}
}
public class run {
     public static void main(String[] args) throws IOException{
    	 A x=new A();
    	 x.a=2000;
    	 x=null;
    	 System.gc();
     }
}

