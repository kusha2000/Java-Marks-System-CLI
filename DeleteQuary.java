import java.sql.*;
import java.util.Scanner;
public class DeleteQuary{
	public static void delete(){
		ResultSet r; 
		while(true){
			try{
				Menu menu=new Menu();
				Scanner sc=new Scanner(System.in);
				System.out.print("Enter index number to need delete:");
				String inde=sc.next();
				String conf;
				while(true){//while3
					System.out.print("Are You Sure(Y/N):");
					conf=sc.next();
					if(conf.equals("y")||conf.equals("Y")||conf.equals("n")||conf.equals("N")){
						break;	
					}else{
						System.out.println("Please press Y/N only");
					}
				}//end of while3
				if(conf.equals("y")||conf.equals("Y")){
						Class.forName("com.mysql.jdbc.Driver");
						//System.out.println("Connectivity is OK...");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatacli","root","");
						//System.out.println("MYSQL connection is OK...");
			            Statement stat=con.createStatement();
			            r=stat.executeQuery("Select * from marks where st_index="+inde+"");
			            r.next();
			            r.getString(1);
			            //System.out.println(r.getString(1)+"\t\t"+r.getString(2)+"\t\t"+r.getString(3)+"\t\t"+r.getString(4));
			            int i=stat.executeUpdate("DELETE FROM marks WHERE st_index='"+inde+"'");
			            System.out.println();
			            System.out.println("--------------------------------");
				    	System.out.println("The record deleted successfully.");
				    	System.out.println("--------------------------------");
				    	con.close();
				    	menu.pause();
				    	break;

				}	
			}catch(Exception e){
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("You Entered wrong index number.");
				System.out.println("-------------------------------");
				System.out.println();
			}
		}
	}
}
