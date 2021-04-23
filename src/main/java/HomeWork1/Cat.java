package HomeWork1;

public class Cat implements Runable, Jumpable{
    public Cat() {
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгнул");
    }

    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }

    public void jump(Wall wall){
        if (validateJump(wall) == false){
            System.out.println("Кот не смог перепрыгнуть стену высотой " + wall.getHigh());
        } else {
            System.out.println("Кот перепрыгнул стену высотой " + wall.getHigh());
        }
    }

    public void run(Treadmill treadmill){
        if(validateRun(treadmill) == false){
            System.out.println("Кот не смог пробежать дорожку длиной " + treadmill.getLength());
        } else {
            System.out.println("Кот пробежал дорожку длиной " + treadmill.getLength());
        }
    }

    public boolean validateJump(Wall wall){
        if(wall.getHigh() > 3){
            return false;
        } else {
            return true;
        }
    }

    public boolean validateRun(Treadmill treadmill){
        if (treadmill.getLength() > 800){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cat{}";
    }


}
