package gc;
import java.io.*;
import java.sql.*;
import java.util.*;
class Abc{
	static String first_name;
	static String last_name;
	static String gmail;
	static String pass;
	static Connection con = null;
	public static void registered() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking", "root", "Admin#4321");
	        PreparedStatement ps = con.prepareStatement("insert into login_form values(?,?,?,?)");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the First Name:");
	        first_name = sc.next();
	        System.out.println("Enter the Last Name:");
	        last_name = sc.next();
	        System.out.println("Enter Mail ID:");
	        gmail = sc.next();
	        System.out.println("Enter the Password:");
	        pass = sc.next();
	        ps.setString(1, first_name);
	        ps.setString(2, last_name);
	        ps.setString(3,gmail);
	        ps.setString(4, pass);
	        ps.execute();
	        System.out.println("Hi "+first_name+" you have registered successfully");
	        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
	}

class B{
	static int id;
	static String name;
	static long account;
	static long phone;
	static String ifsc;
	static long balance;
	static Connection con=null;
	public static void register() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking", "root", "Admin#4321");
	        PreparedStatement ps = con.prepareStatement("insert into account values(?,?,?,?,?,?)");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the ID");
	        id = sc.nextInt();
	        System.out.println("Enter the Name");
	        name = sc.next();
	        System.out.println("Enter the Account");
	        account = sc.nextLong();
	        System.out.println("Enter the Phone");
	        phone = sc.nextLong();
	        System.out.println("Enter the IFSC CODE");
	        ifsc = sc.next();
	        System.out.println("Enter the Balance");
	        balance = sc.nextLong();
	        ps.setInt(1, id);
	        ps.setString(2, name);
	        ps.setLong(3, account);
	        ps.setLong(4, phone);
	        ps.setString(5, ifsc);
	        ps.setLong(6, balance);
	        ps.execute();
	        System.out.println("New Data is Entered");
	        
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			con.close();
		}
		
	}
	public static void Balance() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "Admin#4321");
	        PreparedStatement ps = con.prepareStatement("select * from account where phone=? or account=?");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the account or phone no");
	        Long c = sc.nextLong();
	        ps.setLong(1,c);
	        ps.setLong(2,c);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	        	System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(6));
	        }
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static boolean lave()throws SQLException
	{
		boolean b = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking", "root", "Admin#4321");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Mail ID");
	        String name = sc.next();
	        System.out.println("Enter the password");
	        String password = sc.next();
	        PreparedStatement ps = con.prepareStatement("select * from login_form");
	        ResultSet rs = ps.executeQuery();
	        while(rs.next())
	        {
	        	String a = rs.getString(3);
	        	String x = rs.getString(4);
	        	if(a.equals(name) && x.equals(password))
	        	{
	        		b = true;
	        		return b;
	        		
	        	}		
	        	
	        }
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
		
	}
	
}
	public static void Transfer() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "Admin#4321");
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter the choice 0 for account and 1 for Phone No");
	        int ch = sc.nextInt();
	        if(ch==0)
	        {
	        	PreparedStatement ps = con.prepareStatement("update account set balance = balance + ? where account=?");
	        	Scanner sc1 = new Scanner(System.in);
	        	System.out.println("Enter the account number to which the money is to be transfered");
	        	account = sc1.nextLong();
	        	System.out.println("Enter the amount to be transfered");
	        	balance = sc1.nextLong();
			
	        	ps.setLong(1, balance);
	        	ps.setLong(2, account);
			
	        	ps.execute();
	        	PreparedStatement ps2 = con.prepareStatement("update account set balance = balance - ? where id=1");
	        	ps2.setLong(1, balance);
	        	ps2.execute();
	        	
	        }
	        if(ch==1)
	        {
	        	PreparedStatement ps = con.prepareStatement("update account set balance = balance + ? where phone=?");
	        	Scanner sc1 = new Scanner(System.in);
	        	System.out.println("Enter the phone number to which the money is to be transfered");
	        	phone = sc1.nextLong();
	        	System.out.println("Enter the amount to be transfered");
	        	balance = sc1.nextLong();
			
	        	ps.setLong(1, balance);
	        	ps.setLong(2, phone);
	        	ps.execute();
			
	        	PreparedStatement ps2 = con.prepareStatement("update account set balance = balance - ? where id=1");
	        	ps2.setLong(1, balance);
	        	ps2.execute();
	        	
	        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally {
			con.close();
		}
	}
}
public class run {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("---------WELCOME TO ZEE BANK-----------");
			System.out.println(" 1. Register  ");
			System.out.println(" 2. Login  ");
			System.out.println(" 3. Exit ");
			System.out.println("Enter the Choice");
			int ch = sc.nextInt();
			if (ch==1)
			{
				Abc.registered();
			}
			else if(ch==2)
			{
				if(Abc.lave()==true)
				{
					
					do {
						System.out.println("1.Register");
						System.out.println("2.Balance");
						System.out.println("3.Transfer");
						System.out.println("4.Exit");
						System.out.println("Enter the choice");
						int ch1 = sc.nextInt();
						if(ch1==1)
						{
							B.register();
						}
						else if(ch1==2)
						{
							B.Balance();
						}
						else if(ch1==3)
						{
							B.Transfer();
						}
						else
						{
							System.exit(0);
						}
					}while(true);

					
				}
				else
				{
					System.out.println("Please Register!!!!!!");
					System.out.println();
				}
				
			}
			else
			{
				System.exit(0);
			}
			
		}while(true);
		
		
	}

}

