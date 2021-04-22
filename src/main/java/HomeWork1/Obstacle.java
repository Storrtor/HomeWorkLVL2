package HomeWork1;

public abstract class Obstacle {

    public void validate(int parameter){
        if(parameter < 0) {
            throw new IllegalArgumentException("Отрицательным быть не может");
        }
    }


}
