package HomeWork1;

public interface Jumpable {
    void jump();
    void jump(Wall wall);
    boolean validateJump(Wall wall);
}
