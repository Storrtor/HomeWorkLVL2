package HomeWork1;

public interface Passable {
    default void pass(Obstacle obstacle){
        if (canPass(obstacle) == true){
            System.out.println("Преодолел препятствие");
        } else {
            System.out.println("Не преодолел препятствие");
        }
    }

    default boolean canPass(Obstacle obstacle){
        return true;
    }
}
