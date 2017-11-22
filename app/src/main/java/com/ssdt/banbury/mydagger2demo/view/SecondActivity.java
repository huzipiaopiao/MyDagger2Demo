package com.ssdt.banbury.mydagger2demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ssdt.banbury.mydagger2demo.ClothHandler;
import com.ssdt.banbury.mydagger2demo.MyApplication;
import com.ssdt.banbury.mydagger2demo.R;
import com.ssdt.banbury.mydagger2demo.dagger.component.DaggerSecondComponent;
import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;

import javax.inject.Inject;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_18:00.
 * @description
 */

public class SecondActivity extends AppCompatActivity {
    @Inject
    Cloth cloth;

    @Inject
    ClothHandler clothHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        DaggerSecondComponent.builder().baseComponent(((MyApplication)getApplication()).getBaseComponent()).build().inject(this);
        ((TextView)findViewById(R.id.tv)).setText("红色加工后变成"+clothHandler.handle(cloth)+ "\nclothHandler地址:" + clothHandler);
    }
}
