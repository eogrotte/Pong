package com.example.even.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;

import sheep.game.State;

/**
 * Created by Even on 29.01.2017.
 */

public class GameState extends State {
    //screen width and height
    final int width = 300;
    final int height = 420;

    //The ball
    final int ballSize = 10;
    int ballXCoord = 100;
    int ballYCoord = 100;
    int ballSpeedX = 3;
    int ballSpeedY = 3;

    //The bats
    final int padLength = 90;
    final int padHeight = 10;
    int _topBatX = (width /2) - (padLength / 2);
    final int _topBatY = 20;
    int _bottomBatX = (width /2) - (padLength / 2);
    final int _bottomBatY = 400;
    final int _batSpeed = 3;

    public GameState() {
    }

    //The update method
    public void update() {

        ballXCoord += ballSpeedX;
        ballYCoord += ballSpeedY;

//DEATH!
        if(ballYCoord > height || ballYCoord < 0) {
            ballXCoord = 100; 	ballYCoord = 100;
        }  	//Collisions with the sides

        if(ballXCoord > width || ballXCoord < 0) ballSpeedX *= -1; 	//Collisions with the bats

        if(ballXCoord > _topBatX && ballXCoord < _topBatX+ padLength && ballYCoord < _topBatY) ballSpeedY *= -1;  //Collisions with the bats

        if(ballXCoord > _bottomBatX && ballXCoord < _bottomBatX+ padLength
                && ballYCoord > _bottomBatY)
            ballSpeedY *= -1;

    }

    public boolean motionDetected(MotionEvent event) {
        float trykkX = event.getX();

        _bottomBatX=(int)trykkX- padLength /2;
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
        canvas.drawRect(new Rect(ballXCoord, ballYCoord, ballXCoord + ballSize, ballYCoord + ballSize),
                paint);

//draw the bats
        canvas.drawRect(new Rect(_topBatX, _topBatY, _topBatX + padLength,
                _topBatY + padHeight), paint); //top bat
        canvas.drawRect(new Rect(_bottomBatX, _bottomBatY, _bottomBatX + padLength,
                _bottomBatY + padHeight), paint); //bottom bat

    }
}

