package com.ssdt.banbury.mydagger2demo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ssdt.banbury.mydagger2demo.ClothHandler;
import com.ssdt.banbury.mydagger2demo.MyApplication;
import com.ssdt.banbury.mydagger2demo.R;
import com.ssdt.banbury.mydagger2demo.dagger.component.DaggerOtherComponent;
import com.ssdt.banbury.mydagger2demo.dagger.component.OtherComponent;
import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;
import com.ssdt.banbury.mydagger2demo.dagger.module.OtherModule;

import javax.inject.Inject;

/**
 * @author banbury
 * @version v1.0
 * @created 2017/11/21_17:07.
 * @description
 */

public class OtherActivity extends AppCompatActivity {
    @Inject
    Cloth cloth;

    @Inject
    ClothHandler clothHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        OtherComponent build = DaggerOtherComponent
                .builder()
                .baseComponent(((MyApplication) getApplication()).getBaseComponent())//确保传人的BaseComponent是同一个对象，如果是不同对象，则ClothHandler不会是全局单例；
                .otherModule(new OtherModule())
                .build();
        build.inject(this);

        ((TextView)findViewById(R.id.tv)).setText("蓝色加工后变成"+clothHandler.handle(cloth)+ "\nclothHandler地址:" + clothHandler);

    }
}
