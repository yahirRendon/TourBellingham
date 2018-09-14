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
public class FoodFragment extends Fragment {
    private String mWebsite;

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.food_akroteri_address, R.string.food_akroteri,
                R.drawable.food_akroteri));
        words.add(new Word(R.string.food_boomers_address, R.string.food_boomers,
                R.drawable.food_boomers));
        words.add(new Word(R.string.food_brother_dudes_address, R.string.food_brother_dudes,
                R.drawable.food_brother_dudes));
        words.add(new Word(R.string.food_kombucha_address, R.string.food_kombucha,
                R.drawable.food_kombucha));
        words.add(new Word(R.string.food_leaf_ladle_address, R.string.food_leaf_laddle,
                R.drawable.food_leaf_ladle));
        words.add(new Word(R.string.food_man_pies_address, R.string.food_man_pies,
                R.drawable.food_man_pies));
        words.add(new Word(R.string.food_rock_rye_address, R.string.food_rock_rye,
                R.drawable.food_rock_rye));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_food);

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
                mWebsite = getResources().getString(R.string.food_akroteri_website);
                break;
            case 1:
                mWebsite = getResources().getString(R.string.food_boomers_website);
                break;
            case 2:
                mWebsite = getResources().getString(R.string.food_brother_dudes_website);
                break;
            case 3:
                mWebsite = getResources().getString(R.string.food_kombucha_website);
                break;
            case 4:
                mWebsite = getResources().getString(R.string.food_leaf_ladle_website);
                break;
            case 5:
                mWebsite = getResources().getString(R.string.food_man_pies_website);
                break;
            case 6:
                mWebsite = getResources().getString(R.string.food_rock_rye_website);
                break;
            default:
                break;
        }
    }
}

