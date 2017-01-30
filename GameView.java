package com.example.even.pong;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Even on 29.01.2017.
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private GameThread threadThing;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //eventListenerstufflizm
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

        //starter en thread lizm, må gjøres av en eller annen grunn
        threadThing = new GameThread(holder, context, new Handler());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {
        return threadThing.getGameState().keyPressed(keyCode, msg);
    }
    public boolean onTouchEvent(MotionEvent event) {
        return threadThing.getGameState().motionDetected(event);
    }

    //Viktig surfaceChangedFunksjon, må gjøres.
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    //Også em viktig funksjon
    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        threadThing.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        threadThing.stop();
    }
}

