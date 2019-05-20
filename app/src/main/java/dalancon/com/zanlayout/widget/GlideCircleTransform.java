package dalancon.com.zanlayout.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by yangguanxiao on 2016/12/10.
 */

public class GlideCircleTransform extends BitmapTransformation {

    private Paint mBorderPaint;
    private float mBorderWidth;

    public GlideCircleTransform(Context context, int borderWidth, int borderColor) {
        super(context);
        mBorderWidth = borderWidth;
        if (borderWidth > 0) {
            mBorderPaint = new Paint();
            mBorderPaint.setDither(true);
            mBorderPaint.setAntiAlias(true);
            mBorderPaint.setColor(borderColor);
            mBorderPaint.setStyle(Paint.Style.STROKE);
            mBorderPaint.setStrokeWidth(mBorderWidth);
        }
    }

    public GlideCircleTransform(Context context) {
        super(context);
    }

    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return circleCrop(pool, toTransform);
    }

    private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        int size = (int) (Math.min(source.getWidth(), source.getHeight()));
        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;
        // TODO this could be acquired from the pool too
        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float r = size / 2f;
        float borderRadius = r - mBorderWidth;
        canvas.drawCircle(r, r, borderRadius, paint);
        if (mBorderPaint != null) {
            canvas.drawCircle(r, r, r - (mBorderWidth / 2), mBorderPaint);
        }
        return result;
    }
    
    @Override
    public String getId() {
        return getClass().getName();
    }
}