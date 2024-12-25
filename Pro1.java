import java.util.Scanner;
public class Pro1{
	public static void main(String[] args){
		Menu menu=new Menu();
		menu.list();
	}
}
class Menu{
	Scanner sc=new Scanner(System.in);
	public void list(){
		while(true){//while1
			try{
				System.out.println("+-----------------------+");
				System.out.println("|       Main Menu       |");
				System.out.println("+-----------------------+");
				System.out.println("| 1.Add a record        |");
				System.out.println("| 2.Display a record    |");
				System.out.println("| 3.Display all records |");
				System.out.println("| 4.Edit a record       |");
				System.out.println("| 5.Delete a record     |");
				System.out.println("| 6.Exit                |");
				System.out.println("+-----------------------+");
				String choice;
				boolean choiceok=false;
				while(true){//while2
				System.out.print("Enter Your Choice(1-6): ");
				choice=sc.next();
				String[] choices={"1","2","3","4","5","6"};
				for(int p=0;p<choices.length;p++){
					if(choice.equals(choices[p])){
						choiceok=true;
					}
				}//end of for loop
				if(choiceok){
					System.out.println("|Your selected choice:"+choice+" |");
					System.out.println("+-----------------------+:");
					break;
				}else{
					System.out.println("Your selected wrong choice.Please select 1-7");
					}
				}//end of while2	
				if(choice.equals("1")){
					    InsertQuary in=new InsertQuary();
					    in.insert();
					}
				if(choice.equals("2")){
						SelectQuary sq=new SelectQuary();
						sq.select();
						
					}
				if(choice.equals("3")){
						SelectAllQuary slq=new SelectAllQuary();
						slq.selectall();

					}
				if(choice.equals("4")){
						UpdateQuary uq=new UpdateQuary();
						uq.update();
					}
				if(choice.equals("5")){
						DeleteQuary dq=new DeleteQuary();
						dq.delete();
					}
				if(choice.equals("6")){
						confirm();
					}
			
				
			}catch(Exception e){
				System.out.println(e);
			}
		}//end of while1
	}//end of methord list()
	public void confirm(){
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
					System.out.println("Good Bye...");
					System.exit(0);
				}
		}
	public void pause(){
		System.out.println();
		System.out.println("Press Any Key and enter to Continue... ");
		System.out.println();
		String k=sc.next();
	}
}
