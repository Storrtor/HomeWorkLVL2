package HomeWork1;

public class Human implements Jumpable,Runable{
    private String name;

    public Human(String name) {
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
        if(obstacle.getParameter() > 700){
            return false;
        }
        return Jumpable.super.canPass(obstacle);
    }

    @Override
    public boolean validate(HighObstacle highObstacle) {
        if(highObstacle.getParameter() > 5){
            return false;
        }
        return Jumpable.super.validate(highObstacle);
    }

    @Override
    public boolean validate(LengthObstacle lengthObstacle) {
        if(lengthObstacle.getParameter() > 400){
            return false;
        }
        return Runable.super.validate(lengthObstacle);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
