package javabean;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import wlf.mvpdagger.R;

/**
 * Created by win10 on 2017/8/3.
 */

public class RecMainItemDecoration extends RecyclerView.ItemDecoration {

    Drawable drawable;

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        outRect.set(0, 0, 0, drawable.getIntrinsicHeight());
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return ;
        }
        Log.d("LOG","on draw is called");
        int left, top, right, bottom;
        if (parent.getClipToPadding()) {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
        } else {
            left = 0;
            right = parent.getWidth();
        }
        Rect bounds = new Rect();
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            parent.getDecoratedBoundsWithMargins(child, bounds);

            bottom = bounds.bottom;
            top = bounds.bottom-drawable.getIntrinsicHeight();
            drawable.setBounds(left, top, right, bottom);
            drawable.draw(c);
        }
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }


    public RecMainItemDecoration(Context context) {
        super();
        drawable = context.getDrawable(R.drawable.main_rec_decoration);
        drawable.setBounds(0, 0, 0, drawable.getIntrinsicHeight());
    }
}
