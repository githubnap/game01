package sut.game01.core;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.util.Callback;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;



/**
 * Created by Nap on 12/2/2557.
 */
public class TestScreen extends Screen  {

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

    public TestScreen(ScreenStack ss) {
        this.ss = ss;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();

        Image bgImage = assets().getImage("images/bg.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        layer.add(bgLayer);

        bgImage.addCallback(new Callback<Image>() {
            @Override
            public void onSuccess(Image result) {
            }

            @Override
            public void onFailure(Throwable cause) {
            }
        });


        Image backImage = assets().getImage("images/back.png");
        ImageLayer backLayer = graphics().createImageLayer(backImage);
        backLayer.setSize(150,99);
        backLayer.setOrigin(30,30);
        backLayer.setTranslation(300,99);

        layer.add(backLayer);

        Vec2 gravity = new Vec2(0.0f, 10.0f);
        world = new World(gravity,true);
        world.setWarmStarting(true);
        world.setAutoClearForces(true);
    }
}