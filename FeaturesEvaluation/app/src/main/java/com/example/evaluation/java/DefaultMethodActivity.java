package com.example.evaluation.java;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.evaluation.R;

public class DefaultMethodActivity extends AppCompatActivity {

    public CounterInterface obj1 = new CounterInterface() {
        private int value = 0;
        @Override
        public void incrementCounter() {
            value ++;
        }

        @Override
        public void setCounterValue(int value) {
            this.value = value;
        }

        @Override
        public int getCounterValue() {
            return this.value;
        }
    };

    public CounterInterface obj2 = new CounterInterface() {
        private int value = 2;
        @Override
        public void incrementCounter() {
            value += 2;
        }

        @Override
        public void setCounterValue(int value) {
            this.value = value;
        }

        @Override
        public int getCounterValue() {
            return this.value;
        }

        /**
         * This is a weird implementation, but it demonstrates that default methods can be overridden
         */
        @Override
        public void resetCounter() {
            setCounterValue(value /2);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_eval);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void incrementObj1(View v){
        obj1.incrementCounter();
    }

    public void displayObj1(View v){
        Toast.makeText(this, "Obj1 Value = " + obj1.getCounterValue(), Toast.LENGTH_SHORT).show();
    }

    public void resetObj1(View v){
        obj1.resetCounter();
    }

    public void incrementObj2(View v){
        obj2.incrementCounter();
    }

    public void displayObj2(View v){
        Toast.makeText(this, "Obj1 Value = " + obj2.getCounterValue(), Toast.LENGTH_SHORT).show();
    }

    public void resetObj2(View v){
        obj2.resetCounter();
    }

}
