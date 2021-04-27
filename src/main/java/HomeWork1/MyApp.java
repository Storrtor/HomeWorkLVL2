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

        Runable runnners[] = new Runable[]{bot, cat, human};
        for (Runable runner : runnners) {
            runner.run();
            ((Jumpable) runner).jump();
        }


        System.out.println("------");

        /**
         * 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые,
         * участники должны выполнять соответствующие действия (бежать или прыгать),
         * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
         */
        HighObstacle wall = new Wall(10000);
        HighObstacle wall1 = new Wall(7);
        HighObstacle wall2 = new Wall(1);
        LengthObstacle treadmill = new Treadmill(600);
        LengthObstacle treadmill1 = new Treadmill(7);
        LengthObstacle treadmill2 = new Treadmill(1);

        for (Runable runnner : runnners) {
            runnner.run(treadmill);
            ((Jumpable) runnner).jump(wall);
        }

        Obstacle obstacles[] = new Obstacle[]{wall, treadmill, wall1,treadmill2,wall2,treadmill1};

        bot.jump(wall);
        bot.run(treadmill);


        /**
         * 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
         *
         * 4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
         * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
         */

        for (Runable runner : runnners) {
            for (Obstacle obstacle : obstacles) {
                runner.pass(obstacle);
                if (runner.canPass(obstacle) == false){
                    break;
                }
            }
        }

        for (Runable runner : runnners) {
            System.out.println("-------");
            System.out.println("Забег " + runner);
            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof LengthObstacle){
                    runner.run((LengthObstacle) obstacle);
                    if(runner.validate((LengthObstacle) obstacle) == false) {
                        break;
                    }
                } else {
                    ((Jumpable) runner).jump((HighObstacle) obstacle);
                    if(((Jumpable)runner).validate((HighObstacle) obstacle) == false) {
                        break;
                    }
                }
            }
        }

    }
}
