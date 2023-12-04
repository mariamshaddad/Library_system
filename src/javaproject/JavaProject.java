
package javaproject;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
public class JavaProject {
    
    
//public static void signIn(int usertype, String username,String password){
//    
//    
//        String filename="User.txt";
//        int userIndex=1;
//        boolean userTypeFound= false;
//        
//        try(BufferedReader reader= new BufferedReader(new FileReader(filename))){
//            String line;
//            //while (file not empty)
//            while((line=reader.readLine())!=null){
//                if(line.equals("-")){
//                    userIndex++;
//                    
//                
//                if(++userIndex==usertype){
//                    
//                    userTypeFound=true;
//                }
//                continue;
//                }
//            
//            if(userTypeFound){
//                //creates a string array and puts each word into an index splits words by whitespace
//                String[] parts= line.split(" ");
//                if(parts.length>=3&&parts[0].equalsIgnoreCase(username)){
//                   
//                    System.out.println("Useername Correct");
//                    if(parts[2].equals(password))
//                    {
//                        System.out.println("Password Correct");
//                        
//                    }
//                    
//                    return;}
//                else{
//                    
//                    break;
//                }
//            }
//            }
//            
//            System.out.println("Error: invalid username or password");
//            
//        }catch(IOException e){
//            System.out.println("Error: " + e.getMessage());
//        }
//         
//    }
 


//    public static void signIn(int usertype, String username, String password) {
//        String filename = "User.txt";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            int currentUserType = 0;
//
//            // Iterate through each line in the file
//            while ((line = reader.readLine()) != null) {
//                if (line.equals("-")) {
//                    currentUserType++;
//                    continue;
//                }
//
//                if (currentUserType == usertype) {
//                    String[] parts = line.split(" ");
//                    System.out.println(parts[0]+" "+parts[2]);
//                    if (parts.length >= 3 && parts[0].equalsIgnoreCase(username) && parts[2].equals(password)) {
//                        System.out.println("Username and password are correct.");
//                        return;
//                    } else {
//                        System.out.println("Error: Invalid username or password.");
//                        return;
//                    }
//                }
//            }
//
//            // If the loop completes without finding the user type, print an error message
//            System.out.println("Error: User type not found.");
//
//        } catch (IOException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
//
//    
public static void signIn(int usertype, String username,String password,
    
    ArrayList<Borrower> borrowers,ArrayList<Admin> admins,ArrayList<Librarian> librarians){
    
    switch(usertype){
        
        case 1: 
            //borrower
            for(Borrower borrower: borrowers){
                
              if(borrower.getName().equalsIgnoreCase(username)&& borrower.getPass().equals(password))  {
                  System.out.println(" borrower Username and password are correct.");
                  return;
              }
                
                
                
            }
        break;
        
        case 2:
            //librarian
            for(Librarian librarian: librarians){
                
              if(librarian.getName().equalsIgnoreCase(username)&& librarian.getPass().equals(password))  {
                  System.out.println(" librarian Username and password are correct.");
                  return;
              }
                
                
                
            }
        break;
        case 3:
        for(Admin admin : admins){
                
              if(admin.getName().equalsIgnoreCase(username)&& admin.getPass().equals(password))  {
                  System.out.println(" admin Username and password are correct.");
                  return;
              }
                
                
                
            }
        break;
        default:
        System.out.println(" user type incorrect.");
        return;
    }
        
    System.out.println(" incorrect username or password.");
      return;
}

