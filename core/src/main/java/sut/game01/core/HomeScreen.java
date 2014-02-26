package sut.game01.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Pointer;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

/**
 * Created by Nap on 12/2/2557.
 */
public class HomeScreen extends UIScreen {
    private final ScreenStack ss;
    private Image bg1;
    private ImageLayer bg1Layer;
    private Image bt1;
    private ImageLayer bt1Layer;

    public HomeScreen(ScreenStack ss) {
        this.ss = ss;
    }

    @Override
    public void wasAdded() {
        super.wasAdded();

        //create BG
        bg1 = assets().getImage("images/bg1.png");
        bg1Layer = graphics().createImageLayer(bg1);
        layer.add(bg1Layer);


        bt1 = assets().getImage("images/bt1.png");
        bt1Layer = graphics().createImageLayer(bt1);
        layer.add(bt1Layer);
        bt1Layer.setTranslation(300,100);
       bt1Layer.addListener(new Pointer.Adapter(){
           @Override
           public void onPointerEnd(Pointer.Event event) {
               ss.push(new TestScreen(ss));
           }
       });//addListenner
    }
}
