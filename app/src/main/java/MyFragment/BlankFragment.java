package MyFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.netease.LoginActivity;
import com.example.administrator.netease.R;

import java.util.ArrayList;
import java.util.List;

import Myadapter.Title_adapter;

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
    private ViewPager vp;
    private TabLayout tablayout;
    private Button btn_login;

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
    View view;
    String[]titles;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
       //每个不同的Fragment加载不同的布局
        view=null;
        if(num==1){
            view=inflater.inflate(R.layout.fragment_blank,container,false);
        }else if(num==2){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==3){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==4){
            view=inflater.inflate(R.layout.fragment_blank2,container,false);
        }else if(num==5){
            view=inflater.inflate(R.layout.fragment_blank5,container,false);
        }
        initview();
        return view;
    }
    List<Fragment>fragments;
    private void initview(){
        if(num==1){
            tablayout=(TabLayout)view.findViewById(R.id.tablayout);
            fragments=new ArrayList<>();
            vp = (ViewPager) view.findViewById(R.id.vp);
            titles=new String[]{"头条","娱乐","热点","体育","财经","科技","汽车",
                    "时尚","图片","轻松一刻","段子","军事","历史","家居","独家","游戏","健康",
                    "政务","漫画","哒哒趣闻","彩票","美女"};
            for(int i = 0; i <titles.length ; i++){
                BlankFragment1 fragment=BlankFragment1.newInstance((i+1));
                fragments.add(fragment);
            }
            Title_adapter ad=new Title_adapter(getFragmentManager(),titles,fragments);
            vp.setAdapter(ad);
            tablayout.setupWithViewPager(vp);
        }else if(num==5){
            //用户在列表栏中点击了“我”选项，弹出用户操作界面
            List<String> myList = new ArrayList<>();
            btn_login = (Button) view.findViewById(R.id.my_login);
            ListView mine_ListView = (ListView) view.findViewById(R.id.mine_listView);
            String[] myListString = {"我的消息","金币商城","金币任务","我的钱包","夜间模式","离线阅读","活动广场","我的邮箱","意见反馈"};
            for(int i = 0; i < myListString.length; i++){
                myList.add(myListString[i]);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,myList);
            mine_ListView.setAdapter(adapter);
            btn_login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    startActivityForResult(new Intent(getContext(), LoginActivity.class),1);
                }
            });
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && data != null){
            String username = data.getStringExtra("username");
            btn_login.setText(username);
        }
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
