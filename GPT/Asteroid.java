import java.awt.*;
import java.awt.Rectangle;
import java.util.Random;

public class Asteroid implements Runnable {
    private int x, y;            // ตำแหน่งของอุกาบาด
    private int dx, dy;          // การเปลี่ยนแปลงทิศทางในแกน x และ y
    private int width, height;   // ขนาดของอุกาบาด
    private int screenWidth, screenHeight; // ขนาดหน้าจอ

    public Asteroid(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        Random rand = new Random();

        // กำหนดตำแหน่งเริ่มต้นและทิศทางแบบสุ่ม
        this.x = rand.nextInt(screenWidth);
        this.y = rand.nextInt(screenHeight);
        this.dx = rand.nextInt(7) - 3;  // ความเร็วในแกน x (-3 ถึง 3)
        this.dy = rand.nextInt(7) - 3;  // ความเร็วในแกน y (-3 ถึง 3)
        this.width = 50;  // กำหนดขนาดของอุกาบาด
        this.height = 50;
    }

    @Override
    public void run() {
        while (true) {
            move();
            checkCollisionWithWalls();
            try {
                Thread.sleep(50);  // หน่วงเวลาการเคลื่อนที่
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // การเคลื่อนที่ของอุกาบาด
    private void move() {
        x += dx;
        y += dy;
    }

    // ตรวจสอบการชนกับขอบจอ
    private void checkCollisionWithWalls() {
        if (x <= 0 || x + width >= screenWidth) {
            dx = -dx;  // เปลี่ยนทิศทางแกน x เมื่อชนขอบ
        }
        if (y <= 0 || y + height >= screenHeight) {
            dy = -dy;  // เปลี่ยนทิศทางแกน y เมื่อชนขอบ
        }
    }

    // ตรวจสอบการชนกับอุกาบาดอื่น
    public void checkCollisionWithAsteroid(Asteroid other) {
        Rectangle thisAsteroid = new Rectangle(x, y, width, height);
        Rectangle otherAsteroid = new Rectangle(other.x, other.y, other.width, other.height);
        if (thisAsteroid.intersects(otherAsteroid)) {
            dx = -dx;  // เปลี่ยนทิศทางเมื่อชนกัน
            dy = -dy;
            other.dx = -other.dx;
            other.dy = -other.dy;
        }
    }

    // วาดอุกาบาด (สามารถใช้กับ GUI)
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval(x, y, width, height);
    }
}