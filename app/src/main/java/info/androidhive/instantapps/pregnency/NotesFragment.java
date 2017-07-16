package info.androidhive.instantapps.pregnency;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Saad on 7/16/17.
 */


public class NotesFragment extends Fragment {

    ImageButton imgBtn;
    ImageView img1;
  //  TextView text;
    TextProgressBar pb;
    int myProgress = 0;
    int i=0;
    //int[] fruitArray;
    TypedArray fruitArray;
    //2
    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_one, container, false);

        View view = inflater.inflate(R.layout.fragment_test, container, false);
       // text=(TextView)view.findViewById(R.id.text1) ;


         final TypedArray fruitArray = getResources().obtainTypedArray(R.array.pregnanncy_fruits);

        //fruitArray = getActivity().getResources().getIntArray(R.array.pregnanncy_fruits);

        img1=(ImageView)view.findViewById(R.id.image1) ;
        imgBtn =(ImageButton) getActivity().findViewById(R.id.next);
        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3.5f);
        Drawable draw=getResources().getDrawable(R.drawable.custom_progressbar);
// set the drawable as progress drawable
        pb.setProgressDrawable(draw);




       // text.setText("jdhgewuhg");
          img1.setImageResource(fruitArray.getResourceId(0, -1));

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if(i<41) {
    System.out.println("Saad");
    img1.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
    img1.setImageResource(fruitArray.getResourceId(i, -1));


    //text.setText("saaaad");

    myProgress++;
    i++;
    pb.setProgress(myProgress);
    pb.setText("week " + myProgress + "/32");
}


            }
        });

        return  view;


        //   new Thread(myThread).start();

    }
}

