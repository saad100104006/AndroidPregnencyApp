package info.androidhive.instantapps.pregnency;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Saad on 7/10/17.
 */


public class OneFragment extends Fragment {

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
    public  OneFragment newInstance() {
        return new OneFragment();
    }

    //3

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     //   return inflater.inflate(R.layout.fragment_test, container, false);

        View view = inflater.inflate(R.layout.fragment_test, container, false);
        text=(TextView)view.findViewById(R.id.text1) ;
        img1=(ImageView)view.findViewById(R.id.image1) ;
        imgBtn =(ImageButton) getActivity().findViewById(R.id.next);
        pb = new TextProgressBar(getActivity());
        pb = (TextProgressBar) getActivity().findViewById(R.id.pb);
        pb.setScaleY(3f);




        text.setText("jdhgewuhg");
        img1.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_baby_white));

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Saad");
                img1.setImageDrawable(getActivity().getResources().getDrawable(textureArrayWin[0]));
                text.setText("saaaad");

                myProgress++;
                pb.setProgress(myProgress);
                pb.setText("week "+myProgress+"/32");


            }
        });


     //   new Thread(myThread).start();

        return view;


    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      /*   text=(TextView)getActivity().findViewById(R.id.text1) ;
        img1=(ImageView)getActivity().findViewById(R.id.image1) ;*/



    }

    private Runnable myThread = new Runnable(){
        @Override
        public void run() {
            while (myProgress<32){
                try{
                    System.out.println("SSS");
                    pb.setProgress(myProgress);
                    pb.setText(myProgress+"/32");
                    //   pb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    myHandle.sendMessage(myHandle.obtainMessage());
                    Thread.sleep(500);
                }
                catch(Throwable t){
                }
            }
        }

        Handler myHandle = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                myProgress++;
                pb.setProgress(myProgress);
                pb.setText(myProgress+"/32");
            }
        };
    };
}

