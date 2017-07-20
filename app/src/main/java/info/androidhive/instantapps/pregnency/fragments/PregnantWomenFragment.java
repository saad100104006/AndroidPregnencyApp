package info.androidhive.instantapps.pregnency.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.instantapps.pregnency.R;
import info.androidhive.instantapps.pregnency.utils.TextProgressBar;

/**
 * Created by Saad on 7/10/17.
 */


public class PregnantWomenFragment extends Fragment {

    ImageButton imgBtn;
    ImageView img1;
    TextView text;
    TextProgressBar pb;
    private int[] textureArrayWin = {
            R.drawable.img1,
            R.drawable.ic_woman_white,
            R.drawable.ic_baby_white,
    };
    int myProgress = 0;

    //2
    public PregnantWomenFragment newInstance() {
        return new PregnantWomenFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     //   return inflater.inflate(R.layout.fragment_test, container, false);

        View view = inflater.inflate(R.layout.fragment_women, container, false);
        text=(TextView)view.findViewById(R.id.text1) ;
        img1=(ImageView)view.findViewById(R.id.image1) ;
        imgBtn =(ImageButton) getActivity().findViewById(R.id.next);
        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3.5f);
        Drawable draw=getResources().getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        pb.setProgressDrawable(draw);




        text.setText("jdhgewuhg");
        img1.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_baby_white));

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Saad");
                img1.setImageResource(textureArrayWin[0]);
                text.setText("saaaad");

                myProgress++;
                pb.setProgress(myProgress);
                pb.setText("week "+myProgress+"/32");


            }
        });


     //   new Thread(myThread).start();

        return view;


    }


}

