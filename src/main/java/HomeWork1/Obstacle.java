package HomeWork1;

abstract class Obstacle {
    private int parameter;

    public Obstacle(int parameter) {
        validation(parameter);
        this.parameter = parameter;
    }

    public int getParameter() {
        return parameter;
    }

    public void validation(int parameter){
        if (parameter < 0){
            throw new IllegalArgumentException("Нельзя сделать отрицательное препятствие");
        }
    }
}
