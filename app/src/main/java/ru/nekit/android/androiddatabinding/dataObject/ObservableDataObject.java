package ru.nekit.android.androiddatabinding.dataObject;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import ru.nekit.android.androiddatabinding.BR;

/**
 * Created by MacOS on 10.01.16.
 */
public class ObservableDataObject extends BaseObservable {

    private String mValue;

    public final ObservableField<String> valueSecondType = new ObservableField<>();

    public ObservableDataObject(String data) {
        mValue = data;
        setValueSecondType(data);
    }

    @Bindable
    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
        notifyPropertyChanged(BR.value);
    }

    public void setValueSecondType(String value) {
        valueSecondType.set(value);
    }

}
