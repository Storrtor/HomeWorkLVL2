package HomeWork1;

public interface Passable extends Runable, Jumpable, Swaimable{

    default boolean overtake(Obstacle obstacle){
        if(obstacle instanceof HighObstacle){
            return jump((HighObstacle) obstacle);
        } else if(obstacle instanceof LengthObstacle){
            return run((LengthObstacle) obstacle);
        } else if (obstacle instanceof WaterObstacle){
            return swim((WaterObstacle)obstacle);
        } else {
            throw new RuntimeException("Иначе нельзя");
        }
    }

}
