package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DashboardFragment extends Fragment {


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button button3 = (Button) view.findViewById(R.id.button3);
        EditText length = (EditText) view.findViewById(R.id.editTextNumber);
        EditText width = (EditText) view.findViewById(R.id.editTextNumber2);
        EditText height = (EditText)view.findViewById(R.id.editTextNumber3);
        Switch stud = (Switch)view.findViewById(R.id.switch1);
        Switch nail = (Switch)view.findViewById(R.id.switch2);
        Switch drywall = (Switch)view.findViewById(R.id.switch3);
        Switch putty = (Switch)view.findViewById(R.id.switch4);
        Switch paint = (Switch)view.findViewById(R.id.switch5);
        Switch laminate = (Switch)view.findViewById(R.id.switch6);
        Switch hardwood = (Switch)view.findViewById(R.id.switch7);
        Switch carpet = (Switch)view.findViewById(R.id.switch8);
        Spinner unit = (Spinner)view.findViewById(R.id.spinner);


        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Calculation.class);
                String input = length.getText().toString();
                String input1 = width.getText().toString();
                String input2 = height.getText().toString();
                if (stud.isChecked()) {
                    in.putExtra("stud", "True");
                }
                else {
                    in.putExtra("stud", "False");
                }
                if (nail.isChecked()) {
                    in.putExtra("nail", "True");
                }
                else {
                    in.putExtra("nail", "False");
                    }
                if (drywall.isChecked()) {
                    in.putExtra("drywall", "True");
                }
                else {
                    in.putExtra("drywall", "False");
                }
                if (putty.isChecked()) {
                    in.putExtra("putty", "True");
                }
                else {
                    in.putExtra("putty", "False");
                }
                if (paint.isChecked()) {
                    in.putExtra("paint", "True");
                }
                else {
                    in.putExtra("paint", "False");
                }
                if (laminate.isChecked()) {
                    String op6 = nail.getText().toString();
                    in.putExtra("laminate", "True");
                }
                else {
                    in.putExtra("laminate", "False");
                }
                if (hardwood.isChecked()) {
                    in.putExtra("hardwood", "True");
                }
                else {
                    in.putExtra("hardwood", "False");
                }
                if (carpet.isChecked()) {
                    in.putExtra("carpet", "True");
                }
                else {
                    in.putExtra("carpet", "False");
                }
                String measure = unit.getSelectedItem().toString();
                if(input.isEmpty()){
                    input = "0";
                    in.putExtra("length", input);
                }
                else {
                    in.putExtra("length", input);
                }
                if(input1.isEmpty()){
                    input1 = "0";
                    in.putExtra("width", input1);                }
                else {
                    in.putExtra("width", input1);
                }
                if(input2.isEmpty()){
                    input2 = "0";
                    in.putExtra("height", input2);                }
                else {
                    in.putExtra("height", input2);
                }

                in.putExtra("unitmeasure",measure);
                startActivity(in);
            }

        });


        return view;
    }

}