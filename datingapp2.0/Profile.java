import java.util.ArrayList;

/*
This class contains information about a user's profile. It contains information that is available for the public to see,
which is the user's name, age, and gender. It also keeps a list of users that they have swiped right and left on, and who
they matched with. Each profile that gets created is added to the list where all profiles created are held.
*/

public class Profile {
  /**
  *contains the user's public info
  */
  private String firstName;
  private String lastName;
  private int age;
  private boolean isFemale;
  /**
  *contains the profiles that the user swipes right or left on
  */
  private ArrayList<Profile> likedUsers = new ArrayList<Profile>();
  private ArrayList<Profile> dislikedUsers = new ArrayList<Profile>();
  /**
  *contains profiles where the user and the other profile have both swiped right on each other
  */
  private ArrayList<Profile> matches = new ArrayList<Profile>();
  /**
  *keeps track of all of the profiles that have been made
  */
  public static ArrayList<Profile> allProfiles = new ArrayList<Profile>();

  /**
  *overload constructor that creates a profile given public information
  *@param firstName user's first name
  *@param lastName  user's last name
  *@param age user's age
  *@param isFemale user's gender as male or female
  */
  public Profile(String firstName, String lastName, int age, boolean isFemale) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.isFemale = isFemale;
    allProfiles.add(this);
  }

  /**
  *setter that gets user input for user's public information
  *@param firstName user's first name
  *@param lastName  user's last name
  *@param age user's age
  *@param isFemale user's gender as male or female
  */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public void setGender(boolean isFemale) {
    this.isFemale = isFemale;
  }

  /**
  *getter that gets the user's public information
  *@return a String value of the user's first name
  *@return a String value of the user's last name
  *@return a String value that takes the first and last name to returns the full name
  */
  public String getFirstName() {
    return this.firstName;
  }
  public String getLastName() {
    return this.lastName;
  }
  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  /**
  *getter that gets the user's age
  *@return a int value of the user's age
  */
  public int getAge() {
    return this.age;
  }
  /**
  *getter that gets the user's gender
  *@return a boolean that uses true for female and false for male
  */
  public boolean getGender() {
    return this.isFemale;
  }
  /**
  *getter that returns the user's right swipes
  *@return an arraylist that shows all of the profiles the user likes
  */
  public ArrayList getLikedUsers() {
    return likedUsers;
  }
  /**
  *getter that returns the user's left swipes
  *@return an arraylist that shows all of the profiles the user dislikes
  */
  public ArrayList getDislikedUsers(){
    return dislikedUsers;
  }
  /**
  *getter that returns the user's matches aka the profiles that have swiped right on the user and the user has swiped right on
  *@return an arraylist that shows all of the profiles matches
  */
  public ArrayList getMatches() {
    return matches;
  }

  /**
  *users swipe right on profiles that they like
  *@param profile represents a profile that the user is looking at
  */
  public void swipeRight(Profile profile) {
    likedUsers.add(profile);
    for (int i = 0; i < profile.getLikedUsers().size(); ++i) {                                      //checks to see if the profile swiped right on the user back
      if (this.match(profile) == true) {
        matches.add(profile);
        profile.getMatches().add(this);
      }
    }
  }

  /**
  *users swipe left on profiles that they are uninterested in
  *@param profile represents a profile that the user is looking at
  */
  public void swipeLeft(Profile profile) {
    dislikedUsers.add(profile);
  }

  /**
  *checks to see if the profile that was swipe right on swiped back on the user
  *@param profile represents the profile that the user is viewing
  *@return a boolean that is true the profile has swiped right on the user and is a match
  */
  public boolean match(Profile profile) {
    for (int i = 0; i < profile.getLikedUsers().size(); ++i) {                                      //checks to see if the profile swiped right on the user back
      if (this != profile.getLikedUsers().get(i)) {
        return false;
      }
    }
    return true;
  }

  /**
  *gives public profile display which shows the name and age
  *@return a string that shows the profile's name and age
  */
  public String displayProfile() {
    return this.getFullName() + ", " + this.getAge();
  }


  /**
  *Overrides toString method by printing out the profile's full name
  */
  public String toString() {
    return firstName + " " + lastName;
  }
}
