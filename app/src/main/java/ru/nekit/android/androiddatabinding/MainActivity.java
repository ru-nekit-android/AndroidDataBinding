package ru.nekit.android.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ru.nekit.android.androiddatabinding.dataObject.ClickHandler;
import ru.nekit.android.androiddatabinding.dataObject.ObservableDataObject;
import ru.nekit.android.androiddatabinding.dataObject.SimpleDataObject;
import ru.nekit.android.androiddatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mActivityDataBinding;
    private SimpleDataObject mSimpleDataObject;
    private ObservableDataObject mObservableDataObject;
    private ClickHandler mClickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityDataBinding.staticTextView.setText("Static data");
        mSimpleDataObject = new SimpleDataObject("Data example");
        mObservableDataObject = new ObservableDataObject("Data example");
        mObservableDataObject.setValueSecondType("Data type 2 example");
        mClickHandler = new ClickHandler();
        mClickHandler.onClickSimpleDataObjectUpdate = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update simple data object
                mSimpleDataObject.value = "Simple data example updated";
                mActivityDataBinding.setSimpleDataObject(mSimpleDataObject);
            }
        };
        mActivityDataBinding.setOnClickObservableDataObjectUpdate(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update observable data object
                mObservableDataObject.setValue("Data example updated");
                mObservableDataObject.setValueSecondType("Data type 2 example updated");
            }
        });
        mActivityDataBinding.setSimpleDataObject(mSimpleDataObject);
        mActivityDataBinding.setObservableDataObject(mObservableDataObject);
        mActivityDataBinding.setClickHandler(mClickHandler);
    }

}
