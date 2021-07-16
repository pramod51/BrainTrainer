package com.brain.trainer;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brain.trainer.databinding.FragmentPlayGameBinding;

import java.util.Random;

public class PlayGameFragment extends Fragment {
    FragmentPlayGameBinding playGameBinding;
    private int right=0,total=0,corrOption;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        playGameBinding=FragmentPlayGameBinding.inflate(inflater,container,false);
        View view=playGameBinding.getRoot();

        corrOption=FillOption();
        StartTimer();
        playGameBinding.marks.setText("0/0");

        playGameBinding.start.setOnClickListener(view1 -> {
            playGameBinding.start.setVisibility(View.GONE);
            StartTimer();
            corrOption=FillOption();
            total=1;
            right=0;
            playGameBinding.marks.setText("0/0");
        });
        playGameBinding.num1.setOnClickListener(view1 -> {
            if (playGameBinding.start.getVisibility()==View.VISIBLE)
                return;
            if (corrOption==1)
                right++;
            playGameBinding.marks.setText(right+"/"+total);
            corrOption=FillOption();
        });
        playGameBinding.num2.setOnClickListener(view1 -> {
            if (playGameBinding.start.getVisibility()==View.VISIBLE)
                return;
            if (corrOption==2)
                right++;
            playGameBinding.marks.setText(right+"/"+total);
            corrOption=FillOption();
        });
        playGameBinding.num3.setOnClickListener(view1 -> {
            if (playGameBinding.start.getVisibility()==View.VISIBLE)
                return;
            if (corrOption==3)
                right++;
            playGameBinding.marks.setText(right+"/"+total);
            corrOption=FillOption();
        });
        playGameBinding.num4.setOnClickListener(view1 -> {
            if (playGameBinding.start.getVisibility()==View.VISIBLE)
                return;
            if (corrOption==4)
                right++;
            playGameBinding.marks.setText(right+"/"+total);
            corrOption=FillOption();
        });









        return view;
    }
    private void StartTimer(){
        new CountDownTimer(30000, 1000) {

            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished<=10000)
                    playGameBinding.timer.setText("00:0"+millisUntilFinished / 1000);
                else
                playGameBinding.timer.setText("00:"+millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                playGameBinding.start.setVisibility(View.VISIBLE);
            }

        }.start();
    }
    @SuppressLint("SetTextI18n")
    private int  GenerateQuesAns(){
        final int min = 20;
        final int max = 90;
        int num1 = new Random().nextInt((max - min) + 1) + min;
        int num2 = new Random().nextInt((max - min) + 1) + min;
        playGameBinding.question.setText(num1+"+"+num2);
        return num1+num2;

    }
    @SuppressLint("SetTextI18n")
    private int  FillOption(){
        final int min = 20;
        final int max = 110;
        int num1 = new Random().nextInt((max - min) + 1) + min;
        int num2 = new Random().nextInt((max - min) + 1) + min;
        int num3 = new Random().nextInt((max - min) + 1) + min;
        int num4 = new Random().nextInt((max - min) + 1) + min;
        playGameBinding.num1.setText(num1+"");
        playGameBinding.num2.setText(num2+"");
        playGameBinding.num3.setText(num3+"");
        playGameBinding.num4.setText(num4+"");

        int ansIdx = new Random().nextInt(4) + 1;
        Log.v("tag","Andid=="+ansIdx);
        int ans=GenerateQuesAns();
        if (ansIdx==1)
            playGameBinding.num1.setText(""+ans);
        else if (ansIdx==2)
            playGameBinding.num2.setText(""+ans);
        else if (ansIdx==3)
            playGameBinding.num3.setText(""+ans);
        else
            playGameBinding.num4.setText(""+ans);


        total++;
        return ansIdx;

    }


}