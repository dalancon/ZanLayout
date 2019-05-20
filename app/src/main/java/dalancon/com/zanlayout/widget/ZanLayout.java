package dalancon.com.zanlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by dalancon on 2019/5/20.
 */

public class ZanLayout extends LinearLayout {

    private static final String TAG = "ZanLayout";

    /**
     * 头像控件的偏移
     */
    private int itemOffset = 0;

    public ZanLayout(Context context) {
        super(context);
    }

    public ZanLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZanLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int offset = getChildAt(0).getMeasuredWidth() * 1 / 3;
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
                itemOffset = childWidth / 3;

                final LinearLayout.LayoutParams lp =
                        (LinearLayout.LayoutParams) child.getLayoutParams();

                childLeft += lp.leftMargin;
                if (childLeft - itemOffset < 0) {//第一个头像 不需要偏移

                } else { //后面的头像向左偏移 1/3的宽度
                    childLeft = childLeft - itemOffset;
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
