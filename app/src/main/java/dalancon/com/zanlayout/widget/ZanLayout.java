package dalancon.com.zanlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import dalancon.com.zanlayout.R;

/**
 * Created by dalancon on 2019/5/20.
 */

public class ZanLayout extends LinearLayout {

    private static final String TAG = "ZanLayout";

    /**
     * 头像控件的偏移比例
     */
    private float itemOffsetPercent = 0;

    public ZanLayout(Context context) {
        this(context, null);
    }

    public ZanLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZanLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.zanLayout);

        itemOffsetPercent = typedArray.getFloat(R.styleable.zanLayout_offset, -1);
        if (itemOffsetPercent == -1) {
            //如果没有设置偏移 默认偏移30%
            itemOffsetPercent = 0.3f;
        }

        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int offset = (int) (getChildAt(0).getMeasuredWidth() * itemOffsetPercent);
        setMeasuredDimension(getMeasuredWidth() - (getChildCount() - 1) * offset, getMeasuredHeight());
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (getOrientation() == LinearLayout.HORIZONTAL) {
            layoutHorizontal(l, t, r, b);
            return;
        } else {
            throw new RuntimeException("方向必须是水平方向");
        }
    }

    /**
     * Position the children during a layout pass if the orientation of this
     * LinearLayout is set to {@link #HORIZONTAL}.
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @see #getOrientation()
     * @see #setOrientation(int)
     * @see #onLayout(boolean, int, int, int, int)
     */
    @TargetApi(Build.VERSION_CODES.N)
    void layoutHorizontal(int left, int top, int right, int bottom) {

        int childTop = 0;
        int childLeft = 0;

        final int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child == null) {
                childLeft += measureNullChild(i);
            } else if (child.getVisibility() != GONE) {
                final int childWidth = child.getMeasuredWidth();
                final int childHeight = child.getMeasuredHeight();
                float itemOffset = childWidth * itemOffsetPercent;

                final LinearLayout.LayoutParams lp =
                        (LinearLayout.LayoutParams) child.getLayoutParams();

                childLeft += lp.leftMargin;
                if (childLeft - itemOffset < 0) {//第一个头像 不需要偏移

                } else { //后面的头像向左偏移
                    childLeft = (int) (childLeft - itemOffset);
                }
                child.layout(childLeft, childTop,
                        childLeft + childWidth, childHeight);
                childLeft += childWidth + lp.rightMargin;
            }
        }
    }

    private int measureNullChild(int childIndex) {
        return 0;
    }
}
