package HomeWork1;

public class MyApp {
    public static void main(String[] args) {

        /**
         * №1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
         * Эти классы должны уметь бегать и прыгать.
         */
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();





        Jumpable catJump = new Cat();
        catJump.jump();
        ((Runable) catJump).run();

//        Jumpable jumpers[] = new Jumpable[]{human,cat,robot};
//
//
//        for (Jumpable jumper : jumpers) {
//            jumper.jump();
//        }
//        Runable runners[] = new Runable[]{human,cat,robot};
//        for (Runable runner : runners) {
//            runner.run();
//        }
//
//        /**
//         * 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые,
//         * участники должны выполнять соответствующие действия (бежать или прыгать),
//         * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
//         */
//        Wall wall = new Wall(5);
//        wall.info();
//        Treadmill treadmill = new Treadmill(100);
//        treadmill.info();
//
//        for (Jumpable jumper : jumpers) {
//            jumper.jump(wall);
//        }
//        for (Runable runner : runners) {
//            runner.run(treadmill);
//        }







    }
}
