package com.kyostudios.rollem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Drew on 10/24/2015.
 */
public class AdvantageRoller extends Fragment {

    public static String fragTitle="Advantage Roller";

    public static String getFragTitle(){
        return fragTitle;
    }
    public void AdvantageRoller(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.advantage_roller, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Button button = (Button) view.findViewById(R.id.rollButton);
        final RadioButton advantage = (RadioButton) view.findViewById(R.id.radio_advantage);
        final EditText output = (EditText) view.findViewById(R.id.output);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] answers = rollTwo();


                if(advantage.isChecked()){
                    output.append("You rolled: \n\t" + answers[0] + "\n\t" + answers[1] + "\n");
                    Arrays.sort(answers);
                    output.append("You have advantage, so your number is " + answers[1]);

                }
                else{
                    output.append("You rolled: \n\t" + answers[0] + "\n\t" + answers[1] + "\n");
                    Arrays.sort(answers);
                    output.append("You have disadvantage, so your number is " + answers[0]);
                }
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("Lifecycle", "Pausing");
    }

    @Override
    public void onResume(){
        super.onResume();
        MainActivity main = new MainActivity();
        main.currentFragmentPosition[0] = 3;
    }

    public int[] rollTwo(){
        Random random = new Random();
        int[] twoNumbers = new int[2];

        for(int i=0; i<=1; i++){
            twoNumbers[i]= random.nextInt(20)+1;
        }
        return twoNumbers;
    }
}
