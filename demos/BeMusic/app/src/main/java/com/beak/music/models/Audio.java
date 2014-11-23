package com.beak.music.models;

import android.os.Bundle;
import android.provider.MediaStore;


public class Audio {
	
	
	private String mTitle,
				   mTitleKey,
				   mArtist,
				   mArtistKey,
				   mComposer,
				   mAlbum,
				   mAlbumKey,
				   mDisplayName,
				   mYear,
				   mMimeType,
				   mPath;
	
	private int mId,
                mArtistId,
				mAlbumId,
				mTrack;
	
	private int mDuration = 0,
				 mSize = 0;
	
	private boolean isRingtone = false,
					isPodcast = false,
					isAlarm = false,
					isMusic = false,
					isNotification = false;
	
	public Audio (Bundle bundle) {
        mId = bundle.getInt(MediaStore.Audio.Media._ID);
		mTitle = bundle.getString(MediaStore.Audio.Media.TITLE);
		mTitleKey = bundle.getString(MediaStore.Audio.Media.TITLE_KEY);
		mArtist = bundle.getString(MediaStore.Audio.Media.ARTIST);
		mArtistKey = bundle.getString(MediaStore.Audio.Media.ARTIST_KEY);
		mComposer = bundle.getString(MediaStore.Audio.Media.COMPOSER);
		mAlbum = bundle.getString(MediaStore.Audio.Media.ALBUM);
		mAlbumKey = bundle.getString(MediaStore.Audio.Media.ALBUM_KEY);
		mDisplayName = bundle.getString(MediaStore.Audio.Media.DISPLAY_NAME);
		mYear = bundle.getString(MediaStore.Audio.Media.YEAR);
		mMimeType = bundle.getString(MediaStore.Audio.Media.MIME_TYPE);
		mPath = bundle.getString(MediaStore.Audio.Media.DATA);
		
		mArtistId = bundle.getInt(MediaStore.Audio.Media.ARTIST_ID);
		mAlbumId = bundle.getInt(MediaStore.Audio.Media.ALBUM_ID);
		mTrack = bundle.getInt(MediaStore.Audio.Media.TRACK);
		mDuration = bundle.getInt(MediaStore.Audio.Media.DURATION);
		mSize = bundle.getInt(MediaStore.Audio.Media.SIZE);
		isRingtone = bundle.getInt(MediaStore.Audio.Media.IS_RINGTONE) == 1;
		isPodcast = bundle.getInt(MediaStore.Audio.Media.IS_PODCAST) == 1;
		isAlarm = bundle.getInt(MediaStore.Audio.Media.IS_ALARM) == 1;
		isMusic = bundle.getInt(MediaStore.Audio.Media.IS_MUSIC) == 1;
		isNotification = bundle.getInt(MediaStore.Audio.Media.IS_NOTIFICATION) == 1;
				 
	}

    public int getId() {
        return mId;
    }

    public String getMimeType () {
		return mMimeType;
	}
	
	public int getDuration () {
		return mDuration;
	}
	
	public int getSize () {
		return mSize;
	}
	
	public boolean isRingtone () {
		return isRingtone;
	}
	
	public boolean isPodcast () {
		return isPodcast;
	}
	
	public boolean isAlarm () {
		return isAlarm;
	}
	
	public boolean isMusic () {
		return isMusic;
	}
	
	public boolean isNotification () {
		return isNotification;
	}
	
	public String getTitle () {
		return mTitle;
	}
	
	public String getTitleKey () {
		return mTitleKey;
	}
	
	public String getArtist () {
		return mArtist;
	}
	
	public int getArtistId () {
		return mArtistId;
	}
	
	public String getArtistKey () {
		return mArtistKey;
	}
	
	public String getComposer () {
		return mComposer;
	}
	
	public String getAlbum () {
		return mAlbum;
	}
	
	public int getAlbumId () {
		return mAlbumId;
	}
	
	public String getAlbumKey () {
		return mAlbumKey;
	}
	
	public String getDisplayName () {
		return mDisplayName;
	}
	
	public String getYear () {
		return mYear;
	}
	
	public int getTrack () {
		return mTrack;
	}
	
	public String getPath () {
		return mPath;
	}
	
}
