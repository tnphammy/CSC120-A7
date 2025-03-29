import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;


  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    ArrayList<Student> residents = new ArrayList<>(Student);
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom() {
    if (hasDiningRoom = true) {
      return true;
    }
    else {
      return false;
    }
  }




  public static void main(String[] args) {
    new House();
  }

}