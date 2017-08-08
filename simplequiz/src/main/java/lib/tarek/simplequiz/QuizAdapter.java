package lib.tarek.simplequiz;

import android.support.v7.widget.CardView;

/**
 * Created by Tarek on 01/08/2017.
 */

public interface QuizAdapter{

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();



}
