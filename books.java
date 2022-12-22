package com.example.secondsemesterfinalproject2ndtime;

public class books {
    public String bookname;
    public String authorname;
    public int edition;


    public books(String bookname, String authorname, int edition) {
        this.bookname = bookname;
        this.authorname = authorname;
        this.edition = edition;

    }





    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }



    @Override
    public String toString() {
        return "bookname: " + bookname + '\n' +
                "authorname: " + authorname + '\n' +
                "edition: " + edition+ "\n"
                ;
    }
}
