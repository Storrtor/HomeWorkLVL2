package HomeWork1;

public class Wall extends Obstacle {

    private int high;

    public Wall(int high) {
        super.validate(high);
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int hih) {
        super.validate(high);
        this.high = high;
    }

    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "high=" + high +
                '}';
    }
}
