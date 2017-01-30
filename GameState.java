package com.example.even.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import sheep.input.TouchListener;
import sheep.game.Sprite;
import sheep.game.State;
import sheep.graphics.Image;
import sheep.game.Game;

/**
 * Created by Even on 29.01.2017.
 */

public class GameState extends State {
    //screen width and height
    final int _screenWidth = 300;
    final int _screenHeight = 420;

    //The ball
    final int ballSize = 10;
    int _ballX = 100;
    int _ballY = 100;
    int _ballVelocityX = 3;
    int _ballVelocityY = 3;

    //The bats
    final int _batLength = 90;	final int _batHeight = 10;
    int _topBatX = (_screenWidth/2) - (_batLength / 2);
    final int _topBatY = 20;
    int _bottomBatX = (_screenWidth/2) - (_batLength / 2);
    final int _bottomBatY = 400;
    final int _batSpeed = 3;

    public GameState() {
    }

    //The update method
    public void update() {

        _ballX += _ballVelocityX;
        _ballY += _ballVelocityY;

//DEATH!
        if(_ballY > _screenHeight || _ballY < 0) {
            _ballX = 100; 	_ballY = 100;
        }  	//Collisions with the sides

        if(_ballX > _screenWidth || _ballX < 0) _ballVelocityX *= -1; 	//Collisions with the bats

        if(_ballX > _topBatX && _ballX < _topBatX+_batLength && _ballY < _topBatY) _ballVelocityY *= -1;  //Collisions with the bats

        if(_ballX > _bottomBatX && _ballX < _bottomBatX+_batLength
                && _ballY > _bottomBatY)
            _ballVelocityY *= -1;

    }

    public boolean motionDetected(MotionEvent event) {
        float trykkX = event.getX();

        _bottomBatX=(int)trykkX-_batLength/2;
        if (trykkX > _bottomBatX) {
            _bottomBatX = _bottomBatX + _batSpeed;
            if (Math.random() * 100 > 50) {
                if (Math.random() * 100 < 40) {
                    _topBatX = _topBatX + _batSpeed;
                }
                if (Math.random() * 100 < 60) {
                    _topBatX = _topBatX + _batSpeed + 5;
                }
                if (Math.random() * 100 < 80) {
                    _topBatX = _topBatX + _batSpeed + 10;
                }
                if (Math.random() * 100 > 80) {
                    _topBatX = _topBatX + _batSpeed + 15;
                } else {
                    _topBatX = _topBatX + _batSpeed;
                }
            }
            if (Math.random() * 100 < 50) {
                if (Math.random() * 100 < 40) {
                    _topBatX = _topBatX - _batSpeed;
                }
                if (Math.random() * 100 < 60) {
                    _topBatX = _topBatX - _batSpeed - 5;
                }
                if (Math.random() * 100 < 80) {
                    _topBatX = _topBatX - _batSpeed - 10;
                }
                if (Math.random() * 100 > 80) {
                    _topBatX = _topBatX - _batSpeed - 15;
                } else {
                    _topBatX = _topBatX - _batSpeed;
                }
            }

            if (trykkX <= _bottomBatX) {
                if (Math.random() * 100 < 50) {
                    if (Math.random() * 100 < 40) {
                        _topBatX = _topBatX - _batSpeed;
                    }
                    if (Math.random() * 100 < 60) {
                        _topBatX = _topBatX - _batSpeed - 5;
                    }
                    if (Math.random() * 100 < 80) {
                        _topBatX = _topBatX - _batSpeed - 10;
                    }
                    if (Math.random() * 100 > 80) {
                        _topBatX = _topBatX - _batSpeed - 15;
                    } else {
                        _topBatX = _topBatX - _batSpeed;
                    }
                }
                if (_topBatX>300 || _topBatX<0){
                    _topBatX=_topBatX-150;
                }
                _topBatX = _topBatX - _batSpeed;
            }
        }
        return true;
    }



    public boolean keyPressed(int keyCode, KeyEvent msg) {
        //left
        if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            _topBatX += _batSpeed; _bottomBatX -= _batSpeed;
        }
        //Right
        if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            _topBatX -= _batSpeed; _bottomBatX += _batSpeed;
        }
//        this.addTouchListener(new TouchListener(){
//            @Override
//            public boolean onTouchDown(MotionEvent motionEvent){
//
//                float trykkX=motionEvent.getX();
//                if (trykkX>_bottomBatX){
//                    _bottomBatX=_bottomBatX+_batSpeed;
//                    if (Math.random()*100>50){
//                        if (Math.random()*100<40){
//                            _topBatX=_topBatX+_batSpeed;
//                        }
//                        if (Math.random()*100<60){
//                            _topBatX=_topBatX+_batSpeed+1;
//                        }
//                        if (Math.random()*100<80){
//                            _topBatX=_topBatX+_batSpeed+2;
//                        }
//                        if (Math.random()*100>80){
//                            _topBatX=_topBatX+_batSpeed+3;
//                        }
//                        else {
//                            _topBatX=_topBatX+_batSpeed;
//                        }
//                    }
//                    if (Math.random()*100>50){
//                        if (Math.random()*100<40){
//                            _topBatX=_topBatX-_batSpeed;
//                        }
//                        if (Math.random()*100<60){
//                            _topBatX=_topBatX-_batSpeed-1;
//                        }
//                        if (Math.random()*100<80){
//                            _topBatX=_topBatX-_batSpeed-2;
//                        }
//                        if (Math.random()*100>80){
//                            _topBatX=_topBatX-_batSpeed-3;
//                        }
//                        else {
//                            _topBatX=_topBatX-_batSpeed;
//                        }
//                    }
//
//                    if(trykkX<_bottomBatX){
//                        _topBatX=_topBatX-_batSpeed;
//                    }
//
//                }
//
//                return true;
//            }
//
//            @Override
//            public boolean onTouchUp(MotionEvent motionEvent) {
//                return false;
//            }
//
//            @Override
//            public boolean onTouchMove(MotionEvent motionEvent) {
//                return false;
//            }
//        });

        return true;
    }

    //the draw method
    public void draw(Canvas canvas, Paint paint) {

//Clear the screen
        canvas.drawRGB(20, 20, 20);

//set the colour
        paint.setARGB(200, 0, 200, 0);

//draw the ball
        canvas.drawRect(new Rect(_ballX,_ballY,_ballX + ballSize,_ballY + ballSize),
                paint);

//draw the bats
        canvas.drawRect(new Rect(_topBatX, _topBatY, _topBatX + _batLength,
                _topBatY + _batHeight), paint); //top bat
        canvas.drawRect(new Rect(_bottomBatX, _bottomBatY, _bottomBatX + _batLength,
                _bottomBatY + _batHeight), paint); //bottom bat

    }
}

