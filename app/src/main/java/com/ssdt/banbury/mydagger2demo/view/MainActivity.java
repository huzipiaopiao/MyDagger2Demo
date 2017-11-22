package com.ssdt.banbury.mydagger2demo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ssdt.banbury.mydagger2demo.R;
import com.ssdt.banbury.mydagger2demo.dagger.component.DaggerMainComponent;
import com.ssdt.banbury.mydagger2demo.dagger.component.MainComponent;
import com.ssdt.banbury.mydagger2demo.dagger.data.Cloth;
import com.ssdt.banbury.mydagger2demo.dagger.data.Clothes;
import com.ssdt.banbury.mydagger2demo.dagger.data.Hat;
import com.ssdt.banbury.mydagger2demo.dagger.data.Shoe;
import com.ssdt.banbury.mydagger2demo.dagger.module.MainModule;
import com.ssdt.banbury.mydagger2demo.dagger.qulifier.MyRedClothes;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Inject//表示要通过dagger生成对象
            Cloth cloth;

    @Inject
    @Named("blue")//对应的module中有其他方法也返回同一类型对象，则这个注解用来区分，根据括号中的值来判断，此注解实际上是继承的@Qulifier这个注解
            Cloth blueCloth;

    @Inject//表示要通过dagger生成对象
            Shoe shoe;

    @Inject//表示要通过dagger生成对象
            Clothes clothes;

    @Inject//表示要通过dagger生成对象
            Hat hat;

    @Inject//表示要通过dagger生成对象
    @MyRedClothes//自定义的这个注解@MyRedClothes效果和dagger中的@Named一样
            Clothes myRedClothes;

    @Inject
    Cloth normalCloth;

    @Inject
    Clothes normalClothes;

    @Inject
    @Named("normal2Cloth")
    Cloth normalCloth2;

    @Inject
    @Named("normal2Clothes")
    Clothes normalClothes2;

    @Inject
    @Named("lazy")
    Lazy<Cloth> clothLazy;//Lazy<>代表延迟加载，当需要用到该依赖对象时,Dagger2才帮你去获取一个

    @Inject
    Provider<Clothes> clothesProvider;//Provide用于强制重新加载,也就是每一要用到依赖对象时,Dagger2都会帮你依赖注入一次(并不代表一定会new对象，module中有@Scope子类注解的方法并不会重复创建，因为@Scope表示同一作用域内，只会有一个对应实例)

    @Inject
    @Named("other")
    Provider<Clothes> clothesProviderSingleton;//Provide用于强制重新加载,也就是每一要用到依赖对象时,Dagger2都会帮你依赖注入一次(并不代表一定会new对象，module中有@Scope子类注解的方法并不会重复创建，因为@Scope表示同一作用域内，只会有一个对应实例)

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView tv3;
    private StringBuilder tempHashCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //准备好各自的对象的提供者，这个提供者有对应的方法可以创建出对应的对象
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        //各自的对象的提供者开始创建对象，执行这个方法后，就完成赋值了；
        build.inject(this);
        //下面这个方法可以达到上面两步的效果
        //DaggerMainComponent.create().inject(this);
        ((TextView) findViewById(R.id.tv)).setText(cloth.toString() + "\n" + shoe + "\n" + clothes + "\n" + hat + "\n" + blueCloth + "\n" + myRedClothes);

        ((TextView) findViewById(R.id.tv2)).setText("normalCloth=normalClothes中的cloth吗?:" + (normalClothes.getCloth() == normalCloth) + "\n"
                + "normal2Cloth=normal2Clothes中的cloth吗?:" + (normalClothes2.getCloth() == normalCloth2));

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        tv3 = (TextView) findViewById(R.id.tv3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        tempHashCode = new StringBuilder("单例的:").append(clothesProviderSingleton.get().hashCode()).append("；非单例的:").append(clothesProvider.get().hashCode());
        tv3.setText(tempHashCode);
    }

    @Override
    public void onClick(View view) {
        //通过两个页面，对页面内所生成的ClothHandler对象进行判断，是否是同一个对象。
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, OtherActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, MySubActivity.class));
                break;
            case R.id.btn4:
                //触发使用cloth对象，此时dagger才会去创建对象
                Cloth cloth = clothLazy.get();
                //重复使用Provider<Clothes>对象，看是否会重复创建对象
                tempHashCode.append("\n").append("单例的:").append(clothesProviderSingleton.get().hashCode()).append("；非单例的:").append(clothesProvider.get().hashCode()).toString();
                tv3.setText(tempHashCode);
                break;
            default:
                break;
        }
    }
}
