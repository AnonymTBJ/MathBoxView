package com.anonymtbj.tools.mathboxview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Anonym on 2018/2/28.
 */

public class MathBoxView extends RelativeLayout {

    private View view;
    private TextView number;
    private ImageView backdrop;
    private int textSize,animMax,animMin,animSpeed;
    private int[] animQuantity;
    private double animDouble;
    private MathBoxAnim mathBoxAnim;
    private String text;

    public enum MathBoxAnim {DOWN,RIGHT,CENTER}

    public MathBoxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = inflate(getContext(), R.layout.mathbox_view, this);
        number = (TextView) findViewById(R.id.number);
        backdrop = (ImageView) findViewById(R.id.backdrop);
        textSize = (int) number.getTextSize();
        animMax = 10;
        animMin = 1;
        animDouble = 2;
        animQuantity = new int[] {5,5};
        animSpeed = 1000;
        mathBoxAnim = MathBoxAnim.CENTER;
        text = "";
    }

    public void setTextSize(int textSize){
        this.textSize = textSize;
        number.setTextSize(textSize);
    }

    public void setText(int text, boolean animplay){
        if(text>=0 && text<=9){
            this.text = "0" + text;
        }else{
            this.text = "" + text;
        }
        if(animplay){
            switch (mathBoxAnim){
                case CENTER:
                    AnimCENTER();
                    break;
                case RIGHT:
                    AnimRIGHT();
                    break;
                case DOWN:
                    AnimDOWN();
                    break;
            }
        }else{
            number.setText(this.text);
            number.setTextSize(textSize);
        }
    }
	
    public void setTextColor(int color){
        number.setTextColor(color);
    }
	
    public void setBackdropResource(int resId){
        backdrop.setImageResource(resId);
    }

    public void setBackdropBitmap(Bitmap bitmap){
        backdrop.setImageBitmap(bitmap);
    }

    public void setBackdropDrawable(Drawable drawable){
        backdrop.setImageDrawable(drawable);
    }

    public void setAnim(int animMin,int animMax){
        this.animMin = animMin;
        this.animMax = animMax;
    }

    public void setAnimQuantity(int animQuantity){
        this.animQuantity = new int[] {animQuantity,animQuantity};
    }

    public void setAnimSpeed(int animSpeed){
        this.animSpeed = animSpeed;
    }

    public void setAnimDouble(double animDouble){
        this.animDouble = animDouble;
    }
	
    public void setAnimStyle(MathBoxAnim mathBoxAnim){
        this.mathBoxAnim = mathBoxAnim;
    }	

    private void AnimCENTER(){
        new CountDownTimer(animSpeed*animQuantity[0],animSpeed){
            @Override
            public void onFinish() {
                number.setText(text);
                number.setTextSize(textSize);
            }
            @Override
            public void onTick(long millisUntilFinished) {
                int i = (int) (Math.random() * (animMax - animMin + 1) + animMin);
                if(i>=0 && i<=9){
                    number.setText("0"+i);
                }else{
                    number.setText(""+i);
                }
                number.setTextSize((float)(textSize*animDouble));
            }
        }.start();
    }

    private void AnimRIGHT(){
        view.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(number,"translationX",0,getWidth());
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(number,"alpha",1f,0f);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(number,"translationX",-(getWidth()),0);
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(number,"alpha",0f,1f);

                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator1).with(objectAnimator2).before(objectAnimator3).with(objectAnimator4);
                animatorSet.setDuration(animSpeed);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if(animQuantity[1]==0){
                            number.setText(text);
                            number.setTextSize(textSize);
                        }else{
                            int i = (int) (Math.random() * (animMax - animMin + 1) + animMin);
                            if(i>=0 && i<=9){
                                number.setText("0"+i);
                            }else{
                                number.setText(""+i);
                            }
                            number.setTextSize((float)(textSize*animDouble));
                        }
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(animQuantity[1]>0){
                            animQuantity[1] -- ;
                            animatorSet.start();
                        }else{
                            animQuantity[1] = animQuantity[0];
                        }
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        if(animQuantity[1]>0){
                            animQuantity[1] -- ;
                            animatorSet.start();
                        }else{
                            animQuantity[1] = animQuantity[0];
                        }
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });
            }
        });
    }

    private void AnimDOWN(){
        view.post(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(number,"translationY",0,getHeight());
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(number,"alpha",1f,0f);
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(number,"translationY",-(getHeight()),0);
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(number,"alpha",0f,1f);

                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(objectAnimator1).with(objectAnimator2).before(objectAnimator3).with(objectAnimator4);
                animatorSet.setDuration(animSpeed);
                animatorSet.start();

                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if(animQuantity[1]==0){
                            number.setText(text);
                            number.setTextSize(textSize);
                        }else{
                            int i = (int) (Math.random() * (animMax - animMin + 1) + animMin);
                            if(i>=0 && i<=9){
                                number.setText("0"+i);
                            }else{
                                number.setText(""+i);
                            }
                            number.setTextSize((float)(textSize*animDouble));
                        }
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if(animQuantity[1]>0){
                            animQuantity[1] -- ;
                            animatorSet.start();
                        }else{
                            animQuantity[1] = animQuantity[0];
                        }
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        if(animQuantity[1]>0){
                            animQuantity[1] -- ;
                            animatorSet.start();
                        }else{
                            animQuantity[1] = animQuantity[0];
                        }
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });
            }
        });
    }
}
