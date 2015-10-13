package Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffApplication {
	public static void main(String args[]){
		//declare all the object 
		Scanner scan = new Scanner(System.in);
		String username=null,password= null;
		Staff inputStaff= null;
		ArrayList getList = null;
		boolean staffStatus = false;
		int choiceFunction = 0;
		
		//scan the staff username and password
		System.out.println("Username: ");
		username = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();
		inputStaff = new Staff(username,password);
		//processing database
		System.out.println("Check Database");
		System.out.println("process.....\n");
		getList =  DatabaseStaff.ReadFromDatabase("staff.dat");
		for(int i = 0 ; i < getList.size() ; i++){
			Staff printStaff = (Staff)getList.get(i);
			if(printStaff.EqualsStaff(inputStaff)){
				staffStatus = true;
				break;
			}
		}
		
		if(staffStatus){
			System.out.println("welcome Staff");
		}else{
			System.out.println("Sorry your username and password is not match with our database");
		}
		
		
		//give choices for Staff
		
		while(true){
			System.out.println();
		}
		
	}
	
	public void ConfiguringCineplex(){
		
	}
}
