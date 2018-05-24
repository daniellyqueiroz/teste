package br.ufrpe.tiqueru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

    private Fragment mContent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanteState){
        View rootView= inflater.inflate(R.layout.home_fragment,container,false);
        return rootView;
    }
}