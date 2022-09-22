/**
*This class is the driver that runs a simulation if a user were to enter a dating app.
*They would create a dating profile in which they will input information about themselves
*and what they are looking for. They will have the option to view profiles and swipe right or left on them.
*They will also get to see their matches and the profiles they liked and disliked.
*/

import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);

    /**
    *Setting up user profile starting with the name
    */
    System.out.println("First name: ");
    String firstName = scnr.next();

    System.out.println("Last name: ");
    String lastName = scnr.next();

    /**
    *Gets the user's age
    */
    System.out.println("Age: ");
    int age = scnr.nextInt();

    /**
    *Gets the user's gender
    */
    System.out.println("Male(1) or female(2): ");
    int genderInt = scnr.nextInt();
    boolean gender = false;                             //converting to boolean for methods in Profile class
    if (genderInt == 1) {
      gender = false;
    }
    else if (genderInt == 2) {
      gender = true;
    }

    /**
    *user picks whether they are looking at female or male profiles
    */
    System.out.println("Interested in males(1) or females(2): ");
    int genderInterestInt = scnr.nextInt();
    boolean genderInterest = false;
    if (genderInterestInt == 1) {
      genderInterest = false;
    }
    else if (genderInterestInt == 2) {
      genderInterest = true;
    }

    Profile userProfile = new Profile(firstName, lastName, age, gender);


    /**
    *Setting up profiles to be displayed to the user
    */
    Profile profile1 = new Profile("Ryan", "Last", 34, false);
    Profile profile2 = new Profile("Justin", "Last", 19, false);
    Profile profile3 = new Profile("Oliver", "Last", 24, false);
    Profile profile4 = new Profile("Troy", "Last", 28, false);
    Profile profile5 = new Profile("Wilbur", "Last", 22, false);
    Profile profile6 = new Profile("Wylie", "Last", 23, true);
    Profile profile7 = new Profile("Kayla", "Last", 20, true);
    Profile profile8 = new Profile("Taylor", "Last", 27, true);
    Profile profile9 = new Profile("Tiffany", "Last", 31, true);
    Profile profile10 = new Profile("Evy", "Last", 19, true);
    profile1.swipeRight(userProfile);
    profile2.swipeRight(userProfile);
    profile4.swipeRight(userProfile);
    profile5.swipeRight(userProfile);
    profile7.swipeRight(userProfile);
    profile8.swipeRight(userProfile);
    profile10.swipeRight(userProfile);
    profile3.swipeLeft(userProfile);
    profile6.swipeLeft(userProfile);
    profile9.swipeLeft(userProfile);


    /**
    *Displays profiles based on the user's gender interest
    */
    System.out.println("Displaying profiles. ");
    for (int i = 0; i < Profile.allProfiles.size(); ++i) {                                    //iterates through all profiles creates and skips the one the user made
      if (Profile.allProfiles.get(i) == userProfile) {
        continue;
      }
      else if (Profile.allProfiles.get(i).getGender() == genderInterest) {                    //iterates through all profiles to created to find profile with correct gender interest
        Profile.allProfiles.get(i).displayProfile();
        System.out.println(Profile.allProfiles.get(i).displayProfile());                      //finds profile with correct gender interest and displays it to be swiped
        System.out.println("Swipe right(1) or left(2): ");
        int swipe = scnr.nextInt();
        if (swipe == 1) {
          userProfile.swipeRight(Profile.allProfiles.get(i));
        }
        else if (swipe == 2) {
          userProfile.swipeLeft(Profile.allProfiles.get(i));
        }
      }
    }

    /**
    *user has gone through all potentials and are looking at the results
    */
    System.out.println("See your likes: ");
    System.out.print("  " + userProfile.getLikedUsers().toString());
    System.out.println();
    System.out.println("See your passes: ");
    System.out.print("  " + userProfile.getDisikedUsers().toString());
    System.out.println();
    System.out.println("See your matches: ");
    System.out.print("  " + userProfile.getMatches().toString());
  }
}
