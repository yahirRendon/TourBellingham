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
public class BreweryFragment extends Fragment {
    private String mWebsite = "";

    public BreweryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.brewery_aslan_address, R.string.brewery_aslan,
                R.drawable.brewery_aslan));
        words.add(new Word(R.string.brewery_kulshan_address, R.string.brewery_kulshan,
                R.drawable.brewery_kulshan));
        words.add(new Word(R.string.brewery_melvin_address, R.string.brewery_melvin,
                R.drawable.brewery_melvin));
        words.add(new Word(R.string.brewery_stones_throw_address, R.string.brewery_stones,
                R.drawable.brewery_stones_throw));
        words.add(new Word(R.string.brewery_twin_sisters_address, R.string.brewery_twin_sisters,
                R.drawable.brewery_twin_sisters));
        words.add(new Word(R.string.brewery_wander_address, R.string.brewery_wander,
                R.drawable.brewery_wander));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_brewery);

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
                mWebsite = getResources().getString(R.string.brewery_aslan_website);
                break;
            case 1:
                mWebsite = getResources().getString(R.string.brewery_kulshan_website);
                break;
            case 2:
                mWebsite = getResources().getString(R.string.brewery_melvin_website);
                break;
            case 3:
                mWebsite = getResources().getString(R.string.brewery_stones_website);
                break;
            case 4:
                mWebsite = getResources().getString(R.string.brewery_twin_sisters_website);
                break;
            case 5:
                mWebsite = getResources().getString(R.string.brewery_wander_website);
                break;
            default:
                break;
        }
    }
}
