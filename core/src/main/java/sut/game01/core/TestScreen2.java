package sut.game01.core;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.PlayN;
import playn.core.Pointer;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class TestScreen2 extends Screen {

    public static float M_PER_PIXEL = 1/26.666667f; //size of world
    private static int width = 24;
    private static int height = 18;

    private World world;

    private final ScreenStack ss;
    private Image bg2;
    private ImageLayer bg2Layer;
    private Image bt2;
    private ImageLayer bt2Layer;
    private Zealot z = new Zealot(300,300);
    private DebugDrawBox2D debugDraw;

    private Body body;

    private boolean showDebugDraw = true;

    public TestScreen2(ScreenStack ss) {
        this.ss = ss;
    }


    @Override
    public void wasAdded() {
        super.wasAdded();

        bg2 = PlayN.assets().getImage("images/bg2.png");
        bg2Layer = PlayN.graphics().createImageLayer(bg2);
        layer.add(bg2Layer);

        bt2 = PlayN.assets().getImage("images/bt2.png");
        bt2Layer = PlayN.graphics().createImageLayer(bt2);
        layer.add(bt2Layer);
        bt2Layer.setTranslation(300,100);
        bt2Layer.addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                ss.remove(ss.top());
            }
        });//addListenner

        this.layer.add(z.layer());


        Vec2 gravity = new Vec2(0.0f, 10.0f);
        world = new World(gravity,true);
        world.setWarmStarting(true);
        world.setAutoClearForces(true);





    }//wasAdded


    @Override
    public void update(int delta) {
        super.update(delta);
        z.update(delta);
    }
}//TestScreen2
