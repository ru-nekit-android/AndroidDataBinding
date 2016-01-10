package ru.nekit.android.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.nekit.android.androiddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityDataBinding.textView.setText("Set from code!");


    }
}
