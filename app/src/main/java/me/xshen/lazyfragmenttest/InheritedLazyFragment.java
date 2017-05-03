package me.xshen.lazyfragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 使用继承方式的延迟加载Fragment
 */
public class InheritedLazyFragment extends InheritedFakeFragment {
    public static final String FRAGMENT_MSG = "FRAGMENT_MSG";
    public static final String FRAGMENT_POS = "FRAGMENT_POS";

    private String mFragmentMsg;
    private int mPos;

    public InheritedLazyFragment() {
        // Required empty public constructor
    }

    public static InheritedLazyFragment newInstance(String msg, int position) {
        InheritedLazyFragment fragment = new InheritedLazyFragment();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_MSG, msg);
        args.putInt(FRAGMENT_POS, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFragmentMsg = getArguments().getString(FRAGMENT_MSG);
            mPos = getArguments().getInt(FRAGMENT_POS);
        }
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onCreate");
    }

    @Override
    public View onLazyCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_origin, container, false);
        TextView content = (TextView) view.findViewById(R.id.FragmentContent);
        content.setText(mFragmentMsg + mPos);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onLazyCreateView");
        return view;
    }

    @Override
    public void onLazyViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onLazyViewCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onDetach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onActivityCreated");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "setUserVisibleHint: " + isVisibleToUser);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onDestroy");
    }
}
