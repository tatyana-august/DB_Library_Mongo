package ru.unn.db.Library.model;

public enum SearchType {
    NAME("Поиск по названию"),
    AUTHOR("Поиск по автору"),
    GENRE("Поиск по жанру");

    private  String text;

    SearchType(String txt){
        text=txt;
    }
    public String toString(){
        return text;
    }


}
