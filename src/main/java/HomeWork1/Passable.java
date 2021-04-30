package HomeWork1;

public interface Passable extends Runable, Jumpable{

    default boolean overtake(Obstacle obstacle){
        if(obstacle instanceof HighObstacle){
            return jump((HighObstacle) obstacle);
        } else if(obstacle instanceof LengthObstacle){
            return run((LengthObstacle) obstacle);
        } else {
            throw new RuntimeException("Иначе нельзя");
        }
    }

}
