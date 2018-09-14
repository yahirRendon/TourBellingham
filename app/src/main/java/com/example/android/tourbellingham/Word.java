package com.example.android.tourbellingham;

/**
 * {@link Word} represents a title and address for place in Bellingham
 * It contains resource IDs for the title, address, and image
 */
public class Word {

    /** String resource ID for the place title */
    private int mTitleId;

    /** String resource ID for the place address*/
    private int mAddressId;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** String resource ID for the place web address*/
    private int mWebsiteId;

    /**
     * Create a new Word object with no image .
     *
     * @param titleId is the string resource ID for the place title
     * @param addressId is the string resource Id for the place address
     */
    public Word(int titleId, int addressId, int imageResourceId) {
        mTitleId = titleId;
        mAddressId = addressId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Word object with image
     *
     * @param titleId is the string resource ID for the place title
     * @param addressId is the string resource Id for the place address
     * @param imageResourceId is the drawable resource ID for the image associated with the place
     */
    public Word(int titleId, int addressId, int imageResourceId, int websiteId) {
        mTitleId = titleId;
        mAddressId = addressId;
        mImageResourceId = imageResourceId;
        mWebsiteId = websiteId;
    }

    /**
     * Get the string resource ID for the place title.
     */
    public int getTitleId() {
        return mTitleId;
    }

    /**
     * Get the string resource ID for the place address.
     */
    public int getAddressId() {
        return mAddressId;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the string resource ID for the place address.
     */
    public int getWebsiteId() {
        return mWebsiteId;
    }

}