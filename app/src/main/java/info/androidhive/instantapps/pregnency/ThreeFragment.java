package info.androidhive.instantapps.pregnency;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Saad on 7/12/17.
 */

public class ThreeFragment extends Fragment {
    //2
    public static ThreeFragment newInstance() {
        return new ThreeFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }
}