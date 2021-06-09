package com.example.workout;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment
{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view1;
        view1 = inflater.inflate(R.layout.fragment_settings, null);
        view1.findViewById(R.id.search_button).setOnClickListener((View.OnClickListener) new myClickMethod());
        Button button = (Button) view1.findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String searchFor=((EditText) view1.findViewById(R.id.editText)).getText().toString();
                Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
                viewSearch.putExtra(SearchManager.QUERY, searchFor);
                startActivity(viewSearch);
            }
        });
        return view1;
    }
    private class myClickMethod implements View.OnClickListener
    {

        @Override
        public void onClick(View v)
        {
            String searchFor = ((EditText) v.findViewById(R.id.editText)).getText().toString();
            Intent viewSearch = new Intent(Intent.ACTION_WEB_SEARCH);
            viewSearch.putExtra(SearchManager.QUERY, searchFor);
            startActivity(viewSearch);
        }
    }
}
