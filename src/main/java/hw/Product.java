package hw;

public abstract class Product implements Remains{
    protected int lot; //номер лота
    protected String title; //название
    protected String description; //описание
    protected double price; //цена
    protected int remain; //остаток

    public int getRemain() {
        return remain;
    }
    public void setRemain(int remain) {
        this.remain = remain;
    }
}



