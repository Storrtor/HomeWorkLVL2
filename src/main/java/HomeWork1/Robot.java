package HomeWork1;

public class Robot implements Passable {
    private String name;

    private static final int LIMIT_HIGH = 15;
    private static final int LIMIT_LENGTH = 800;

    public Robot(String name) {
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
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }
}
