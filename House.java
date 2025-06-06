import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements {
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * Constructor for the House class
   * Initialize House Object with information from the Building (as a House is a type of Building)
   * In addition, has its own ArrayList of residents.
   * 
   * @param name The name of the 'House'
   * @param address The 'House' address
   * @param nFloors The number of floors of the 'House'
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Check whether this 'House' has a dining room
   * 
   * @return true/false 
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Return number of residents in this House
   * 
   * @return The number of residents
   */
  public int nResidents() {
    int count = this.residents.size();
    return count;
  }

  /**
   * Move in a student
   * 
   * @param s The student's name
   */
  public void moveIn(Student s) {
    if(this.residents.contains(s)) { // Student s is a resident of this 'House'=> CANNOT be added.
      String message = s.getName() + "already lives here.";
      throw new RuntimeException(message);
    } 
    this.residents.add(s);

  }

  /**
   * Move out a student
   * 
   * @param s The student's name
   * @return The student's name (who has now moved out)
   */
  public Student moveOut(Student s) {
    if(this.residents.contains(s)) { // Student is resident of 'House' => CAN be removed.
      this.residents.remove(s);
      return s;
    }
    else {
      String message = s.getName() + "does NOT live here";
      throw new RuntimeException(message);
    }
  }

  /**
   * Check whether this student is a resident of this 'House'
   * 
   * @param s The student's name
   * @return true/false
   */
  public boolean isResident(Student s) {
    if(this.residents.contains(s)){
      return true;
    }
    return false;
  }



  public static void main(String[] args) {
    House cutter = new House("Cutter", "79 Elm St.", 3, true);
    Student tammy = new Student("Tammy", "991472193", 2028);
    cutter.moveIn(tammy);
    System.out.println(cutter.isResident(tammy));

  }

}