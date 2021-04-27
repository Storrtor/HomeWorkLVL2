package HomeWork1;

public interface Jumpable extends Passable{
    default void jump(){
        System.out.println("прыгнул");
    }

    default void jump(HighObstacle highObstacle){
        if (validate(highObstacle) == true){
            System.out.println("Перепрыгнул препятствие");
        } else {
            System.out.println("Не перепрыгнул препятствие");
        }
    }

    default boolean validate(HighObstacle obstacle){
        return true;
    }
}
