package HomeWork1;

public interface Runable  {

    boolean run(LengthObstacle lengthObstacle);




//    default void run(){
//        System.out.println("пробежал");
//    }
//
//    @Override
//    default boolean overtake(Obstacle obstacle) {
//        return run((LengthObstacle) obstacle);
//    }
//
//    default boolean run(LengthObstacle lengthObstacle){
//        if (validate(lengthObstacle) == true){
//            System.out.println("Пробежал препятствие");
//            return true;
//        } else {
//            System.out.println("Не пробежал препятствие");
//            return false;
//        }
//    }
//
//    default boolean validate(LengthObstacle obstacle){
//        return true;
//    }

}
