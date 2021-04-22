package HomeWork1;

public class Treadmill extends Obstacle {
    private int length;

    public Treadmill(int length) {
        super.validate(length);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        super.validate(length);
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
}
