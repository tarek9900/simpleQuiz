package lib.tarek.simplequiz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

import java.util.HashMap;

/**
 * Created by Tarek on 02/08/2017.
 */

public class CustomProgresseBar extends AppCompatSeekBar {

    private HashMap<Integer  , ProgressItem> mProgressItemsList;

    public CustomProgresseBar(Context context) {
        super(context);
        mProgressItemsList = new HashMap<>();

    }

    public CustomProgresseBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mProgressItemsList = new HashMap<>();

    }


    public void initData(HashMap<Integer , ProgressItem> progressItemsList) {
        this.mProgressItemsList = progressItemsList;
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec,
                                          int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onDraw(Canvas canvas) {
        if (mProgressItemsList.size() > 0) {
            int progressBarWidth = getWidth();
            int progressBarHeight = getHeight();
            int thumboffset = getThumbOffset();
            int lastProgressX = 0;
            int progressItemWidth, progressItemRight;
            for (int i = 0; i < mProgressItemsList.size(); i++) {
                ProgressItem progressItem = mProgressItemsList.get(i);
                Paint progressPaint = new Paint();
                progressPaint.setColor(progressItem.color);

                progressItemWidth = (int) (progressItem.progressItemPercentage
                        * progressBarWidth / 100);

                progressItemRight = lastProgressX + progressItemWidth;
                if (i == mProgressItemsList.size() - 1
                        && progressItemRight != progressBarWidth) {
                    progressItemRight = progressBarWidth;
                }
                Rect progressRect = new Rect();
                progressRect.set(lastProgressX, thumboffset / 2,
                        progressItemRight, progressBarHeight - thumboffset / 2);
                canvas.drawRect(progressRect, progressPaint);
                lastProgressX = progressItemRight;
            }
            super.onDraw(canvas);
        }

    }

}
