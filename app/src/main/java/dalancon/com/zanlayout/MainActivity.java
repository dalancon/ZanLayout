package dalancon.com.zanlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import dalancon.com.zanlayout.widget.GlideCircleTransform;

/**
 * Created by dalancon on 2019/5/20.
 */

public class MainActivity extends AppCompatActivity {

    private ImageView mIv;
    private ImageView mIv2;
    private ImageView mIv3;
    private ImageView mIv4;
    private ImageView mIv5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIv = findViewById(R.id.head1);
        mIv2 = findViewById(R.id.head2);
        mIv3 = findViewById(R.id.head3);
        mIv4 = findViewById(R.id.head4);
        mIv5 = findViewById(R.id.head5);

        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558330293787&di=34ed02eb8ba8efb2f88d0a7dc3c0de69&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F00bc8151242c7d2460d0b7d4b913c6ed97f957cc158f9-SXd0Yk_fw658")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
                .into(mIv);

        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558331175522&di=b2ed598098deef6f9268d80062ec6242&imgtype=0&src=http%3A%2F%2Fimage.zymkcdn.com%2Ffile%2Fhead%2F005%2F299%2F740.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
                .into(mIv2);

        Glide.with(this)
                .load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558330706471&di=95379df025c06cf47cef5ea70b8facdf&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F458af12108c4da0f1cf4fe8e2713a458898e332b28196-jdjJ3j_fw658")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
                .into(mIv3);

        Glide.with(this)
                .load("http://img5.imgtn.bdimg.com/it/u=2717595227,1512397782&fm=26&gp=0.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
                .into(mIv4);

        Glide.with(this)
                .load("http://baiducdn.pig66.com/uploadfile/2017/0511/20170511080327163.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
                .into(mIv5);
    }
}
