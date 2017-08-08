package lib.tarek.quiz;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.HashMap;

import lib.tarek.simplequiz.ButtonInterface;
import lib.tarek.simplequiz.CustomProgresseBar;
import lib.tarek.simplequiz.ProgressItem;
import lib.tarek.simplequiz.QuizItem;
import lib.tarek.simplequiz.ShadowTransformer;

public class MainActivity extends AppCompatActivity implements ButtonInterface {


    private ViewPager mViewPager;
    private QuizPagerAdapter mCardAdapter;
    private CustomProgresseBar customProgresseBar ;
    private ProgressItem mProgressItem  ;
    private HashMap<Integer , ProgressItem> progressItemList ;
    private ShadowTransformer mCardShadowTransformer;
    private int position;
    public static HashMap<Integer,Boolean> mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        customProgresseBar = ((CustomProgresseBar) findViewById(R.id.seekBar0));

        mAnswer = new HashMap<>();

        // Create a new pager adapter
        mCardAdapter = new QuizPagerAdapter();

        // set the quiz questions ( Title , description , photo  , answer )
        mCardAdapter.addCardItem(new QuizItem("Android" , "Was founded in 2003 ?" , R.drawable.android , true));
        mCardAdapter.addCardItem(new QuizItem("Web" , "Is google.com a search engine ?" ,  R.drawable.google ,true));
        mCardAdapter.addCardItem(new QuizItem("google" , "Was google found in 1998 " , R.drawable.google , false));
        mCardAdapter.addCardItem(new QuizItem("Facebook" , "Did mark zuckerberg founded facebook ?" , R.drawable.facebook , true));
        mCardAdapter.addCardItem(new QuizItem("Cars" , "Is Mercedes a german car ? " , R.drawable.mercedes , false));
        mCardAdapter.addCardItem(new QuizItem("Facebook" , "Did mark zuckerberg founded facebook ?" , R.drawable.facebook , true));
        mCardAdapter.addCardItem(new QuizItem("Cars" , "Is the S class faster than the E class ? " , R.drawable.mercedes , true));
        mCardAdapter.addCardItem(new QuizItem("Android" , "Is kotlin a programming language ?" , R.drawable.android , true));
        mCardAdapter.addCardItem(new QuizItem("google" , "Was google found in 1998 " , R.drawable.google , false));
        mCardAdapter.addCardItem(new QuizItem("Cars" , "Have you driven a cls 63 before ? " , R.drawable.mercedes , true));

        customProgresseBar.getThumb().mutate().setAlpha(0);
        mViewPager.setAdapter(mCardAdapter);

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);

        initDataToSeekbar();

    }

    private void initDataToSeekbar() {
        progressItemList = new HashMap<>();

        // Set the quiz bar state to white collar

        for(int i= 0 ; i<= mCardAdapter.getCount() ; i++ ) {

            mProgressItem = new ProgressItem();
            mProgressItem.progressItemPercentage =  100 / mCardAdapter.getCount();
            mProgressItem.color = Color.WHITE;
            progressItemList.put(i , mProgressItem);
            customProgresseBar.initData(progressItemList);
            customProgresseBar.invalidate();

        }

    }

    @Override
    public void trueAction() {

        // When the true button is clicked set the answer ,  bar colors to green and move to the next items
        position = mViewPager.getCurrentItem();
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 100 / mCardAdapter.getCount() ;
        mProgressItem.color = Color.GREEN;
        progressItemList.put(position,mProgressItem);
        customProgresseBar.initData(progressItemList);
        customProgresseBar.invalidate();
        mAnswer.put(position, true);
        mViewPager.setCurrentItem(position+1);

    }

    @Override
    public void falseAction() {
        position = mViewPager.getCurrentItem();
        mProgressItem = new ProgressItem();
        mProgressItem.progressItemPercentage = 100 / mCardAdapter.getCount() ;
        mProgressItem.color = Color.RED;
        progressItemList.put(position,mProgressItem);
        customProgresseBar.initData(progressItemList);
        customProgresseBar.invalidate();
        mViewPager.setCurrentItem(position+1);

    }
}
