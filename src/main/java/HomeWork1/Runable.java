package HomeWork1;

public interface Runable extends Passable{
    default void run(){
        System.out.println("пробежал");
    }

    default void run(LengthObstacle lengthObstacle){
        if (validate(lengthObstacle) == true){
            System.out.println("Пробежал препятствие");
        } else {
            System.out.println("Не пробежал препятствие");
        }
    }

    default boolean validate(LengthObstacle obstacle){
        return true;
    }

}
