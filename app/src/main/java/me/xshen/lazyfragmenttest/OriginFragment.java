package me.xshen.lazyfragmenttest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * 正常的Fragment
 */
public class OriginFragment extends Fragment {
    private static final String FRAGMENT_MSG = "FRAGMENT_MSG";
    private static final String FRAGMENT_POS = "FRAGMENT_POS";

    private String mFragmentMsg;
    private int mPos;

    public OriginFragment() {
        // Required empty public constructor
    }

    public static OriginFragment newInstance(String msg, int position) {
        OriginFragment fragment = new OriginFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_origin, container, false);
        TextView content = (TextView) view.findViewById(R.id.FragmentContent);
        content.setText(mFragmentMsg + mPos);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onActivityCreated");
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FragmentTest" + mPos, "Pos: " + mPos + " , " + "onViewCreated");
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
