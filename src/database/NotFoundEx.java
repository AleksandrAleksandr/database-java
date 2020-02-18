package database;

public class NotFoundEx extends Exception{
    private String detail;

    NotFoundEx(String detail_){ detail = detail_; }

    public String toString(){ return "[not found exception] " + detail; }

}
