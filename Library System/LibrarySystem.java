package librarysystem;
import java.util.*;
import java.io.*;
public class LibrarySystem {
    public static void main(String[] args) throws Exception{
        List<Book> booksList = new ArrayList<>(); // ArrayList Of Books in The Library 
        booksList = new ArrayList<>();
        List<User> usersList = new ArrayList<>();  // ArrayList Of Users in The Library
        usersList = new ArrayList<>();
        PrintWriter Datain = new PrintWriter("Books.txt");
        // fill the database of The books
        booksList.add(new PurchasedBook("123","The DaVinci Code",new Author("danbrown",1,new Date(1,2,1975)),2000,100,150)); 
        booksList.add(new PurchasedBook("122","Le Petit Prince",new Author("Antoine de Saint-Exupéry",1,new Date(1,2,1965)),2001,200,280));
        booksList.add(new ReferenceBook("456","A Tale of Two Cities",new Author("Charles Dickens",1,new Date(2,5,1976)),2004,10,1));
        booksList.add(new ReferenceBook("789","The Lord of the Rings",new Author("John Ronald Reuel Tolkien",1,new Date(4,5,1980)),2003,20,2));
        booksList.add(new ReferenceBook("910","Harry Potter and the Goblet of Fire",new Author("Joanne Rowling",1,new Date(1,6,1977)),2003,20,3));
        for( Book b : booksList){
            Datain.println(b.toString());
        }
        Scanner scan = null ; // Scanner to Scan Data From Library System User
        try{
            PrintWriter writer = new PrintWriter("output.txt");
            scan = new Scanner(new BufferedReader(new FileReader("input.txt")));
            // create a librarian 
            Librarian firstLibrarian = new Librarian();
            writer.println("Welcome To AAST Library :)");
            writer.println("Please Enter Your Data");
            writer.println("Please Enter Your Name :");
            // Data of the librarian
            if(scan.hasNext())
            firstLibrarian.setLibrarianName(scan.next());
            else System.out.println("Please Enter A String");
            writer.println("Please Enter Your Id : ");
            if(scan.hasNext())
            firstLibrarian.setLibrarianId(scan.next());
            else System.out.println("Please Enter A String");
            writer.println("Please Enter Your Password : ");
            if(scan.hasNext())
            firstLibrarian.setLibrarianPassword(scan.next());
            else System.out.println("Please Enter A String");
           // System.out.println(firstLibrarian.toString());
            writer.println("Your Are Successfully In The System :)");
            // num # of Operations on the system
            for(int i=0;scan.hasNext();i++){   
                writer.println("Choose One Of The Following Options");
                writer.println("1) For Users  2) For Books 3) For Else");
                int choice = 0;
                if(scan.hasNextInt()) // exception handling 
                    choice = scan.nextInt();
                else System.out.println("Please Enter A Nubmer");
                if(choice==1){
                    writer.println("Choose One Of The Following Options");
                    writer.println("1) For Add New User  2) For Current User");
                    int choice1 = 0;
                    if(scan.hasNextInt()) // exception handling 
                    choice1 = scan.nextInt();
                    else System.out.println("Please Enter A Number");
                    if(choice1==1){
                        writer.println("Choose One Of The Following Options");
                        writer.println("1) For Faculty  2) For Student");
                        int choice11 = 0;
                        if(scan.hasNextInt()) // exception handling 
                        choice11= scan.nextInt();
                        else System.out.println("Please Enter A Number");
                        if(choice11==1){
                            Faculty faculty =  new Faculty("","","","","");
                            writer.println("Please Enter UserData");
                            writer.println("Please Enter UserName");
                            String facultyData = "";
                            if(scan.hasNext())// exception handling 
                            facultyData = scan.next();
                            else System.out.println("Please Enter A String");
                            faculty.setName(facultyData);
                            writer.println("Please Enter UserId");
                            if(scan.hasNext())// exception handling 
                            facultyData = scan.next();
                            else System.out.println("Please Enter A String");
                            faculty.setUserId(facultyData);
                            writer.println("Please Enter PhoneNum");
                            if(scan.hasNext())// exception handling 
                            facultyData = scan.next();
                            else System.out.println("Please Enter A String");
                            faculty.setPhoneNum(facultyData);
                            writer.println("Please Enter Address");
                            if(scan.hasNext())// exception handling 
                            facultyData = scan.next();
                            else System.out.println("Please Enter A String");
                            faculty.setAddress(facultyData);
                            writer.println("Please Enter Degree");
                            if(scan.hasNext())// exception handling 
                            facultyData = scan.next();
                            else System.out.println("Please Enter A String");
                            faculty.setDegree(facultyData);
                            usersList.add(faculty);
                        }else if(choice11==2){
                            Student student =  new Student(); // create object of class student 
                            writer.println("Please Enter UserData");
                            writer.println("Please Enter UserName");
                            String StudentData="";
                            if(scan.hasNext())// exception handling 
                            StudentData = scan.next();
                            else System.out.println("Please Enter A String");
                            student.setName(StudentData);
                            writer.println("Please Enter UserId");
                            if(scan.hasNext())// exception handling 
                            StudentData = scan.next();
                            student.setUserId(StudentData);
                            writer.println("Please Enter PhoneNum");
                            if(scan.hasNext())// exception handling 
                            StudentData = scan.next();
                            else System.out.println("Please Enter A String");
                            student.setPhoneNum(StudentData);
                            writer.println("Please Enter Address");
                            if(scan.hasNext())// exception handling 
                            StudentData = scan.next();
                            else System.out.println("Please Enter A String");
                            student.setAddress(StudentData);
                            writer.println("Please Enter Reg#");
                            if(scan.hasNext())// exception handling 
                            StudentData = scan.next();
                            else System.out.println("Please Enter A String");
                            student.setRegNumber(StudentData);
                            writer.println("Please Enter Term");
                            int StudentTerm;
                            if(scan.hasNextInt())// exception handling 
                            StudentTerm = scan.nextInt();
                            else System.out.println("Please Enter A Number");
                            student.setRegNumber(StudentData);
                            usersList.add(student);
                        }
                    }else if(choice1==2){
                        writer.println("Please Enter UserId");
                        String UserData=""; 
                        if(scan.hasNext())// exception handling 
                        UserData = scan.next();
                        else System.out.println("Please Enter A String");
                        Student student = new Student();
                        student.setUserId(UserData);
                        boolean Flag = false;
                        for (User s : usersList){
                            if(student.equals(s)){
                                writer.println("This User Exists in The DataBase");
                                writer.println("Data Of This User");
                                writer.println(s.toString());
                                writer.println("Choose One Of The Following Options");
                                writer.println("1) For BorrowBook  2) For Purchase  3) For Return Book ");
                                int choice12 = 0;
                                if(scan.hasNext())// exception handling 
                                choice12 = scan.nextInt();
                                else  System.out.println("Please Enter A Number");
                                if(choice12==2){
                                    System.out.println("Please Enter ISBN OF The Book");
                                    String BookISBN ="";
                                    if(scan.hasNext())// exception handling 
                                    BookISBN = scan.next();
                                    else System.out.println("Please Enter A String");
                                    ReferenceBook book =  new ReferenceBook();
                                    boolean flag = true;
                                    book.setISBN(BookISBN);
                                    for (Book b : booksList){ // polymorphism
                                        if(b.equals(book)){
                                            System.out.println("The Book is Available");
                                            flag = false;
                                            System.out.println(b.toString());
                                            s.bookPurchase(b);
                                            b.decrementNumberOfCopies();
                                        }
                                    }
                                    if(flag)
                                        System.out.println("The Book Is Not Available"); // Message 
                                }else if(choice12==1){
                                    System.out.println("Please Enter ISBN OF The Book");
                                    String BookISBN = "";
                                    if(scan.hasNext()) //handle exception 
                                    BookISBN = scan.next();
                                    else System.out.println("Please Enter A String");
                                    PurchasedBook book = new PurchasedBook();
                                    book.setISBN(BookISBN);
                                    boolean flag = true;
                                    for (Book b : booksList){ //polymorphism
                                        if(b.equals(book)){
                                            flag= false;
                                            writer.println("The Book is Available");
                                            writer.println(b.toString());
                                            s.addItem(b);
                                        }
                                    }
                                    if(flag)
                                        writer.println("The Book Is Not Available");
                                }else {
                                    writer.println("Please Enter ISBN OF The Book");
                                    String BookISBN = "" ;
                                    if(scan.hasNext()) // handle exception 
                                    BookISBN = scan.next();
                                    ReferenceBook book = new ReferenceBook();
                                    book.setISBN(BookISBN);
                                    for (Book b : booksList){
                                        if(b.equals(book)&&!b.getStatus()){
                                            writer.println("The Book is Available");
                                            writer.println(b.toString());
                                            s.returnBooks(b);
                                            b.setStatus(true);
                                        }
                                    }
                                }
                            }
                            Flag = true;
                        }
                        if(!Flag){
                            writer.println("This User Doesn't Exist in The DataBase");
                        }
                    }else{
                        return ;
                    }
                }else if(choice==2){
                    writer.println("Choose One Of The Following Options");
                    writer.println("1) For Add New Book  2) For Delete Book");
                    int choice2 = 0;
                    if(scan.hasNextInt()) // handle exception
                    choice2 = scan.nextInt();
                    else System.out.println("Please Enter A Number");
                    if(choice2==1){
                        writer.println("Please Enter The Type Of Book 1) For RefBook and 2) For PurchasedBook");
                        int choice21 = 0;
                        if(scan.hasNextInt()) // hadle exception
                        choice21 = scan.nextInt();
                        else System.out.println("Please Enter A Number");
                        if(choice21==1){
                            /*RunTime Polmorphism or Dynamic Method dispatch*/
                            Book Book = new Book();
                            ReferenceBook book = new ReferenceBook();
                            Book = book;
                            String BookData = "";
                            writer.println("Please Enter The Name Of Book");
                            if(scan.hasNext())
                            BookData = scan.next();
                            else System.out.println("Please Enter A String");
                            Book.setTitle(BookData);
                            writer.println("Please Enter The ISBN Of Book");
                            if(scan.hasNext())
                            BookData = scan.next();
                            else System.out.println("Please Enter A String");
                            Book.setISBN(BookData);
                            writer.println("Please Enter The Data Of The BookAuthor");
                            Author author ;
                            author = new Author((scan.hasNext())?scan.next():null,(scan.hasNextInt())?scan.nextInt():0,new Date((scan.hasNextInt())?scan.nextInt():0,(scan.hasNextInt())?scan.nextInt():0,(scan.hasNextInt())?scan.nextInt():0)); 
                            Book.setBookAuthor(author);
                            writer.println("Please Enter The YearOfPub");
                            int YearOfPubBook = 0;
                            if(scan.hasNextInt())
                            YearOfPubBook = scan.nextInt();
                            else System.out.println("Please Enter A Number");
                            Book.setYearOfPub(YearOfPubBook);
                            writer.println("Please Enter The Fine");
                            int BookFine = 0 ;
                            if(scan.hasNextInt())
                            BookFine = scan.nextInt();
                            else System.out.println("Please Enter A Number");
                            book.setFine(BookFine);
                            booksList.add(book);
                            writer.println("The Book Is Successfully added");
                        }else{
                            /*RunTime Polmorphism or Dynamic Method dispatch*/
                            Book Book = new Book();
                            PurchasedBook book = new PurchasedBook();
                            Book = book;
                            String BookData = "";
                            writer.println("Please Enter The Name Of Book");
                            if(scan.hasNext())
                            BookData = scan.next();
                            else System.out.println("Please Enter A String");
                            Book.setTitle(BookData);
                            writer.println("Please Enter The Id Of Book");
                            if(scan.hasNext())
                            BookData = scan.next();
                            else System.out.println("Please Enter A String");
                            Book.setISBN(BookData);
                            writer.println("Please Enter The Data Of The BookAuthor");
                            Author author = new Author((scan.hasNext())?scan.next():null,(scan.hasNextInt())?scan.nextInt():0,new Date((scan.hasNextInt())?scan.nextInt():0,(scan.hasNextInt())?scan.nextInt():0,(scan.hasNextInt())?scan.nextInt():0)); 
                            Book.setBookAuthor(author);
                            writer.println("Please Enter The YearOfPub");
                            int YearOfPubBook =0;
                            if(scan.hasNextInt())
                            YearOfPubBook = scan.nextInt();
                            else System.out.println("Please Enter A Number");
                            Book.setYearOfPub(YearOfPubBook);
                            writer.println("Please Enter The NumberOfCopies");
                            book.setNumberOfCopies((scan.hasNextInt())?scan.nextInt():0);
                            writer.println("Please Enter The Price");
                            book.setPrice((scan.hasNextInt())?scan.nextInt():0);
                            booksList.add(book);
                        }
                    }else{
                        List<Book> Temp = new ArrayList<>(); // Temp List
                        String BookData;
                        writer.println("Please Enter The ISBN Of Book");
                        BookData = "" ;
                        if(scan.hasNext())
                            BookData = scan.next();
                        else System.out.println("Please Enter A String");
                        Book book;
                        book = new Book();
                        book.setISBN(BookData);
                        for (Book b : booksList){
                            if(b.equals(book)){
                               // System.out.println("YES");
                                continue;
                            }else
                                Temp.add(b);
                        }
                        //System.out.println("NO");
                        booksList.clear();
                        for (Book b : Temp){
                            booksList.add(b);
                        }
                    }
                }else{
                    return ;
                }
                writer.println("Choose One Of The Following Options");
                writer.println("1) For Diplay System Data  2) For Else");
                int choice3 = 0;
                if(scan.hasNextInt())
                    choice3 = scan.nextInt();
                else System.out.println("Please Enter A Number");
                if(choice3==1){
                    writer.println("The Data in The BookList");
                    for (Book b : booksList ){
                        writer.println(b.toString());
                    }
                    writer.println("The Data in The UserList");
                    for (User s : usersList ){
                        writer.println(s.toString());
                    }
                }else{
                    return ;
                }
                writer.println("Choose One Of The Following Options");
                writer.println("1) Continue  2) For Exit");
                int choice4 = 0;
                if(scan.hasNextInt())
                choice4 = scan.nextInt();
                else System.out.println("Please Enter A Number");
                if(choice4==1)
                    continue;
                else
                    break;
            }
            writer.println("Bye");
            writer.close();
            Datain.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Is Not Found");
        }   
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds");
        }
        finally {
            if (scan != null) {
                scan.close();
            }
            
        }
    }
}

