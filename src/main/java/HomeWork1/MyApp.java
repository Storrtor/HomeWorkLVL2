package HomeWork1;

public class MyApp {
    public static void main(String[] args) {
        /**
         *1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
         * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
         */

        Robot bot = new Robot("Robot");
        Cat cat = new Cat("Cat");
        Human human = new Human("Human");

        /**
         * 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые,
         * участники должны выполнять соответствующие действия (бежать или прыгать),
         * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
         */
        HighObstacle wall = new Wall(1);
        HighObstacle wall1 = new Wall(5);
        HighObstacle wall2 = new Wall(10);
        LengthObstacle treadmill = new Treadmill(100);
        LengthObstacle treadmill1 = new Treadmill(500);
        LengthObstacle treadmill2 = new Treadmill(700);


        Runable runnners[] = new Runable[]{bot, cat, human};
        Obstacle obstacles[] = new Obstacle[]{wall, treadmill, wall1, treadmill2, wall2, treadmill1};

         /**
         * 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
         *
         * 4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
         * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
         */

        for (Runable runner : runnners) {
            System.out.println("-------");
            System.out.println("Забег " + runner);
            for (Obstacle obstacle : obstacles) {
                if(runner.overtake(obstacle) == false){
                    break;
                }
            }
        }
    }

}
