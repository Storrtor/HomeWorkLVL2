package HomeWork1;

public class Human implements Runable, Jumpable{
    public Human() {
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул");
    }

    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }

    public void jump(Wall wall){
        if (validateJump(wall) == false){
            System.out.println("Человек не смог перепрыгнуть стену высотой " + wall.getHigh());
        } else {
            System.out.println("Человек перепрыгнул стену высотой " + wall.getHigh());
        }
    }

    public void run(Treadmill treadmill){
        if(validateRun(treadmill) == false){
            System.out.println("Человек не смог пробежать дорожку длиной " + treadmill.getLength());
        } else {
            System.out.println("Человек пробежал дорожку длиной " + treadmill.getLength());
        }
    }

    public boolean validateJump(Wall wall){
        if(wall.getHigh() > 2){
            return false;
        } else {
            return true;
        }
    }

    public boolean validateRun(Treadmill treadmill){
        if (treadmill.getLength() > 500){
            return false;
        } else {
            return true;
        }
    }
}
