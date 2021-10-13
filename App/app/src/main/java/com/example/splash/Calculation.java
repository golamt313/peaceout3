package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculation extends AppCompatActivity {
    private TextView studs, nails,drywalls,puttys,paints,laminates,hardwoods,carpets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation2);
        studs = findViewById(R.id.text);
        nails = findViewById(R.id.text2);
        drywalls = findViewById(R.id.text3);
        puttys = findViewById(R.id.text4);
        paints = findViewById(R.id.text5);
        laminates = findViewById(R.id.text8);
        hardwoods = findViewById(R.id.text9);
        carpets = findViewById(R.id.text10);
        Intent intent = getIntent();
        Double length = Double.parseDouble(intent.getStringExtra("length"));
        Double width = Double.parseDouble(intent.getStringExtra("width"));
        Double height = Double.parseDouble(intent.getStringExtra("height"));
        String stud = intent.getStringExtra("stud");
        String nail = intent.getStringExtra("nail");
        String drywall = intent.getStringExtra("drywall");
        String putty = intent.getStringExtra("putty");
        String paint = intent.getStringExtra("paint");
        String laminate = intent.getStringExtra("laminate");
        String hardwood = intent.getStringExtra("hardwood");
        String carpet = intent.getStringExtra("carpet");
        String unit = intent.getStringExtra("unitmeasure");
        String pols = "Inch";
        String not = "True";
        if(unit.equals("Inch")){
            if(stud.equals(not)){
                if(length.equals(0.0)){
                    String s = "Paint can only be calculate by entering length";
                    studs.setText(s);
                }
                else {
                    double calculated_stud = (length/12)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    String s=String.valueOf(stud_int);
                    studs.setText("Stud: "+s+" count");
                }
            }
            else{
                String s = "Stud was not picked to be calculated";
                studs.setText(s);
            }
            if(nail.equals("True")){
                if(length.equals(0.0)){
                    String n = "Nail can only be calculate by entering length";
                    nails.setText(n);
                }
                else {
                    double calculated_stud = (length/12)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    int nail_int = stud_int*4;
                    String n=String.valueOf(nail_int);
                    nails.setText("Nail: "+n+" count");

                }
            }
            else{
                String n = "Nail was not picked to be calculated";
                nails.setText(n);
            }
            if(drywall.equals("True")){
                if(length.equals(0.0)){
                    String d = "Drywall can only be calculated by entering length";
                    drywalls.setText(d);
                }
                else {
                    double calculated_drywall = (length/12)/4;
                    int drywall_int = (int)calculated_drywall;
                    String d=String.valueOf(drywall_int);
                    drywalls.setText("Drywall: "+d+" count");
                }
            }
            else{
                String d = "Drywall was not picked to be calculated";
                drywalls.setText(d);
            }
            if(putty.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String p = "Putty can only be calculate by entering both length and height";
                    puttys.setText(p);
                }
                else {
                    double calculated_putty = 0.063*((length/12)*(height/12));
                    String p=String.valueOf(calculated_putty);
                    puttys.setText("Putty: "+p+" kg");
                }
            }
            else{
                String p = "Putty was not picked to be calculated";
                puttys.setText(p);
            }
            if(paint.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String pa = "Paint can only be calculate by entering both length and height";
                    paints.setText(pa);
                }
                else {
                    double calculated_paint = 0.0025*((length/12)*(height/12));
                    String pa=String.valueOf(calculated_paint);
                    paints.setText("Paint: "+pa+" gallons.");
                }
            }
            else{
                String pa = "Paint was not picked to be calculated";
                paints.setText(pa);            }
            if(laminate.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String l = "Laminate can only be calculate by entering both length and width";
                    laminates.setText(l);
                }
                else {
                    double calculated_laminate = 2.5*((length/12)*(width/12));
                    String l=String.valueOf(calculated_laminate);
                    laminates.setText("Laminate: $"+l);
                }
            }
            else{
                String l = "Laminate was not picked to be calculated";
                laminates.setText(l);            }
            if(hardwood.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String h = "Hardwood can only be calculate by entering both length and width";
                    hardwoods.setText(h);
                }
                else {
                    double calculated_hardwood = 8.5*((length/12)*(width/12));
                    String h=String.valueOf(calculated_hardwood);
                    hardwoods.setText("Hardwood: $"+h);
                }
            }
            else{
                String h = "Hardwood was not picked to be calculated";
                hardwoods.setText(h);            }
            if(carpet.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String c = "Carpet can only be calculate by entering both length and width";
                    carpets.setText(c);
                }
                else {
                    double calculated_carpet = 2*((length/12)*(width/12));
                    String c=String.valueOf(calculated_carpet);
                    carpets.setText("Carpet: $"+c);
                }
            }
            else{
                String c = "Carpet was not picked to be calculated";
                carpets.setText(c);            }

        }
        else if(unit.equals("Foot")){
            if(stud.equals(not)){
                if(length.equals(0.0)){
                    String s = "Paint can only be calculate by entering length";
                    studs.setText(s);
                }
                else {
                    double calculated_stud = (length)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    String s=String.valueOf(stud_int);
                    studs.setText("Stud: "+s+" count");
                }
            }
            else{
                String s = "Stud was not picked to be calculated";
                studs.setText(s);
            }
            if(nail.equals("True")){
                if(length.equals(0.0)){
                    String n = "Nail can only be calculate by entering length";
                    nails.setText(n);
                }
                else {
                    double calculated_stud = (length)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    int nail_int = stud_int*4;
                    String n=String.valueOf(nail_int);
                    nails.setText("Nail: "+n+" count");

                }
            }
            else{
                String n = "Nail was not picked to be calculated";
                nails.setText(n);
            }
            if(drywall.equals("True")){
                if(length.equals(0.0)){
                    String d = "Drywall can only be calculated by entering length";
                    drywalls.setText(d);
                }
                else {
                    double calculated_drywall = (length)/4;
                    int drywall_int = (int)calculated_drywall;
                    String d=String.valueOf(drywall_int);
                    drywalls.setText("Drywall: "+d+" count");
                }
            }
            else{
                String d = "Drywall was not picked to be calculated";
                drywalls.setText(d);
            }
            if(putty.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String p = "Putty can only be calculate by entering both length and height";
                    puttys.setText(p);
                }
                else {
                    double calculated_putty = 0.063*((length)*(height));
                    String p=String.valueOf(calculated_putty);
                    puttys.setText("Putty: "+p+" kg");
                }
            }
            else{
                String p = "Putty was not picked to be calculated";
                puttys.setText(p);
            }
            if(paint.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String pa = "Paint can only be calculate by entering both length and height";
                    paints.setText(pa);
                }
                else {
                    double calculated_paint = 0.0025*((length)*(height));
                    String pa=String.valueOf(calculated_paint);
                    paints.setText("Paint: "+pa+" gallons.");
                }
            }
            else{
                String pa = "Paint was not picked to be calculated";
                paints.setText(pa);            }
            if(laminate.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String l = "Laminate can only be calculate by entering both length and width";
                    laminates.setText(l);
                }
                else {
                    double calculated_laminate = 2.5*((length)*(width));
                    String l=String.valueOf(calculated_laminate);
                    laminates.setText("Laminate: $"+l);
                }
            }
            else{
                String l = "Laminate was not picked to be calculated";
                laminates.setText(l);            }
            if(hardwood.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String h = "Hardwood can only be calculate by entering both length and width";
                    hardwoods.setText(h);
                }
                else {
                    double calculated_hardwood = 8.5*((length)*(width));
                    String h=String.valueOf(calculated_hardwood);
                    hardwoods.setText("Hardwood: $"+h);
                }
            }
            else{
                String h = "Hardwood was not picked to be calculated";
                hardwoods.setText(h);            }
            if(carpet.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String c = "Carpet can only be calculate by entering both length and width";
                    carpets.setText(c);
                }
                else {
                    double calculated_carpet = 2*((length)*(width));
                    String c=String.valueOf(calculated_carpet);
                    carpets.setText("Carpet: $"+c);
                }
            }
            else{
                String c = "Carpet was not picked to be calculated";
                carpets.setText(c);            }

        }
        else if(unit.equals("Meter")){
            if(stud.equals(not)){
                if(length.equals(0.0)){
                    String s = "Paint can only be calculate by entering length";
                    studs.setText(s);
                }
                else {
                    double calculated_stud = (length*3.28084)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    String s=String.valueOf(stud_int);
                    studs.setText("Stud: "+s+" count");
                }
            }
            else{
                String s = "Stud was not picked to be calculated";
                studs.setText(s);
            }
            if(nail.equals("True")){
                if(length.equals(0.0)){
                    String n = "Nail can only be calculate by entering length";
                    nails.setText(n);
                }
                else {
                    double calculated_stud = (length*3.28084)*.75 +12;
                    int stud_int = (int)calculated_stud;
                    int nail_int = stud_int*4;
                    String n=String.valueOf(nail_int);
                    nails.setText("Nail: "+n+" count");

                }
            }
            else{
                String n = "Nail was not picked to be calculated";
                nails.setText(n);
            }
            if(drywall.equals("True")){
                if(length.equals(0.0)){
                    String d = "Drywall can only be calculated by entering length";
                    drywalls.setText(d);
                }
                else {
                    double calculated_drywall = (length*3.28084)/4;
                    int drywall_int = (int)calculated_drywall;
                    String d=String.valueOf(drywall_int);
                    drywalls.setText("Drywall: "+d+" count");
                }
            }
            else{
                String d = "Drywall was not picked to be calculated";
                drywalls.setText(d);
            }
            if(putty.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String p = "Putty can only be calculate by entering both length and height";
                    puttys.setText(p);
                }
                else {
                    double calculated_putty = 0.063*((length*3.28084)*(height*3.28084));
                    String p=String.valueOf(calculated_putty);
                    puttys.setText("Putty: "+p+" kg");
                }
            }
            else{
                String p = "Putty was not picked to be calculated";
                puttys.setText(p);
            }
            if(paint.equals("True")){
                if(length.equals(0.0) || height.equals(0.0)){
                    String pa = "Paint can only be calculate by entering both length and height";
                    paints.setText(pa);
                }
                else {
                    double calculated_paint = 0.0025*((length*3.28084)*(height*3.28084));
                    String pa=String.valueOf(calculated_paint);
                    paints.setText("Paint: "+pa+" gallons.");
                }
            }
            else{
                String pa = "Paint was not picked to be calculated";
                paints.setText(pa);            }
            if(laminate.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String l = "Laminate can only be calculate by entering both length and width";
                    laminates.setText(l);
                }
                else {
                    double calculated_laminate = 2.5*((length*3.28084)*(width*3.28084));
                    String l=String.valueOf(calculated_laminate);
                    laminates.setText("Laminate: $"+l);
                }
            }
            else{
                String l = "Laminate was not picked to be calculated";
                laminates.setText(l);            }
            if(hardwood.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String h = "Hardwood can only be calculate by entering both length and width";
                    hardwoods.setText(h);
                }
                else {
                    double calculated_hardwood = 8.5*((length*3.28084)*(width*3.28084));
                    String h=String.valueOf(calculated_hardwood);
                    hardwoods.setText("Hardwood: $"+h);
                }
            }
            else{
                String h = "Hardwood was not picked to be calculated";
                hardwoods.setText(h);            }
            if(carpet.equals("True")){
                if(length.equals(0.0) || width.equals(0.0)){
                    String c = "Carpet can only be calculate by entering both length and width";
                    carpets.setText(c);
                }
                else {
                    double calculated_carpet = 2*((length*3.28084)*(width*3.28084));
                    String c=String.valueOf(calculated_carpet);
                    carpets.setText("Carpet: $"+c);
                }
            }
            else{
                String c = "Carpet was not picked to be calculated";
                carpets.setText(c);            }

        }
        else{
        }
    }
}