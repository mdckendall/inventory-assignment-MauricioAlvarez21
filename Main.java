import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 
    ArrayList<String> inventory = new ArrayList<String>();
    int numDel =0;
    while (true){// Create a Scanner object
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the programs.");
  
      String userResponse = scanner.nextLine();
      String name;
      String serNum;
      String value;
      if (userResponse.equals("1")){
        System.out.println("Enter the name:");
        name = scanner.nextLine();
        System.out.println("Enter the serial number:");
        serNum = scanner.nextLine();
        System.out.println("Enter the value in dollars (whole number):");
        value = scanner.nextLine();
        inventory.add(serNum);
        inventory.add(name);
        inventory.add(value);
        
      }
      else if(userResponse.equals("2")){
        numDel+=1;
        System.out.println("Enter the serial number of the item to delete:");
        serNum = scanner.nextLine();
        int i;
        for (i=0; i<inventory.size(); i++){
          if (inventory.get(i).equals(serNum)&& (i==0 || i%3==0)){
            i=i;
            break;
          }
        }
        for (i=i;i<inventory.size()-3;i++){
          inventory.set(i,inventory.get(i+3));
        }
       inventory.remove(inventory.size()-1);
       inventory.remove(inventory.size()-2);
       inventory.remove(inventory.size()-3); 
      }
      else if(userResponse.equals("3")){
        System.out.println("Enter the serial number of the item to change:");
        serNum = scanner.nextLine();
        System.out.println("Enter the new name:");
        name = scanner.nextLine();
        System.out.println("Enter the new value in dollars (whole number):");
        value = scanner.nextLine();
        int i;
        int toCh=0;
        for (i=0; i<inventory.size(); i++){
          if (inventory.get(i).equals(serNum)){
            toCh = i;
            break;
          }
        }
        inventory.set(toCh+1,name);
        inventory.set(toCh+2,value);
        
      }
      else if(userResponse.equals("4")){
        String out;
          for (int i=0; i < inventory.size()-2;i=i+3){
            if(i == inventory.size()-3 && numDel>=1 && numDel%2!=0){
              out = inventory.get(i+2) +","+inventory.get(i)+","+inventory.get(i+1);
            }
            else {
              out = inventory.get(i+1) +","+inventory.get(i)+","+inventory.get(i+2);
            }
            System.out.println(out);
          }
        }
      else if(userResponse.equals("5")){
        break;
      }
    }


	}
}