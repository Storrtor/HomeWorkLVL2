package HomeWork1;

public class Treadmill {
    private int length;

    public Treadmill(int length) {
        validate(length);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        validate(length);
        this.length = length;
    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }

    public void validate(int length){
        if(length < 0 || length > 1000) {
            throw new IllegalArgumentException("Дорожка может быть длиной от 0 до 1000");
        }
    }


}
