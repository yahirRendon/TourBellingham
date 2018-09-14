package com.example.android.tourbellingham;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of color vocabulary words.
 */
public class CafeFragment extends Fragment {
    private String mWebsite = "";

    public CafeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.cafe_adagio_address, R.string.cafe_adagio,
                R.drawable.cafe_adagio));
        words.add(new Word(R.string.cafe_blackdrop_address, R.string.cafe_blackdrop,
                R.drawable.cafe_blackdrop));
        words.add(new Word(R.string.cafe_camber_address, R.string.cafe_camber,
                R.drawable.cafe_camber));
        words.add(new Word(R.string.cafe_lettered_address, R.string.cafe_lettered,
                R.drawable.cafe_lettered));
        words.add(new Word(R.string.cafe_primer_address, R.string.cafe_primer,
                R.drawable.cafe_primer));
        words.add(new Word(R.string.cafe_velo_address, R.string.cafe_velo,
                R.drawable.cafe_velo));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_cafe);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Get the correct website based on Id
                getWebsite(position);

                // Launch website
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mWebsite));
                startActivity(intent);
            }
        });

        return rootView;
    }

    /**
     * Set the correct website to mWebsite based on
     * @ param position is the position object
     */
    public void getWebsite(int position) {
        switch (position) {
            case 0:
                mWebsite = getResources().getString(R.string.cafe_adagio_website);
                break;
            case 1:
                mWebsite = getResources().getString(R.string.cafe_blackdrop_website);
                break;
            case 2:
                mWebsite = getResources().getString(R.string.cafe_camber_website);
                break;
            case 3:
                mWebsite = getResources().getString(R.string.cafe_lettered_website);
                break;
            case 4:
                mWebsite = getResources().getString(R.string.cafe_primer_website);
                break;
            case 5:
                mWebsite = getResources().getString(R.string.cafe_velo_website);
                break;
            default:
                break;
        }
    }

}

