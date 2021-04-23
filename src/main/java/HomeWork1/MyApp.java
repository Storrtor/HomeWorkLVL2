package HomeWork1;

public class MyApp {
    public static void main(String[] args) {

        /**
         * 1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
         * Эти классы должны уметь бегать и прыгать.
         */
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();

        //Массив участников
        Runable runners[] = new Runable[]{human,cat,robot};
        for (Runable runner : runners) {
            runner.run();
            ((Jumpable) runner).jump();
        }

        /**
         * 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые,
         * участники должны выполнять соответствующие действия (бежать или прыгать),
         * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
         */
        Wall wall = new Wall(5);
        Treadmill treadmill = new Treadmill(100);

        Jumpable catJump = new Cat();
        Jumpable humanJump = new Human();//
        Jumpable jumpers[] = new Jumpable[]{catJump, humanJump, robot};
        for (Jumpable jumper : jumpers) {
            jumper.jump(wall);
            ((Runable) jumper).run(treadmill);
        }

        System.out.println("-------");

        /**
         * 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
         *
         * 4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
         * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
         */
        Wall wall1 = new Wall(1);
        Wall wall2 = new Wall(2);
        Wall wall3 = new Wall(4);

        Treadmill treadmill1 = new Treadmill(500);
        Treadmill treadmill2 = new Treadmill(800);
        Treadmill treadmill3 = new Treadmill(1000);

        //Массив препятствий
        Object objects[] = new Object[]{wall1, treadmill1, treadmill2, wall2, treadmill3, wall3};

        for (Runable runner : runners) {
            System.out.println("Забег " + runner);
            for (Object object : objects) {
                if(object.getClass().equals(wall1.getClass())){
                   ((Jumpable) runner).jump((Wall) (object));
                   if(((Jumpable) runner).validateJump((Wall) object) == false){
                        break;
                   }
                } else {
                    runner.run((Treadmill) object);
                    if(runner.validateRun((Treadmill) object) == false){
                        break;
                    }
                }
            }
        }

    }
}
