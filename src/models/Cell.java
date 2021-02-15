package models;

public class Cell {
    private String value; // "", "X", "O"
    public Cell () {
        this.value = "";
    }

    public boolean isSet () {
        return this.value != "";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
