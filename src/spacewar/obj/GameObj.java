package spacewar.obj;

import spacewar.GameWin;

import java.awt.*;

public class GameObj {
    Image img;
    int x;
    int y;
    int width;
    int height;
    double speed;
    GameWin frame;

    public GameObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public GameObj() {
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    public Image getImg() {
        return img;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getSpeed() {
        return speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void paintSelf(Graphics gImage) {
        gImage.drawImage(img,x, y, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
