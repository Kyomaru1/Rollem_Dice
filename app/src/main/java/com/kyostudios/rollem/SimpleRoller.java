package com.kyostudios.rollem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * Created by Kyoma_000 on 4/14/2015.
 */
public class SimpleRoller extends Fragment {
    final String fragTitle = "Simple Roller";
    public void SimpleRoller(){

    }

    public String getFragTitle(){
        return fragTitle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.simple_roller, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
            Button b2 = (Button) view.findViewById(R.id.button2);
            Button b3 = (Button) view.findViewById(R.id.button3);
            Button b4 = (Button) view.findViewById(R.id.button4);
            Button b6 = (Button) view.findViewById(R.id.button6);
            Button b8 = (Button) view.findViewById(R.id.button8);
            Button b12 = (Button) view.findViewById(R.id.button12);
            Button b10 = (Button) view.findViewById(R.id.button10);
            Button b20 = (Button) view.findViewById(R.id.button20);
            Button b100 = (Button) view.findViewById(R.id.button100);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(2, view);
                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(3, view);
                }
            });

            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(4, view);
                }
            });

            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(6, view);
                }
            });

            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(8, view);
                }
            });

            b10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(10, view);
                }
            });

            b12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(12, view);
                }
            });

            b20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(20, view);
                }
            });

            b100.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollSingle(100, view);
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
        main.currentFragmentPosition[0] = 0;
        Log.d("Testing", "Resuming activity with currentFragmentPosition of " + Integer.toString(main.currentFragmentPosition[0]));
    }

    public void rollSingle(int max, View view){
        Random rand = new Random();
        int solution;
        //Context context = getApplicationContext();
        solution = rand.nextInt(max) + 1;
        /*Toast toast = Toast.makeText(context, "Your d" + max + " rolled a " + solution, Toast.LENGTH_SHORT);
        toast.show();*/

        EditText output = (EditText) view.findViewById(R.id.output);
        output.append("Your d" + max + " rolled a " + solution + ".\n");
    }
}
