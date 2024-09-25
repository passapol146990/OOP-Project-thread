import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AsteroidPanel extends JPanel {
    private List<Asteroid> asteroids; // รายการของอุกาบาต

    public AsteroidPanel(int n) {
        asteroids = new ArrayList<>();

        // สร้างอุกาบาต n ลูก และเพิ่มลงในรายการ
        for (int i = 0; i < n; i++) {
            Asteroid asteroid = new Asteroid(800, 600);
            asteroids.add(asteroid);
            Thread asteroidThread = new Thread(asteroid);
            asteroidThread.start(); // เริ่มรันอุกาบาตใน Thread
        }
    }

    // วาดอุกาบาตทั้งหมดในหน้าจอ
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Asteroid asteroid : asteroids) {
            asteroid.checkCollisionWithAsteroid(asteroid);
            asteroid.draw(g);  // วาดอุกาบาตแต่ละลูก
        }
    }

    // การอัพเดท GUI
    public void refresh() {
        repaint();  // รีเฟรชหน้าจอ
    }

    public static void main(String[] args) {
        int n = 10;  // กำหนดจำนวนอุกาบาตที่ต้องการ
        JFrame frame = new JFrame("Asteroid Simulation");
        AsteroidPanel panel = new AsteroidPanel(n);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // ลูปหลักสำหรับการรีเฟรชหน้าจอ
        while (true) {
            panel.refresh();  // อัพเดทหน้าจอ
            try {
                Thread.sleep(10);  // หน่วงเวลา 50ms ก่อนรีเฟรชใหม่
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
