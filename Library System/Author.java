package librarysystem;
public class Author implements Person{
    private String AuthorName ;
    private int AuthorSalary;
    Date DateOfBirthAuthor;
    private int NumOfBooks ;
    Book [] books;
    public Author(){}
    public Author(String AuthorName,int NumOfBooks,Date DateOfBirthAuthor )
    {
        this.AuthorName = AuthorName;
        this.NumOfBooks = NumOfBooks;
        this.DateOfBirthAuthor = DateOfBirthAuthor;
        books = new Book[NumOfBooks];
    }
    public void setAuthorName(String AuthorName){
        this.AuthorName = AuthorName;
    }
    public String getAuthorName(){
        return AuthorName;
    }
    public void setNumOfBooks(int NumOfBooks){
        this.NumOfBooks = NumOfBooks;
    }
    public int getNumOfBooks(){
        return NumOfBooks;
    }
    public Book[] getBooksOfAuthor(){
        return books;
    }
    public void addNewBook(Book book){
        books[NumOfBooks] = book;
        NumOfBooks++;
    }
    @Override
    public String toString(){
        return "AuthorName : " + AuthorName +"\n"+ "DateOfBirthAuthor : " + DateOfBirthAuthor.toString() + "\n" +"NumOfBooks : " + NumOfBooks;
    }
    @Override
    public int Salary() {
        return NumOfBooks*AuthorSalary;
    }
    public boolean equals(Object object){ //override .equals method
        if(object instanceof Author && ((Author)object).getAuthorName().compareTo(this.AuthorName)==0)
            return true;
        else 
            return false;
    }
}
