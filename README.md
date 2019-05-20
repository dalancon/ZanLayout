# ZanLayout

<img src="https://github.com/dalancon/ZanLayout/blob/master/screen.jpg" alt="Sample"  width="216" height="384"/>


# 思路：
自己实现onLayout方法，摆放子控件.

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
