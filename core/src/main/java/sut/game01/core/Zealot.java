package sut.game01.core;

import playn.core.Layer;
import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.util.Callback;
import sut.game01.core.Sprite.Sprite;
import sut.game01.core.Sprite.SpriteLoader;

/**
 * Created by Nap on 12/2/2557.
 */
public class Zealot {
    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasloaded = false;
    public Layer layer;

    public Layer layer() {
        return sprite.layer();
    }


    public enum State {
        IDLE,RUN,ATTK
    };//enum

    private State state = State.IDLE;

    private int e=0;
    private int offset = 0;

    public Zealot(final float x, final float y){
        sprite = SpriteLoader.getSprite("images/555.json");
        sprite.addCallback(new Callback<Sprite>() {
            @Override
            public void onSuccess(Sprite sprite) {
                sprite.setSprite(spriteIndex);
                sprite.layer().setOrigin(sprite.width()/2f,sprite.height()/2f);
                sprite.layer().setTranslation(x,y+13f);
                hasloaded=true;
            }

            @Override
            public void onFailure(Throwable cause) {
                PlayN.log().error("5555555555555555555",cause);
            }
        });

        sprite.layer().addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event) {
                state = State.ATTK;
                spriteIndex=-1;
                e=0;
            }
        });
    }

    public void update(int delta){
        if (!hasloaded)return;
        e+=delta;

        if (e > 150){
            switch (state){
                case IDLE:offset=0;
                    break;
                case RUN:offset=8;
                    break;
                case ATTK:offset=16;
                    if (spriteIndex == 23){
                        state = State.IDLE;
                    }//if
                    break;
            }//switch
            spriteIndex = offset + ((spriteIndex + 1) % 4 );
            sprite.setSprite(spriteIndex);
            e=0;
        }//if
    }//update


}//Zealot
