package HomeWork1;

public class Wall {

    private int high;

    public Wall(int high) {
        validate(high);
        this.high = high;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        validate(high);
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
    public void validate(int high){
        if(high < 0 || high > 15) {
            throw new IllegalArgumentException("Стена может быть высотой от 0 до 15 метров");
        }
    }
}
