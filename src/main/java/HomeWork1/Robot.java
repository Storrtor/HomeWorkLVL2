package HomeWork1;

public class Robot implements Runable, Jumpable{
    public Robot() {
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгнул");
    }

    @Override
    public void run() {
        System.out.println("Робот пробежал");
    }

    public void jump(Wall wall){
        if (validateJump(wall) == false){
            System.out.println("Робот не смог перепрыгнуть стену высотой " + wall.getHigh());
        } else {
            System.out.println("Робот перепрыгнул стену высотой " + wall.getHigh());
        }
    }

    public void run(Treadmill treadmill){
        if(validateRun(treadmill) == false){
            System.out.println("Робот не смог пробежать дорожку длиной " + treadmill.getLength());
        } else {
            System.out.println("Робот пробежал дорожку длиной " + treadmill.getLength());
        }
    }

    public boolean validateJump(Wall wall){
        if(wall.getHigh() > 5){
            return false;
        } else {
            return true;
        }
    }

    public boolean validateRun(Treadmill treadmill){
        if (treadmill.getLength() > 1000){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Robot{}";
    }
}
