package spacewar.obj;

import spacewar.GameWin;
import spacewar.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj{
    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    public ShellObj() {
        super();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y -= speed;
            if(GameUtils.shellObjList.get(0).y < 0) {
                GameUtils.shellObjList.remove(0);
                GameUtils.removeList.add(this);
            }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
