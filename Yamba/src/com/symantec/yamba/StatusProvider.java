package com.symantec.yamba;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;

public class StatusProvider extends ContentProvider {
	private static final String TAG = "StatusProvider";
	private DbHelper dbHelper;

	@Override
	public boolean onCreate() {
		dbHelper = new DbHelper(getContext());
		return (dbHelper == null) ? false : true;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		long rowId = db.insertWithOnConflict(StatusContract.TABLE, null,
				values, SQLiteDatabase.CONFLICT_REPLACE);
		if (rowId > 0 ) {
			Uri ret = ContentUris.withAppendedId(uri,
					values.getAsLong(StatusContract.Column.ID));
			Log.d(TAG, "inserted uri: "+ret);
			return ret;
		} else {
			throw new SQLiteException("Failed to insert uri: "+uri);
		}
		
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
