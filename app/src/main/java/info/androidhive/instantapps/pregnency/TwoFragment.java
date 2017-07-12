package info.androidhive.instantapps.pregnency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Saad on 7/12/17.
 */


public class TwoFragment extends Fragment {
    //2
    public static OneFragment newInstance() {
        return new OneFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }
}
