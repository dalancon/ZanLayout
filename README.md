# ZanLayout

<img src="https://github.com/dalancon/ZanLayout/blob/master/screen.jpg" alt="Sample"  width="216" height="384"/>


# 思路：
自己实现onLayout方法，摆放子控件.


# 用法:
### xml布局方式：

```
<dalancon.com.zanlayout.widget.ZanLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal"
        android:orientation="horizontal"
        app:offset="0.6">
        <ImageView
            android:id="@+id/head1"
            android:layout_width="40dp"
            android:layout_height="40dp" />

        <ImageView
            android:id="@+id/head2"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android:layout_marginVertical="10dp" />

        <ImageView
            android:id="@+id/head3"
            android:layout_width="40dp"
            android:layout_height="40dp" />

    </dalancon.com.zanlayout.widget.ZanLayout>
```

app:offset 控制偏移百分比，默认是30%

### 代码方式：
```
List<String> urls = new ArrayList<>();

urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558330293787&di=34ed02eb8ba8efb2f88d0a7dc3c0de69&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F00bc8151242c7d2460d0b7d4b913c6ed97f957cc158f9-SXd0Yk_fw658");
urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558331175522&di=b2ed598098deef6f9268d80062ec6242&imgtype=0&src=http%3A%2F%2Fimage.zymkcdn.com%2Ffile%2Fhead%2F005%2F299%2F740.jpg");
urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1558330706471&di=95379df025c06cf47cef5ea70b8facdf&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F458af12108c4da0f1cf4fe8e2713a458898e332b28196-jdjJ3j_fw658");
urls.add("http://img5.imgtn.bdimg.com/it/u=2717595227,1512397782&fm=26&gp=0.jpg");
urls.add("http://baiducdn.pig66.com/uploadfile/2017/0511/20170511080327163.jpg");

int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
for (String url : urls) {
     ImageView imageView = new ImageView(this);
     zanlayout.addView(imageView, new LinearLayout.LayoutParams(size, size));
     Glide.with(this)
           .load(url)
           .diskCacheStrategy(DiskCacheStrategy.ALL)
           .error(R.mipmap.ic_launcher)
           .placeholder(R.mipmap.ic_launcher)
           .transform(new GlideCircleTransform(this, 4, getResources().getColor(android.R.color.white)))
           .into(imageView);
}
```

