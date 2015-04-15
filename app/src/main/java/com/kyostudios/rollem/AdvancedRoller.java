package com.kyostudios.rollem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Kyoma_000 on 3/9/2015.
 */
public class AdvancedRoller extends Fragment {
    final String title = "Advanced Roller";
    
    public AdvancedRoller(){

    }

    public static AdvancedRoller newInstance(){
        AdvancedRoller fragment = new AdvancedRoller();
        return fragment;
    }
    
    public String getFragTitle(){
        return title;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.advanced_roller, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

            Button rollButton = (Button) view.findViewById(R.id.rollButton);
            final EditText reps = (EditText) view.findViewById(R.id.repeatAmount);
            final EditText size = (EditText) view.findViewById(R.id.diceSize);
            final EditText output = (EditText) view.findViewById(R.id.output);
            rollButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(reps.getText().toString().trim().length() > 0){
                        if(size.getText().toString().trim().length() > 0){
                            rollMulti(Integer.parseInt(reps.getText().toString().trim()),Integer.parseInt(size.getText().toString().trim()) , view );
                        }
                        else{
                            output.setText(null);
                            output.setText("Please enter the greatest side of the die being rolled.");
                        }
                    }
                    else{
                        output.setText(null);
                        output.setText("Please enter the number of times you wish to roll the die.");
                    }

                }
            });


    }

    @Override
    public void onResume(){
        super.onResume();
        MainActivity main = new MainActivity();
        main.currentFragmentPosition[0] = 1;
        Log.d("Testing", "Resuming activity with currentFragmentPosition of " + Integer.toString(main.currentFragmentPosition[0]));
    }
    public void rollMulti(int reps, int max, View view){
        int r, m, total, current;
        r = reps;
        m = max;
        total = 0;
        Random random = new Random();
        EditText output = (EditText) view.findViewById(R.id.output);
        output.setText("");
        for(int i = 1; i <= r; i++){
            current = random.nextInt(m) + 1;
            output.append("Roll " +  i + ": " + current + "\n");
            total += current;
        }
        output.append("\tTotal of Rolls: " + total);
    }

}
