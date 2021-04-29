package HomeWork1;

public interface Jumpable  extends Passable{
    default void jump(){
        System.out.println("прыгнул");
    }

    @Override
    default boolean overtake(Obstacle obstacle) {
        return jump((HighObstacle) obstacle);
    }

    default boolean jump(HighObstacle highObstacle){
        if (validate(highObstacle) == true){
            System.out.println("Перепрыгнул препятствие");
            return true;
        } else {
            System.out.println("Не перепрыгнул препятствие");
            return false;
        }
    }

    default boolean validate(HighObstacle obstacle){
        return true;
    }
}