    public static void main(String[] args) throws IOException{
//    try {
//        User.deserializeData();
//    } catch (FileNotFoundException | ClassNotFoundException ex) {
//        Logger.getLogger(JavaProject.class.getName()).log(Level.SEVERE, null, ex);
//    }
        ArrayList<Borrower> borrowers = new ArrayList<>();
        ArrayList<Librarian> librarians = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();

       String password;
        Admin admin=new Admin(); //to call non static methods 
        Supplier supplier=new Supplier();
        Librarian librarian=new Librarian();
        Librarian_Mgn manage=new Librarian_Mgn();
         User borrower;  
Borrower borrower1 = new Borrower("Borrower1", "Password1");
        Borrower borrower2 = new Borrower("Borrower2", "Password2");
        Librarian librarian1 = new Librarian("Librarian1", "Password1");
        Admin admin1 = new Admin("Admin1", "Password4");
        borrowers.add(borrower1);
        borrowers.add(borrower2);
        librarians.add(librarian1);
        admins.add(admin1);
   Scanner input=new Scanner(System.in);
         //executes loop till break is found 
         while(true){
             System.out.println("1.sign in \n2.sign up \n3. exit");
             int choice= input.nextInt();
             input.nextLine(); //3ashan next iteration ye2ra sah from the next line ashan lw el user dakhal input characters aw haga kda el mara el ablaha
             //if (choice == 3) break;
             
             System.out.println("Do you want to enter as: 1-Borrower 2-Librarian 3-Admin ");
             int usertype= input.nextInt();
             input.nextLine();
             
              System.out.println("Enter username:");
              String userName=input.nextLine();
             
              
              if(userName.isEmpty()){
                  System.out.println("Error: username can't be empty");
                  continue; //skips the rest of the loop and goes back to the beginning
                  
              }
              System.out.println("Enter password");
               password= input.nextLine();
                User username= new Borrower(userName,password);
              if(password.length()<=0){
                  System.out.println("Error: password can't be empty or negative");
                  continue; //skips the rest of the loop and goes back to the beginning
                  
              }
              switch(choice){
                  //sign in 
                  case 1:
                  
                  signIn(usertype,userName,password,borrowers,admins,librarians); //1 borrower 2-librarian 3-admin
                  switch(usertype){
                      case 1:
                               int choice1;
                               //User u=new Borrower("Mariam",password); 
        do {
            System.out.println("Menu:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Edit name");
            System.out.println("4. rate a Book");
            System.out.println("5. View ratings of a Book");
            System.out.println("6. Display borrower information");
            System.out.println("7. Total number of borrowings you added so far");
            System.out.println("8: Return  book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
           //Scanner input= new Scanner(System.in);
            choice1=input.nextInt(); // Consume the newline character
input.nextLine();
            switch (choice1) {
                case 1:
                       Book book1 = new Book("Title 1", "Author 1", "Category 1");
        Book book2 = new Book("Title 2", "Author 2", "Category 2");

        // Adding books
        Book.addBook(book1);
        Book.addBook(book2);
                    Book.listBooks();
                    System.out.print("Enter the title of the book to borrow: ");
                   // System.out.println();
                    String borrowTitle = input.nextLine();
                    username.borrowBook(borrowTitle);
                    while(choice ==1){
                      System.out.println("Do you want to borrow book again? "+"\n 1. Yes\n 2. No");
                      
                    choice=input.nextInt();
                    input.nextLine();
                    if(choice==1){
                        Book.listBooks();
                        System.out.print("Enter the title of the book to borrow: ");
                     borrowTitle = input.nextLine();
                     username.borrowBook(borrowTitle);
                    }
                    else{
                        break;
                    }
                    }
                    
                    break;
                case 2:
                    Book book=null; //not sure
                    System.out.println("The book you currently borrowed");
                    username.ListBorrowed();
                    System.out.print("Enter the title of the book to return: ");
                    String Title = input.nextLine();
//                    Book bookToReturn=Book.findBookByTitle(Title);
//                    book.returnBook(bookToReturn);
                    break;
                case 3:
                    System.out.print("Enter the new name: ");
                    String newName = input.nextLine();
                    username.editName(newName);
                    break;
                case 4:
                    //int rating=0;
                    Book.listBooks();
                    System.out.println();
                    System.out.println("Rate a book");
                    System.out.println("Which book do you want to rate");
                   //input.nextLine(); //possible whitepsace
                    Title=input.nextLine();
                    System.out.println("On a scale of 1 to 5, how do you want to rate the book");
                    int rating=input.nextInt();
                    input.nextLine();
                    username.rateBook(Title,rating);
                    break;
                case 5:
                    System.out.println("Which book do you want view its rating");
                   //input.nextLine();//consume newline
                    Title=input.nextLine();
                    username.displayAllRatings(Title);
                  //  username.writeRatingsToFile(Title);
                    
                    break;
                case 6:
                    System.out.println("Displaying your information: ");
                    System.out.println();
                    username.display();
                    break;
                case 7:
                    System.out.println("Total number of borrowings you added so far");
                    System.out.println(username.getNumberOfBorrowings());
                    break;
                case 8:
                    System.out.println("Total number of borrowings you added so far");
                    System.out.println(username.getNumberOfBorrowings());
                break;
                case 9:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 9);
                          break;
                          
                      case 2:
                System.out.println("Welcome librarian "+userName);
                System.out.println(" Menu: ");
                System.out.println("1.edit Info");
                System.out.println("2.search librarian");
                System.out.println("3. list librarians ");
                System.out.println("4. number of borrowings");
                System.out.println("5. librarian with max revenue");
                System.out.println("6.librarian with max borrowings");
                System.out.println("7.list books");
                 choice=input.nextInt();
                switch(choice){
                    case 1: 
                   
                        String answer="yes";
                        
                       while(answer.equalsIgnoreCase("yes")){
                           System.out.println("Hi, "+ username+" what would you like to edit: your user name or password ");
                           String choice2=input.nextLine();
                           boolean found=false;
                           // ArrayList<Librarian>
                           librarians=Librarian.getLibrarians();
                           for(int i=0;i<librarians.size();i++){
                              // Librarian librarian=librarians.get(i);
                               if( librarian.getUserName().equals(username)&& librarian.getPassword().equals(password)){
                
                    found=true;
                           
                           switch(choice2.toLowerCase()){
                               case "user name":
                                   System.out.println("please enter your new user name");
                                   userName=input.nextLine();
                                   librarian.setUserName(userName);
                                    librarian.editLibrarian(librarian);
                                   break;
                                   
                               case "password":
                                    System.out.println("please enter your new password");
                                    password=input.nextLine();
                                    librarian.setPassword(password);
                                     librarian.editLibrarian(librarian);
                                    break;
                                 
                                     default:
                            System.out.println("The choice you entered is invalid. Please enter either user name, password or phone number.");
                            break;
                           }
                           }
                           }
                           if(!found){
                               System.out.println("no librarian was found in the system by this user name");
                           }
                           System.out.println("Would you like to edit anything else?");
                           answer=input.nextLine();
                          
        
    }
                    case 2:
                        System.out.println("Please enter the user name of the librarian you want to find.");
                        String name=input.nextLine();
                        Librarian.searchLibrarian(name);
                        break;
                        
                    case 3:
                        System.out.println("Librarians in the system: ");
                        Librarian.listLibrarians();
                        break;
                        
                    case 4:
                        Librarian.getNumOfBorrowings();
                        break;
                        
                    case 5:
                        Librarian.getLibrarianWithMaxRev();
                        break;
                        
                    case 6:
                        Librarian.getLibrarianWithMaxNumOfBorrowings();
                        break;
                    case 7:
                        Book.listBooks();
                        break;
                        
                    default: 
                        System.out.println("choice you entered is invalid");
                }
                //Librarian.saveToFile();
//                filename="librarians.txt";
                     break;
                          
                      case 3: //pass el admin fixed w ha chech hena 3aliha
                            Book book1 = new Book("Title 1", "Author 1", "Category 1");
        Book book2 = new Book("Title 2", "Author 2", "Category 2");

        // Adding books
        Book.addBook(book1);
        Book.addBook(book2);
        Scanner bookinput= new Scanner(System.in);
       do{
            
            System.out.println("1: Add User"); 
            System.out.println("2: edit user"); 
            System.out.println("3: search for a user"); 
            System.out.println("4: Add book"); 
            System.out.println("5: Add Supplier"); 
            System.out.println("6: List books");
            System.out.println("7: search book");
            System.out.println("8: Edit book");
            System.out.println("9: Remove book");
            System.out.println("10: Add Order"); 
            System.out.println("11: Remove Supplier"); 
            System.out.println("12: Search supplier.");
            System.out.println("13: Display supplier Info.");
            System.out.println("14: Display All suppliers.");
            System.out.println("15: Edit supplier.");
            System.out.println("16: View Supplier Orders"); 
            System.out.println("17: View Total Revenue"); 
            System.out.println("18: View Average Revenue"); 
            System.out.println("19: View Supplier with Max Orders"); 
            System.out.println("20: View Supplier with Max Revenue");
            System.out.println("21: View borrowing term details");
            System.out.println("22: Add admin"); //lesa ma7tnha4
            System.out.println("23: View all borrowers");
            System.out.println("24: Exit");
            int choose=bookinput.nextInt();
            bookinput.nextLine();
        
        switch(choose){

                case 1:
//Add User
        System.out.println("Enter the name of the new user:");
        String newName = input.next();

        System.out.println("Enter the password for the new user:");
        String newPassword = input.next();
        User newUser = new User(newName, newPassword);
        admin.addUser(newUser);
        //admin.saveToFile(newName);
        Admin.saveToFile(); // added for updates

        System.out.println("User added successfully.");
  break;
                case 2: 
               //Edit User
    System.out.print("Enter user name to edit: ");
    String Name = input.next();
    System.out.print("Enter field to edit (name/password): ");
    String Field = input.next();
    System.out.print("Enter new value: ");
    String newValue = input.next();
    admin.editUser(Name, Field, newValue);
    
                    break; 

                    

                case 3: 
                   //Search For A User
  System.out.print("Enter field to search by (id/name): ");
    String searchField = input.next();
    System.out.print("Enter "+searchField+" to search for: ");
    String searchValue = input.next();
    List<User> searchresult = admin.searchUsers(searchField, searchValue);
    
    if (!searchresult.isEmpty()) {
        System.out.println("Search results:");
        for (User result : searchresult) {
            System.out.println("Name: " + result.getName() + ", Password: " + result.getPass());
        }
    } else {
        System.out.println("No matching users found.");
    }
    break;

            case 4: 
                System.out.println("Enter title:");
                String title= bookinput.nextLine();
                System.out.println("Enter author's name:");
                String author= bookinput.nextLine();
                System.out.println("Enter category:");
                String category= bookinput.nextLine();
                Book book= new Book(title,author,category);
            Book.addBook(book);
            System.out.println("List of books:");
             Book.listBooks();
            break;
            
            

                case 5: 

                    // Add Supplier 

                        // Add Supplier 
            System.out.println("Enter information for Supplier:");
            System.out.print("Enter supplier name: ");
            String supplierName = input.nextLine();

            // Check if the supplier already exists
            if (!admin.searchSupplier(supplierName)) {
                System.out.print("Enter supplier Password: ");
                 password = input.next();
                int numOfOrders = 0;
                double revenue = 0.0;
//                      admin.addSupplier(supplierName, password, numOfOrders, revenue);
             
            }
            else{
            System.out.print("Supplier already exists.");
            }
            admin.saveToFile(supplierName);

                    break; 

            case 6:
            System.out.println("List of books:");
             Book.listBooks();
            break;
            case 7:
             System.out.println("Enter title to search:");    
              String searchTitle= bookinput.nextLine();
                
                Book foundBook = Book.searchBook(searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook.getTitle());
        }
        else{
                 System.out.println("Book not found ");
        }
        System.out.println("List of books:");
             Book.listBooks();
                break;
                
            case 8:
                System.out.println("Enter title of the book you want to edit ");
                String editTitle= bookinput.nextLine();
                Book bookToEdit = Book.searchBook(editTitle);
                if (bookToEdit!=null){
                   
                    Book.editBook(bookToEdit);
                }
                else{
                 System.out.println("Book not found ");
        }
                System.out.println("List of books:");
             Book.listBooks();
                break;
                
                
            case 9:
                System.out.println("Enter title of the book you want to remove ");
                String removeTitle= bookinput.nextLine();
                Book bookToRemove = Book.searchBook(removeTitle);
                if (bookToRemove!=null){
                   
                    Book.removeBook(bookToRemove);
                }
                else{
                 System.out.println("Book not found ");
        }
                System.out.println("List of books:");
             Book.listBooks();
                break;
            

                case 10:
                    //Add Order
                    String sName;

                    supplier.displayAllSuppliers();
                    System.out.println("Enter the name of the supplier you want to order from");
                    sName= input.next();
                    librarian.addOrder(sName);
                    supplier.recieveOrder(sName);
                    admin.saveToFile(sName);
                    
                    
                    
                    break;
                case 11:
                    //Remove Supplier
                    
                  String removedSupplier;
                  supplier.displayAllSuppliers();
                  System.out.println("which supplier would you like to remove.");
                  removedSupplier=input.next();
                  admin.removeSupplier(removedSupplier);
                    break;
                case 12:
                    //Search Supplier
                    String SName;
                    System.out.println("Which supplier are you looking for?");
                    SName=input.next();
                    if(admin.searchSupplier(SName)){
                    System.out.println("Supplier found");
                    }
                    else{
                        System.out.println("Supplier not found");
                    }
                    break;
                    
                case 13:
                    //Display a specific supplier info
                    String Dname;
                     System.out.println("Which supplier do you want to display thier file?");
                    Dname=input.next();
                 //   admin.displaySupplierInfo(Dname);
                    
                    break;
                case 14:
                    //display all suppliers info
                 //   admin.displayAllSuppliers();
                    break;
                case 15:
                    // Edit Supplier
                     String Ename;
                     System.out.println("Which supplier do you want to edit");
                     Ename=input.next();
                     supplier.editSupplier(Ename);
                     break;
                     
                case 16:
                    //View Supplier Orders
                     String Vname;
                     System.out.println("Which supplier do you want to view their order");
                     Vname=input.next();
                     supplier.SupplierOrders(Vname);
                    
                    break;
                case 17: 

                    // View Total Revenue 

                    System.out.println("Total Revenue: " + admin.getTotalRevenue()); 

                    break; 

  

                case 18: 

                    // View Average Revenue 

                    System.out.println("Average Revenue: " + admin.getAverageRevenue()); 

                    break; 

  

                case 19: 

                    // View Supplier with Max Orders 

                    System.out.println("Supplier with Max Orders: " + admin.getSupplierWithMaxOrders()); 

                    break; 

  

                case 20: 

                    // View Supplier with Max Revenue 

                    System.out.println("Supplier with Max Revenue: " + admin.getSupplierWithMaxRevenue()); 

                    break; 
case 21:
    
                     Borrower b=new Borrower();
         List<User> u=b.readFromFile(); 
                   
                    for(User i:u)
                    {
                        
                         admin.specifyBorrowingTermDetails(i); 
                    }
                    break;
                        
case 22:
    
    System.out.println("Enter the name of the new user:");
        String Names = input.next();

        System.out.println("Enter the password for the new user:");
        String Password = input.next();
        
        admin.addAdmin(Names, Password);
        admin.saveAllAdminsToFile();
        System.out.println("User added successfully.");
            break;
           
                case 23:
                System.out.println("Exiting..");
                bookinput.close();
                return;
            default:
                System.out.println("Invalid input please enter a number from 1 to 6");
                break;
            
        } 
        }while (choice != 23);
                  }
  }
         }
}
    
}