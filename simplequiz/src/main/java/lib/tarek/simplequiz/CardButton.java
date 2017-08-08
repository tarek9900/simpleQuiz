package lib.tarek.simplequiz;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;

/**
 * Created by Tarek on 06/08/2017.
 */

public class CardButton extends FrameLayout {

    private RevealFrameLayout fabLayout;
    private FloatingActionButton trueButton;
    private FloatingActionButton falseButton;
    private TypedArray attrs;
    private Context context;


    public CardButton(Context context) {
        this(context, null);
    }

    public CardButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.reveal_fab, this);

        this.context = context;
        this.attrs = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.RevealFAB,
                0, 0);
    }



    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        trueButton = (FloatingActionButton) findViewById(R.id.fab);
        falseButton = (FloatingActionButton) findViewById(R.id.falseFloatButton);
        fabLayout = (RevealFrameLayout) findViewById(R.id.fab_container);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Color the frame in white
                trueButton.setBackgroundTintList(ColorStateList.valueOf(attrs.getColor(R.styleable.RevealFAB_fab_color, Color.WHITE)));
                // Set the frame colors to green
                fabLayout.setBackgroundColor(Color.parseColor("#DCEDC8"));
                startAnimation(trueButton);
                //Wait for animation to finish and call the true method
                //SupportAnimator listener can be override instead
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        ((ButtonInterface)context).trueAction();
                    }
                }, 400);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                falseButton.setBackgroundTintList(ColorStateList.valueOf(attrs.getColor(R.styleable.RevealFAB_fab_color, Color.WHITE)));
                fabLayout.setBackgroundColor(Color.parseColor("#FFCCBC"));
                startAnimation(falseButton);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            ((ButtonInterface)context).falseAction();
                        }
                    }, 400);

            }
        });

    }


    public void startAnimation(FloatingActionButton button) {
        float finalRadius = Math.max(fabLayout.getWidth(), fabLayout.getHeight());
        int x = button.getLeft() + button.getMeasuredWidth() / 2;
        int y = button.getTop() + button.getMeasuredHeight() / 2;
        //Crate a fab annimation
        Animator animator = ViewAnimationUtils.createCircularReveal(fabLayout, x, y, 0, finalRadius);
        fabLayout.setVisibility(VISIBLE);
        // start animation
        animator.start();
    }


}
