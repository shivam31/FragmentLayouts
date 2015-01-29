package com.droidacid.fragmentlayouts;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by shivam.chopra on 30-01-2015.
 */
public class DetailsFragment extends Fragment {

    TextView tvDetails;

    public static DetailsFragment newInstance(int index) {

        DetailsFragment df = new DetailsFragment();

        Bundle args = new Bundle();
        args.putInt("index", index);
        df.setArguments(args);
        return df;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(getActivity());
        tvDetails = new TextView(getActivity());

        int padding = (int)
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        4, getActivity().getResources().getDisplayMetrics());
        tvDetails.setPadding(padding, padding, padding, padding);

        tvDetails.setText(SuperHeroInfo.HISTORY[getShownIndex()]);

        return scrollView;
    }
}
