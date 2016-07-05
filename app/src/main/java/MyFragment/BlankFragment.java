package MyFragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.netease.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment{


    private OnFragmentInteractionListener mListener;


    public static BlankFragment newInstance(int index, String param2){
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        args.putString("urls", param2);
        fragment.setArguments(args);
        return fragment;
    }
    int num;
    String url;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            num = getArguments().getInt("index");
            url = getArguments().getString("urls");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       //每个不同的Fragment加载不同的布局
        View view=null;
        if(num==1){
            view=inflater.inflate(R.layout.fragment_blank,container,false);
        }else if(num==2){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==3){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==4){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==5){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri){
        if(mListener != null){
            mListener.onFragmentInteraction(uri);
        }
    }

  /*  @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach(){
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener{
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
