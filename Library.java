import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;

    /**
     * Constructor for the Library class
     * Initialize 'Library' Object with information from the 'Building' (as a 'Library' is a type of 'Building')
     * In addition, has its hash table.
     * 
     * @param name The name of the 'Library'
     * @param address The 'Library' address
     * @param nFloors The number of floors of the 'Library'
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>(); // I'm not sure yet but okay
      System.out.println("You have built a library: 📖");
    }

    /**
     * Add a title to the collection
     * 
     * @param title Title of the book
     */
    public void addTitle(String title) {
      if(containsTitle(title)){
        throw new RuntimeException(title +" is already in the collection. Try again with a new book.");
      }
      else {
        this.collection.put(title, true);
      }

    }
  
    /**
     * Remove a book from the collection
     * 
     * @param title The title of the book
     * @return The title of the book (that was removed)
     */
    public String removeTitle(String title) {
      if(containsTitle(title)) {
        this.collection.remove(title);
        return title;
      }
      else {
        throw new RuntimeException(title + " does NOT exist within the collection, and thus cannot be removed.");
      }
    }

    /**
     * Check out a book from library collection
     * 
     * @param title The title of the book getting checked out
     */
    public void checkOut(String title) {
      if(containsTitle(title)) {
        if(!isAvailable(title)) {
          throw new RuntimeException(title + " has already been checked out by someone else. Please come back another time.");
        }
        this.collection.replace(title, false);
        System.out.println(title + " is checked out. Have fun reading!");
      }
      else {
        throw new RuntimeException(title + " is NOT within the collection, and thus cannot be checked out. Please try again with a new book.");
      }
    }

    /**
     * Returns a borrowed (previously checked out) book
     * 
     * @param title The title of the book being returned
     */
    public void returnBook(String title) {
      if(containsTitle(title)) {
        if(isAvailable(title) == false) { // Check if the book was borrowed
          this.collection.replace(title,true); // Then return the book
        }
        throw new RuntimeException(title + " was NOT previously checked out, and thus cannot be returned.");
      }
      throw new RuntimeException(title + " does NOT exist within our collection, and thus cannot be returned.");
    }

    /**
     * Check if a book exists within the library's collection.
     * 
     * @param title The title of the book.
     * @return true/false
     */
    public boolean containsTitle(String title) {
      if(this.collection.containsKey(title)) {
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Check if a book is available
     * 
     * @param title The title of the book
     * @return true/false
     */
    public boolean isAvailable(String title) {
      if(this.collection.get(title)) {
        return true;
      }
      else {
        return false;
      }
    }

    /**
     * Prints out the entire collection in an easy-to-read way (including checkout status)
     * 
     */
    public void printCollection() {
      System.out.println(this.collection.toString());
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Neilson Drive", 4);
      String wow = new String("World of Wonders");
      neilson.addTitle("Gut Check");
      neilson.addTitle(wow);
      System.out.println(neilson.containsTitle(wow));
      neilson.printCollection();
      neilson.checkOut(wow);
      System.out.println(neilson.isAvailable(wow));
    }
  
  }