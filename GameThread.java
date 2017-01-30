package com.example.even.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.SurfaceHolder;

/**
 * Created by Even on 29.01.2017.
 */

public class GameThread extends Thread{
    /** Handle to the surface manager object we interact with */
    private SurfaceHolder sHolder;
    private Paint paint1;
    private GameState state;

    public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler)
    {
        sHolder = surfaceHolder;
        paint1 = new Paint();
        state = new GameState();
    }

    @Override
    public void run() {
        while(true) {
            Canvas canvas = sHolder.lockCanvas();
            state.update();
            state.draw(canvas, paint1);
            sHolder.unlockCanvasAndPost(canvas);
        }
    }

    public GameState getGameState(){
        return state;
    }
}

