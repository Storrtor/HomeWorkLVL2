package HomeWork1;

public class Cat implements Passable{
    private String name;

    private static final int LIMIT_HIGH = 10;
    private static final int LIMIT_LENGTH = 600;

    public Cat(String name) {
        this.name = name;
    }


    @Override
    public boolean jump(HighObstacle highObstacle) {
        if(highObstacle.getParameter() > LIMIT_HIGH){
            System.out.println(this.name + " не перепрыгнул препятствие высотой " + highObstacle.getParameter());
            return false;
        } else {
            System.out.println(this.name + " перепрыгнул препятствие высотой " + highObstacle.getParameter());
            return true;
        }
    }

    @Override
    public boolean run(LengthObstacle lengthObstacle) {
        if(lengthObstacle.getParameter() > LIMIT_LENGTH){
            System.out.println(this.name + " не пробежал препятствие длиной " + lengthObstacle.getParameter());
            return false;
        } else {
            System.out.println(this.name + " пробежал дорожку длиной " + lengthObstacle.getParameter());
            return true;
        }
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean swim(WaterObstacle waterObstacle) {
        if(waterObstacle.getParameter() > LIMIT_LENGTH){
            System.out.println(this.name + " не переплыл водный обьект длиной " + waterObstacle.getParameter());
            return false;
        } else {
            System.out.println(this.name + " переплыл водный обьект длиной " + waterObstacle.getParameter());
            return true;
        }
    }
}
