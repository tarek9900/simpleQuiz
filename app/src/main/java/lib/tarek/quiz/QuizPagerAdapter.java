package lib.tarek.quiz;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lib.tarek.simplequiz.QuizAdapter;
import lib.tarek.simplequiz.QuizItem;

/**
 * Created by Tarek on 01/08/2017.
 */

public class QuizPagerAdapter extends PagerAdapter implements QuizAdapter {

    private List<CardView> mViews;
    private List<QuizItem> mData;
    public static int currentItem ;

    @Override
    public float getBaseElevation() {
        return 10;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    public QuizPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
        currentItem = 0;
    }

    public void addCardItem(QuizItem item) {
        mViews.add(null);
        mData.add(item);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item , container , false);
        container.addView(view);

        TextView titleText = (TextView) view.findViewById(R.id.titleText);
        TextView descriptionText = (TextView) view.findViewById(R.id.descriptionText);
        ImageView imageId = (ImageView) view.findViewById(R.id.imageView);

        imageId.setImageResource(mData.get(position).getImageId());
        titleText.setText(mData.get(position).getTitle());
        descriptionText.setText(mData.get(position).getDesription());

        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * QuizAdapter.MAX_ELEVATION_FACTOR );

        mViews.set(position, cardView);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView)object);
    }
}
