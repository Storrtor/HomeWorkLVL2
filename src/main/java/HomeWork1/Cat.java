package HomeWork1;

public class Cat implements Runable, Jumpable{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println(this.name + " прыгнул");
    }

    @Override
    public void run() {
        System.out.println(this.name + " пробежал");
    }

    @Override
    public void jump(HighObstacle highObstacle) {
        if(validate(highObstacle) == true){
            System.out.println(this.name + " перепрыгнул препятствие высотой " + highObstacle.getParameter());
        } else {
            System.out.println(this.name + " не перепрыгнул препятствие высотой " + highObstacle.getParameter());
        }

    }

    @Override
    public void run(LengthObstacle lengthObstacle) {
        if(validate(lengthObstacle) == true){
            System.out.println(this.name + " пробежал дорожку длиной " + lengthObstacle.getParameter());
        } else {
            System.out.println(this.name + " не пробежал препятствие высотой " + lengthObstacle.getParameter());
        }
    }

    @Override
    public boolean canPass(Obstacle obstacle) {
        if(obstacle.getParameter() > 1000){
            return false;
        }
        return Jumpable.super.canPass(obstacle);
    }

    @Override
    public boolean validate(HighObstacle highObstacle) {
        if(highObstacle.getParameter() > 10){
            return false;
        }
        return Jumpable.super.validate(highObstacle);
    }

    @Override
    public boolean validate(LengthObstacle lengthObstacle) {
        if(lengthObstacle.getParameter() > 600){
            return false;
        }
        return Runable.super.validate(lengthObstacle);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
