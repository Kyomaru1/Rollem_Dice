package com.kyostudios.rollem;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by Kyoma_000 on 4/9/2015.
 */
public class ConstraintsContainer extends LinearLayout implements Serializable {
    private int _repeat, _max_side, _mod;
    private String _title;
    Activity activity = new Activity();

    public ConstraintsContainer(Context context){
        super(context);
    }

    public ConstraintsContainer(int repeat, int max_side, int mod, Context context){
        super(context);
        _repeat = repeat;
        _max_side = max_side;
        _mod = mod;

        activity.setContentView(R.layout.multi_list_layout);

        TextView repeatVariable = (TextView) activity.findViewById(R.id.repeatVariable);
        TextView greatestSide = (TextView) activity.findViewById(R.id.greatestSide);
        TextView modifier = (TextView) activity.findViewById(R.id.modifier);
        TextView cardTitle = (TextView) activity.findViewById(R.id.cardTitle);

        cardTitle.setVisibility(INVISIBLE);
        repeatVariable.setText(Integer.toString(_repeat));
        greatestSide.setText(Integer.toString(_max_side));
        modifier.setText(Integer.toString(_mod));
    }

    public ConstraintsContainer(int repeat, int max_side, int mod, String title, Context context){
        super(context);
        _repeat = repeat;
        _max_side = max_side;
        _mod = mod;
        _title = title;

        activity.setContentView(R.layout.multi_list_layout);

        TextView repeatVariable = (TextView) activity.findViewById(R.id.repeatVariable);
        TextView greatestSide = (TextView) activity.findViewById(R.id.greatestSide);
        TextView modifier = (TextView) activity.findViewById(R.id.modifier);
        TextView cardTitle = (TextView) activity.findViewById(R.id.cardTitle);

        repeatVariable.setText(Integer.toString(_repeat));
        greatestSide.setText(Integer.toString(_max_side));
        modifier.setText(Integer.toString(_mod));
        cardTitle.setText(_title);
    }

    public void set_repeat(int repeatAmount){
        _repeat = repeatAmount;
        activity.setContentView(R.layout.multi_list_layout);
        TextView repeatVariable = (TextView) activity.findViewById(R.id.modifier);
        repeatVariable.setText(Integer.toString(_repeat));
    }

    public void set_max_side(int max_sideAmount){
        _max_side = max_sideAmount;
        activity.setContentView(R.layout.multi_list_layout);
        TextView greatestSide = (TextView) activity.findViewById(R.id.modifier);
        greatestSide.setText(Integer.toString(_max_side));
    }

    public void set_mod(int modAmount){
        _mod = modAmount;

        activity.setContentView(R.layout.multi_list_layout);
        TextView modifier = (TextView) activity.findViewById(R.id.modifier);
        modifier.setText(Integer.toString(_mod));
    }

    public void set_output(int output){
        activity.setContentView(R.layout.multi_list_layout);
        TextView resultOutput = (TextView) activity.findViewById(R.id.resultOutput);

        resultOutput.setText(Integer.toString(output));
    }

    public void set_title(String title){
        _title = title;

        activity.setContentView(R.layout.multi_list_layout);
        TextView cardTitle = (TextView) activity.findViewById(R.id.modifier);
        cardTitle.setText(_title);
    }

    public int get_repeat(){
        return _repeat;
    }

    public int get_max_side(){
        return _max_side;
    }

    public int get_mod(){
        return _mod;
    }

    public String get_title(){
        return _title;
    }

}
