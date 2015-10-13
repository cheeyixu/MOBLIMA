package Staff;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DatabaseStaff {
	
	public static void WriteToDatabase(String filename,ArrayList<Staff> list){
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try{
			fos = new FileOutputStream(filename);
			bos = new BufferedOutputStream(fos);
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(list);
			os.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	
	}
	

	public static ArrayList ReadFromDatabase(String filename){
		ArrayList returnedList = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try{
			fis = new FileInputStream(filename);
			bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			returnedList = (ArrayList)ois.readObject();
			ois.close();
		}catch(IOException e){
			
		} catch (ClassNotFoundException e) {
			
		}
		return returnedList;
	}
	
	
	public static void main(String args[]){
		ArrayList list = new ArrayList<Staff>();
		Staff newStaff = new Staff("EdwardSujono","12345");
		list.add(newStaff);
		String filename = "staff.dat";
		DatabaseStaff.WriteToDatabase(filename, list);
	
		
	}
	
}
